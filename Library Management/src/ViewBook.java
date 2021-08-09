import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewBook {
    JFrame f;
    JTable j;

    public ViewBook()
    {
        f = new JFrame();
        f.setTitle("JTable Example");

        j = new JTable(0,4);
        j.setBounds(30, 40, 300, 300);

        j.setFont(new Font("arial",Font.BOLD,16));
        f.setFont(new Font("Arial",Font.BOLD,16));

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);

        Connection con;
        Statement s;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1","root","123");
            s =con.createStatement();
            String sql = "Select * from Books";

            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String id = String.valueOf(rs.getInt("Book_ID"));
                String Name = rs.getString("Book_Name");
                String Author = rs.getString("Author");
                String genre = rs.getString("Genre");


                String tbData[] = {id, Name , Author, genre};
                String tbData11[] = {"Book ID", "Name" , "Author", "Genre"};
                DefaultTableModel tblModel = (DefaultTableModel)j.getModel();
                tblModel.setColumnIdentifiers(tbData11);
                tblModel.addRow(tbData);

            }

        }catch(Exception e){
            System.out.println("database error" + e);
        }
        f.setSize(600, 500);
        setVisible(true);
        f.setVisible(true);
        f.setTitle("VIEW BOOK : CENTRAL LIBRARY");
        f.getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args)
    {
        new ViewBook();
    }


    public void setVisible(boolean b) {
    }
}
