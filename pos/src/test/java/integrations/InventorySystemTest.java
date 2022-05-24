package integrations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventorySystemTest {
     private InventorySystem instance;
     private String result;
     private String expResult;
     
    
    @BeforeEach
    public void setUp() {
       instance = new InventorySystem();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
        result = null;
    }

    @Test
    public void testDatabaseException() {
        int enteredItemId = 5;
        try {
        instance.lookForItem(enteredItemId).getName();
        fail("Exception wasn't thrown since an item was found.");
        } catch(DatabaseException | InvalidItemIdException e){
          assertTrue(e.getMessage().contains("No connection with database"), "DatabaseException wasn't thrown");
        }
        
    }
    
    @Test
    public void testInvalidItemIdException() {
        int enteredItemId = 6;
        try {
        instance.lookForItem(enteredItemId).getName();
        fail("Exeption wasn't thrown since item was found");
        } catch(DatabaseException | InvalidItemIdException e){
           assertTrue(e.getMessage().contains("can't be found in inventory system"), "InvalidItemIdException wasn't thrown");
        }
        
        
    }
    
    
}
