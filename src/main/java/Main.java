import java.io.IOException;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {
        //GUI Thread
        GUIThread guiThreadIMP = new GUIThread();
        Thread guiThread = new Thread(guiThreadIMP);
        guiThread.start();
        //Input Thread
        InputThread inputThreadIMP = new InputThread();
        Thread inputThread = new Thread(inputThreadIMP);
        inputThread.start();
        //Output Thread
        OutputThread outputThreadIMP = new OutputThread();
        Thread ouputThread = new Thread(outputThreadIMP);
        ouputThread.start();

    }

}
