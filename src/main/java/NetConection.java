import java.io.*;
import java.net.Socket;

public class NetConection  {

    static Socket conectionSocet;

    static {
        try {
            conectionSocet = new Socket("localhost",1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public NetConection() throws IOException {
//        if(conectionSocet.isConnected()){
//            System.out.println("conect");
//        }
//    }


}
