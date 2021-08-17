import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputThread implements Runnable{


    @Override
    public void run() {
        // Output Stream initialization
        OutputStream Sockout = null;
        try {
            Sockout = NetConection.conectionSocet.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataOutputStream out = new DataOutputStream(Sockout);

        //Output data

        try {
            synchronized (TempDataHolder.lock) {
                while (true) {
                    TempDataHolder.lock.wait();
                    out.writeUTF(TempDataHolder.outputData);

                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
