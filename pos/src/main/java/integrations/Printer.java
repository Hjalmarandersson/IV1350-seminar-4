package integrations;

import model.Receipt;

/**
 * Represents the printer that prints the Receipt after a sale has ended.
 * @author Hjalmar
 */

public class Printer {
        /**
         * Creates a new instance of Printer.
         * 
         * @param receipt represents the receipt containing information
         * about the current sale.
         */
	public void Printer(Receipt receipt) {
		System.out.println("Purchase Certificate");
                System.out.println("Time of purchase: " + receipt.printDateAndTime());
                for(int i = 0; i < receipt.printItems().size(); i++){
                    System.out.print("Item: " + receipt.printItems().get(i).getName() + " Price: " + receipt.printItems().get(i).getPrice() + " Quantity: " + receipt.printQuantity().get(i) );
                    System.out.println();
                }
                System.out.println("Total price: " + receipt.printTotalPrice());
                System.out.println("Total tax: " + receipt.printTotalTax());
                System.out.println("Amount paid: " + receipt.printAmountPaid());
                System.out.println("Change: " + receipt.printChange());
	}

}
