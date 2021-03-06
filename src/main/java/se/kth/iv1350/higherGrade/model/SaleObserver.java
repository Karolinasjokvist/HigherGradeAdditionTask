package se.kth.iv1350.higherGrade.model;

public interface SaleObserver {
    /**
     * This function is called when a sale is completed
     * 
     * @param priceOfPurchase The cost of the sale
     */
    public void newSale(double priceOfPurchase);
    
}