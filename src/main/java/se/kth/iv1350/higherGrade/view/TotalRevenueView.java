package se.kth.iv1350.higherGrade.view;

/**
 * TotalRevenueView This class writes to the console whenever notified.
 */
public class TotalRevenueView extends TotalRevenueDisplay {

    /** 
     *
     *
     */
    @Override
    protected void handleErrors(Exception e) {
        System.out.println("Could not write total revenue :(");
    }

    /** 
     * Writes the total revenue since the program started, to the console log
     * @param priceOfPurchase The price paid for the current sale
     */
    @Override
    protected void doShowTotalIncome(double totalRevenue) throws Exception{
        System.out.println("--- A message from TotalRevenueobserver ---");
        System.out.println("The total revenue since the program started is: " + totalRevenue);
    }
    
}

