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
    private File fichCustomer = new File("fichCustomer.dat");
    private FileInputStream fis = null;
    private ObjectInputStream ois = null;
    private FileOutputStream fos = null;
    private ObjectOutputStream oos = null;
    private MyObjectOutputStream moos;

    @Override
    public void addCustomer(Customer pCustomer) {
        if (fichCustomer.exists()) {
            Customer findCustomer = checkDataCustomer(pCustomer.getID());
            try {
                if (findCustomer != null) {
                    //Error message
                } else {
                    fos = new FileOutputStream(fichCustomer, true);
                    moos = new MyObjectOutputStream(fos);
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
                fos = new FileOutputStream(fichCustomer);
                oos = new ObjectOutputStream(fos);
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
    public Customer checkDataCustomer(Integer pID) {
        Customer pCustomer = null;
        try {
            fis = new FileInputStream(fichCustomer);
            ois = new ObjectInputStream(fis);
            int cont = calculoFichero(fichCustomer);
            for (int i = 0; i < cont; i++) {
                pCustomer = (Customer) ois.readObject();
                if (pCustomer.getID() == pID) {
                    i = cont;
                }
            }
            ois.close();
            fis.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void checkAccount(Customer pCustomer) {
        try{
            fis = new FileInputStream(fichCustomer);
            int cont = calculoFichero(fichCustomer);
            for(int i=0; i<cont;i++){
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAccountToCustomer(Customer customer, Account account) {
        Customer pCustomer = null;
        ArrayList<Customer> customers = new ArrayList <Customer> ();
        try {
            fis = new FileInputStream(fichCustomer);
            ois = new ObjectInputStream(fis);
            int cont = calculoFichero(fichCustomer);
            for (int i = 0; i < cont; i++) {
                pCustomer = (Customer) ois.readObject();
                if (pCustomer.getID()==customer.getID()){
                    customer.getAccounts().add(account);
                }
                customers.add(pCustomer);
            }
            ois.close();
            fis.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos = new FileOutputStream(fichCustomer);
            oos = new ObjectOutputStream(fos);
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

    public Account checkDataAccount(Integer accountId) {
        Customer customer = null;
        Account account = null;
        if (fichCustomer.exists()) {
            try {
                fis = new FileInputStream(fichCustomer);
                ois = new ObjectInputStream(fis);
                int cont = calculoFichero(fichCustomer);
                for (int i = 0; i < cont; i++) {
                    customer = (Customer) ois.readObject();
                    for (int j = 0; j < customer.getAccounts().size(); j++) {
                        if (customer.getAccounts().get(j).getID() == accountId) {
                            account = customer.getAccounts().get(j);
                            j = customer.getAccounts().size();
                            i = cont;
                        }
                    }
                }
                ois.close();
                fis.close(); 
                
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return account;
    }

    @Override
    public void addMovement(Movement pMovement, Account pAccount) {
        pAccount.addMovement(pMovement);
        Customer pCustomer = null;
        int cont = calculoFichero(fichCustomer);
        ArrayList<Customer> customers = new ArrayList <Customer>();

        try {
            fis = new FileInputStream(fichCustomer);
            ois = new ObjectInputStream(fis);

            for (int j = 0; j < cont; j++) {
                pCustomer = (Customer) ois.readObject();
                for (int i = 0; i < pCustomer.getAccounts().size(); i++) {
                    if (pAccount.getID() == pCustomer.getAccounts().get(i).getID()) {
                        pAccount.addMovement(pMovement);
                        i = pCustomer.getAccounts().size();
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
            fos = new FileOutputStream(fichCustomer);
            oos = new ObjectOutputStream(fos);
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
        
    }

    /**Calculates the lenght of the file
     */
    public int calculoFichero(File fich) {
        int cont = 0;
        if (fich.exists()) {
            fis = null;
            ois = null;
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
}
