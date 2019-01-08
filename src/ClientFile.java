import java.io.*;
import java.net.*;

public class ClientFile {
    public static void main(String[] args){
        try{
            Socket s = new Socket("localhost",6666);
            System.out.print("Enter path : ");
            DataInputStream br = new DataInputStream(System.in);
            String path = br.readLine();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(path);
            dos.flush();
            br = new DataInputStream(s.getInputStream());
            String content = br.readUTF();
            if(content.equals("x")){
                System.out.print("Enter Content : ");
                br = new DataInputStream(System.in);
                String send_content = br.readLine();
                dos.writeUTF(send_content);
            }else{
                System.out.println("File : \n"+content);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
