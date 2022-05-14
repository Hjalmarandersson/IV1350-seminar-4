package model;

import integrations.Item;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Contains, and represents, everything in a reciept that proves the payment.
 * @author Hjalmar
 */

public class Receipt {
    private LocalDateTime dateAndTime;
    private ArrayList<Item> itemInSale = new ArrayList<Item>();
    private ArrayList<Integer> itemQuantityInSale = new ArrayList<Integer>();
    private double totalPrice;
    private double totalTax;
    private double amountPaid;
    private double change;
    
    /**
      * Creates a new instance of Printer.
      * 
      * @param sale represents the sale and contains information about current sale.
      */
    
    public Receipt(Sale sale){
        this.dateAndTime = sale.getTimeOfSale();
        this.itemInSale = sale.getItems();
        this.itemQuantityInSale = sale.getQuantity();
        this.totalPrice = sale.getRunningTotal();
        this.totalTax = sale.getTaxAmount();
        this.amountPaid = sale.getAmountPaid();
        this.change = sale.getChange();
    }
    
    /**
      * @return the items in sale that is going to be on the receipt.
      */
    
    public ArrayList<Item> printItems(){
        return this.itemInSale;
    }
    
    /**
      * @return the quantity of the items that should be printed on receipt.
      */
    
    public ArrayList<Integer> printQuantity(){
        return this.itemQuantityInSale;
    }
    
    /**
      * @return the date and time of the sale that should be printed on the receipt.
      */
    
    public LocalDateTime printDateAndTime(){
        return this.dateAndTime;
    }
    
    /**
      * @return the total price that should be printed on receipt.
      */
    
    public double printTotalPrice(){
        return this.totalPrice;
    }
    
    /**
      * @return the total tax that should be printed on receipt.
      */
    
    public double printTotalTax(){
        return this.totalTax;
    }
    
    /**
      * @return the amount paid by customer that should be printed on receipt.
      */
    
    public double printAmountPaid(){
        return this.amountPaid;
    }
    
    /**
      * @return the amount of change that the customer should receive
      */
    
    public double printChange(){
        return this.change;
    }
}
