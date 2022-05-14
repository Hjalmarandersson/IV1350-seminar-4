package model;

import java.time.LocalDateTime;
import integrations.Item;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents one single sale made by one single customer.
 * @author Hjalmar
 */

public class Sale {

	private double runningTotal;
        private double amountPaid;
        private double taxAmount;
        private double change;
        private boolean alreadyAdded;
	private LocalDateTime saleTime;
        private ArrayList<Item> itemInSale;
        private ArrayList<Integer> itemQuantityInSale;
        private List<SaleObserver> SaleObservers = new ArrayList<>();
        
        /**
         * Creates a new instance of Sale.
         */
        
	public Sale(){
            this.saleTime = LocalDateTime.now();
            this.taxAmount = 0;
            this.change = 0;
            this.alreadyAdded = false;
            this.itemInSale = new ArrayList<Item>();
            this.itemQuantityInSale = new ArrayList<Integer>();
            
	}
        
        /**
         * Method to check if item exists in Sale of not.
         * 
         * @param item represents one item.
         * @param itemPos represents the item index in the <code>ArrayList itemInSale</code>.
         * 
         * @return returns true or false depending on if the item exists in sale.
         */

	public boolean checkItemOccurrence(Item item, int itemPos) {
            if (item.getItemId() == itemInSale.get(itemPos).getItemId()){
                return true;
            } else {
            return false;
            }
	}
        
        /**
         * Method to add items to current sale.
         * If the itemInSale is empty, it adds the item directly.
         * If the itemInSale is not empty, it checks if the item
         * has already been added and increment the quantity of it. Otherwise
         * it just adds it to the ArrayList itemInSale
         * 
         * @param item represents an item in the store that's being added to Sale.
         * @param quantity represents the quantity of the item that is added.
         */

	public void addItemToSale(Item item, int quantity) {
            if(itemInSale.isEmpty()){
                itemInSale.add(item);
                itemQuantityInSale.add(quantity);
                alreadyAdded = true;
            }
            if(itemInSale.isEmpty() == false){
                for(int itemPos = 0; itemPos < itemInSale.size(); itemPos++){
                if(checkItemOccurrence(item, itemPos) == true && alreadyAdded == false){
                int incrementQuantity = itemQuantityInSale.get(itemPos);
                itemQuantityInSale.set(itemPos, incrementQuantity += quantity);
                alreadyAdded = true;
                }
                }
              if(alreadyAdded == false){
                    itemInSale.add(item);
                    itemQuantityInSale.add(quantity);
                    alreadyAdded = true;
              }
            }
            alreadyAdded = false;
            calculateRunningTotal(item, quantity);
            calculateTaxAmount(item, quantity);
	}
        
        private void calculateRunningTotal(Item item, int quantity){
            this.runningTotal += item.getPrice() * quantity;
        }
        
        private void calculateTaxAmount(Item item, int quantity){
            this.taxAmount += (item.getTaxRate() * item.getPrice())* quantity;
        }
        
        private void calculateChange(double amountPaid){
            this.change = amountPaid - this.runningTotal;
        }
        
        /**
         * Method that represents the end of an sale.
         */
        
        public double endSale() {
            return this.getRunningTotal();
	}
        
        /**
         * Method that represents when the cashier has recieved the payment from
         * the customer and calculates the change.
         * 
         * @param amountPaid represents the amount paid by the customer.
         */

	public void pay(double amountPaid) {
            this.amountPaid = amountPaid;               
            calculateChange(amountPaid);
	}
        
        private void notifyObservers(){
            for(SaleObserver obs : this.SaleObservers){
                double revenue = this.amountPaid - this.change;
                obs.revenueUpdate(revenue);
            }
        }
        
        public void addRevenueObserver(List<SaleObserver> obs){
           this.SaleObservers.addAll(obs);
           notifyObservers();
        }
        
        /**
         * Getter method for running total.
         */
        
        public double getRunningTotal(){
            return this.runningTotal;
        }
        
        /**
         * Getter method for tax amount.
         */
        
        public double getTaxAmount(){
            return this.taxAmount;
        }
        
        /**
         * Getter method for change.
         */
        
        public double getChange(){
            return this.change;
        }
        
        /**
         * Getter method for items in sale.
         */
        
        public ArrayList<Item> getItems(){
            return this.itemInSale;
        }
        
        /**
         * Getter method for the item quantity in sale.
         */
        
        public ArrayList<Integer> getQuantity(){
            return this.itemQuantityInSale;
        }
        
        /**
         * Getter method for sale time and date.
         */
        
        public LocalDateTime getTimeOfSale(){
            return this.saleTime;
        }
        
        /**
         * Getter method for amount paid.
         */
        
        public double getAmountPaid(){
            return this.amountPaid;
        }
        
        

}
