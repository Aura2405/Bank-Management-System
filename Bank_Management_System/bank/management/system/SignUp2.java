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

public class SignUp2 extends JFrame implements ActionListener{
    
    JComboBox com,com1,com2,com3,com4;
    JTextField tpan,tadh;
    JButton b1;
    JRadioButton s1,s2,e1,e2;
    String appnumber;
    SignUp2(String first){
        super("APPLICATION FORM");
        
        try{
        BufferedImage a1=ImageIO.read(new File("C:/Users/ANUBRATA/Downloads/bank.png"));
        Image bank=a1.getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon a2=new ImageIcon(bank);
        JLabel image=new JLabel(a2);
        image.setBounds(150,5,100,100);
        add(image);
        
        this.appnumber=first;
        
        JLabel l1=new JLabel("Page 2");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(380,30,600,40);
        add(l1);
        
        JLabel l2=new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(330,60,600,40);
        add(l2);
        
        JLabel rel=new JLabel("Religion :");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);
        
        String religion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        com=new JComboBox(religion);
        com.setBackground(new Color(242,208,96));
        com.setFont(new Font("Raleway",Font.BOLD,14));
        com.setBounds(350,140,320,30);
        add(com);
        
        JLabel cat=new JLabel("Catergory :");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,120,30);
        add(cat);
        
        String category[]={"General","OBC","SC","ST","Other"};
        com1=new JComboBox(category);
        com1.setBackground(new Color(242,208,96));
        com1.setFont(new Font("Raleway",Font.BOLD,14));
        com1.setBounds(350,190,320,30);
        add(com1);
        
        JLabel inc=new JLabel("Income :");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100,240,120,30);
        add(inc);
        
        String income[]={"null","less than 1,50,000","2,50,000","5,00,000","Upto 10,00,000","Above 10,00,000"};
        com2=new JComboBox(income);
        com2.setBackground(new Color(242,208,96));
        com2.setFont(new Font("Raleway",Font.BOLD,14));
        com2.setBounds(350,240,320,30);
        add(com2);
        
        JLabel ed=new JLabel("Education :");
        ed.setFont(new Font("Raleway",Font.BOLD,20));
        ed.setBounds(100,290,120,30);
        add(ed);
        
        String education[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        com3=new JComboBox(education);
        com3.setBackground(new Color(242,208,96));
        com3.setFont(new Font("Raleway",Font.BOLD,14));
        com3.setBounds(350,290,320,30);
        add(com3);
        
        JLabel occ=new JLabel("Occupation :");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,340,120,30);
        add(occ);
        
        String occupation[]={"Unemployed","Self-Employed","Employed","Business","Student","Retired","Other"};
        com4=new JComboBox(occupation);
        com4.setBackground(new Color(242,208,96));
        com4.setFont(new Font("Raleway",Font.BOLD,14));
        com4.setBounds(350,340,320,30);
        add(com4);
        
        JLabel pan=new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,390,150,30);
        add(pan);
        
        tpan=new JTextField();
        tpan.setFont(new Font("Raleway",Font.BOLD,14));
        tpan.setBounds(350,390,320,30);
        add(tpan);
        
        JLabel adh=new JLabel("Aadhar Number :");
        adh.setFont(new Font("Raleway",Font.BOLD,20));
        adh.setBounds(100,440,180,30);
        add(adh);
        
        tadh=new JTextField();
        tadh.setFont(new Font("Raleway",Font.BOLD,14));
        tadh.setBounds(350,440,320,30);
        add(tadh);
        
        JLabel sen=new JLabel("Senior Citizen :");
        sen.setFont(new Font("Raleway",Font.BOLD,20));
        sen.setBounds(100,490,180,30);
        add(sen);
        
        s1=new JRadioButton("Yes");
        s1.setFont(new Font("Raleway",Font.BOLD,20));
        s1.setBackground(new Color(242,208,96));
        s1.setBounds(350,490,100,30);
        add(s1);
        
        s2=new JRadioButton("No");
        s2.setFont(new Font("Raleway",Font.BOLD,20));
        s2.setBackground(new Color(242,208,96));
        s2.setBounds(450,490,100,30);
        add(s2);
        
        ButtonGroup senior=new ButtonGroup();
        senior.add(s1);
        senior.add(s2);
        
        JLabel eacc=new JLabel("Existing Account :");
        eacc.setFont(new Font("Raleway",Font.BOLD,20));
        eacc.setBounds(100,540,180,30);
        add(eacc);
        
        e1=new JRadioButton("Yes");
        e1.setFont(new Font("Raleway",Font.BOLD,20));
        e1.setBackground(new Color(242,208,96));
        e1.setBounds(350,540,100,30);
        add(e1);
        
        e2=new JRadioButton("No");
        e2.setFont(new Font("Raleway",Font.BOLD,20));
        e2.setBackground(new Color(242,208,96));
        e2.setBounds(450,540,100,30);
        add(e2);
        
        ButtonGroup exist=new ButtonGroup();
        exist.add(e1);
        exist.add(e2);
        
        JLabel form=new JLabel("Form No. :");
        form.setFont(new Font("Raleway",Font.BOLD,15));
        form.setBounds(570,30,100,30);
        add(form);
        
        JLabel form1=new JLabel(appnumber);
        form1.setFont(new Font("Raleway",Font.BOLD,15));
        form1.setBounds(660,30,80,30);
        add(form1);
        
        b1=new JButton("Next");
        b1.setFont(new Font("Raleway",Font.BOLD,20));
        b1.setBackground(Color.WHITE);
        b1.setBounds(600,600,100,30);
        b1.addActionListener(this);
        add(b1);
        
        setLayout(null);
        setSize(850,750);
        setVisible(true);
        setLocation(450,80);
        getContentPane().setBackground(new Color(242,208,96));
        
        }catch(Exception e){
        e.printStackTrace();
    }
    
}

public void actionPerformed(ActionEvent e){
    
    
        String rel=(String)com.getSelectedItem();
        String cat=(String)com1.getSelectedItem();
        String inc=(String)com2.getSelectedItem();
        String edu=(String)com3.getSelectedItem();
        String occ=(String)com4.getSelectedItem();
        
        String pan=tpan.getText();
        String adh=tadh.getText();
        
        String scitizen="";
        if(s1.isSelected())
        scitizen="Yes";
        else if(s2.isSelected())
        scitizen="No";
        
        String eacc="";
        if(e1.isSelected())
        eacc="Yes";
        else if(e2.isSelected())
        eacc="No";
        
        try{
        
            if(tpan.getText().equals("") || tadh.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Fill all fields");
        }
            else
            {
                Cont c1=new Cont();
                String q="insert into signup2 values('"+appnumber+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+adh+"','"+scitizen+"','"+eacc+"')";
                c1.stat.executeUpdate(q);
                new SignUp3(appnumber);
                setVisible(false);
                
            }
            
        
        }  
    catch(Exception E){
        E.printStackTrace();
    }
}
    
    public static void main(String args[]){
        new SignUp2("");
    }
}