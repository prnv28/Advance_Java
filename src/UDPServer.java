import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String [] args ) throws IOException {

        DatagramSocket ds = new DatagramSocket(6666);

        byte [] data= new byte[1024];
        DatagramPacket dp = new DatagramPacket(data,data.length);
        ds.receive(dp);
        String str = new String(dp.getData(),0,dp.getLength());
        String str2 = str.toUpperCase();
        data = str2.getBytes();
        dp = new DatagramPacket(data,data.length, dp.getAddress(),dp.getPort());
        ds.send(dp);
    }
}
