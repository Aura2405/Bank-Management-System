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

public class UpdateEmp extends JFrame implements ActionListener
{
    JTextField tedu,fname,tadd,tadh,tphn,tsal,temail,tdesig;
    JLabel tempid;
    JButton b1,b2;
    String number;
    
    UpdateEmp(String number){
        super("EMPLOYEE UPDATE");
        
        this.number=number;
        
        JLabel h=new JLabel("Set Employee Details");
        h.setBounds(320,30,500,50);
        h.setFont(new Font("serif",Font.BOLD,25));
        add(h);
        
        JLabel n=new JLabel("Name :");
        n.setBounds(50,150,150,30);
        n.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(n);
        
        JLabel tname=new JLabel();
        tname.setBounds(200,150,180,30);
        add(tname);
        
        JLabel f=new JLabel("Father's Name :");
        f.setBounds(440,150,150,30);
        f.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(f);
        
        fname=new JTextField();
        fname.setBounds(640,150,180,30);
        add(fname);
        
        JLabel dob=new JLabel("Date of Birth :");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);
        
        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,180,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,14));
        add(tdob);
        
        JLabel add=new JLabel("Address :");
        add.setBounds(440,200,150,30);
        add.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(add);
        
        tadd=new JTextField();
        tadd.setBounds(640,200,180,30);
        add(tadd);
        
        JLabel s=new JLabel("Salary :");
        s.setBounds(50,250,150,30);
        s.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(s);
        
        tsal=new JTextField();
        tsal.setBounds(200,250,180,30);
        add(tsal);
        
        JLabel p=new JLabel("Phone No. :");
        p.setBounds(440,250,150,30);
        p.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(p);
        
        tphn=new JTextField();
        tphn.setBounds(640,250,180,30);
        add(tphn);
        
        JLabel e=new JLabel("Email ID :");
        e.setBounds(50,300,150,30);
        e.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(e);
        
        temail=new JTextField();
        temail.setBounds(200,300,180,30);
        add(temail);
        
        JLabel edu=new JLabel("Highest Education :");
        edu.setBounds(440,300,200,30);
        edu.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(edu);
        
        tedu=new JTextField();
        tedu.setBounds(640,300,180,30);
        add(tedu);
        
        JLabel deg=new JLabel("Designation :");
        deg.setBounds(50,350,150,30);
        deg.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(deg);
        
        tdesig=new JTextField();
        tdesig.setBounds(200,350,180,30);
        add(tdesig);
        
        JLabel adh=new JLabel("Aadhar No. :");
        adh.setBounds(440,350,150,30);
        adh.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(adh);
        
        JLabel tadh=new JLabel();
        tadh.setBounds(640,350,180,30);
        add(tadh);
        
        JLabel empid=new JLabel("Employee ID :");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);
        
        tempid=new JLabel(number);
        tempid.setBounds(200,400,180,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);
        
        try{
            
            Cont c=new Cont();
            String q="select * from emp where empid = '"+number+"'";
            ResultSet r=c.stat.executeQuery(q);
            while(r.next()){
                tname.setText(r.getString("name"));
                fname.setText(r.getString("fname"));
                tdob.setText(r.getString("dob"));
                tadd.setText(r.getString("address"));
                tsal.setText(r.getString("salary"));
                tphn.setText(r.getString("phone"));
                temail.setText(r.getString("email"));
                tedu.setText(r.getString("education"));
                tadh.setText(r.getString("aadhar"));
                tdesig.setText(r.getString("designation"));
            }
            
        }catch(Exception E){
            E.printStackTrace();
        }
        
        b1=new JButton("UPDATE");
        b1.setBounds(250,500,150,40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("BACK");
        b2.setBounds(450,500,150,40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(new Color(163,255,188));
        setSize(900,700);
        setLocation(300,50);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==b1){
            String fathname=fname.getText();
            String add=tadd.getText();
            String sal=tsal.getText();
            String phone=tphn.getText();
            String email=temail.getText();
            String edu=tedu.getText();
            String desig=tdesig.getText();
            
            try{
                
                Cont c = new Cont();
                String q = "update emp set fname = '"+fathname+"',salary = '"+sal+"',address = '"+add+"',phone = '"+phone+"',email = '"+email+"',education = '"+edu+"',designation = '"+desig+"' where empid = '"+number+"'";
                c.stat.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details updated successfully.");
                setVisible(false);
                new ViewEmp();
                
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        
        else{
            setVisible(false);
            new ViewEmp();
        }
        
    }
    
    public static void main(String args[]){
        new UpdateEmp("");
    }
}
