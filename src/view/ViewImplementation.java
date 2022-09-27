package view;

import java.time.LocalDate;

import obj.Account;
import obj.Customer;

public class ViewImplementation {
    public static Customer inputCustomer() {
        int pID, pZip, pPhone;
        String pFirstName, pLastName, pMiddleInitial, 
        pStreet, pCity, pState, pEmail;

        System.out.println("Input the customers ID:");
            pID = Read.integer();
        System.out.println("Input their first name:");
            pFirstName = Read.string();
        System.out.println("Input their last name:" );
            pLastName = Read.string();
        System.out.println("Input their middle initial: ");
            pMiddleInitial = Read.string().charAt(0) + "";
        System.out.println("Input their street: ");
            pStreet = Read.string();
        System.out.println("Input their city: ");
            pCity = Read.string();
        System.out.println("Input the state: ");
            pState = Read.string();
        System.out.println("Input the ZIP: ");
            pZip = Read.integer();
        System.out.println("Input their phone number: ");
            pPhone = Read.integer();
        System.out.println("Input their email: ");
            pEmail = Read.string();

        return 
            new Customer(pID, pFirstName, pLastName, pMiddleInitial,
            pStreet, pCity, pState, pZip, pPhone, pEmail);
    }

    public static Account createAccount() {
        int pID, pType;
        String pDescription;
        Double pBalance, pCreditLine, pBeginBalance;
        LocalDate pBeginBalanceTimestamp;

        System.out.println("Input the Account's ID:");
            pID = Read.integer();
        System.out.println("Input its description:");
            pDescription = Read.string();
        System.out.println("Input its balance:");
            pBalance = Read.aDouble();
        System.out.println("Input its credit line:");
            pCreditLine = Read.aDouble();
        System.out.println("Input its begin balance:");
            pBeginBalance = Read.aDouble();
        System.out.println("Input its begin balance's timestamp:");
            pBeginBalanceTimestamp = Read.date();
        System.out.println("Select the account type:");
            pType = Read.integer();
        return 
            new Account(pID, pDescription, pBalance, pCreditLine,
            pBeginBalance, pBeginBalanceTimestamp, pType);
    }
    
}
