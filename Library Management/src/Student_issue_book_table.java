import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Student_issue_book_table{

    public Student_issue_book_table(){
        JFrame f = new JFrame();
        f.setTitle("JTable Example");

        JTable j = new JTable(0,4);
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
        f.setSize(600, 500);
        f.setVisible(true);
        setVisible(true);
        f.setTitle("VIEW ISSUED BOOKS : CENTRAL LIBRARY");
        f.getContentPane().setBackground(Color.WHITE);
    }

    public void setVisible(boolean b) {
    }

    public static void main(String[] args) {
        new Student_issue_book_table();
    }
}