import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter; 

class Run extends Thread{
    public void run(){
        JFrame frm = new JFrame("Pipi");
        frm.setSize(1000,550);
        frm.setResizable(false);
        frm.setIconImage(Toolkit.getDefaultToolkit().getImage("img/icon.png")); 
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //------Frame design finished----------------
        JPanel pn1 = new JPanel();
        pn1.setLayout(null);
        pn1.setLocation(0,0);
        pn1.setSize(1000,500);
        frm.add(pn1);
        
        Icon a = new ImageIcon(getClass().getResource("img/bn.png"));
        JLabel bn = new JLabel(a);
        bn.setLocation(0,0);
        bn.setSize(1000,50);
        pn1.add(bn);
        
        JLabel lb1 = new JLabel("Drop Message :");
        lb1.setFont(new Font(null, Font.PLAIN, 15));
        lb1.setLocation(10,50);
        lb1.setSize(150,30);
        pn1.add(lb1);
        
        JLabel lb2 = new JLabel("Converted Message :");
        lb2.setFont(new Font(null, Font.PLAIN, 15));
        lb2.setLocation(540,50);
        lb2.setSize(150,30);
        pn1.add(lb2);
        
        JLabel lb3 = new JLabel("Key Code : ");
        lb3.setFont(new Font(null, Font.PLAIN, 15));
        lb3.setLocation(10,390);
        lb3.setSize(90,30);
        pn1.add(lb3);
        
        JLabel lb4 = new JLabel("Six digit only");
        lb4.setFont(new Font(null, Font.PLAIN, 10));
        lb4.setForeground(Color.red);
        lb4.setLocation(180,390);
        lb4.setSize(90,30);
        pn1.add(lb4);
        
        JLabel lb5 = new JLabel("Designed and developed by ARCS12 CORPORATION. Visit www.arcs12.com.");
        lb5.setFont(new Font(null, Font.PLAIN, 10));
        lb5.setLocation(10,480);
        lb5.setSize(1000,20);
        pn1.add(lb5);
        
        //-----------------Text Areas-------------
        JTextField tf = new JTextField();
        tf.setFont(new Font(null, Font.PLAIN, 20));
        tf.setLocation(100, 390);
        tf.setSize(70,30);
        pn1.add(tf);
        
        
        final JTextArea txt1 = new JTextArea(10,10);
        JScrollPane sp = new JScrollPane(txt1);
        txt1.setFont(new Font(null, Font.PLAIN,15));
        txt1.setLineWrap(true);
        txt1.setWrapStyleWord(true);
        sp.setLocation(10,80);
        sp.setSize(440,300);
        pn1.add(sp);
        
        final JTextArea txt2 = new JTextArea(10,10);
        JScrollPane sp1 = new JScrollPane(txt2);
        txt2.setFont(new Font(null, Font.PLAIN,15));
        txt2.setLineWrap(true);
        txt2.setWrapStyleWord(true);
        sp1.setLocation(540,80);
        sp1.setSize(440,300);
        pn1.add(sp1);
        //---------------Image added-----------------
        Icon c = new ImageIcon(getClass().getResource("img/open.png"));
        Icon d = new ImageIcon(getClass().getResource("img/copy.png"));
        Icon e = new ImageIcon(getClass().getResource("img/paste.png"));
        Icon f = new ImageIcon(getClass().getResource("img/save.png"));
        Icon g = new ImageIcon(getClass().getResource("img/lock.png"));
        Icon h = new ImageIcon(getClass().getResource("img/unlock.png"));
        //--------------Buttons----------------------
        JButton btn1 = new JButton(null, c);
        btn1.setLocation(10,430);
        btn1.setSize(120,40);
        pn1.add(btn1);
        
        JButton btn2 = new JButton(null, g);
        btn2.setLocation(135,430);
        btn2.setSize(120,40);
        pn1.add(btn2);
        
        JButton btn3 = new JButton(null, h);
        btn3.setLocation(260,430);
        btn3.setSize(120,40);
        pn1.add(btn3);
        
        JButton btn4 = new JButton(null, d);
        btn4.setLocation(540,430);
        btn4.setSize(120,40);
        pn1.add(btn4);
        
        JButton btn5 = new JButton(null, e);
        btn5.setLocation(665,430);
        btn5.setSize(120,40);
        pn1.add(btn5);
        
        JButton btn6 = new JButton(null, f);
        btn6.setLocation(790,430);
        btn6.setSize(120,40);
        pn1.add(btn6);
       
        //---------End of User Interface-----------------
        btn1.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent ae) {
                               JFileChooser fc=new JFileChooser(); 
                               FileNameExtensionFilter filter = new FileNameExtensionFilter("PIPI file", "pi");
                               fc.addChoosableFileFilter(filter); 
                               int i=fc.showOpenDialog(frm);
                               File f=fc.getSelectedFile();
                                String filename=f.getAbsolutePath();
                                try{
                                   FileInputStream fis = new  FileInputStream(filename);
                                   DataInputStream dis = new DataInputStream(fis);
                                   String str = dis.readUTF();
                                   txt1.setText(str);
                                  }catch(IOException e){
                                 e.printStackTrace();
                                  }
                            }
              });
        
        //---------btn6 action (Save)--------------------
        
              btn6.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent ae) {
                             
                          JFileChooser fs = new JFileChooser(new File("c:\\"));
                          FileNameExtensionFilter filter = new FileNameExtensionFilter("PIPI file", ".pi"); 
                          fs.setDialogTitle("Save");
                          fs.setFileFilter(filter);
                          int result=fs.showSaveDialog(frm);
                          if(result==JFileChooser.APPROVE_OPTION){
                                String str=txt2.getText().toString();
                                File fi = new File(fs.getSelectedFile().getAbsolutePath()+".pi");
                                try{
                                    FileOutputStream fos = new FileOutputStream(fi);
                                    DataOutputStream dos = new DataOutputStream(fos);
                                    dos.writeUTF(str);
                                }catch(Exception e2){}
                            }
                                     }
                               });
                               
              btn5.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent ae) {
                                        txt1.paste();
                                     }
                               });
              btn4.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent ae) {
                                        txt2.copy();
                                     }
                               });
              btn2.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent ae) {
                                        String tx1=txt1.getText(),con="";
                                        char c,cc;
                                        String s=tf.getText();
                                        int i,l=tx1.length(),j=0,n=0;
                                        for(i=0;i<l;i++){
                                            c = tx1.charAt(i);
                                            if(j<=4){
                                               n= (int)c + Integer.parseInt(Character.toString(s.charAt(0))); j++;
                                            }
                                            else if (j>4 && j<=8){
                                               n= (int)c + Integer.parseInt(Character.toString(s.charAt(1))); j++;
                                            }
                                            else if (j>8 && j<=12){
                                               n= (int)c + Integer.parseInt(Character.toString(s.charAt(2))); j++;
                                            }
                                            else if (j>12 && j<=16){
                                               n= (int)c + Integer.parseInt(Character.toString(s.charAt(3))); j++;
                                            }
                                            else if (j>16 && j<=20){
                                               n= (int)c + Integer.parseInt(Character.toString(s.charAt(4))); j++;
                                            }
                                            else{
                                               n= (int)c + Integer.parseInt(Character.toString(s.charAt(5))); j=0;
                                            }
                                            cc = (char)n;
                                           String s2=Character.toString(cc);
                                           con=con.concat(s2);txt2.setText(con);
                                        }
                                     }
                               });
                               
                 btn3.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent ae) {
                                        String tx1=txt1.getText().toString(),con="";
                                        char c,cc;
                                        String s=tf.getText();
                                        int i,l=tx1.length(),j=0,n=0;
                                        for(i=0;i<l;i++){
                                            c = tx1.charAt(i);
                                            if(j<=4){
                                               n= (int)c - Integer.parseInt(Character.toString(s.charAt(0))); j++;
                                            }
                                            else if (j>4 && j<=8){
                                               n= (int)c - Integer.parseInt(Character.toString(s.charAt(1))); j++;
                                            }
                                            else if (j>8 && j<=12){
                                               n= (int)c - Integer.parseInt(Character.toString(s.charAt(2))); j++;
                                            }
                                            else if (j>12 && j<=16){
                                               n= (int)c - Integer.parseInt(Character.toString(s.charAt(3))); j++;
                                            }
                                            else if (j>16 && j<=20){
                                               n= (int)c - Integer.parseInt(Character.toString(s.charAt(4))); j++;
                                            }
                                            else {
                                               n= (int)c - Integer.parseInt(Character.toString(s.charAt(5))); j=0;
                                            }
                                            cc = (char)n;
                                           String s2=Character.toString(cc);
                                           con=con.concat(s2);txt2.setText(con);
                                        }
                                     }
                               });
        
        //---------End of Action------------------------
        
        frm.setVisible(true);
    }
    
}
