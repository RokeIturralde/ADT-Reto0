package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Modelable;
import obj.*;

public class ModelImplementation extends SQLAccess implements Modelable {
    private PreparedStatement stmt;
    
    final String addMovement = "INSERT INTO MOVEMENT VALUES (?,?,?,?,?,?)";
    final String checkMovement = "SELECT M.* FROM MOVEMENT M,ACCOUNT A WHERE A.ID=? AND M.ACCOUNT_ID=A.ID";
    
    @Override
    public void createCustomer(Customer pCustomer) {
        // TODO Auto-generated method stub
    }

    @Override
    public Customer checkDataCustomer(Integer pID) {
        ResultSet rs = null;
        Customer pCustomer;
        
        String checkDataCustomer = "SELECT * FROM CUSTOMER WHERE ID = ?";
        
        return null;
    }

    @Override
    public void checkAccount(Customer pCustomer) {
        ResultSet rs;
        Account account = null;
        String sacarCuentas = "select a.* from account a,customer_account ca where ca.customers_id=?";
        try {
            openConnection();
            stmt = con.prepareStatement(sacarCuentas);
            stmt.setString(1, pCustomer.getID().toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                account = new Account(
                        rs.getInt("a.id"),
                        rs.getString("a.description"),
                        rs.getDouble("a.balance"),
                        rs.getDouble("a.creditLine"),
                        rs.getDouble("a.beginBalance"),
                        rs.getDate("a.beginBalanceTimestamp").toLocalDate(),
                        new AccountType()); // TODO: still to fix it.
                pCustomer.getCuentas().add(account);
            }

            
            
        } catch (SQLException e) {
        }
    }

    @Override
    public Account checkDataAccount(Account pAccount) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createMovement(Movement pMovement) {
       //Open connection
        openConnection();
        
        try {
            stmt = con.prepareStatement(addMovement);
        } catch (SQLException ex) {
            Logger.getLogger(ModelImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

}

    @Override
    public Movement[] checkDataMovement(Account pAccount) {
        // TODO Auto-generated method stub
        return null;
    }
}