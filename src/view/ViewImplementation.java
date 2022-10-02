package view;

import java.time.LocalDate;

import obj.Account;
import obj.Customer;
import obj.Movement;

public class ViewImplementation implements Viewable {
    
    @Override
    public Customer createCustomer() {
        int pID, pZip, pPhone;
        String pFirstName, pLastName, pMiddleInitial, 
        pStreet, pCity, pState, pEmail;

        print("Input the customers ID:");
            pID = Read.integer();
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
            pPhone = Read.integer();
        print("Input their email: ");
            pEmail = Read.string();
        print("");

        return 
            new Customer(pID, pFirstName, pLastName, pMiddleInitial,
            pStreet, pCity, pState, pZip, pPhone, pEmail);
    }

    @Override
    public Account createAccount() {
        int pID, pType;
        String pDescription;
        Double pBalance, pCreditLine, pBeginBalance;
        LocalDate pBeginBalanceTimestamp;

        print("Input the Account's ID:");
            pID = Read.integer();
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
            pType = Read.integer();
        print("");

        return 
            new Account(pID, pDescription, pBalance, pCreditLine,
            pBeginBalance, pBeginBalanceTimestamp, pType);
    }

    @Override
    public Movement createMovement() {
        int pID;
        LocalDate pTimestamp;
        double pAmount, pBalance;
        String pDescription;

        print("Input the movements ID:");
            pID = Read.integer();
        print("Input its date:");
            pTimestamp = Read.date();
        print("Input the amount");
            pAmount = Read.real();
        print("Input the balance:");
            pBalance = Read.real();
        print("Input the description:");
            pDescription = Read.string();
        print("");
        
        return 
            new Movement(pID, pTimestamp, 
            pAmount, pBalance, pDescription);
    }

    private void print(String s) {
        System.out.println(s);
    }
}