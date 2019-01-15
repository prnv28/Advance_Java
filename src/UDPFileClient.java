import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPFileClient {
    public static void main(String [] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();

        DataInputStream dis = new DataInputStream(System.in);
        System.out.print("Enter Path : ");
        String path = dis.readLine();
        byte [] data = path.getBytes();
        DatagramPacket dp = new DatagramPacket(data,data.length, InetAddress.getLocalHost(),6666);
        ds.send(dp);

        data = new byte[1024];
        dp = new DatagramPacket(data,data.length);
        ds.receive(dp);
        String str2 = new String(dp.getData(),0,dp.getLength());

        if(str2.equals("NO")){
            System.out.println("File Not Found.");
            System.out.print("Enter Content : ");
            dis = new DataInputStream(System.in);
            String send_content = dis.readLine();
            data = send_content.getBytes();
            dp = new DatagramPacket(data,data.length,dp.getAddress(),dp.getPort());
            ds.send(dp);
        }else {
            System.out.println("File Content : "+str2);
        }
    }
}
