package bank.management.system;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;

public class Login extends JFrame implements ActionListener
{
    
    JButton b1,b2,b3;
    
    Login(){
        super("Aura Bank");
        
        try{
        BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/bank.png"));
        Image bank=a1.getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon a2=new ImageIcon(bank);
        JLabel image=new JLabel(a2);
        image.setBounds(350,10,100,100);
        add(image);
        
        JLabel l=new JLabel("WELCOME TO AURA BANK");
        l.setBounds(200,130,400,50);
        l.setFont(new Font("System",Font.BOLD,30));
        add(l);
        
        b1=new JButton("ADMIN LOGIN");
        b1.setBounds(250,210,300,30);
        b1.setFont(new Font("System",Font.BOLD,20));
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("EMPLOYEE LOGIN");
        b2.setBounds(250,260,300,30);
        b2.setFont(new Font("System",Font.BOLD,20));
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("CUSTOMER LOGIN");
        b3.setBounds(250,310,300,30);
        b3.setFont(new Font("System",Font.BOLD,20));
        b3.setBackground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);
        
        getContentPane().setBackground(new Color(210,255,220));
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);
        
    }catch(Exception e){
        e.printStackTrace();
    }
}
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==b1){
            setVisible(false);
            new Adm_Login();
        }
        else if(e.getSource()==b2){
            setVisible(false);
            new Emp_Login();
        }
        else{
            setVisible(false);
            new Cust_Login();
        }
        
    }
    
    public static void main(){
        new Login();
    }
}
