package controller;

import integrations.InventorySystem;
import integrations.CashRegister;
import integrations.DatabaseException;
import integrations.FileLogger;
import integrations.InvalidItemIdException;
import integrations.Item;
import integrations.Printer;
import java.util.ArrayList;
import java.util.List;
import model.Receipt;
import model.Sale;
import model.SaleObserver;

/**
 * This is the program's only controller. All calls to the model pass through this class.
 * @author Hjalmar
 */

public class Controller {

	private Sale sale;
        private Receipt receipt;
        private Printer printer;
        private InventorySystem inventorySystem;
        private CashRegister cashRegister;
        private List<SaleObserver> saleObservers = new ArrayList<>();
        
        /**
         * Creates a new instance of Controller
         * with references to <code>inventorySystem</code>, <code>cashRegister</code>,
         * and <code>printer</code>.
         * 
         * @param inventorySystem represents the store's inventorysystem.
         * @param cashRegister represents the store's cash register.
         * @param printer represents the receipt printer.
         */
        
        public Controller(InventorySystem inventorySystem, CashRegister cashRegister, Printer printer){
            this.inventorySystem = inventorySystem;
            this.cashRegister = cashRegister;
            this.printer = printer;
        }

	/**
         * Starts new sale.
         * Method most be called before doing anything anything else during a sale.
         */
	public Sale startSale() {
            sale = new Sale();
            return sale;
	}
        
        /**
         * Method runs when cashier scans an item into current sale.
         * Method first checks if the item exists in inventory system.
         * Then it adds it into current sale or throws a fake error (print).
         * 
         * 
         * @param itemId is what is used to identifie the item
         * @param quantity is the quantity of the item that is scanned.
         * @throws InvalidItemIdException if the retrieved item id does not exist in inventory system. Exception is passed between inventory system and view.
         * @throws DatabaseException if the database can't be reached. Exception is passed between inventory system and view.
         * @return returns <code>validItem</code> or null, which tells if
         * the item's id match with an item in the inventory system or not.
         */

	public Item scanItem(int itemId, int quantity) throws InvalidItemIdException, DatabaseException {
                Item item = inventorySystem.lookForItem(itemId);
                if(item != null){
                sale.addItemToSale(item,quantity);
                return item;
                }
                return null;
	}
        
        /**
         * Method that represents when the cashier ends the sale.
         */
        public double endSale() {
            return sale.endSale();
	}
        
        /**
         * Method to add Sale observer.
         * @param obs represents the observer added to the ArrayList.
         */
        public void addSaleObserver(SaleObserver obs) {
        this.saleObservers.add(obs);
        }
        
        /**
         * Method that represents when the cashier has recieved the payment from
         * the customer and enters it into the program.
         * pay also adds observer to SaleObserver.
         * 
         * @param amountPaid represents the amount paid by the customer.
         */

	public void pay(double amountPaid) {
           sale.pay(amountPaid);
           cashRegister.addPayment(sale.getRunningTotal());
           sale.addRevenueObserver(this.saleObservers);
           createReceipt();
	}
        
        /**
         * Method for creating the receipt and send it to the printer.
         */
        
        public void createReceipt(){
            this.receipt = new Receipt(sale);
            printer.Printer(this.receipt);
        }

}
