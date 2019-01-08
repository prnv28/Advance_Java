import java.io.*;
import java.net.*;
public class Server{
    public static void main(String [] args){
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s= ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());
            String message = din.readUTF();
            String new_message = message.toUpperCase();
            DataOutputStream dos =new DataOutputStream(s.getOutputStream());
            dos.writeUTF(new_message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}