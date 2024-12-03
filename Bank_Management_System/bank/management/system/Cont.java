package bank.management.system;

import java.sql.*;

public class Cont{
    
    Connection con;
    Statement stat;
    
    public Cont(){        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Anu@2410");
            stat=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}