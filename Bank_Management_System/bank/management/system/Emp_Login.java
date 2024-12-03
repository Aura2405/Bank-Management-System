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

public class Emp_Login extends JFrame implements ActionListener
{
    JTextField text1,empid,pos;
    JLabel label1,label2,label3,label4;
    JButton b1,b2;
    
    Emp_Login(){
        super("EMPLOYEE LOGIN");
        
        try{
            
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
        
        label3=new JLabel("WELCOME EMPLOYEE");
        label3.setForeground(Color.YELLOW);
        label3.setFont(new Font("System",Font.BOLD,32));
        label3.setBounds(250,125,375,30);
        add(label3);
        
        label1=new JLabel("Name :");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Ralway",Font.BOLD,26));
        label1.setBounds(150,190,375,30);
        add(label1);
        
        text1=new JTextField(15);
        text1.setBounds(325,190,230,30);
        text1.setFont(new Font("Arial",Font.BOLD,14));
        add(text1);
        
        label2=new JLabel("Employee ID :");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway",Font.BOLD,26));
        label2.setBounds(150,250,375,30);
        add(label2);
        
        empid=new JTextField(15);
        empid.setBounds(325,250,230,30);
        empid.setFont(new Font("Arial",Font.BOLD,14));
        add(empid);
        
        label4=new JLabel("Position :");
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Ralway",Font.BOLD,26));
        label4.setBounds(150,310,375,30);
        add(label4);
        
        pos=new JTextField(15);
        pos.setBounds(325,310,230,30);
        pos.setFont(new Font("Arial",Font.BOLD,14));
        add(pos);
        
        b1=new JButton("LOGIN");
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(325,370,230,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("CLEAR");
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(325,410,230,30);
        b2.addActionListener(this);
        add(b2);
        
        BufferedImage a4=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/backbg.png"));
        Image back=a4.getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon b=new ImageIcon(back);
        JLabel image2=new JLabel(b);
        image2.setBounds(0,0,850,480);
        add(image2);
        
        setLayout(null);
        setSize(850,500);
        setLocation(450,200);
        setVisible(true);
        
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
    public void actionPerformed(ActionEvent e){
        try{
            String name = text1.getText();
            String emp = empid.getText();
            String position=pos.getText();
            
            if(e.getSource()==b1){
                                
                if(name.equals("")||empid.equals("")||pos.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the details");
                }
                else{
                    Cont c=new Cont();
                    ResultSet r = c.stat.executeQuery("select * from emp where name = '"+name+"' and empid ='"+emp+"' and designation = '"+position+"'");
                    if(r.next()){
                        new ViewCust();
                        setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Details!");
                    }
                }
                
            }
            else if(e.getSource()==b2){
                text1.setText("");
                empid.setText("");
                pos.setText("");
            }
            
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    
    public static void main(){
        new Emp_Login();
    }
}
