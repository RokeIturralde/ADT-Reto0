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
    File fichAccount = new File("fichAccount.dat");
    File fichMovement = new File("fichMovement.dat");
    File fichCustomer = new File("fichCustomer.dat");

    @Override
    public void createFileCustomer(Customer pCustomer, File fichCustomer) {
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
    public void checkFileAccount(Customer pCustomer) {
        // Shows all the information of the accounts of this customer
        for (int i = 0; i < pCustomer.getCuentas().size(); i++) {
            pCustomer.getCuentas().get(i);
        }
    }

    public Account checkFileDataAccount(String accountId, File fichAccount) {
        Account account = null;
        try {
            FileInputStream fis = new FileInputStream(fichAccount);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int cont = calculoFichero(fichAccount);
            for (int i = 0; i < cont; i++) {
                if (ois.readObject().toString().contains(accountId)) {
                    account = (Account) ois.readObject();
                }
            }
        } catch (Exception e) {
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

            } catch (EOFException e1) {

            } catch (Exception e2) {
                e2.printStackTrace();
            }

            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar los flujos");

            }
        }
        return cont;
    }

    @Override
    public void addFileMovement(Movement pMovement, Account pAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkFileMovement(Account pAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
