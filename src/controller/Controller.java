package controller;

import model.*;
import model.dao.*;
import view.*;
import obj.*;

public class Controller {

    private Modelable model = 
        new ModelImplementation();
    private Viewable view = 
        new ViewImplementation();

    private Customer c = null;
    private Account a = null;
    private Movement m = null;

    private String greet = 
        "Welcome to the bank data management application!";
    private String options = 
        "What would you like to do?\n\n" +
        "1. Create a customer.\n" +
        "2. View the data of a customer.\n" +
        "3. View the accounts of a customer.\n" +
        " -----------------------------------\n"+
        "4. Create a new customer's account.\n" +
        "5. Add a client to an account.\n" +
        "6. View the data of an account\n" +
        " -----------------------------------\n"+
        "7. Make movements in an acount.\n" +
        "8. View movements from an account.\n";

    public void run() {
        print(greet);
        print(options);
        Read.integer(1, 8);
        reset();
    }

    /**Asks for data and creates a new Customer,
     * later storing it. If already created, gives
     * a message.
    */
    public void createACustomer() {
        c = view.createCustomer();
        if (c.equals(
            model.checkDataCustomer(c.getID())))
            print("The customer already exists in the database.");
        else {
            model.createCustomer(c);
            print("The customer has succesfully been stored in the DB.");
        }
    }
    /**Shows the data of a Customer after
     * asking it's ID.
     */
    public void viewDataOfCustomer() {
        print("Please, select the ID of the customer you wish to see:");
        c = 
            model.checkDataCustomer(
                Read.integer());

        if (c.equals(null))
            print("There's no customer with that ID in the database.");
        else
            print("The customer has the following data:\n\n" + c.toString());
    }
    /**Shows all the accounts* of a Customer.
     * If there are none, message.
     */
    public void viewAccountsOfCustomer() {
        print("What's the ID of the customer whoose accounts you wish seeing?");
            c = 
                model.checkDataCustomer(
                    Read.integer());

        if (c.equals(null))
            print("There's no customer with that ID.");
        else {
            print("This is the customer:\n" + c.toString());
                a = model.checkAccount(c);
            // TODO: it's suposed to be an array.
            if (a.equals(null))
                print("There are no accounts associated with the customer.");
            else
                print(a.toString());
        }
    }
    /**Creatae new account for a customer.
    */
    public void createAccountToCustomer() {
        print("Please input the ID of the customer:");
            c = model.checkDataCustomer(
                Read.integer());
        if (c.equals(null))
            print("There are no customer with this ID.");
        else {
            print("Please enter the data of the account you wish to create.");
                a = view.createAccount();
            print("The account will be associated with the following customer:\n\n" + c.toString());

        }
    }




    public void print(Object obj) {
        System.out.println(obj);
    }

    private void reset() {
        c = null;
        a = null;
        m = null;
    }
}