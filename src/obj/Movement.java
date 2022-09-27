package obj;

import java.time.LocalDate;

public class Movement {
    
    private Integer ID;
    private LocalDate timestamp;
    private double amount;
    private double balance;
    private String description;

    public Movement(Integer pID) {
        ID = pID;
    }

    public Movement(
        Integer pID, LocalDate pTimestamp, 
        double pAmount, double pBalance, String pDescription) {
        ID = pID;
        timestamp = pTimestamp;
        amount = pAmount;
        balance = pBalance;
        description = pDescription;
    }    

    // Getters.
    public Integer getID() {
        return ID;
    }
    public LocalDate getTimestamp() {
        return timestamp;
    }
    public double getAmount() {
        return amount;
    }
    public double getBalance() {
        return balance;
    }
    public String getDescription() {
        return description;
    }

    // Setters.
    public void setID(Integer pID) {
        ID = pID;
    }
    public void setTImestamp(LocalDate pTimestamp) {
        timestamp = pTimestamp;
    }
    public void setAmount(double pAmount) {
        amount = pAmount;
    }
    public void setBalance(double pBalance) {
        balance = pBalance;
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }
}