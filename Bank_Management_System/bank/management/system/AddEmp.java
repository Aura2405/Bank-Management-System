package bank.management.system;

import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import com.toedter.calendar.*;

public class AddEmp extends JFrame implements ActionListener
{
    JTextField tname,fname,tadd,tadh,tphn,tsal,temail,tdesig;
    JLabel tempid;
    JDateChooser date;
    JComboBox ed;
    Random ran=new Random();
    int number = ran.nextInt(999999);
    JButton b1,b2;
    
    AddEmp(){
        
        super("ADD EMPLOYEE");
        
        JLabel h=new JLabel("Set Employee Details");
        h.setBounds(320,30,500,50);
        h.setFont(new Font("serif",Font.BOLD,25));
        add(h);
        
        JLabel n=new JLabel("Name :");
        n.setBounds(50,150,150,30);
        n.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(n);
        
        tname=new JTextField();
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
        
        date = new JDateChooser();
        date.setForeground(new Color(105,105,105));
        date.setBounds(200,200,180,30);
        add(date);
        
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
        
        String items[]={"BBA","MBA","B.Tech","BCA","BA","BSc.","B.Com","MCA","M.Tech","MSc.","PhD"};
        ed=new JComboBox(items);
        ed.setBounds(640,300,180,30);
        add(ed);
        
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
        
        tadh=new JTextField();
        tadh.setBounds(640,350,180,30);
        add(tadh);
        
        JLabel empid=new JLabel("Employee ID :");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);
        
        tempid=new JLabel(""+number);
        tempid.setBounds(200,400,180,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);
        
        b1=new JButton("ADD");
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
        try{
            
            if(e.getSource()==b1){
                String name=tname.getText();
                String fathname=fname.getText();
                String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
                String salary=tsal.getText();
                String add=tadd.getText();
                String phn=tphn.getText();
                String email=temail.getText();
                String education=(String)ed.getSelectedItem();
                String desig=tdesig.getText();
                String adh=tadh.getText();
                String empid=tempid.getText();
                
                Cont c=new Cont();
                String q="insert into emp values('"+name+"','"+fathname+"','"+dob+"','"+salary+"','"+add+"','"+phn+"','"+email+"','"+education+"','"+desig+"','"+adh+"','"+empid+"')";
                c.stat.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee details added successfully.");
                setVisible(false);
                new Adm();
            }
            else if(e.getSource()==b2){
                setVisible(false);
                new Adm();
            }
            
        }catch(Exception E){
            E.printStackTrace();
        }
        
        
    }
    
    public static void main(){
        new AddEmp();
    }
}
