package obj;

import java.io.Serializable;
import java.time.LocalDate;

public class Movement implements Serializable {

    private String ID;
    private LocalDate timestamp;
    private double amount;
    private double balance;
    private String description;
    
    public Movement(String pID) {
    ID = pID;
    }

    public Movement(
            String pID, LocalDate pTimestamp,
            double pAmount, double pBalance, String pDescription) {
        ID = pID;
        timestamp = pTimestamp;
        amount = pAmount;
        balance = pBalance;
        description = pDescription;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    @Override
    public String toString() {
        return 
            "ID: " + ID + "\n" +
            "Timestamp: " + timestamp + "\n" +
            "Amount: " + amount + "\n" +
            "Balance: " + balance  + "\n" +
            "Description: " + description + "\n";
    }
}