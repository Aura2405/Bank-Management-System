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

public class ATM extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    
    ATM(String pin)
    {
        super("ATM");
        
        try{
            this.pin=pin;
            
            BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/atm2.png"));
            Image atm=a1.getScaledInstance(1550,830,Image.SCALE_DEFAULT);
            ImageIcon a2=new ImageIcon(atm);
            JLabel image=new JLabel(a2);
            image.setBounds(0,0,1550,830);
            add(image); 
            
            JLabel l1=new JLabel("Please Select Your Transaction");
            l1.setBounds(430,180,700,35);
            l1.setForeground(Color.WHITE);
            l1.setFont(new Font("System",Font.BOLD,28));
            image.add(l1);
            
            b1=new JButton("DEPOSIT");
            b1.setForeground(Color.WHITE);
            b1.setBackground(new Color(65,125,128));
            b1.addActionListener(this);
            b1.setBounds(410,272,150,30);
            image.add(b1);
            
            b2=new JButton("CASH WITHDRAWAL");
            b2.setForeground(Color.WHITE);
            b2.setBackground(new Color(65,125,128));
            b2.addActionListener(this);
            b2.setBounds(700,272,150,30);
            image.add(b2);
            
            b3=new JButton("FAST CASH");
            b3.setForeground(Color.WHITE);
            b3.setBackground(new Color(65,125,128));
            b3.addActionListener(this);
            b3.setBounds(410,318,150,30);
            image.add(b3);
            
            b4=new JButton("MINI STATEMENT");
            b4.setForeground(Color.WHITE);
            b4.setBackground(new Color(65,125,128));
            b4.addActionListener(this);
            b4.setBounds(700,318,150,30);
            image.add(b4);
            
            b5=new JButton("PIN CHANGE");
            b5.setForeground(Color.WHITE);
            b5.setBackground(new Color(65,125,128));
            b5.addActionListener(this);
            b5.setBounds(410,365,150,30);
            image.add(b5);
            
            b6=new JButton("BALANCE ENQUIRY");
            b6.setForeground(Color.WHITE);
            b6.setBackground(new Color(65,125,128));
            b6.addActionListener(this);
            b6.setBounds(700,365,150,30);
            image.add(b6);
            
            b7=new JButton("EXIT");
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
            
            if(e.getSource()==b1){
                new Deposit(pin);
                setVisible(false);
            }
            else if(e.getSource()==b2){
                new CashWithdrawal(pin);
                setVisible(false);
            }
            else if(e.getSource()==b3){
                new FastCash(pin);
                setVisible(false);
            }
            else if(e.getSource()==b4){
                new MiniStat(pin);
            }
            else if(e.getSource()==b5){
                new ChangePin(pin);
                setVisible(false);
            }
            else if(e.getSource()==b6){
                new Balance(pin);
                setVisible(false);
            }
            else if(e.getSource()==b7){
                System.exit(0);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
        
    }
    public static void main(String args[]){
        new ATM("");
    }
}
