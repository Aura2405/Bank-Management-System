package bank.management.system;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class MiniStat extends JFrame implements ActionListener
{
    String pin;
    JButton b;
    
    MiniStat(String pin){
        super("MINI STATEMENT");    
        
            this.pin=pin;
            
            JLabel l1=new JLabel();
            l1.setBounds(20,140,400,380);
            add(l1);
            
            JLabel l2=new JLabel("Aura Bank");
            l2.setFont(new Font("System",Font.BOLD,15));
            l2.setBounds(150,20,200,20);
            add(l2);
            
            JLabel l3=new JLabel();
            l3.setBounds(20,80,300,20);
            add(l3);
            
            JLabel l4=new JLabel();
            l4.setBounds(20,600,300,20);
            add(l4);
            
            
            try{
            Cont c = new Cont();
            ResultSet r=c.stat.executeQuery("select * from login where pin = '"+pin+"'");
            while(r.next()){
                l3.setText("Card Number : "+r.getString("card_number").substring(0,4)+"XXXXXXXX"+r.getString("card_number").substring(12));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            
            Cont c=new Cont();
            ResultSet r= c.stat.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            r.afterLast();
            
            while(r.previous()){
            
                l1.setText(l1.getText()+"<html>"+r.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+r.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+r.getString("amount")+"<br><br><br><html>");
                
                if(r.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(r.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(r.getString("amount"));
                }
            }
                l4.setText("Your Total Balance is Rs."+balance);
                
        
        }catch(Exception E){
            E.printStackTrace();
        }
        
        b=new JButton("EXIT");
        b.setBounds(20,640,100,25);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        add(b);
        
        setLayout(null);
        setSize(400,800);
        setLocation(20,20);
        getContentPane().setBackground(new Color(255,204,204));
        setVisible(true);
                
    }
    
    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }
    
    public static void main(String args[]){
        new MiniStat("");
    }
}
