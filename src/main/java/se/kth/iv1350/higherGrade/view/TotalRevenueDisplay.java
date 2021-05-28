package se.kth.iv1350.higherGrade.view;

import se.kth.iv1350.higherGrade.model.SaleObserver;

public abstract class TotalRevenueDisplay implements SaleObserver{
    private double totalRevenue;

    protected TotalRevenueDisplay(){
        totalRevenue = 0;
    }

    // This is the  method  defined  in the  observer  interface.
    public  void  newSale(double  priceOfTheSaleThatWasJustMade) {
        calculateTotalIncome(priceOfTheSaleThatWasJustMade );

        showTotalIncome ();
    }

    private void calculateTotalIncome(double priceOfPurchase) {
        totalRevenue += priceOfPurchase;
    }

    private  void  showTotalIncome () {
        try {
            doShowTotalIncome(totalRevenue);
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected  abstract  void  doShowTotalIncome (double totalRevenue) throws Exception;
    
    protected  abstract  void  handleErrors(Exception e);
}
