package se.kth.iv1350.higherGrade.view;

import java.io.IOException;

import se.kth.iv1350.higherGrade.util.PrintWriterComposition;
import se.kth.iv1350.higherGrade.util.PrintWriterInheritance;

/**
 * TotalRevenueFileOutput This class writes the total income for the cash register, since the program started
 */
public class TotalRevenueFileOutput extends TotalRevenueDisplay{
    private PrintWriterComposition printWriterComp;
    private PrintWriterInheritance printWriterInh;

    /**
     * Genreates a new instance of the TotalRevenueFileOutput class
     */
    TotalRevenueFileOutput() {
        try {
            printWriterComp = new PrintWriterComposition();
            printWriterInh = new PrintWriterInheritance();
        } catch (IOException ex) {
            System.out.println("[FOR DEVELOPER] Could not create logger.");
            ex.printStackTrace();
        }
    }


    @Override
    protected void handleErrors(Exception e) {
        System.out.println("[FOR DEVELOPER] Could not write total revenue");
    }

    /** 
     * Logs the total revenue in the log file
     * @param priceOfPurchase The price paid for the current sale
     */
    @Override
    protected void doShowTotalIncome(double totalRevenue) throws Exception {
        printWriterComp.println("Total Revenue: " + totalRevenue);
        printWriterInh.println("Total Revenue: " + totalRevenue);
        
    }
}
