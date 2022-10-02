package obj;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account implements Serializable{

    private Integer ID;
    private String description;
    private Double balance;
    private Double creditLine;
    private Double beginBalance;
    private LocalDate beginBalanceTimestamp;
    private AccountType type;
    private ArrayList <Movement> Movements = new ArrayList <Movement> ();

    public ArrayList<Movement> getMovements() {
        return Movements;
    }

    public void setMovements(ArrayList<Movement> Movements) {
        this.Movements = Movements;
    }

    public Account(Integer pID) {
        ID = pID;
    }

    public Account(
            Integer pID, String pDescription, Double pBalance, Double pCreditLine,
            Double pBeginBalance, LocalDate pBeginBalanceTimestamp, AccountType pType) {
        ID = pID;
        balance = pBalance;
        creditLine = pCreditLine;
        beginBalance = pBeginBalance;
        beginBalanceTimestamp = pBeginBalanceTimestamp;
        type = pType;
    }
    // Getters.
    public Integer getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getCreditLine() {
        return creditLine;
    }

    public Double getBeginBalance() {
        return beginBalance;
    }

    public LocalDate getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public AccountType getType() {
        return type;
    }

    // Setters.
    public void setDescription(String pDescription) {
        description = pDescription;
    }

    public void setBalance(Double pBalance) {
        balance = pBalance;
    }

    public void setCreditLine(Double pCreditLine) {
        creditLine = pCreditLine;
    }

    public void setBeginBalance(Double pBeginBalance) {
        beginBalance = pBeginBalance;
    }

    public void setBeginBalanceTimestamp(LocalDate pBeginBalanceTimestamp) {
        beginBalanceTimestamp = pBeginBalanceTimestamp;
    }

    public void setType(AccountType pType) {
        type = pType;
    }
    /**This method DOES NOT return the accounts.
     * They have to be printed separately.
     */
    @Override
    public String toString() {
        String s = 
            "ID: " + ID + "\n" +
            "Description: " + description + "\n" +
            "Balance: " + balance + "\n" +
            "Credit line: " + creditLine + "\n" +
            "Begin balance: " + beginBalance + "\n" +
            "Credit line: " + creditLine + "\n" +
            "Begin balance: " + beginBalance + "\n" +
            "Begin balance timestamp: " +
            beginBalanceTimestamp.format(
                DateTimeFormatter
                    .ofPattern("d/MM/yyyy")) + "\n";

        if (type.equals(AccountType.STANDARD))
            s += "Account type: " + AccountType.STANDARD.toString();
        else 
            s += "Account type: " + AccountType.CREDIT.toString();

        return s;
    }
    
    public void addMovement(Movement pMovement){
        Movements.add(pMovement);
    }
}