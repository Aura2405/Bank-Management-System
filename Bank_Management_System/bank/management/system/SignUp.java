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
import com.toedter.calendar.*;


public class SignUp extends JFrame implements ActionListener{
    Random ran = new Random();
    long f4=(ran.nextLong() % 9000L) + 1000L;
    String f=" " + Math.abs(f4);
    JTextField tname,faname,temail,tadd,tcity,tpin,tstate;
    JDateChooser date;
    
    JButton next;
    JRadioButton g1,g2;
    JRadioButton m1,m2,m3;
    
    SignUp(){
        super("APPLICATION FORM");
        try{
        BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/bank.png"));
        Image bank=a1.getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon a2=new ImageIcon(bank);
        JLabel image=new JLabel(a2);
        image.setBounds(25,10,100,100);
        add(image);
        
        JLabel label1=new JLabel("APPLICATION FORM NO.: " + f);
        label1.setBounds(180,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,36));
        add(label1);
        
        JLabel label2=new JLabel("Page 1");
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        label2.setBounds(400,70,600,30);
        add(label2);
        
        JLabel label3=new JLabel("Personal Details");
        label3.setBounds(350,100,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);
        
        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,190,100,30);
        add(name);
        
        tname=new JTextField();
        tname.setFont(new Font("Raleway",Font.BOLD,14));
        tname.setBounds(300,190,400,30);
        add(tname);
        
        JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,240,200,30);
        add(fname);
        
        faname=new JTextField();
        faname.setFont(new Font("Raleway",Font.BOLD,14));
        faname.setBounds(300,240,400,30);
        add(faname);
        
        JLabel dob=new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,340,200,30);
        add(dob);
        
        date = new JDateChooser();
        date.setForeground(new Color(105,105,105));
        date.setBounds(300,340,400,30);
        add(date);
        
        JLabel gen=new JLabel("Gender :");
        gen.setFont(new Font("Raleway",Font.BOLD,20));
        gen.setBounds(100,290,200,30);
        add(gen);
        
        g1=new JRadioButton("Male");
        g1.setFont(new Font("Raleway",Font.BOLD,15));
        g1.setBackground(new Color(210,255,220));
        g1.setBounds(300,290,80,30);
        add(g1);
        
        g2=new JRadioButton("Female");
        g2.setFont(new Font("Raleway",Font.BOLD,15));
        g2.setBackground(new Color(210,255,220));
        g2.setBounds(450,290,100,30);
        add(g2);
        
        ButtonGroup gender = new ButtonGroup();
        gender.add(g1);
        gender.add(g2);
        
        JLabel email=new JLabel("Email Address :");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,390,200,30);
        add(email);
        
        temail=new JTextField();
        temail.setFont(new Font("Raleway",Font.BOLD,14));
        temail.setBounds(300,390,400,30);
        add(temail);
        
        JLabel ms=new JLabel("Marital Status :");
        ms.setFont(new Font("Raleway",Font.BOLD,20));
        ms.setBounds(100,440,200,30);
        add(ms);
        
        m1=new JRadioButton("Unmarried");
        m1.setFont(new Font("Raleway",Font.BOLD,15));
        m1.setBackground(new Color(210,255,220));
        m1.setBounds(300,437,110,40);
        add(m1);
        
        m2=new JRadioButton("Married");
        m2.setFont(new Font("Raleway",Font.BOLD,15));
        m2.setBackground(new Color(210,255,220));
        m2.setBounds(450,437,110,40);
        add(m2);
        
        m3=new JRadioButton("Other");
        m3.setFont(new Font("Raleway",Font.BOLD,15));
        m3.setBackground(new Color(210,255,220));
        m3.setBounds(600,437,80,40);
        add(m3);
        
        ButtonGroup mstat = new ButtonGroup();
        mstat.add(m1);
        mstat.add(m2);
        mstat.add(m3);
        
        JLabel add=new JLabel("Address :");
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.setBounds(100,490,200,30);
        add(add);
        
        tadd=new JTextField();
        tadd.setFont(new Font("Raleway",Font.BOLD,14));
        tadd.setBounds(300,490,400,30);
        add(tadd);
        
        JLabel city=new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,540,200,30);
        add(city);
        
        tcity=new JTextField();
        tcity.setFont(new Font("Raleway",Font.BOLD,14));
        tcity.setBounds(300,540,400,30);
        add(tcity);
        
        JLabel pincode=new JLabel("Pin Code :");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        tpin=new JTextField();
        tpin.setFont(new Font("Raleway",Font.BOLD,14));
        tpin.setBounds(300,590,400,30);
        add(tpin);
        
        JLabel state=new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,640,200,30);
        add(state);
        
        tstate=new JTextField();
        tstate.setFont(new Font("Raleway",Font.BOLD,14));
        tstate.setBounds(300,640,400,30);
        add(tstate);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setForeground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.setBounds(620,700,80,30);
        next.addActionListener(this);
        add(next);
        
        }
        catch(IOException E)
        {
            E.printStackTrace();
        }
    
        getContentPane().setBackground(new Color(210,255,220));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
        String appnumber = f;
        String name = tname.getText();
        String fname = faname.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(g1.isSelected()){
            gender = "Male";
        }
        else if(g2.isSelected()){
            gender="Female";
        }
        String email = temail.getText();
        String marital=null;
        if(m1.isSelected()){
            marital="Unmarried";
        }
        else if(m2.isSelected()){
            marital="Married";
        }
        else if(m3.isSelected()){
            marital="Other";
        }
        String address = tadd.getText();
        String city = tcity.getText();
        String pin = tpin.getText();
        String state = tstate.getText();
        
        try{
            if(tname.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all fields");
            }
            else{
                Cont con1=new Cont();
                String q = "insert into signup values('"+appnumber+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                con1.stat.executeUpdate(q);
                new SignUp2(appnumber);
                setVisible(false);
            }
            
        }catch(Exception E)
        {
            E.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new SignUp();
    }
}