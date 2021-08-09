import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class view_student extends JFrame implements ActionListener {
    JLabel lb0,lb_head,lb_page1,lb_name,lb_father,lb_ID,lb_course,lb_branch,lb_year,lb_sem , bg;
    JTextField tf0,tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JButton srch_btn,back_btn;
    JPanel panel1;
    public view_student(){
        //Labels
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("View Students");
        lb0 = new JLabel("ENTER STUDENT ID:");
        lb_name  = new JLabel("Name:");
        lb_father = new JLabel("Father's Name:");
        lb_ID = new JLabel("Student ID:");
        lb_course = new JLabel("Course:");
        lb_branch = new JLabel("Branch:");
        lb_year = new JLabel("Year:");
        lb_sem = new JLabel("Semester:");

        //label properties
        lb_head.setBounds(270,10,400,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,38));
        lb_head.setForeground(Color.white);

        lb_page1.setBounds(380,70,700,40);
        lb_page1.setFont(new Font("Times new roman",Font.BOLD,20));
        lb_page1.setForeground(Color.white);

        lb0.setBounds(15,30,300,40);
        lb0.setFont(new Font("Dialog",Font.BOLD,20));

        lb_ID.setBounds( 115,60,100,40);
        lb_ID.setFont(new Font("Arial",Font.BOLD,18));

        lb_name.setBounds(158,90,200,40);
        lb_name.setFont(new Font("Arial",Font.BOLD,18));

        lb_father.setBounds(81,120,200,40);
        lb_father.setFont(new Font("Arial",Font.BOLD,18));

        lb_course.setBounds(143,150,200,40);
        lb_course.setFont(new Font("Arial",Font.BOLD,18));

        lb_branch.setBounds(143,180,200,40);
        lb_branch.setFont(new Font("Arial",Font.BOLD,18));

        lb_year.setBounds(168,210,200,40);
        lb_year.setFont(new Font("Arial",Font.BOLD,18));

        lb_sem.setBounds(126,240,200,40);
        lb_sem.setFont(new Font("Arial",Font.BOLD,18));

        //text fields
        tf0 = new JTextField(30);
        tf0.setFont(new Font("Arial",Font.BOLD,16));

        tf1 = new JTextField(30);
        tf1.setFont(new Font("Arial",Font.BOLD,16));

        tf2 = new JTextField(30);
        tf2.setFont(new Font("Arial",Font.BOLD,16));

        tf3 = new JTextField(30);
        tf3.setFont(new Font("Arial",Font.BOLD,16));

        tf4 = new JTextField(30);
        tf4.setFont(new Font("Arial",Font.BOLD,16));

        tf5 = new JTextField(30);
        tf5.setFont(new Font("Arial",Font.BOLD,16));

        tf6 = new JTextField(30);
        tf6.setFont(new Font("Arial",Font.BOLD,16));

        tf7 = new JTextField(30);
        tf7.setFont(new Font("Arial",Font.BOLD,16));

        //text fields properties
        tf0.setBounds(240,40,150,25);
        tf1.setBounds(240,73,200,20);
        tf1.setEditable(false);
        tf2.setBounds(240,103,200,20);
        tf2.setEditable(false);
        tf3.setBounds(240,133,200,20);
        tf3.setEditable(false);
        tf4.setBounds(240,163,200,20);
        tf4.setEditable(false);
        tf5.setBounds(240,193,200,20);
        tf5.setEditable(false);

        tf6.setBounds(240,223,200,20);
        tf6.setEditable(false);

        tf7.setBounds(240,253,200,20);
        tf7.setEditable(false);

        //button
        srch_btn = new JButton("Search");
        srch_btn.setBounds(400,40,80,25);
        srch_btn.setBackground(Color.black);
        srch_btn.setForeground(Color.white);

        back_btn = new JButton("BACK");
        back_btn.setBounds(50,310,100,30);
        back_btn.setBackground(Color.black);
        back_btn.setForeground(Color.white);

        panel1 = new JPanel();
        panel1.setVisible(true);
        panel1.setLayout(null);
        panel1.setBounds(200,150,500,350);

        panel1.setBackground(Color.WHITE);
        add(panel1);


        add(lb_head);
        add(lb_page1);
        panel1.add(lb_name);
        panel1.add(lb_father);
        panel1.add(lb_ID);
        panel1.add(lb_course);
        panel1.add(lb_branch);
        panel1.add(lb_year);
        panel1.add(lb_sem);
        panel1.add(lb0);
        panel1.add(tf0);
        panel1.add(tf1);
        panel1.add(tf2);
        panel1.add(tf3);
        panel1.add(tf4);
        panel1.add(tf5);
        panel1.add(tf6);
        panel1.add(tf7);
        panel1.add(srch_btn);
        panel1.add(back_btn);

        srch_btn.addActionListener(this);
        back_btn.addActionListener(this);

        setLayout(null);
        setSize(900,600);
        setVisible(true);
        setTitle("CENTRAL LIBRARY : VIEW STUDENT");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);


        ImageIcon img1 = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("", img1, JLabel.CENTER);

        add(bg);

        bg.setBounds(0, 0, 900, 1000);
    }


    public static void main(String[] args) {
        new view_student();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==back_btn){
            new admin_page().setVisible(true);
            dispose();
        }

        if(e.getSource()== srch_btn){
            try {
                int id = Integer.parseInt(tf0.getText());

                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1", "root", "123");

                String q1 = "select Student_ID,Name, FatherName, Course, Branch, Year, Semester from studentdetails where Student_ID = ?";

                ps = con.prepareStatement(q1);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tf1.setText(rs.getString("Student_ID"));
                    tf2.setText(rs.getString("Name"));
                    tf3.setText(rs.getString("FatherName"));
                    tf4.setText(rs.getString("Course"));
                    tf5.setText(rs.getString("Branch"));
                    tf6.setText(rs.getString("Year"));
                    tf7.setText(rs.getString("Semester"));
                }

                else{
                    JOptionPane.showMessageDialog(null,"No such user!!");
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    tf5.setText("");
                    tf6.setText("");
                    tf7.setText("");
                }
            }
            catch(Exception aq){
                System.out.println(aq);
            }

        }
    }
}
