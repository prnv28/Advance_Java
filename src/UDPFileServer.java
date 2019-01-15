import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPFileServer {
    public static void main(String [] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6666);

        byte [] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data,data.length);
        ds.receive(dp);
        String path = new String(dp.getData(),0,dp.getLength());

        File file = new File(path);

        if(file.exists()){
            FileReader fr = new FileReader(path);
            int i;
            String content = "";
            while ((i=fr.read())!=-1){
                content+=((char)i);
            }
            data = content.getBytes();
            dp = new DatagramPacket(data,data.length,dp.getAddress(),dp.getPort());
            ds.send(dp);
        } else {
            String sendmsg="NO";
            data = sendmsg.getBytes();
            dp = new DatagramPacket(data,data.length,dp.getAddress(),dp.getPort());
            ds.send(dp);

            data = new  byte[1024];
            dp = new DatagramPacket(data,data.length);
            ds.receive(dp);

            String content = new String(dp.getData(),0,dp.getLength());
            FileWriter fw = new FileWriter(path);
            fw.write(content);
            fw.close();
            System.out.println("File created succesfully.");
        }

    }
}
