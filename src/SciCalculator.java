import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.*;

public class SciCalculator extends JFrame implements ActionListener {
    JButton b[]=new JButton[10];
    JButton c[]=new JButton[17];
    int v1=0, v2=0;
    String c1=null;
    JTextField tf;
    public SciCalculator(){
        for(int i=0;i<10;i++){
            b[i]=new JButton(""+i);
        }
        setLayout(null);
        setVisible(true);
        setSize(500,500);
        tf=new JTextField();
        add(tf);

        c[0]=new JButton("+");
        c[1]=new JButton("-");
        c[2]=new JButton("*");
        c[3]=new JButton("/");
        c[4]=new JButton("=");
        c[5]=new JButton("%");
        c[6]=new JButton("^");
        c[7]=new JButton("sin");
        c[8]=new JButton("cos");
        c[9]=new JButton("tan");
        c[10]=new JButton("cot");
        c[11]=new JButton("cosec");
        c[12]=new JButton("sec");
        c[13]=new JButton("sqrt");
        c[14]=new JButton("n!");
        c[15]=new JButton("AC");
        c[16]=new JButton("1/x");

        setLayout(new GridLayout(7,4));
        setVisible(true);
        setSize(500,500);

        for(int i=0;i<10;i++){
            add(b[i]);
        }
        for(int i=0;i<17;i++){
            add(c[i]);
        }
        for(int i=0;i<10;i++){
            b[i].addActionListener(this);
        }
        for(int i=0;i<17;i++){
            c[i].addActionListener(this);
        }
    }

    public static void main(String [] s){
        new SciCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        if( s.equals("0")||
                s.equals("1")||
                s.equals("2")||
                s.equals("3")||
                s.equals("4")||
                s.equals("5")||
                s.equals("6")||
                s.equals("7")||
                s.equals("8")||
                s.equals("9")
        ){
            tf.setText(tf.getText()+s);
        }
        if(s.equals("+")){
            c1="+";
            v1=Integer.parseInt(tf.getText());
            tf.setText(null);
        }
        if(s.equals("-")){
            c1="-";
            v1=Integer.parseInt(tf.getText());
            tf.setText(null);
        }
        if(s.equals("*")){
            c1="*";
            v1=Integer.parseInt(tf.getText());
            tf.setText(null);
        }
        if(s.equals("/")){
            c1="/";
            v1=Integer.parseInt(tf.getText());
            tf.setText(null);
        }
        if(s.equals("%")){
            c1="%";
            v1=Integer.parseInt(tf.getText());
            tf.setText(null);
        }
        if(s.equals("^")){
            c1="^";
            v1=Integer.parseInt(tf.getText());
            tf.setText(null);
        }
        if(s.equals("AC")){
            c1=null;
            v1=v2=0;
            tf.setText(null);
        }
        if(s.equals("1/x")){
            v1=Integer.parseInt(tf.getText());
            tf.setText(""+(v1==0?("Invalid Number"):(1/(float)v1)));
        }
        if(s.equals("sin")){
            v1=Integer.parseInt(tf.getText());
            tf.setText(""+sin(v1));
        }
        if(s.equals("cos")){
            v1=Integer.parseInt(tf.getText());
            tf.setText(""+cos(v1));
        }
        if(s.equals("tan")){
            v1=Integer.parseInt(tf.getText());
            tf.setText(""+tan(v1));
        }
        if(s.equals("cot")){
            v1=Integer.parseInt(tf.getText());
            tf.setText(""+(1/tan(v1)));
        }
        if(s.equals("cosec")){
            v1=Integer.parseInt(tf.getText());
            tf.setText(""+(1/sin(v1)));
        }
        if(s.equals("sec")) {
            v1 = Integer.parseInt(tf.getText());
            tf.setText("" + (1 / cos(v1)));
        }
        if(s.equals("sqrt")) {
            v1 = Integer.parseInt(tf.getText());
            tf.setText("" +sqrt(v1));
        }
        if(s.equals("n!")) {
            v1 = Integer.parseInt(tf.getText());
            int mul=1;
            if(v1==0){
                mul=1;
            }
            else {
                for(int i=v1;i>0;i--){
                    mul*=i;
                }
            }
            tf.setText("" +mul);
        }
        if(s.equals("=")) {

            if(c1.equals("+")) {
                v2 = Integer.parseInt(tf.getText());
                tf.setText("" +(v1+v2));
            }
            if(c1.equals("-")) {
                v2 = Integer.parseInt(tf.getText());
                tf.setText("" +(v1-v2));
            }
            if(c1.equals("*")) {
                v2 = Integer.parseInt(tf.getText());
                tf.setText("" +(v1*v2));
            }
            if(c1.equals("/")) {
                v2 = Integer.parseInt(tf.getText());
                tf.setText("" +(v1/(float)v2));
            }if(c1.equals("%")) {
                v2 = Integer.parseInt(tf.getText());
                tf.setText("" +(v1*v2)/(float)100);
            }if(c1.equals("^")) {
                v2 = Integer.parseInt(tf.getText());
                tf.setText("" +pow(v1,v2));
            }
        }
    }
}