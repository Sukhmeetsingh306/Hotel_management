package hotel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;       // asper after using this we need the connection string to be built which we built in the try
    Statement s;
    Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "/*Enter the SOL Password*/");
            s = c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
