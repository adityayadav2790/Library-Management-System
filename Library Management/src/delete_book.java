import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class delete_book extends JFrame implements ActionListener {
    JLabel lb_head,lb_page1,book_id,book_name , bg;
    JTextField tf1,tf2;
    JButton delete_btn,back_btn,search_btn;
    JPanel panel1;


    public delete_book(){
        //labels
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("DELETE BOOKS");
        book_id = new JLabel("Book ID :");
        book_name = new JLabel("Book Name :");
        // label properties
        lb_head.setBounds(270,20,400,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,38));
        lb_head.setForeground(Color.white);

        lb_page1.setBounds(360,80,700,40);
        lb_page1.setFont(new Font("Times new roman",Font.BOLD,24));
        lb_page1.setForeground(Color.white);

        book_id.setBounds( 71,50,400,40);
        book_id.setFont(new Font("Arial",Font.BOLD,24));

        book_name.setBounds(30,100,400,40);
        book_name.setFont(new Font("Arial",Font.BOLD,24));;

        //Text Fields and properties
        tf1 = new JTextField(50);
        tf1.setBounds(200,60,190,25);
        tf1.setFont(new Font("Arial",Font.BOLD,18));
        tf2 = new JTextField(50);
        tf2.setBounds(200,110,190,25);
        tf2.setFont(new Font("Arial",Font.BOLD,18));
        tf2.setEditable(false);

        //Buttons
        delete_btn = new JButton("DELETE");
        back_btn = new JButton("BACK");
        delete_btn.setBounds(370,240,100,30);
        delete_btn.setBackground(Color.black);
        delete_btn.setForeground(Color.white);
        back_btn.setBounds(30,240,100,30);
        back_btn.setBackground(Color.black);
        back_btn.setForeground(Color.white);
        search_btn = new JButton("SEARCH");
        search_btn.setForeground(Color.white);
        search_btn.setBackground(Color.black);
        search_btn.setBounds(400,60,90,30);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setVisible(true);
        panel1.setBounds(200,150,500,300);
        panel1.setBackground(Color.WHITE);
        add(panel1);

        add(lb_head);
        add(lb_page1);
        panel1.add(book_id);
        panel1.add(book_name);
        panel1.add(tf1);
        panel1.add(tf2);
        panel1.add(delete_btn);
        panel1.add(back_btn);
        panel1.add(search_btn);

        delete_btn.addActionListener(this);
        back_btn.addActionListener(this);
        search_btn.addActionListener(this);

        ImageIcon img1 = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("", img1, JLabel.CENTER);

        add(bg);

        bg.setBounds(0, 0, 900, 1000);

        setLayout(null);
        setSize(900,600);
        setVisible(true);
        setTitle("DELETE BOOK : CENTRAL LIBRARY");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new delete_book();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search_btn){
            try {
                int id = Integer.parseInt(tf1.getText());

                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1", "root", "123");

                String q1 = "select Book_name from Books where Book_ID = ?";

                ps = con.prepareStatement(q1);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tf2.setText(rs.getString("Book_Name"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"NO RECORD FOUND!!");
                    tf2.setText("");
                }
            }
            catch(Exception aq){
                System.out.println(aq);
            }


        }

        if(e.getSource()==delete_btn){
            int id = Integer.parseInt(tf1.getText());
            try {

                if (tf1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    Connection con;
                    PreparedStatement ps;

                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1","root","123");

                    String q1 = "delete from Books where Book_ID = ?";

                    ps = con.prepareStatement(q1);
                    ps.setInt(1,id);

                    int rows = ps.executeUpdate();

                    if(rows>0)
                        JOptionPane.showMessageDialog(null,"Book deleted Successful");
                    else
                        JOptionPane.showMessageDialog(null,"Book not found");

                    con.close();

                }

            } catch (Exception qe) {
                System.out.println(qe);
            }

        }

        if(e.getSource()==back_btn){
            new librarian_page().setVisible(true);
            dispose();
        }
    }
}
