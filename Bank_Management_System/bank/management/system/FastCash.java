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

public class FastCash extends JFrame implements ActionListener
{
    String pin;
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    FastCash(String pin){
        super("FAST CASH");
        
           try{
            this.pin=pin;
        
            BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/atm2.png"));
            Image atm=a1.getScaledInstance(1550,830,Image.SCALE_DEFAULT);
            ImageIcon a2=new ImageIcon(atm);
            JLabel image=new JLabel(a2);
            image.setBounds(0,0,1550,830);
            add(image);
            
            JLabel l1=new JLabel("SELECT WITHDRAWAL AMOUNT");
            l1.setBounds(430,180,700,35);
            l1.setForeground(Color.WHITE);
            l1.setFont(new Font("System",Font.BOLD,24));
            image.add(l1);
            
            b1=new JButton("Rs. 100");
            b1.setForeground(Color.WHITE);
            b1.setBackground(new Color(65,125,128));
            b1.addActionListener(this);
            b1.setBounds(410,272,150,30);
            image.add(b1);
            
            b2=new JButton("Rs. 500");
            b2.setForeground(Color.WHITE);
            b2.setBackground(new Color(65,125,128));
            b2.addActionListener(this);
            b2.setBounds(700,272,150,30);
            image.add(b2);
            
            b3=new JButton("Rs. 1000");
            b3.setForeground(Color.WHITE);
            b3.setBackground(new Color(65,125,128));
            b3.addActionListener(this);
            b3.setBounds(410,318,150,30);
            image.add(b3);
            
            b4=new JButton("Rs. 2000");
            b4.setForeground(Color.WHITE);
            b4.setBackground(new Color(65,125,128));
            b4.addActionListener(this);
            b4.setBounds(700,318,150,30);
            image.add(b4);
            
            b5=new JButton("Rs. 5000");
            b5.setForeground(Color.WHITE);
            b5.setBackground(new Color(65,125,128));
            b5.addActionListener(this);
            b5.setBounds(410,365,150,30);
            image.add(b5);
            
            b6=new JButton("Rs. 10,000");
            b6.setForeground(Color.WHITE);
            b6.setBackground(new Color(65,125,128));
            b6.addActionListener(this);
            b6.setBounds(700,365,150,30);
            image.add(b6);
            
            b7=new JButton("BACK");
            b7.setForeground(Color.WHITE);
            b7.setBackground(new Color(65,125,128));
            b7.addActionListener(this);
            b7.setBounds(700,412,150,30);
            image.add(b7);
            
            setSize(1550,1080);
            setLocation(0,0);
            setLayout(null);
            setVisible(true);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e){
        
        try{
        if(e.getSource()==b7){
            new ATM(pin);
            setVisible(false);
        }
        else{
            String amt = ((JButton)e.getSource()).getText().substring(4);
            Date date=new Date();
            
            Cont c=new Cont();
            ResultSet r= c.stat.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while(r.next()){
                if(r.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(r.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(r.getString("amount"));
                }
            }
            
            if(balance < Integer.parseInt(amt)){
                JOptionPane.showMessageDialog(null,"Insuffiecient Balane!");
                return;
            }
            c.stat.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amt+"')");
            JOptionPane.showMessageDialog(null,"Rs. "+amt+" Debited successfully!");
        }
    }catch(Exception E){
        E.printStackTrace();
    }
    
    setVisible(false);
    new ATM(pin);
}
    
    public static void main(String args[]){
        new FastCash("");
    }
}
