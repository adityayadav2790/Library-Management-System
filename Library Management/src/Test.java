//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//
//
//
//public class Test extends JFrame {
//
//    JLabel label;
//    // frame
//    JFrame f;
//    // Table
//    JTable j;
//
//    public Test(){
//        label = new JLabel("HEllo");
//
//        f.add(sp);
//        add(label);
//
//        label.setBounds(10,10,300,30);
//
//        // Packages to import
//
//
//
//            // Constructor
//
//                // Frame initiallization
//                f = new JFrame();
//
//                // Frame Title
//                f.setTitle("JTable Example");
//
//                // Data to be displayed in the JTable
//                String[][] data = {
//                        { "Kundan Kumar Jha", "4031", "CSE" },
//                        { "Anand Jha", "6014", "IT" }
//                };
//
//                // Column Names
//                String[] columnNames = { "Name", "Roll Number", "Department" };
//
//                // Initializing the JTable
//                j = new JTable(data, columnNames);
//                j.setBounds(30, 40, 200, 300);
//
//                // adding it to JScrollPane
//                JScrollPane sp = new JScrollPane(j);
//
//                // Frame Size
//
//
//
//
//
//
//
////        Connection con;
////        Statement s;
////        try{
////            Class.forName("com.mysql.jdbc.Driver");
////            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1","root","123");
////            s =con.createStatement();
////            String sql = "Select * from Books";
////
////            ResultSet rs = s.executeQuery(sql);
////
////            while(rs.next()){
////                String id = String.valueOf(rs.getInt("Book_ID"));
////                String Name = rs.getString("Book_Name");
////                String Author = rs.getString("Author");
////
////
////                String tbData[] = {id, Name , Author};
////                DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
////
////                tblModel.addRow(tbData);
////
////
////            }
////
////
////
////        }catch(Exception e){
////            System.out.println("database error" + e);
////        }
////
////
////
////
////
////
////
////
////
////
////
//
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int xSize = ((int) tk.getScreenSize().getWidth());
//        int ySize = ((int) tk.getScreenSize().getHeight());
//        setSize(xSize, ySize);
//        setLayout(null);
//        setVisible(true);
//        setTitle("CENTRAL LIBRARY : ADD BOOKS");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        getContentPane().setBackground(Color.WHITE);
//
//        }
//
//    public static void main(String[] args) {
//        new Test();
//    }
//}
