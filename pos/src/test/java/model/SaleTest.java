/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model;

import integrations.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class SaleTest {
    private Sale sale;
    
    @BeforeEach
    public void setUp(){
        this.sale = new Sale();
    }
    
    @AfterEach
    public void tearDown(){
        this.sale = null;
    }
    
    @Test
    public void testCheckItemOccurrence() {
        Item item = new Item(2,"250g Lingonberry jam","Swedish Lingonberry jam", 35, 0.06);
        this.sale.addItemToSale(item, 2);
        boolean result = this.sale.checkItemOccurrence(item, 0);
        boolean expResult = true;
        assertEquals(expResult, result, "Item occurs in sale");
    }

    @Test
    public void testAddOneItemToSale() {
        Item item = new Item(2,"250g Lingonberry jam","Swedish Lingonberry jam", 35, 0.06);
        this.sale.addItemToSale(item, 2);
        int result = sale.getItems().size();
        int expResult = 1;
        assertEquals(expResult,result,"Item wasn't added to sale.");
    }
    @Test
    public void testAddTwoItemsToSale() {
        Item itemOne = new Item(2,"250g Lingonberry jam","Swedish Lingonberry jam", 35, 0.06);
        Item itemTwo = new Item(3,"Brown sauce","Swedish Brown sauce", 20, 0.06);
        this.sale.addItemToSale(itemOne, 1);
        this.sale.addItemToSale(itemTwo, 1);
        int result = sale.getItems().size();
        int expResult = 2;
        assertEquals(expResult,result,"Fewer or more than 2 items were added.");
    }
    @Test
    public void testAddSameItemsToSale() {
        Item itemOne = new Item(2,"250g Lingonberry jam","Swedish Lingonberry jam", 35, 0.06);
        this.sale.addItemToSale(itemOne, 1);
        this.sale.addItemToSale(itemOne, 1);
        int result = sale.getQuantity().get(0);
        int expResult = 2;
        assertEquals(expResult,result,"The items are different.");
    }

    @Test
    public void testPay() {
        double testPayment = 150.0; 
        this.sale.pay(testPayment);
        double result = sale.getAmountPaid();
        double expResult = 150.0;
        assertEquals(expResult, result, "The correct amount wasn't added to sale.");
    }
    
}
