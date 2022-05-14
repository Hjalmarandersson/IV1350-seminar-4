/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package integrations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CashRegisterTest {
    
    private CashRegister cashRegister;
    
    
    @BeforeEach
    public void setUp() {
        this.cashRegister = new CashRegister();
              
    }
    
    @AfterEach
    public void tearDown() {
        this.cashRegister = null;
    }

    @Test
    public void testAddPayment() {
        double payment = 150.0;
        double result = cashRegister.addPayment(payment);
        double expResult = 1150.0;
        assertEquals(expResult, result, "The right payment did not get added to cash register.");
    }
    
}
