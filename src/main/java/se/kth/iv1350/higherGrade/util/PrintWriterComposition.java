package se.kth.iv1350.higherGrade.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class PrintWriterComposition{
    PrintWriter printWriter;

    public PrintWriterComposition() throws IOException{
        printWriter = new PrintWriter(new FileWriter("total-revenue-composition.txt"),true);
    }

    public void println(String message){
        printWriter.println("Print from: "+ LocalTime.now().toString()+ "\n" + message);
    }

    
}
