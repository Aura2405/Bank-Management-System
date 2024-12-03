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

public class SignUp3 extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton s,c;
    String appno;
    
    SignUp3(String first)
    {
        super("APPLICATION FORM");

        this.appno=first;
        try{
        BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/bank.png"));
        Image bank=a1.getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon a2=new ImageIcon(bank);
        JLabel image=new JLabel(a2);
        image.setBounds(150,5,100,100);
        add(image);
        
        JLabel l1=new JLabel("Page 3");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(380,40,400,40);
        add(l1);
        
        JLabel l2=new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(330,70,400,40);
        add(l2); 
        
        JLabel l3=new JLabel("Account Type :");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setBounds(100,140,200,30);
        add(l3); 
        
        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(new Color(215,232,252));
        r1.setBounds(100,180,200,30);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(new Color(215,232,252));
        r2.setBounds(350,180,300,30);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(new Color(215,232,252));
        r3.setBounds(100,220,200,30);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(new Color(215,232,252));
        r4.setBounds(350,220,300,30);
        add(r4);
        
        ButtonGroup account=new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);
        
        JLabel l4=new JLabel("Card Number :");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,300,200,30);
        add(l4); 
        
        JLabel l5=new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l5.setBounds(100,330,200,30);
        add(l5);
        
        JLabel l6=new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(330,300,250,30);
        add(l6); 
        
        JLabel l7=new JLabel("(It would appear on atm card/cheque book and statements)");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(330,330,500,30);
        add(l7);
        
        JLabel l8=new JLabel("PIN :");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,390,200,30);
        add(l8);
        
        JLabel l9=new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(330,390,200,30);
        add(l9);
        
        JLabel l10=new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(100,420,200,30);
        add(l10);
        
        JLabel l11=new JLabel("Services Required :");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,480,200,30);
        add(l11);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(new Color(215,232,252));
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,520,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215,232,252));
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,520,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(215,232,252));
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,570,200,30);
        add(c3);
        
        c4=new JCheckBox("Email Alerts");
        c4.setBackground(new Color(215,232,252));
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,570,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(new Color(215,232,252));
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,620,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(new Color(215,232,252));
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,620,200,30);
        add(c6);
        
        JCheckBox c7=new JCheckBox("I hereby declare that the above details provided by me are accurate to the best of my knowledge",true);
        c7.setBackground(new Color(215,232,252));
        c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBounds(100,670,600,30);
        add(c7);
        
        JLabel form=new JLabel("Form No. :");
        form.setFont(new Font("Raleway",Font.BOLD,15));
        form.setBounds(600,30,100,30);
        add(form);
        
        JLabel form1=new JLabel();
        form1.setFont(new Font("Raleway",Font.BOLD,15));
        form1.setBounds(660,30,80,30);
        add(form1);
        
        s=new JButton("Submit");
        s.setBackground(Color.WHITE);
        s.setFont(new Font("Raleway",Font.BOLD,16));
        s.setBounds(300,720,100,30);
        s.addActionListener(this);
        add(s);
        
        c=new JButton("Cancel");
        c.setBackground(Color.WHITE);
        c.setFont(new Font("Raleway",Font.BOLD,16));
        c.setBounds(420,720,100,30);
        c.addActionListener(this);
        add(c);
        
        setLayout(null);
        getContentPane().setBackground(new Color(215,232,252));
        setVisible(true);
        setLocation(400,20);
        setSize(850,800);
        
    }catch(Exception e){
        e.printStackTrace();
    }
}

    public void actionPerformed(ActionEvent e){
        
        String atype = "";
        if(r1.isSelected()){
            atype="Savings Account";
        }
        else if(r2.isSelected()){
            atype="Fixed Deposit Account";
        }
        else if(r3.isSelected()){
            atype="Current Account";
        }
        else if(r4.isSelected()){
            atype="Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L)+ 1409963000000000L;
        String cardno = "" +Math.abs(first7);
        long first3 = (ran.nextLong() % 9000L)+ 1000L;
        String pin ="" +Math.abs(first3);
        
        String ser="";
        if(c1.isSelected()){
            ser+="ATM Card";
        }
        else if(c2.isSelected()){
            ser+="Internet Banking";
        }
        else if(c3.isSelected()){
            ser+="Mobile Banking";
        }
        else if(c4.isSelected()){
            ser+="Email Alerts";
        }
        else if(c5.isSelected()){
            ser+="Cheque Book";
        }
        else if(c6.isSelected()){
            ser+="E-Statement";
        }
         
        try{
            if(e.getSource()==s)
            {
                if(ser.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all Fields");
                }
                else
                {
                    Cont c1=new Cont();
                    String q1= "insert into signup3 values('"+appno+"','"+atype+"','"+cardno+"','"+pin+"','"+ser+"')";
                    String q2= "insert into login values('"+appno+"','"+cardno+"','"+pin+"')";
                    c1.stat.executeUpdate(q1);
                    c1.stat.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin : "+pin);
                    new ATM(pin);
                    setVisible(false);
                }
            }
            else if(e.getSource()==c){
                System.exit(0);
            }
        
    }catch(Exception E){
        E.printStackTrace();
    }
}

    public static void main(String args[]){
        
        new SignUp3("");
        
    }
}
