package se.kth.iv1350.higherGrade.discount;

import java.util.ArrayList;
import se.kth.iv1350.higherGrade.dto.*;

/** 
 * The interface that is used to find discounts for the sale. The different discounts implements this
 * and finds the discounts in different ways, with different algorithms. 
 */
public interface DiscountFinder {

    ArrayList<DiscountDTO> findDiscount(SaleDTO saleDTO, ArrayList<DiscountDTO> availableDiscounts);
}
