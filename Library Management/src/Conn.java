import java.sql.*;

public class Conn{
    Connection con;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1","root","123");
            s =con.createStatement();
        }catch(Exception e){
            System.out.println("database error" + e);
        }
    }
}