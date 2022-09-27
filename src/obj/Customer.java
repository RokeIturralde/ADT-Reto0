package obj;

import java.util.ArrayList;

public class Customer {

    private Integer ID;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private Integer phone;
    private String email;

    public ArrayList<Account> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Account> cuentas) {
        this.cuentas = cuentas;
    }
    private ArrayList<Account> cuentas;

    public Customer(Integer ppI) {
        ID = ppI;
    }

    public Customer(
            Integer pID, String pFirstName, String pLastName,
            String pMiddleInitial, String pStreet, String pCity,
            String pState, Integer pZip, Integer pPhone, String pEmail) {
        ID = pID;
        firstName = pFirstName;
        lastName = pLastName;
        middleInitial = pMiddleInitial;
        street = pStreet;
        city = pCity;
        state = pState;
        zip = pZip;
        phone = pPhone;
        email = pEmail;
    }

    // Getters.
    public Integer getID() {
        return ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleInitial() {
        return middleInitial;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public Integer getZip() {
        return zip;
    }
    public Integer getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    // Setters.
    public void setID(Integer pID) {
        ID = pID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
