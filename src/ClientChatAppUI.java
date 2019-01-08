import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ClientChatAppUI extends JFrame implements ActionListener {
    JTextField tf;
    JButton b;
    static JTextArea ta;
    static DataInputStream din;
    DataOutputStream dout;
    String str="";
    static String str2="";

    public ClientChatAppUI(Socket s){
        try{
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }

        ta = new JTextArea();
        tf = new JTextField("Client");
        b = new JButton("Send");

        setLayout(null);
        setSize(510,480);
        setVisible(true);
        setTitle("Client");

        ta.setBounds(50,30,400,300);
        ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ta.setEditable(false);
        ta.setFont(new Font("Verdana", Font.BOLD, 11));

        tf.setBounds(50,350,300,30);
        tf.setFont(new Font("Cendara", Font.BOLD, 11));
        tf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        b.setBounds(370,350,80,30);
        b.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(ta);
        add(tf);
        add(b);

        b.addActionListener(this);
    }

    public static void main(String [] args) throws IOException {
        Socket s=new Socket("localhost",6666);
        ClientChatAppUI a = new ClientChatAppUI(s);

        while(true){
            str2=din.readUTF();
            ta.append("Server : "+str2+"\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        str = tf.getText();
        try{
                ta.append("Client : "+str+"\n");
                dout.writeUTF(str);
                dout.flush();
                tf.setText("");
        }catch(IOException ec){
            ec.printStackTrace();
        }
    }
}
