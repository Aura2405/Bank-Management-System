package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import java.io.IOException;
import java.sql.*;

public class RemoveEmp extends JFrame implements ActionListener
{
    Choice choice;
    JButton r,b;
    
    RemoveEmp(){
        super("REMOVE EMPLOYEE");
        
        JLabel l=new JLabel("Employee ID");
        l.setBounds(50,50,100,30);
        l.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l);
        
        choice=new Choice();
        choice.setBounds(200,50,150,30);
        add(choice);
        
        try{
            
            Cont c = new Cont();
            ResultSet r=c.stat.executeQuery("select * from emp");
            while(r.next()){
                choice.add(r.getString("empid"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(50,100,100,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l1);
        
        JLabel l2=new JLabel();
        l2.setBounds(200,100,100,30);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l2);
        
        JLabel l3=new JLabel("Phone");
        l3.setBounds(50,150,100,30);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);
        
        JLabel l4=new JLabel();
        l4.setBounds(200,150,100,30);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l4);
        
        JLabel l5=new JLabel("Email ID");
        l5.setBounds(50,200,100,30);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l5);
        
        JLabel l6=new JLabel();
        l6.setBounds(200,200,200,30);
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l6);
        
        try{
            
            Cont c = new Cont();
            ResultSet r=c.stat.executeQuery("select * from emp where empid = '"+choice.getSelectedItem()+"'");
            while(r.next()){
            l2.setText(r.getString("name"));
            l4.setText(r.getString("phone"));
            l6.setText(r.getString("email"));
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        choice.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
               try{
                   
                   Cont c = new Cont();
            ResultSet r=c.stat.executeQuery("select * from emp where empid = '"+choice.getSelectedItem()+"'");
            while(r.next()){
            l2.setText(r.getString("name"));
            l4.setText(r.getString("phone"));
            l6.setText(r.getString("email"));
                   
               }
            }
            catch(Exception E){
                   E.printStackTrace();
               }
            }
        });
        
        r=new JButton("Remove");
        r.setBounds(80,300,100,30);
        r.setBackground(Color.BLACK);
        r.setForeground(Color.WHITE);
        r.addActionListener(this);
        add(r);
        
        b=new JButton("Back");
        b.setBounds(220,300,100,30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        add(b);
        
        setSize(600,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==r){
            
            try{
                
                Cont c=new Cont();
                String q="delete from emp where empid = '"+choice.getSelectedItem()+"'";
                c.stat.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee removed successfully");
                setVisible(false);
                
            }catch(Exception E){
                E.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
        }
        
    }
    
    public static void main(String args[]){
        new RemoveEmp();
    }
}
