package view;

import java.time.LocalDate;

import obj.Account;
import obj.AccountType;
import obj.Customer;
import obj.Movement;

public class ObjectCreator {
    /**Asks the data of a Customer and 
     * returns the corresponding object.
     * @see Customer
     */
    public static Customer createCustomer() {
        int pZip;
        String pID, pPhone, pFirstName, pLastName, pMiddleInitial, 
        pStreet, pCity, pState, pEmail;

        print("Input the customers ID:");
            pID = Read.string();
            pID.replaceAll("[^\\d.]", "");
        print("Input their first name:");
            pFirstName = Read.string();
        print("Input their last name:" );
            pLastName = Read.string();
        print("Input their middle initial: ");
            pMiddleInitial = Read.string().charAt(0) + "";
        print("Input their street: ");
            pStreet = Read.string();
        print("Input their city: ");
            pCity = Read.string();
        print("Input the state: ");
            pState = Read.string();
        print("Input the ZIP: ");
            pZip = Read.integer();
        print("Input their phone number: ");
            pPhone = Read.string();
        print("Input their email: ");
            pEmail = Read.string();

        return 
            new Customer(pID, pFirstName, pLastName, pMiddleInitial,
            pStreet, pCity, pState, pZip, pPhone, pEmail);
    }
    /**Asks the data of an Account and 
     * returns the corresponding object.
     * @see Account
     */
    public static Account createAccount() {
        AccountType pType;
        String pID, pDescription;
        Double pBalance, pCreditLine, pBeginBalance;
        LocalDate pBeginBalanceTimestamp;

        print("Input the Account's ID:");
            pID = Read.string();
            pID.replaceAll("[^\\d.]", "");
        print("Input its description:");
            pDescription = Read.string();
        print("Input its balance:");
            pBalance = Read.real();
        print("Input its credit line:");
            pCreditLine = Read.real();
        print("Input its begin balance:");
            pBeginBalance = Read.real();
        print("Input its begin balance's timestamp:");
            pBeginBalanceTimestamp = Read.date();
        print("Select the account type:");
            pType = (Read.integer() == 0) ? AccountType.STANDARD : AccountType.CREDIT;

        return 
            new Account(pID, pDescription, pBalance, pCreditLine,
            pBeginBalance, pBeginBalanceTimestamp, pType);
    }
    /**Asks the data of a Movement and 
     * returns the corresponding object.
     * @see Movement
     */
    public static Movement createMovement() {
        LocalDate pTimestamp;
        double pAmount, pBalance;
        String pID, pDescription;

        print("Input the movements ID:");
            pID = Read.string();
            pID.replaceAll("[^\\d.]", "");
        print("Input its date:");
            pTimestamp = Read.date();
        print("Input the amount");
            pAmount = Read.real();
        print("Input the balance:");
            pBalance = Read.real();
        print("Input the description:");
            pDescription = Read.string();
        
        return 
            new Movement(pID, pTimestamp, 
            pAmount, pBalance, pDescription);
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}