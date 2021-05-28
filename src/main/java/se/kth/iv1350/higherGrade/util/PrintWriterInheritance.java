package se.kth.iv1350.higherGrade.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class PrintWriterInheritance extends PrintWriter{

    public PrintWriterInheritance() throws IOException {
        super(new FileWriter("total-revenue-inheritance.txt"),true);
    }

    @Override
    public void println(String message){
        super.println("Print from: "+ LocalTime.now().toString() + "\n" + message);
    }

    
}
