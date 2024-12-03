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

public class Adm extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5;
    
    Adm(){
        try{
            BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/bank.png"));
            Image bank=a1.getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon a2=new ImageIcon(bank);
            JLabel image=new JLabel(a2);
            image.setBounds(300,10,100,100);
            add(image);
            
            JLabel l1=new JLabel("AURA BANK");
            l1.setForeground(Color.BLACK);
            l1.setFont(new Font("System",Font.BOLD,32));
            l1.setBounds(255,125,375,30);
            add(l1);
            
            b1=new JButton("ADD EMPLOYEE");
            b1.setFont(new Font("Arial",Font.BOLD,16));
            b1.setBackground(Color.WHITE);
            b1.setForeground(Color.BLACK);
            b1.setBounds(80,220,230,35);
            b1.addActionListener(this);
            add(b1);
            
            b2=new JButton("VIEW EMPLOYEE");
            b2.setFont(new Font("Arial",Font.BOLD,16));
            b2.setBackground(Color.WHITE);
            b2.setForeground(Color.BLACK);
            b2.setBounds(370,220,230,35);
            b2.addActionListener(this);
            add(b2);
            
            b3=new JButton("VIEW CUSTOMER");
            b3.setFont(new Font("Arial",Font.BOLD,16));
            b3.setBackground(Color.WHITE);
            b3.setForeground(Color.BLACK);
            b3.setBounds(80,300,230,35);
            b3.addActionListener(this);
            add(b3);
            
            b4=new JButton("REMOVE EMPLOYEE");
            b4.setFont(new Font("Arial",Font.BOLD,16));
            b4.setBackground(Color.WHITE);
            b4.setForeground(Color.BLACK);
            b4.setBounds(370,300,230,35);
            b4.addActionListener(this);
            add(b4);
            
            b5=new JButton("EXIT");
            b5.setFont(new Font("Arial",Font.BOLD,16));
            b5.setBackground(Color.WHITE);
            b5.setForeground(Color.BLACK);
            b5.setBounds(220,400,230,35);
            b5.addActionListener(this);
            add(b5);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        getContentPane().setBackground(new Color(210,255,220));
        setSize(720,550);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==b1){
                setVisible(false);
                new AddEmp();
            }
            else if(e.getSource()==b2){
                new ViewEmp();
            }
            else if(e.getSource()==b3){
                new ViewCust();
            }
            else if(e.getSource()==b4){
                new RemoveEmp();
            }
            else if(e.getSource()==b5){
                setVisible(false);
                System.exit(0);
            }
            
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(){
        new Adm();
    }
}
