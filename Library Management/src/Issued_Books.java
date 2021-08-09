import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Issued_Books {
    JFrame f;
    JTable j;


    public Issued_Books()
    {

        f = new JFrame();
        f.setTitle("JTable Example");

        j = new JTable(0,4);
        j.setBounds(30, 40, 300, 300);
        //f.setBounds(30, 40, 300, 300);
        j.setFont(new Font("arial",Font.BOLD,16));
        f.setFont(new Font("Arial",Font.BOLD,16));

        //back = new JButton("Back");

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
//        f.add(back);

        // back.setBounds(300,400,100,40);


        Connection con;
        Statement s;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1","root","123");
            s =con.createStatement();
            String sql = "Select * from issuebook";

            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String id = String.valueOf(rs.getInt("Book_ID"));
                //String Name = rs.getString("Book_Name");
                String sid = rs.getString("Student_ID");
                //String sname = rs.getString("Student_Name");
                String issueDate = rs.getString("Issue_date");
               // String returnDate = rs.getString("Return_date");


                String tbData[] = {id, sid, issueDate};
                String tbData11[] = {"Book ID", "Student ID" , "Issue Date"};
                DefaultTableModel tblModel = (DefaultTableModel)j.getModel();
                tblModel.setColumnIdentifiers(tbData11);
                tblModel.addRow(tbData);


            }

        }catch(Exception e){
            System.out.println("database error" + e);
        }
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int xSize = ((int) tk.getScreenSize().getWidth());
//        int ySize = ((int) tk.getScreenSize().getHeight());
        f.setSize(600, 500);
        setVisible(true);
        f.setVisible(true);
        f.setTitle("ISSUED BOOK : CENTRAL LIBRARY");
        // f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.WHITE);


    }

    // Driver method
    public static void main(String[] args)
    {
        new Issued_Books();
    }


    public void setVisible(boolean b) {
    }
}


