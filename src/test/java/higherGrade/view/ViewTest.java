package higherGrade.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.higherGrade.integration.*;
import se.kth.iv1350.higherGrade.view.View;
import se.kth.iv1350.higherGrade.controller.Controller;


import static org.junit.Assert.assertTrue;

public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    @Before
    public void setUp() {
        EIShandler eis = new EIShandler();
        EAShandler eas = new EAShandler();
        DChandler dc = new DChandler();
        Printer printer = new Printer();
        Controller contr = new Controller(eas, eis, dc, printer);
        instanceToTest = new View(contr);
        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @After
    public void tearDown() {
        instanceToTest = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testRunFakeExecution() {
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "started";
        assertTrue("UI did not start correctly.", printout.contains(expectedOutput));
        expectedOutput = "change";
        assertTrue("Did not reach the end of the function.", printout.contains(expectedOutput));
    }
}
