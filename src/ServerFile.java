import java.io.*;
import java.net.*;

public class ServerFile{
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream br = new DataInputStream(s.getInputStream());
            String path = br.readUTF();
            System.out.println(path);

            File file = new File(path);

            if(file.exists()){
                FileReader fr = new FileReader(path);
                int i;
                String content = "";
                while ((i=fr.read())!=-1){
                    content+=((char)i);
                }
                dos.writeUTF(content);
                dos.flush();
            }
            else{
                String sendmsg="x";
                dos.writeUTF(sendmsg);

                String data = br.readUTF();
                FileWriter fw = new FileWriter(path);
                fw.write(data);
                fw.close();
                System.out.println("File created succesfully.");
            }
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
