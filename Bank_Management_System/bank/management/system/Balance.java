package bank.management.system;

import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;


public class Balance extends JFrame implements ActionListener
{
    JLabel l2;
    String pin;
    JButton b1;
    
    Balance(String pin){
        super("BALANCE");
        
    try{    
        
    this.pin=pin;
        
    BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/atm2.png"));
    Image atm=a1.getScaledInstance(1550,830,Image.SCALE_DEFAULT);
    ImageIcon a2=new ImageIcon(atm);
    JLabel image=new JLabel(a2);
    image.setBounds(0,0,1550,830);
    add(image);    
        
    JLabel l1=new JLabel("YOUR CURRENT BALANCE IS Rs. ");
    l1.setFont(new Font("System",Font.BOLD,16));
    l1.setBounds(430,180,400,35);
    l1.setForeground(Color.WHITE);
    image.add(l1);    
    
    l2=new JLabel();
    l2.setFont(new Font("System",Font.BOLD,16));
    l2.setBounds(430,220,400,35);
    l2.setForeground(Color.WHITE);
    image.add(l2);
        
    b1=new JButton("BACK");
    b1.setBounds(700,410,150,35);
    b1.setBackground(new Color(65,125,128));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    image.add(b1);
    
    int balance=0;
    try{
        Cont c=new Cont();
        ResultSet r = c.stat.executeQuery("select * from bank where pin = '"+pin+"'");
        while(r.next()){
            if(r.getString("type").equals("Deposit")){
                balance+=Integer.parseInt(r.getString("amount"));
            }
            else
            {
                balance-=Integer.parseInt(r.getString("amount"));
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    l2.setText(""+balance);
    
    setSize(1550,1080);
    setLocation(0,0);
    setLayout(null);
    setVisible(true);
}catch(Exception e){
    e.printStackTrace();
}
}
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new ATM(pin);
    }

    public static void main(String args[]){
        new Balance("");
    }
}
