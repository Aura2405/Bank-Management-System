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


public class Cust_Login extends JFrame implements ActionListener{
    
    JLabel label1,label2,label3;
    
    JTextField text1;
    
    JPasswordField pass1;
    
    JButton b1,b2,b3;
    
    Cust_Login(){
        super("CUSTOMER LOGIN");
        
        try
        {
        BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/bank.png"));
        Image bank=a1.getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon a2=new ImageIcon(bank);
        JLabel image=new JLabel(a2);
        image.setBounds(350,10,100,100);
        add(image);
        
        BufferedImage a3=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/card.png"));
        Image card=a3.getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon c=new ImageIcon(card);
        JLabel image1=new JLabel(c);
        image1.setBounds(630,350,100,100);
        add(image1);
        
        label1=new JLabel("WELCOME CUSTOMER");
        label1.setForeground(Color.YELLOW);
        label1.setFont(new Font("AvantGarde",Font.BOLD,36));
        label1.setBounds(150,125,500,40);
        add(label1);
        
        label2=new JLabel("Card No: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setBounds(150,190,375,30);
        add(label2);
        
        text1=new JTextField(15);
        text1.setBounds(325,190,230,30);
        text1.setFont(new Font("Arial",Font.BOLD,14));
        add(text1);
        
        label3=new JLabel("PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setBounds(150,250,375,30);
        add(label3);
        
        pass1=new JPasswordField(15);
        pass1.setBounds(325,250,230,30);
        pass1.setFont(new Font("Arial",Font.BOLD,14));
        add(pass1);
        
        b1=new JButton("SIGN IN");
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setBounds(325,310,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("CLEAR");
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setBounds(455,310,100,30);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("SIGN UP");
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.WHITE);
        b3.setBounds(325,360,230,30);
        b3.addActionListener(this);
        add(b3);
        
        BufferedImage a4=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/backbg.png"));
        Image back=a4.getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon b=new ImageIcon(back);
        JLabel image2=new JLabel(b);
        image2.setBounds(0,0,850,480);
        add(image2);

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        try
        {
            if(e.getSource()==b1){
                
                Cont c= new Cont();
                String cardno = text1.getText();
                String pin = pass1.getText();
                String q="select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet r = c.stat.executeQuery(q);
                if(r.next()){
                    setVisible(false);
                    new ATM(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin!");
                }
                
            }
            else if(e.getSource()==b2){
                text1.setText("");
                pass1.setText("");
            }
            else if(e.getSource()==b3){
                new SignUp();
                setVisible(false);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        
    }
    
    public static void main(String args[]){
        new Cust_Login();
    }
}

