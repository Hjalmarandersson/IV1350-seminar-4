package integrations;

import java.lang.String;

/**
 * Represents one item sold that is sold in a sale
 * @author Hjalmar.
 */

public class Item {

	private int itemId;
	private String name;
	private String description;
	private double price;
	private double taxRate;
        private Item item;

        /**
         * Creates an instance of Item which represents an item in the store.
         * 
         * @param itemId the unique number that every item has.
         * @param name the name of the item.
         * @param description describes the tiem.
         * @param price the price of the item.
         * @param taxRate is the tax rate (VAT) of the item.
         */
        
	public Item(int itemId, String name, String description, double price, double taxRate  ) {
          this.itemId = itemId;
          this.name = name;
          this.description = description;
          this.price = price;
          this.taxRate = taxRate;
	}
        
        /**
         * @return the price of the item.
         */
	public double getPrice() {
		return this.price;
	}
	
        /**
         * @return the id of an item
         */
	public int getItemId() {
		return this.itemId;
	}
        
        /**
         * @return the name of an item
         */
        public String getName(){
            return this.name;
        }
	
        /**
         * 
         * @return the description of an item.
         */
	public String getDescription() {
		return this.description;
	}
        
	/**
         * 
         * @return the tax rate of an item
         */
	public double getTaxRate() {
		return this.taxRate;
        }

}
