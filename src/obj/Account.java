package obj;

import java.time.LocalDate;
import java.util.ArrayList;


public class Account {

    private Integer ID;
    private String description;
    private Double balance;
    private Double creditLine;
    private Double beginBalance;
    private LocalDate beginBalanceTimestamp;
    private AccountType type;
    private ArrayList<Movement> Movements;

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

    public Account(
    Integer pID, String pDescription, Double pBalance, Double pCreditLine, 
    Double pBeginBalance, LocalDate pBeginBalanceTimestamp, Integer pType) {
        if (pType == 0)
            // TODO: select the type from integer.
            new Object();
        else 
            // do the other stuffs
            new Object();
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
}
