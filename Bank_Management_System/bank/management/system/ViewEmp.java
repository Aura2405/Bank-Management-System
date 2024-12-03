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


public class ViewEmp extends JFrame implements ActionListener
{
    Choice ce;
    JTable table;
    JButton s,p,u,b;
    
   ViewEmp(){
       super("VIEW EMPLOYEE");
       
       JLabel search=new JLabel("Search by Employee ID");
       search.setBounds(20,20,150,20);
       add(search);
       
       ce=new Choice();
       ce.setBounds(180,20,150,20);
       add(ce);
       
       try{
           
           Cont c=new Cont();
           ResultSet r=c.stat.executeQuery("select * from emp");
           while(r.next()){
               ce.add(r.getString("empid"));
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       table=new JTable();
       try{
           
           Cont c=new Cont();
           ResultSet rs=c.stat.executeQuery("select * from emp");
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
           String q="select * from emp where empid = '"+ce.getSelectedItem()+"'";
           try{
               
               Cont c=new Cont();
               ResultSet r=c.stat.executeQuery(q);
               table.setModel(DbUtils.resultSetToTableModel(r));
               
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
           new UpdateEmp(ce.getSelectedItem());
       }
       else if(e.getSource()==b){
           setVisible(false);
       }
       
   }
   
   public static void main(String args[]){
       new ViewEmp();
   }
}
