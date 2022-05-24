
package integrations;

/**
 * Exception that is thrown when a database can't be reached.
 * @author Hjalmar
 */
public class DatabaseException extends RuntimeException {
    
    /**
     * Creates a new instance of DatabaseException.
     */
    public DatabaseException(){
        super("No connection with database. Reconnect and try again.");
    }
}
