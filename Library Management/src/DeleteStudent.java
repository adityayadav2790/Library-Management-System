import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteStudent extends JFrame implements ActionListener {

    JLabel lb_search, lb_record, lb_head, lb_page1,Stu_name,Stu_Course, stu_branch,bg;
    JButton btn_delete, btn_back, btn_search;
    JTextField tf_search, tf_stu_name, tf_stu_course, tf_stu_branch;
    JPanel jp;

    public DeleteStudent() {


        lb_search = new JLabel("Enter Student ID:");
        lb_record = new JLabel("Records-");
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("Delete Student");
        Stu_name = new JLabel("Name:");
        Stu_Course = new JLabel("Course:");
        stu_branch = new JLabel("Branch:");

        tf_search = new JTextField("");
        tf_stu_name = new JTextField("");
        tf_stu_course = new JTextField("");
        tf_stu_branch = new JTextField("");

        btn_delete = new JButton("Delete");
        btn_back = new JButton("Back");
        btn_search = new JButton("Search");

        jp = new JPanel();

        jp.add(lb_search);
        jp.add(lb_record);
        add(lb_head);
        add(lb_page1);
        jp.add(tf_search);
        jp.add(btn_delete);
        jp.add(btn_back);
        jp.add(Stu_name);
        jp.add(Stu_Course);
        jp.add(stu_branch);
        jp.add(tf_stu_name);
        jp.add(tf_stu_course);
        jp.add(tf_stu_branch);
        jp.add(btn_search);
        add(jp);


        btn_search.setForeground(Color.white);
        btn_search.setBackground(Color.black);

        btn_delete.setForeground(Color.white);
        btn_delete.setBackground(Color.black);

        btn_back.setForeground(Color.white);
        btn_back.setBackground(Color.black);

        ImageIcon img = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        add(bg);
        bg.setBounds(0,0,900,1000);

        lb_head.setBounds(260, 0, 400, 40);
        lb_head.setFont(new Font("Times new roman", Font.BOLD, 38));
        lb_head.setForeground(Color.WHITE);

        lb_page1.setBounds(370, 40, 700, 40);
        lb_page1.setFont(new Font("Times new roman", Font.BOLD, 20));
        //lb_page1.setForeground(Color.WHITE);

        lb_search.setBounds(20, 10, 400, 40);
        lb_search.setFont(new Font("Times new roman", Font.BOLD, 20));

        tf_search.setBounds(190, 15, 150, 30);
        tf_search.setFont(new Font("Times new roman", Font.BOLD, 20));

        btn_back.setBounds(30, 240, 100, 25);
        btn_back.setFont(new Font("Times new roman", Font.BOLD, 18));

        btn_delete.setBounds(370, 240, 100, 25);
        btn_delete.setFont(new Font("Times new roman", Font.BOLD, 18));

        lb_record.setBounds(20,50,400,40);
        lb_record.setFont(new Font("Times new roman",Font.BOLD,20));

        Stu_name.setBounds(40,90,400,40);
        Stu_name.setFont(new Font("Times new roman",Font.BOLD,20));

        Stu_Course.setBounds(28,130,400,40);
        Stu_Course.setFont(new Font("Times new roman",Font.BOLD,20));

        stu_branch.setBounds(27,170,400,40);
        stu_branch.setFont(new Font("Times new roman",Font.BOLD,20));

        tf_stu_name.setBounds(110,95,300,30);
        tf_stu_name.setFont(new Font("Times new roman",Font.BOLD,20));
        tf_stu_name.setEditable(false);

        tf_stu_branch.setBounds(110,175,300,30);
        tf_stu_branch.setFont(new Font("Times new roman",Font.BOLD,20));
        tf_stu_branch.setEditable(false);

        tf_stu_course.setBounds(110,135,300,30);
        tf_stu_course.setFont(new Font("Times new roman",Font.BOLD,20));
        tf_stu_course.setEditable(false);

        btn_search.setBounds(360,15,100,30);
        btn_search.setFont(new Font("Times new roman", Font.BOLD, 18));

        //105 30


        btn_back.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_search.addActionListener(this);

        jp.setBounds(200,120,500,300);
        jp.setVisible(true);
        jp.setLayout(null);
        jp.setBackground(Color.white);



        setTitle("DELETE STUDENT : CENTRAL LIBRARY");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }

    public static void main(String[] args) {
        new DeleteStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_back) {
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
                    con =DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1","root","123");

                    String q1 = "delete from studentdetails where Student_ID = ?";

                    ps = con.prepareStatement(q1);
                    ps.setInt(1,id);

                    int rows = ps.executeUpdate();

                    if(rows>0)
                        JOptionPane.showMessageDialog(null,"User deleted Successful");
                    else
                        JOptionPane.showMessageDialog(null,"User not found");

                    con.close();

                }

            } catch (Exception qe) {
                System.out.println(qe);
            }

        }

        if(e.getSource()==btn_search){
            try {
                int id = Integer.parseInt(tf_search.getText());

                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1", "root", "123");

                String q1 = "select name,course,branch from studentdetails where Student_ID = ?";

                ps = con.prepareStatement(q1);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tf_stu_name.setText(rs.getString("Name"));
                    tf_stu_course.setText(rs.getString("Course"));
                    tf_stu_branch.setText(rs.getString("Branch"));
                }

                else{
                    JOptionPane.showMessageDialog(null,"No such user!!");
                    tf_stu_name.setText("");
                    tf_stu_course.setText("");
                    tf_stu_branch.setText("");
                }
            }
            catch(Exception aq){
                System.out.println(aq);
            }


        }


        }

    }
