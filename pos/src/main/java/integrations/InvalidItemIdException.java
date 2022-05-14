package integrations;

/**
 * Exception that is thrown when a specific item id can't be found.
 * @author Hjalmar
 */
public class InvalidItemIdException extends Exception {
    
    /**
     * Creates a new instance of InvalidItemIdException.
     * @param itemId represents the item id.
     */
    public InvalidItemIdException(int itemId){
        super("The item with id: " + itemId + " can't be found in inventory system.");
    }
}