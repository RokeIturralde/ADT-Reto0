/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    File fichAccount = new File("fichAccount.dat");
    File fichMovement = new File("fichMovement.dat");
    File fichCustomer = new File("fichCustomer.dat");

    @Override
    public void createCustomer(Customer pCustomer, File fichCustomer) {
        if (fichCustomer.exists()){
            Customer findCustomer = checkDataCustomer(pCustomer.getID());
            try{
                if (findCustomer != null){
                    //Error message
                }else{
                    FileOutputStream fos = new FileOutputStream(fichCustomer, true);
                    MyObjectOutputStream moos = new MyObjectOutputStream(fos);
                    moos.writeObject(pCustomer);
                    moos.close();
                    fos.close();
                }
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
            
        } else{
            try{
                FileOutputStream fos = new FileOutputStream(fichCustomer);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(pCustomer);
                oos.close();
                fos.close();
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }       
    }

    @Override
    public Customer checkDataCustomer(Integer pID) {
        
    }

    @Override
    public void checkAccount(Customer pCustomer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account checkDataAccount(String accountId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMovement(Movement pMovement, Account pAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkMovement(Account pAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

}
