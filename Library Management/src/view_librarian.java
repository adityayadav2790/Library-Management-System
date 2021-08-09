import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class view_librarian extends JFrame implements ActionListener {
    JLabel lb_head,lb_page1,lb0,lb_name,lb_ID,bg;
    JTextField tf0,tf1,tf2;
    JButton srch_btn,back_btn;
    JPanel panel1;

    public view_librarian(){
        //Labels
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_head.setForeground(Color.WHITE);
        lb_page1 = new JLabel("View Librarian");
        lb_page1.setForeground(Color.WHITE);
        lb0 = new JLabel("ENTER LIBRARIAN ID:");
        lb_name  = new JLabel("Librarian Name:");
        lb_ID = new JLabel("Librarian ID:");

        //label properties
        lb_head.setBounds(260,10,600,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,38));

        lb_page1.setBounds(360,50,700,40);
        lb_page1.setFont(new Font("Times new roman",Font.BOLD,24));

        lb0.setBounds(20,43,500,40);
        lb0.setFont(new Font("Dialog",Font.BOLD,18));

        lb_ID.setBounds( 110,123,300,40);
        lb_ID.setFont(new Font("Arial",Font.BOLD,18));

        lb_name.setBounds(78,180,300,40);
        lb_name.setFont(new Font("Arial",Font.BOLD,18));

        //text fields
        tf0 = new JTextField(20);
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);

        //text fields properties
        tf0.setBounds(230,48,150,35);
        tf0.setFont(new Font("Arial",Font.BOLD,18));
        tf1.setBounds(230,130,250,30);
        tf1.setFont(new Font("Arial",Font.BOLD,18));
        tf1.setEditable(false);

        tf2.setBounds(230,185,250,30);
        tf2.setFont(new Font("Arial",Font.BOLD,18));
        tf2.setEditable(false);

        //button
        srch_btn = new JButton("Search");
        srch_btn.setBounds(390,48,90,35);
        srch_btn.setBackground(Color.BLACK);
        srch_btn.setForeground(Color.WHITE);

        back_btn = new JButton("BACK");
        back_btn.setBounds(30,250,100,30);
        back_btn.setBackground(Color.BLACK);
        back_btn.setForeground(Color.WHITE);

        // panel
        panel1 = new JPanel();
        panel1.setVisible(true);
        panel1.setLayout(null);
        panel1.setBounds(200,120,500,300);
        //panel1.setBorder(BorderFactory.createTitledBorder(  "Librarian" ));

        //panel1.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
        panel1.setBackground(Color.WHITE);
        add(panel1);
        add(lb_head);
        panel1.add(lb0);
        add(lb_page1);
        panel1.add(lb_name);
        panel1.add(lb_ID);
        panel1.add(tf0);
        panel1.add(tf1);
        panel1.add(tf2);
        panel1.add(srch_btn);
        panel1.add(back_btn);

        back_btn.addActionListener(this);
        srch_btn.addActionListener(this);

        setLayout(null);
        setSize(900,600);
        setVisible(true);
        setTitle("CENTRAL LIBRARY : VIEW LIBRARIAN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon img = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        add(bg);
        bg.setBounds(0,0,900,1000);


    }

    public static void main(String[] args) {
        new view_librarian();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== srch_btn){
            try {
                int id = Integer.parseInt(tf0.getText());

                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1", "root", "123");

                String q1 = "select Librarian_ID,name from librariandetails where Librarian_ID = ?";

                ps = con.prepareStatement(q1);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tf1.setText(rs.getString("Librarian_ID"));
                    tf2.setText(rs.getString("Name"));
                }
                else{
                    JOptionPane.showMessageDialog(null,"No such Librarian!!");
                    tf1.setText("");
                    tf2.setText("");
                }
            }
            catch(Exception aq){
                System.out.println(aq);
            }


        }

        if(e.getSource()== back_btn){
            new admin_page().setVisible(true);
            dispose();
        }

    }
}
