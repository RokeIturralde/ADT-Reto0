/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Modelable;
import obj.Account;
import obj.Customer;
import obj.Movement;

/**
 *
 * @author 2dam
 */
public class ModelFileImplementation implements Modelable {

    // Yo creo que hay que meter esto en ModelImplementation (Gestion de base de datos y ficheros unida)
    File fichCustomer = new File("fichCustomer.dat");

    @Override
    public void createCustomer(Customer pCustomer) {
        if (fichCustomer.exists()) {
            Customer findCustomer = checkDataCustomer(pCustomer.getID());
            try {
                if (findCustomer != null) {
                    //Error message
                } else {
                    FileOutputStream fos = new FileOutputStream(fichCustomer, true);
                    MyObjectOutputStream moos = new MyObjectOutputStream(fos);
                    moos.writeObject(pCustomer);
                    moos.close();
                    fos.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                FileOutputStream fos = new FileOutputStream(fichCustomer);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(pCustomer);
                oos.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void checkAccount(Customer pCustomer) {
        // Shows all the information of the accounts of this customer
        for (int i = 0; i < pCustomer.getAccounts().size(); i++) {
            pCustomer.getAccounts().get(i);
        }
    }

    public Account checkDataAccount(Integer accountId) {
        Customer customer = null;
        Account account = null;
        if (fichCustomer.exists()) {
            try {
                FileInputStream fis = new FileInputStream(fichCustomer);
                ObjectInputStream ois = new ObjectInputStream(fis);
                int cont = calculoFichero(fichCustomer);
                for (int i = 0; i < cont; i++) {
                    customer = (Customer) ois.readObject();
                    for (int j = 0; j < customer.getAccounts().size(); j++) {
                        if (customer.getAccounts().get(j).getID() == accountId) {
                            account = customer.getAccounts().get(j);
                        }
                    }
                }
                ois.close();
                fis.close();
            } catch (Exception e) {
            }
        }

        return account;
    }

    //Calculates the lenght of the file
    public static int calculoFichero(File fich) {
        int cont = 0;
        if (fich.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream(fich);
                ois = new ObjectInputStream(fis);

                Object aux = ois.readObject();

                while (aux != null) {
                    cont++;
                    aux = ois.readObject();
                }
                ois.close();
                fis.close();
            } catch (EOFException e1) {

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return cont;
    }

    @Override
    public void addMovement(Movement pMovement, Account pAccount) {
        pAccount.addMovement(pMovement);
        Customer pCustomer = null;
        int cont = calculoFichero(fichCustomer);
        ArrayList<Customer> customers = new ArrayList();

        try {
            FileInputStream fis = new FileInputStream(fichCustomer);
            ObjectInputStream ois = new ObjectInputStream(fis);

            for (int j = 0; j < cont; j++) {
                pCustomer = (Customer) ois.readObject();
                for (int i = 0; i < pCustomer.getAccounts().size(); i++) {
                    if (pAccount.getID() == pCustomer.getAccounts().get(i).getID()) {
                        pAccount.addMovement(pMovement);
                    }
                }
                customers.add(pCustomer);
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        /**
         * Rewrite the file
         */
        try {
            FileOutputStream fos = new FileOutputStream(fichCustomer);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < customers.size(); i++) {
                oos.writeObject(customers.get(i));
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void checkMovement(Account pAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer checkDataCustomer(Integer pID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCustomerToAccount(Customer customer, Account account) {

    }

    @Override
    public void createCustomersAccount(Customer customerModification, Account accountAdd) {
        ArrayList<Customer> customers = new ArrayList();
        if (fichCustomer.exists()) {
            try {
                /**
                 * Charge all the customers from the file
                 */
                FileInputStream fis = new FileInputStream(fichCustomer);
                ObjectInputStream ois = new ObjectInputStream(fis);
                int cont = calculoFichero(fichCustomer);
                for (int i = 0; i < cont; i++) {
                    customers.add((Customer) ois.readObject());
                }
                ois.close();
                fis.close();

                /**
                 * Modify the array
                 */
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getID() == customerModification.getID()) {
                        customers.get(i).getAccounts().add(accountAdd);
                        i = customers.size();
                    }
                }

                /**
                 * Rewrite the file
                 */
                try {
                    FileOutputStream fos = new FileOutputStream(fichCustomer);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    for (int i = 0; i < customers.size(); i++) {
                        oos.writeObject(customers.get(i));
                    }
                    oos.close();
                    fos.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
            }
        }
    }

}
