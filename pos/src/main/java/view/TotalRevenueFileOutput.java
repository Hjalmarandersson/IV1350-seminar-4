package view;

import integrations.FileLogger;
import model.SaleObserver;

/**
 *
 * @author Hjalmar
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private double revenue;
    private FileLogger logger = new FileLogger("c:/users/hjalmar/desktop/revenuelog.txt");
    
    @Override
    public void revenueUpdate(double runningTotal) {
        this.revenue += runningTotal;
        logger.log("Revenue update", ": "+this.revenue);
    }
    
}
