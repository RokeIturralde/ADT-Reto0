package model;

import model.dao.ModelImplementation;

public class ModelFactory {
    /**Factory method that returns the
     * DAO with access to the database.
     */
    public static Modelable getAccess() {
        return new ModelImplementation();
    }
}
