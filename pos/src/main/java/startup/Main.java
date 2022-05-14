package startup;

import view.View;
import controller.Controller;
import integrations.Printer;
import integrations.CashRegister;
import integrations.InventorySystem;

/**
 * Starts the entire program, contains the main method.
 * @author Hjalmar
 */

public class Main {
        
        /**
         * The main method used to start the entire program.
         * 
         * @param args the program does not take any command line parameters.
         */
	public static void main(String[] args) {
            InventorySystem inventorySystem = new InventorySystem();
            CashRegister cashRegister = new CashRegister();
            Printer printer = new Printer();
            Controller controller = new Controller(inventorySystem, cashRegister, printer);
            View view = new View(controller);
            view.runFakeSale();           
	}

}
