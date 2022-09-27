package model;

import java.util.ResourceBundle;

public class SQLAccess {
    private static ResourceBundle file = 
        ResourceBundle
            .getBundle("resources.sql");
    
    private static String 
        url = file.getString("URL"),
        user = file.getString("USER"),
        password = file.getString("password");


    public static void main(String[] args) {
        System.out.println(url);
    }

    
}
