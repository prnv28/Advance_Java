import java.net.*;
import java.io.*;
public class Client{
    public static void main(String [] args){
        try{
            Socket s = new Socket("localhost",6666);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Message : ");
            String message = br.readLine();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(message);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            String upper_message = dis.readUTF();
            System.out.println("Uppercase Message : "+upper_message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}