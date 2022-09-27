/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import obj.*;
import org.junit.Test;
import java.time.LocalDate;
import static obj.AccountType.STANDARD;
import static org.junit.Assert.*;

/**
 *
 * @author 2dam
 */
public class ModelImplementationTest {
    ModelImplementation modelImplement;
    
    public ModelImplementationTest() {
    }

    /**
     * Test of createCustomer method, of class ModelImplementation.
     */
    @Test
    public void testCreateCustomer() {
        modelImplement = new ModelImplementation();
        Customer pCustomer = new Customer(1, "David", "Jauregui",
            "H", "Avadia de Gracia 24", "Madrid",
            "España", 234, 655542879, "djauregui@gmail.com");
        
        modelImplement.createCustomer(pCustomer);
        assertNotNull(modelImplement.checkDataCustomer(1));
    }

    /**
     * Test of checkDataCustomer method, of class ModelImplementation.
     */
    @Test
    public void testCheckDataCustomer() {
        modelImplement = new ModelImplementation();
        assertNotNull(modelImplement.checkDataCustomer(1));
        
    }

    /**
     * Test of checkAccount method, of class ModelImplementation.
     */
    /*@Test
    public void testCheckAccount() {
        modelImplement = new ModelImplementation();
        Customer pCustomer = new Customer(2, "Juana", "Jauregui",
            "H", "Avadia de Gracia 24", "Madrid",
            "España", 234, 655542879, "jjauregui@gmail.com");
        modelImplement.createCustomer(pCustomer);
        assertNotNull(modelImplement.checkAccount(pCustomer));
    }*/

    /**
     * Test of checkDataAccount method, of class ModelImplementation.
     */
    @Test
    public void testCheckDataAccount() {
         modelImplement = new ModelImplementation();
         
    }

    /**
     * Test of addMovement method, of class ModelImplementation.
     */
    @Test
    public void testAddMovement() {
        modelImplement = new ModelImplementation();
        
    }

    /**
     * Test of checkMovement method, of class ModelImplementation.
     */
    /*@Test
    public void testCheckMovement() {
        modelImplement = new ModelImplementation();
        LocalDate date = LocalDate.now();
        Account pAccount = new Account(1,"Account for Addam's Family", 0.999, 12.334,
            12.0, date, STANDARD);
        assertNotNull(modelImplement.checkMovement(pAccount));
        
    }
    */
}
