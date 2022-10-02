package controller;

import obj.*;
import view.*;
import model.*;

/**@author Dani
 * 
 */
public class Controller {

    private Modelable model = 
        ModelFactory.getAccess();

    private Account a = null;
    private Customer c = null;
    private Movement m = null;


    /**Asks for data and creates a new Customer,
     * later storing it. If already created, gives
     * a message.
    */
    public void createACustomer() {
        print("Enter the data of the customer you want to create.");
        c = ObjectCreator.createCustomer();
        if (c.equals(
            model.checkDataCustomer(c.getID())))
            print("The customer already exists in the database.");
        else {
            model.addCustomer(c);
            print("The customer has succesfully been stored in the DB.");
        }
    }
    /**Shows the data of a Customer after
     * asking it's ID.
     */
    public void viewDataOfCustomer() {
        print("Please, input the ID of the customer you wish to see: ");
        c = model.checkDataCustomer(
                Read.integer() + "");

        if (c.equals(null))
            print("There's no customer with that ID in the database.");
        else
            print("The customer has the following data:\n" + c.toString());
    }
    /**Shows all the accounts of a Customer.
     * If there are none, message.
     */
    public void viewAccountsOfCustomer() {
        print("Please, input the ID of the customer you wish to see: ");
            c = model.checkDataCustomer(
                Read.integer() + "");

        if (c.equals(null))
            print("There's no customer with that ID.");
        else {
            print("The customer has the following data:\n" + c.toString());
                model.checkAccount(c);
            // TODO: it's suposed to be an array.
            if (c.getAccounts().isEmpty())
                print("\nThere are no accounts associated with the customer.");
            else {
                print("\nThese are all the accounts of this customer:");
                for (Account p : c.getAccounts())
                    print(p.toString());
            }
        }
    }
    /**Create new account for a customer.
    */
    public void createAccountToCustomer() {
        print("Please input the ID of the customer whose account you want to create: ");
            c = model.checkDataCustomer(
                Read.integer() + "");
        if (c.equals(null))
            print("There are no customer with this ID.");
        else {
            print("Please enter the data of the account you wish to create.");
                a = ObjectCreator.createAccount();
            print(
                "The account will be associated with the following customer:\n\n" + 
                c.toString() + "\n\n Are you sure? [Y/n]");
                    String s = Read.string();

            if ((s.equals("") 
            || s.toUpperCase().charAt(0) == 'y'))
                model.addAccountToCustomer(c, a);
        }
    }
    /**
     */
    public void addClientToAnAccount() {
        print("Enter the ID of the customer:\n");
            c = model.checkDataCustomer(Read.integer() + "");
        if (c.equals(null))
            print("There are no customers with that ID.");
        else
            print("Which account do you want to add to this customer? (enter the ID)\n");
                a = model.checkDataAccount(Read.integer() + "");
            if (a.equals(null))
                print("There are no accounts with that ID.");
            else {
                print(
                "Data of the Customer:\n" + c.toString() + "\n\n" +
                "Data of the Account:\n" + a.toString() + "\n\n" +
                "Are you sure about linking them? [Y/n]");
                    String s = Read.string();
                
                if (s.equals("") 
                || s.toUpperCase().charAt(0) == 'y')
                    model.addMovement(m, a);  
                
            }
    }
    /**Prints at the screen data from an account
     * after asking its ID.
     */
    public void viewDataOfAccount() {
        print("Input the ID of the account: ");
            a = model.checkDataAccount(Read.integer() + "");
        if (a == null || a.equals(null))
            print("There are no accounts with this ID.");
        else
            print(a.toString());
    }
    /**Creates a new movement that will be associated
     * with an account.
     */
    public void makeMovementInAccount() {
        print("Input the ID of the account: ");
            a = model.checkDataAccount(Read.integer() + "");
        if (a.equals(null))
            print("There are no accounts with this ID.");
        else {
            print("Please input the data of the movement:");
                m = ObjectCreator.createMovement();
            model.addMovement(m, a);
        }
    }
    /**Given the ID of an account, shows all the movements
     * associated to it.
     */
    public void viewMovementFromAccount() {
        print("Please input the ID of the account: ");
            a = model.checkDataAccount(Read.integer() + "");
        if (a.equals(null))
            print("There are no accounts with this ID. Try again.");
        else {
            print(
            "An account has been found:\n" + a.toString() + "\n" +
            "Searching for movements...\n");
            if (a.getMovements().isEmpty())
                print("There are no movements related to this account.");
            else 
                for (Movement p : a.getMovements()) 
                    print(p.toString() + "\n");
        }
    }
    /**Auxiliar method to set the values of the attributes
     * to null, just in case to avoid errors. This way it's
     * not necessary to define them in the methods. Simpler.
     */
    private void reset() {
        c = null;
        a = null;
        m = null;
    }
    /**Auxilair void to clear the screen and make it pretty.
     */
    private void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
     /**Stoopid function to make prettier the prints.
     * That's all it does really, nothing more.
     * @param obj to be printed, with a new line.
    */
    private void print(Object obj) {
        System.out.println(obj);
    }
    /**Main method of the class.
     * Calls every other private function.
     */
    public void run() {
        clear();
        print(greet);
        //while (true) {
            reset();
            print(options);
            switch (Read.integer(1, 8)) { 
                case 1: createACustomer();
                    break;
                case 2: viewDataOfCustomer();
                    break;
                case 3: viewAccountsOfCustomer();
                    break;
                case 4: createAccountToCustomer();
                    break;
                case 5: addClientToAnAccount();
                    break;
                case 6: viewDataOfAccount();
                    break;
                case 7: makeMovementInAccount();
                    break;
                case 8: viewMovementFromAccount();
                    break;
            }
        //}
    }
    /** Constant Strings to store the greeting
     * and the options of the program.
     */
    private final String greet = 
        "Welcome to the bank data management application!";
    private final String options = 
        "What would you like to do?\n\n" +
        "1. Create a customer.\n" +
        "2. View the data of a customer.\n" +
        "3. View the accounts of a customer.\n" +
        " -----------------------------------\n"+
        "4. Create a new customer's account.\n" +
        "5. Add a client to an account.\n" +
        "6. View the data of an account\n" +
        " -----------------------------------\n" +
        "7. Make movements in an acount.\n" +
        "8. View movements from an account.\n\n" +
        "Option: ";
}