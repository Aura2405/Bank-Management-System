package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import java.io.IOException;
import java.sql.*;

public class UpdateCust extends JFrame implements ActionListener
{
    JButton up,b;
    JTextField faname,temail,tadd,tcity,tpin,tstate,tmar;
    JLabel tname,tdob,tcard,tgen;
    String f;
    
   UpdateCust(String form){
       super("CUSTOMER UPDATE");
       
       f=form;
       
       JLabel label1=new JLabel("CARD NO.: ");
        label1.setBounds(220,20,200,40);
        label1.setFont(new Font("Raleway",Font.BOLD,22));
        add(label1);
        
        tcard=new JLabel();
        tcard.setBounds(380,20,200,40);
        tcard.setFont(new Font("Raleway",Font.BOLD,18));
        add(tcard);
        
        JLabel label3=new JLabel("Customer Details");
        label3.setBounds(350,100,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);
        
        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,190,100,30);
        add(name);
        
        tname=new JLabel();
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
        
        tdob=new JLabel();
        tdob.setBounds(300,340,400,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,14));
        add(tdob);
        
        JLabel gen=new JLabel("Gender :");
        gen.setFont(new Font("Raleway",Font.BOLD,20));
        gen.setBounds(100,290,200,30);
        add(gen);
        
        tgen=new JLabel();
        tgen.setBounds(300,290,400,30);
        tgen.setFont(new Font("Raleway",Font.BOLD,14));
        add(tgen);
        
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
        
        tmar=new JTextField();
        tmar.setBounds(300,440,400,30);
        tmar.setFont(new Font("Raleway",Font.BOLD,14));
        add(tmar);
        
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
        
        try{
            
            Cont c=new Cont();
            ResultSet r = c.stat.executeQuery("select * from signup where app_number = '"+f+"'");
            
            while(r.next()){
                tname.setText(r.getString("name"));
                faname.setText(r.getString("father_name"));
                tdob.setText(r.getString("DOB"));
                tgen.setText(r.getString("gender"));
                temail.setText(r.getString("email"));
                tmar.setText(r.getString("marital_status"));
                tadd.setText(r.getString("address"));
                tcity.setText(r.getString("city"));
                tpin.setText(r.getString("pin_code"));
                tstate.setText(r.getString("state"));
            }
            
            ResultSet rs=c.stat.executeQuery("select * from login where form_no = '"+f+"'");
            
            while(rs.next()){
                tcard.setText(rs.getString("card_number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        up = new JButton("Update");
        up.setFont(new Font("Raleway",Font.BOLD,14));
        up.setForeground(Color.BLACK);
        up.setBackground(Color.WHITE);
        up.setBounds(500,700,100,30);
        up.addActionListener(this);
        add(up);
        
        b = new JButton("Back");
        b.setFont(new Font("Raleway",Font.BOLD,14));
        b.setForeground(Color.BLACK);
        b.setBackground(Color.WHITE);
        b.setBounds(620,700,100,30);
        b.addActionListener(this);
        add(b);
        
        getContentPane().setBackground(new Color(210,255,220));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);

       
   }
   
   public void actionPerformed(ActionEvent e){
       
       if(e.getSource()==up){
           try{
               
               String fathname=faname.getText();
               String gender=tgen.getText();
               String email=temail.getText();
               String marital=tmar.getText();
               String add=tadd.getText();
               String city=tcity.getText();
               String pin=tpin.getText();
               String state=tstate.getText();
               
               Cont c=new Cont();
               String q="update signup set father_name = '"+fathname+"', gender= '"+gender+"', email = '"+email+"', marital_status = '"+marital+"', address = '"+add+"', city = '"+city+"', pin_code = '"+pin+"', state = '"+state+"' where app_number = '"+f+"'";
               c.stat.executeUpdate(q);
               JOptionPane.showMessageDialog(null,"Details updated successfully.");
               setVisible(false);
               new ViewCust();
               
           }catch(Exception E){
               E.printStackTrace();
           }
       }
       else{
           setVisible(false);
           new ViewCust();
       }
       
   }
   
   public static void main(String args[]){
       new UpdateCust("");
   }
}
