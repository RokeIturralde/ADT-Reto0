package model;

import obj.*;

public interface Modelable {

    /**
     * Stores a new customer in the databse.
     */
    public void addCustomer(Customer pCustomer);

    /**
     * Use an object to send the data and check if the Customer is or not stored
     * in the database.
     */
    public Customer checkDataCustomer(String pID);

    /**
     * Use an object to send the data and checj if the Account is or not stored
     * in the database.
     */
    /**
     * Input a Customer, the function returns an array of all the account of the
     * Customer. (null if none)
     */
    public void checkAccount(Customer pCustomer);

    /*
    * Relates a customer to an account and adds a new account to the customer Array
     */
    public void addAccountToCustomer(Customer customer, Account account);

    /*
    * Creates an account and adds that account to the customer Array
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
}