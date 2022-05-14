package view;

import model.SaleObserver;

/**
 *
 * @author Hjalmar
 */
public class TotalRevenueView implements SaleObserver {
    private double revenue;

    @Override
    public void revenueUpdate(double runningTotal) {
        this.revenue += runningTotal;
        System.out.println("Revenue update: " + this.revenue);
    }
    
}
