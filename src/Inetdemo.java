import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inetdemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        InetAddress ip = InetAddress.getByName("www.github.com");
        System.out.println("Local host : "+ host);
        System.out.println("Host : "+ip);
        
        byte[] rowaddress=ip.getAddress();
        for(int i=0;i<rowaddress.length;i++){
            System.out.println(rowaddress[i]);
        }
        if(ip.isMulticastAddress()){
            System.out.println("Multiclass Address : YES");
        }
        else{
            System.out.println("Multiclass Adderess : NO");
        }

        System.out.println("Local host name : " + host.getHostName());
        System.out.println("Local host IP : " + host.getHostAddress());
        System.out.println("Host Name : " + ip.getHostName());
        System.out.println("Host IP : " + ip.getHostAddress());
    }
}
