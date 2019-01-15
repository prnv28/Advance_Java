import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String [] args ) throws IOException {

        DatagramSocket ds = new DatagramSocket();

        DataInputStream dis = new DataInputStream(System.in);
        System.out.print("Enter String : ");
        String str = dis.readLine();
        byte [] data = str.getBytes();
        DatagramPacket dp = new DatagramPacket(data,data.length, InetAddress.getLocalHost(),6666);
        ds.send(dp);

        data= new byte[1024];
        dp = new DatagramPacket(data,data.length);
        ds.receive(dp);
        str = new String(dp.getData(),0,dp.getLength());
        System.out.println("Output : "+str);
    }
}
