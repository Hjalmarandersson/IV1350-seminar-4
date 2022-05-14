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
        result = instance.lookForItem(enteredItemId).getName();
        expResult = null;
        fail("Exception wasn't thrown since an item was found.");
        } catch(DatabaseException | InvalidItemIdException e){
            System.out.println(e.getMessage());
        }
            assertEquals(expResult, result, "Database connection was OK.");
        
    }
    
    @Test
    public void testInvalidItemIdException() {
        int enteredItemId = 6;
        try {
        result = instance.lookForItem(enteredItemId).getName();
        expResult = null;
        fail("Exeption wasn't thrown since item was found");
        } catch(DatabaseException | InvalidItemIdException e){
            System.out.println(e.getMessage());
        }
        assertEquals(expResult, result, "Unexpected item was found");
        
    }
    
    
}
