package infrastructure.logging;


import java.text.SimpleDateFormat;
import java.util.Date;

public class StdTestLogger implements AbstractLogger {
    public static int counter = 0;

    @Override
    public void log(String operation){
        System.out.println(getEntry(operation));
    }

    private String getEntry(String operation){
        counter++;
        Date curDate = new Date();
        String formatatedDate = new SimpleDateFormat("HH:mm:ss.SSS").format(curDate.getTime());

        return counter +") " + formatatedDate + "[" + Thread.currentThread().getName() + "]: " + operation;
    }

    public void atFinish(){

    }

    public void atStart(){

    }

}
