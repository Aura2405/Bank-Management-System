package bank.management.system;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;

public class ChangePin extends JFrame implements ActionListener
{
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    
    ChangePin(String pin){
        super("CHANGE PIN");
        
        try{
            
            this.pin=pin;
            
            BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/atm2.png"));
            Image atm=a1.getScaledInstance(1550,830,Image.SCALE_DEFAULT);
            ImageIcon a2=new ImageIcon(atm);
            JLabel image=new JLabel(a2);
            image.setBounds(0,0,1550,830);
            add(image); 
            
            JLabel l1=new JLabel("CHANGE YOUR PIN");
            l1.setFont(new Font("System",Font.BOLD,16));
            l1.setBounds(430,180,400,35);
            l1.setForeground(Color.WHITE);
            image.add(l1); 
            
            JLabel l2=new JLabel("New PIN :");
            l2.setFont(new Font("System",Font.BOLD,16));
            l2.setBounds(430,230,400,35);
            l2.setForeground(Color.WHITE);
            image.add(l2); 
            
            p1=new JPasswordField();
            p1.setBackground(new Color(65,125,128));
            p1.setForeground(Color.WHITE);
            p1.setBounds(580,234,200,30);
            p1.setFont(new Font("Raleway",Font.BOLD,22));
            image.add(p1);
            
            JLabel l3=new JLabel("Re-Enter New PIN :");
            l3.setFont(new Font("System",Font.BOLD,16));
            l3.setBounds(430,270,400,35);
            l3.setForeground(Color.WHITE);
            image.add(l3);
            
            p2=new JPasswordField();
            p2.setBackground(new Color(65,125,128));
            p2.setForeground(Color.WHITE);
            p2.setBounds(580,274,200,30);
            p2.setFont(new Font("Raleway",Font.BOLD,22));
            image.add(p2);
            
            b1=new JButton("CHANGE");
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
            
            setLayout(null);
            setLocation(0,0);
            setSize(1550,1080);
            setVisible(true);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e){
        try{
            
            String pin1=p1.getText();
            String pin2=p2.getText();
            
            if(e.getSource()==b1){
                
                if(!pin1.equals(pin2)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match!");
                }
                else if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN!");
                }
                else{
                    Cont c=new Cont();
                    String q1="update bank set pin = '"+pin1+"' where pin = '"+pin+"' ";
                    String q2="update login set pin = '"+pin1+"' where pin = '"+pin+"' ";
                    String q3="update signup3 set pin = '"+pin1+"' where pin = '"+pin+"' ";
                    
                    c.stat.executeUpdate(q1);
                    c.stat.executeUpdate(q2);
                    c.stat.executeUpdate(q3);
                    
                    JOptionPane.showMessageDialog(null,"PIN changed successfully!");
                    setVisible(false);
                    new ATM(pin1);
                }
            }
            
            else if(e.getSource()==b2){
                
                setVisible(false);
                new ATM(pin);
                
            }
            
        }catch(Exception E){
            E.printStackTrace();
        }
        
        
    }
    
    public static void main(String args[]){
        new ChangePin("");
    }
}
