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

public class CashWithdrawal extends JFrame implements ActionListener
{
    
    String pin;
    JTextField t1;
    JButton b1,b2;
    
    CashWithdrawal(String pin){
        super("CASH WITHDRAWAL");
        
    try{    
    this.pin=pin;    
    BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/atm2.png"));
    Image atm=a1.getScaledInstance(1550,830,Image.SCALE_DEFAULT);
    ImageIcon a2=new ImageIcon(atm);
    JLabel image=new JLabel(a2);
    image.setBounds(0,0,1550,830);
    add(image);    
        
    JLabel l1=new JLabel("MAXIMUM WITHDRAWAL IS 10,000");
    l1.setFont(new Font("System",Font.BOLD,16));
    l1.setBounds(460,180,400,35);
    l1.setForeground(Color.WHITE);
    image.add(l1);
    
    JLabel l2=new JLabel("ENTER YOUR AMOUNT");
    l2.setFont(new Font("System",Font.BOLD,16));
    l2.setBounds(460,220,400,35);
    l2.setForeground(Color.WHITE);
    image.add(l2);
    
    t1=new JTextField();
    t1.setBackground(new Color(65,125,128));
    t1.setForeground(Color.WHITE);
    t1.setBounds(460,260,320,25);
    t1.setFont(new Font("Raleway",Font.BOLD,22));
    image.add(t1);
    
    b1=new JButton("WITHDRAW");
    b1.setBounds(700,364,150,35);
    b1.setBackground(new Color(65,125,128));
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    image.add(b1);
    
    b2=new JButton("BACK");
    b2.setBounds(700,410,150,35);
    b2.setBackground(new Color(65,125,128));
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    image.add(b2);
    
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
            String amt=t1.getText();
            Date date=new Date();
        if(e.getSource()==b1)
        {
            if(t1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Enter the amount!");
        }
        else{
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
            t1.setText("");
            JOptionPane.showMessageDialog(null,"Rs. "+amt+" Debited successfully!");
        }
    }else if(e.getSource()==b2){
        setVisible(false);
        new ATM(pin);
        }
    }catch(Exception E){
            E.printStackTrace();
        }
        
    }
    
    public static void main(String args[]){
        new CashWithdrawal("");
    }
}
