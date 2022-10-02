package obj;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {

    private String ID;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private String phone;
    private String email;
    private ArrayList <Account> accounts = new ArrayList <Account> ();

    public Customer(String pID) {
        ID = pID;
    }

    public Customer(
        String pID, String pFirstName, String pLastName,
            String pMiddleInitial, String pStreet, String pCity,
            String pState, Integer pZip, String pPhone, String pEmail) {
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
    public String getID() {
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

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    // Setters.
    public void setID(String ID) {
        this.ID = ID;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void addAccount(Account pAccount) {
        accounts.add(pAccount);
    }

    @Override
    public String toString() {
        return 
            "ID: " + ID + "\n" +
            "First name: " + firstName + "\n" +
            "Last name: " + lastName + "\n" +
            "Middle initial: " + middleInitial + "\n" +
            "Street: " + street + "\n" +
            "City: " + city + "\n" +
            "State: " + state + "\n" +
            "ZIP: " + zip + "\n" +
            "Phone: " + phone + "\n" +
            "Email: " + email;
    }

}