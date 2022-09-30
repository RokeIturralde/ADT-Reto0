package model;


import java.io.File;
import java.util.ArrayList;
import obj.*;

public interface Modelable {

    /**
     * Stores a new customer in the databse.
     */
    public void createCustomer(Customer pCustomer);

    /**
     * Use an object to send the data and check if the Customer is or not stored
     * in the database.
     */
    public Customer checkDataCustomer(Integer pID);

    /**
     * Use an object to send the data and checj if the Account is or not stored
     * in the database.
     */
    /**
     * Input a Customer, the function returns an array of all the account of the
     * Customer. (null if none)
     */
    public Account checkAccount(Customer pCustomer);

    /**
     * Maybe it's unnecesary, idk.
     */
    public Account checkDataAccount(String accountId);

    /**
     * Input a movement and it will be stored in the database. YOU HAVE TO CHECK
     * THE ACCOUNT.
     */
    public void addMovement(Movement pMovement, Account pAccount);

    /**
     * Use an object to send the data and check if the Movement is or not stored
     * in the database.
     */
    public void checkMovement(Account pAccount);

    /**
     * All the methods for the file part
     */
    public void createFileCustomer(Customer pCustomer, File fichCustomer);

    public void checkFileAccount(Customer pCustomer);

    public Account checkFileDataAccount(String accountId);

    public void addFileMovement(Movement pMovement, Account pAccount);

    public void checkFileMovement(Account pAccount);
}
