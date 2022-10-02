package model;

import java.util.ResourceBundle;

import model.dao.ModelFileImplementation;
import model.dao.ModelImplementation;

public class ModelFactory {
    /**System to check the system used to 
     * manage the information. File or Database
     * @see ResourceBundle
     */
    private static String type = 
        ResourceBundle
            .getBundle("resources.datamode")
                .getString("SYSTEM");

    public static Modelable getAccess() {
        if (type.toUpperCase().contains("DATABASE"))
            return new ModelImplementation();
        else if (type.toUpperCase().contains("FILE"))
            return new ModelFileImplementation();
            
        return new ModelFileImplementation();
    }
}