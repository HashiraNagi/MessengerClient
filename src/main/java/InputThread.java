import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputThread implements Runnable{

    GUI mainwindow = GUI.getWindow();

    @Override
    public void run() {

        InputStream Sockin = null;
        try {
            Sockin = NetConection.conectionSocet.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(Sockin);

        try {
            while (true) {

                TempDataHolder.inputData = in.readUTF();
                System.out.println(TempDataHolder.inputData);
                mainwindow.outputTextField.append(TempDataHolder.inputData);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public String getData(String data){
//
//
//    }
}
