package higherGrade.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.higherGrade.controller.Controller;
import se.kth.iv1350.higherGrade.integration.*;
import se.kth.iv1350.higherGrade.dto.SaleInfoDTO;
import se.kth.iv1350.higherGrade.dto.ItemDTO;

public class ControllerTest {
    private Controller instance;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @Before
    public void setUp(){
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);

        EIShandler eis = new EIShandler();
        EAShandler eas = new EAShandler();
        DChandler dc = new DChandler();
        Printer printer = new Printer();

        instance = new Controller(eas, eis, dc, printer);
        instance.startSale();
    }

    @After
    public void tearDown(){
        printoutBuffer = null;
        System.setOut(originalSysOut);

        instance = null;
    }

    @Test
    public void testUIHasStarted()
    {
        String printout = printoutBuffer.toString();
        String expectedOutput = "success";
        assertTrue("Controller did not start correctly.", printout.contains(expectedOutput));
    }

    @Test
    public void testStartSale(){

        String printout = printoutBuffer.toString();
        String expectedOutput = "success";
        assertTrue("Controller did not start correctly.", printout.contains(expectedOutput));

    }

    @Test
    public void testIdentifyItem(){

        ItemDTO itemInfo = new ItemDTO(null, "green apple", 0, 0, "1234");
        SaleInfoDTO saleInfoDTO;
        try {
            saleInfoDTO = instance.identifyItem(itemInfo.getIdentifier());
        } catch (ItemNotFoundException | ServerDownException e) {
            fail("Exception was thrown");
            return;
        }

        assertEquals("Item was not Identified", itemInfo.getDescription(), 
                    saleInfoDTO.getItemDescription());
    }

    @Test
    public void addItemPrintsWhenExceptionIsThrown() {
        try {
            instance.identifyItem("INVALID IDENTIFIER");
            fail("Exception was not thrown when it should have");
        } catch (ItemNotFoundException | ServerDownException exception) {
            String printOut = printoutBuffer.toString();
            String expectedOutput = "DEVELOPER";
            assertTrue("Controller did not log as expected", printOut.contains(expectedOutput));
        }
    }



    @Test
    public void testPay(){
        double amountPaid = 100;
        SaleInfoDTO saleInfo;
        try {
            saleInfo = instance.identifyItem("1234");
        } catch (ItemNotFoundException | ServerDownException e) {
            fail("Exception was thrown");
            return;
        }
        double totalPrice = saleInfo.getRunningTotal();
        double calculatedChange = instance.pay(amountPaid, null);

        assertEquals("Change was not correctly calculated", 
                    (amountPaid - totalPrice), calculatedChange, 0.01);
    }
}