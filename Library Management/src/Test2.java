import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {
    JFrame f;
    JTable j;

    public Test2()
    {

        f = new JFrame();
        f.setTitle("JTable Example");

        j = new JTable(0,4);
        j.setBounds(30, 40, 200, 300);
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
                DefaultTableModel tblModel = (DefaultTableModel)j.getModel();

                tblModel.addRow(tbData);


            }

        }catch(Exception e){
            System.out.println("database error" + e);
        }
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        f.setSize(xSize, ySize);
        f.setVisible(true);
        f.setTitle("VIEW BOOKS : CENTRAL LIBRARY");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.WHITE);
    }

    // Driver method
    public static void main(String[] args)
    {
        new Test2();
    }
}


