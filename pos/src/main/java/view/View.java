package view;

import controller.Controller;
import integrations.DatabaseException;
import integrations.FileLogger;
import integrations.InvalidItemIdException;
import integrations.Item;
import model.Sale;

/**
 * Contains hardcoded calls to all system operations in the controller.
 * @author Hjalmar.
 */

public class View {

	private Controller controller;
        private Sale sale;
        private FileLogger logger = new FileLogger("c:/users/hjalmar/desktop/exceptionLog.txt");
       
        
        /**
         * Creates a new instance, that uses the referenced controller for all calls to other layers.
         * 
         * @param controller is used for all calls to other layers.
         */

	public View(Controller controller) {
		this.controller = controller;
                controller.addSaleObserver(new TotalRevenueView());
                controller.addSaleObserver(new TotalRevenueFileOutput());
	}
        
        /**
         * Performs a fake sale by calling system operations in the controller.
         */
        
        public void runFakeSale(){
            System.out.println("Starting fake sale");
            sale = controller.startSale();
               
            printScannedItem(5,1);
            printScannedItem(0,1);
            printScannedItem(1,1);
            printScannedItem(2,1);
            printScannedItem(3,1);
            printScannedItem(4,1);
            printScannedItem(1,1);
            
            controller.endSale();
            System.out.println("Cashier has ended fake sale!");
            System.out.println("Total price including tax: " + controller.endSale());
            controller.pay(500.0);
        }
        
        private void printScannedItem(int itemId, int itemQuantity){
            Item item = null;
            try{
                item = controller.scanItem(itemId, itemQuantity);
            } catch(InvalidItemIdException iie){
                System.out.println(iie.getMessage());
            } catch(DatabaseException dbe){
                System.out.println(dbe.getMessage());
                logger.log("Database exception: ",dbe.getMessage());
            }
            
            if(item != null){
                System.out.println("----");
                System.out.println("Scanned item: " + item.getName());
                System.out.println("Description: " + item.getDescription());
                System.out.println("Price: " + item.getPrice());
                System.out.println("Running total:" + sale.getRunningTotal());
                System.out.println("----");
            }
        }

}
