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
import net.proteanit.sql.DbUtils;


public class ViewCust extends JFrame implements ActionListener
{
    Choice ce;
    JTable table;
    JButton s,p,u,b;
    String form;
    
   ViewCust(){
       super("VIEW CUSTOMER");
       
       JLabel search=new JLabel("Search by Card No.");
       search.setBounds(20,20,150,20);
       add(search);
       
       ce=new Choice();
       ce.setBounds(180,20,150,20);
       add(ce);
       
       try{
           
           Cont c=new Cont();
           ResultSet r=c.stat.executeQuery("select * from login");
           while(r.next()){
               ce.add(r.getString("card_number"));
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       table=new JTable();
       try{
           
           Cont c=new Cont();
           ResultSet rs=c.stat.executeQuery("select * from signup");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
           
       }catch(Exception E){
           E.printStackTrace();
       }
       
       JScrollPane jp=new JScrollPane(table);
       jp.setBounds(0,100,900,600);
       add(jp);
       
       s=new JButton("Search");
       s.setBounds(20,70,80,20);
       s.addActionListener(this);
       add(s);
       
       p=new JButton("Print");
       p.setBounds(120,70,80,20);
       p.addActionListener(this);
       add(p);
       
       u=new JButton("Update");
       u.setBounds(220,70,80,20);
       u.addActionListener(this);
       add(u);
       
       b=new JButton("Close");
       b.setBounds(320,70,80,20);
       b.addActionListener(this);
       add(b);
       
       getContentPane().setBackground(new Color(255,131,122));
       
       setSize(900,700);
       setLocation(300,100);
       setLayout(null);
       setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e){
       
       if(e.getSource()==s){
           String q="select * from login where card_number = '"+ce.getSelectedItem()+"'";
           try{
               
               Cont c=new Cont();
               ResultSet r=c.stat.executeQuery(q);
               while(r.next()){
               form=r.getString("form_no");
            }
               ResultSet rs=c.stat.executeQuery("select * from signup where app_number = '"+form+"'");
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
           }catch(Exception E){
               E.printStackTrace();
           }
       }
       else if(e.getSource()==p){
           try{
               
               table.print();
               
           }catch(Exception E){
               E.printStackTrace();
           }
       }
       else if(e.getSource()==u){
           setVisible(false);
           new UpdateCust(form);
       }
       else if(e.getSource()==b){
           setVisible(false);
       }
       
   }
   
   public static void main(String args[]){
       new ViewCust();
   }
}
