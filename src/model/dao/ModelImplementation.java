package model.dao;

import java.sql.ResultSet;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Modelable;
import obj.*;

public class ModelImplementation extends SQLAccess implements Modelable {

    private PreparedStatement stmt;

    final String addMovement = "INSERT INTO MOVEMENT VALUES (?,?,?,?,?,?)";
    final String checkMovement = "SELECT M.* FROM MOVEMENT M,ACCOUNT A WHERE A.ID=? AND M.ACCOUNT_ID=A.ID";
    final String insertCustomer = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?,?,?)";
    final String checkDataCustomer = "SELECT * FROM CUSTOMER WHERE ID = ?";

    @Override
    public void createCustomer(Customer pCustomer) {
        try {
            openConnection();
            stmt = con.prepareStatement(insertCustomer);
            stmt.setInt(1, pCustomer.getID());
            stmt.setString(2, pCustomer.getCity());
            stmt.setString(3, pCustomer.getEmail());
            stmt.setString(4, pCustomer.getFirstName());
            stmt.setString(5, pCustomer.getLastName());
            stmt.setString(6, pCustomer.getMiddleInitial());
            stmt.setInt(7, pCustomer.getPhone());
            stmt.setString(8, pCustomer.getState());
            stmt.setString(9, pCustomer.getStreet());
            stmt.setInt(10, pCustomer.getZip());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public Customer checkDataCustomer(Integer pID) {
        ResultSet rs = null;
        Customer pCustomer = null;

        try {
            openConnection();
            stmt = con.prepareStatement(checkDataCustomer);
            stmt.setInt(1, pID);
            if (rs.next()) {
                pCustomer.setID(rs.getInt("id"));
                pCustomer.setCity(rs.getString("city"));
                pCustomer.setEmail(rs.getString("email"));
                pCustomer.setFirstName(rs.getString("firstName"));
                pCustomer.setLastName(rs.getString("lastName"));
                pCustomer.setMiddleInitial(rs.getString("middleInitial"));
                pCustomer.setPhone(rs.getInt("phone"));
                pCustomer.setState(rs.getString("state"));
                pCustomer.setStreet(rs.getString("street"));
                pCustomer.setZip(rs.getInt("zip"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection();
        }
        return pCustomer;
    }

    @Override
    public Account checkAccount(Customer pCustomer) {
        ResultSet rs;
        Account account = null;
        AccountType accountType = null;
        String sacarCuentas = "select a.* from account a,customer_account ca where ca.customers_id=?";
        try {
            openConnection();
            stmt = con.prepareStatement(sacarCuentas);
            stmt.setString(1, pCustomer.getID().toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                AccountType type = null;

                for (AccountType a : AccountType.values()) {
                    if (a.ordinal() == rs.getInt("a.type")) {
                        type = a;
                    }
                }
                account = new Account(rs.getInt("a.id"),
                        rs.getString("a.description"),
                        rs.getDouble("a.balance"),
                        rs.getDouble("a.creditLine"),
                        rs.getDouble("a.beginBalance"),
                        rs.getDate("a.beginBalanceTimestamp").toLocalDate(),
                        type);
                pCustomer.getCuentas().add(account);
            }

        } catch (SQLException e) {
        }
        return account;
    }

    @Override
    public Account checkDataAccount(Integer pID) {
        Account account = null;
        ResultSet rs;
        String dataAccount = "select * from account where id=?";
        try {
            openConnection();
            stmt = con.prepareStatement(dataAccount);
            stmt.setString(1, ""+pID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                AccountType type = null;

                for (AccountType a : AccountType.values()) {
                    if (a.ordinal() == rs.getInt("a.type")) {
                        type = a;
                    }
                }
                account = new Account(rs.getInt("id"),
                        rs.getString("description"),
                        rs.getDouble("balance"),
                        rs.getDouble("creditLine"),
                        rs.getDouble("beginBalance"),
                        rs.getDate("beginBalanceTimestamp").toLocalDate(),
                        type);
            }

        } catch (SQLException e) {
        }
        return account;
    }

    @Override
    public void addMovement(Movement pMovement, Account pAccount) {
        //Open connection
        openConnection();

        try {
            //Tabla de Movements
            stmt = con.prepareStatement(addMovement);
            stmt.setInt(1, pMovement.getID());
            stmt.setDouble(2, pMovement.getAmount());
            stmt.setDouble(3, pMovement.getBalance());
            stmt.setString(4, pMovement.getDescription());
            stmt.setObject(5, (pMovement.getTimestamp()));
            stmt.setInt(6, pAccount.getID());
            stmt.executeUpdate();
            // Add the movement to the account array
            pAccount.getMovements().add(pMovement);

        } catch (SQLException ex) {
            Logger.getLogger(ModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Close connection
            closeConnection();
        }

    }

    @Override
    public void checkMovement(Account pAccount) {
        Movement move = null;
        //Open connection

        openConnection();
        ResultSet rs;

        try {
            stmt = con.prepareStatement(checkMovement);
            stmt.setInt(1, pAccount.getID());

            rs = stmt.executeQuery();

            while (rs.next()) {
                move = new Movement(rs.getInt("m.id"), rs.getDate("m.timestamp").toLocalDate(),
                        rs.getDouble("m.amount"), rs.getDouble("m.balance"), rs.getString("m.description"));
                //pAccount.getMovements().add(move);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

        for (int i = 0; i < pAccount.getMovements().size(); i++) {
            pAccount.getMovements().get(i);
        }
    }

}
