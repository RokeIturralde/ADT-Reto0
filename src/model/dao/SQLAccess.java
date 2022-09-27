package model.dao;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SQLAccess {
    public Connection con;
    // access to the database access credentials.
    private final ResourceBundle config = 
        ResourceBundle.getBundle("resources.database_access");

    // store the credentials in local Strings.
    private final String 
        url = config.getString("URL"),
        user = config.getString("USER"),
        pass = config.getString("PASSWORD");

    public void openConnection() {
        con = null;
        try {
            con = DriverManager
                .getConnection(url, user, pass);
        } catch (SQLException sqle) {
            // TODO: throw the exception.
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException sqle) {
            // TODO: handle exception.
        }
    }
}
