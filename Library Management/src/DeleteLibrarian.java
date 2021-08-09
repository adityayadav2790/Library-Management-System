import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteLibrarian extends JFrame implements ActionListener {

    JLabel lb_search, lb_record, lb_head,lb_page1, lib_det,bg;
    JButton btn_search, btn_delete, btn_back;
    JTextField tf_search, lib_ID, lib_name;
    JPanel jp;

    public DeleteLibrarian(){

        lb_search = new JLabel("Enter Librarian ID:");
        lb_record = new JLabel("Records-");
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("Delete Librarian");
        lib_det = new JLabel("Name:");

        tf_search = new JTextField("");
        lib_ID = new JTextField("");
        lib_name = new JTextField("");

        btn_search = new JButton("Search");
        btn_delete = new JButton("Delete");
        btn_back = new JButton("Back");

        jp = new JPanel();

        jp.add(lb_search);
        jp.add(lb_record);
        add(lb_head);
        jp.add(lb_page1);
        jp.add(tf_search);
        jp.add(btn_search);
        jp.add(btn_delete);
        jp.add(btn_back);
        jp.add(lib_name);
        jp.add(lib_ID);
        jp.add(lib_det);
        add(jp);

        lb_head.setBounds(260,0,400,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,38));

        lb_page1.setBounds(170,0,700,40);
        lb_page1.setFont(new Font("Times new roman",Font.BOLD,20));

        lb_search.setBounds(10,40,400,40);
        lb_search.setFont(new Font("Times new roman",Font.BOLD,20));

        tf_search.setBounds(190,45,150,30);
        tf_search.setFont(new Font("Times new roman",Font.BOLD,20));

        btn_search.setBounds(350,45,100,30);
        btn_search.setFont(new Font("Times new roman",Font.BOLD,20));

        lb_record.setBounds(10,80,400,40);
        lb_record.setFont(new Font("Times new roman",Font.BOLD,20));

        btn_back.setBounds( 40,230,100,25);
        btn_back.setFont(new Font("Times new roman",Font.BOLD,18));

        btn_delete.setBounds( 350,230,100,25);
        btn_delete.setFont(new Font("Times new roman",Font.BOLD,18));

        lib_name.setBounds(90,130,200,30);
        lib_name.setFont(new Font("Times new roman",Font.BOLD,20));
        lib_name.setEditable(false);

        lib_det.setBounds(10,130,300,30);
        lib_det.setFont(new Font("Times new roman",Font.BOLD,20));


        btn_search.setForeground(Color.white);
        btn_search.setBackground(Color.black);

        btn_delete.setForeground(Color.white);
        btn_delete.setBackground(Color.black);

        btn_back.setForeground(Color.white);
        btn_back.setBackground(Color.black);


        btn_back.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_search.addActionListener(this);

        jp.setBounds(200,120,500,300);
        jp.setVisible(true);
        jp.setLayout(null);
        jp.setBackground(Color.white);

        setTitle("DELETE LIBRARIAN : CENTRAL LIBRARY");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon img = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        add(bg);
        bg.setBounds(0,0,900,1000);

    }

    public static void main(String[] args) {
        new DeleteLibrarian();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_back) {
            new admin_page().setVisible(true);
            dispose();
        }
        if (e.getSource() == btn_delete) {
            int id = Integer.parseInt(tf_search.getText());
            try {

                if (tf_search.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    Connection con;
                    PreparedStatement ps;

                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1","root","123");

                    String q1 = "delete from librariandetails where Librarian_ID = ?";

                    ps = con.prepareStatement(q1);
                    ps.setInt(1,id);

                    int rows = ps.executeUpdate();

                    if(rows>0)
                        JOptionPane.showMessageDialog(null,"Librarian deleted Successful");
                    else
                        JOptionPane.showMessageDialog(null,"Librarian not found");

                    con.close();

                }

            } catch (Exception qe) {
                System.out.println(qe);
            }

        }

        if(e.getSource()== btn_search){
        try {
            int id = Integer.parseInt(tf_search.getText());

            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1", "root", "123");

            String q1 = "select name from librariandetails where Librarian_ID = ?";

            ps = con.prepareStatement(q1);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lib_name.setText(rs.getString("Name"));
            }
            else{
                JOptionPane.showMessageDialog(null,"No such Librarian!!");
                lib_name.setText("");
            }
        }
        catch(Exception aq){
                System.out.println(aq);
            }


        }
    }
}
