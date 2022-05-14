
package integrations;

/**
 * Represents the store's cash register.
 * @author Hjalmar
 */
public class CashRegister {
    private double amountPresent;
    private double amountPaid;
    
    
    /**
      * Creates a new instance of CashRegister.
      */
    public CashRegister(){
        this.amountPaid = 0;
        this.amountPresent = 1000.0;
    }
    
    /**
      * Adds the paid amount from the customer to the cash reigster.
      * @param paidAmount represents the amount paid by the customer.
      * @return returns the updated amount in the cash register.
      */
    public double addPayment(double paidAmount){
        this.amountPaid = paidAmount;
        this.amountPresent = this.amountPresent + this.amountPaid;
      return this.amountPresent;
    }
    
    /**
     * @return amount present in cashRegister.
     */
    public double getAmountPresent(){
        return this.amountPresent;
    }
    
}
