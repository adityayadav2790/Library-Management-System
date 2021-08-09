import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddLibrarian extends JFrame implements ActionListener {

    JLabel lb_search, lb_head, lb_page1,Stu_name,Stu_Course, stu_branch,bg;
    JButton btn_delete, btn_back;
    JTextField tf_search, tf_stu_name;
    JPasswordField createPass , conPass;
    JPanel jp;

    public AddLibrarian() {


        lb_search = new JLabel("Enter Librarian ID:");
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("Add Librarian");
        Stu_name = new JLabel("Librarian Name:");
        Stu_Course = new JLabel("Create Password:");
        stu_branch = new JLabel("Confirm Password:");

        tf_search = new JTextField("");
        tf_stu_name = new JTextField("");
        createPass = new JPasswordField("");
        conPass = new JPasswordField("");

        btn_delete = new JButton("Add");
        btn_back = new JButton("Back");


        jp = new JPanel();

        jp.add(lb_search);
        add(lb_head);
        add(lb_page1);
        jp.add(tf_search);
        jp.add(btn_delete);
        jp.add(btn_back);
        jp.add(Stu_name);
        jp.add(Stu_Course);
        jp.add(stu_branch);
        jp.add(tf_stu_name);
        jp.add(createPass);
        jp.add(conPass);
        add(jp);


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

        lb_search.setBounds(30, 50, 400, 40);
        lb_search.setFont(new Font("Times new roman", Font.BOLD, 20));

        tf_search.setBounds(210, 50, 200, 30);
        tf_search.setFont(new Font("Times new roman", Font.BOLD, 20));

        btn_back.setBounds(30, 240, 100, 25);
        btn_back.setFont(new Font("Times new roman", Font.BOLD, 18));

        btn_delete.setBounds(370, 240, 100, 25);
        btn_delete.setFont(new Font("Times new roman", Font.BOLD, 18));


        Stu_name.setBounds(55,90,400,40);
        Stu_name.setFont(new Font("Times new roman",Font.BOLD,20));

        Stu_Course.setBounds(46,130,400,40);
        Stu_Course.setFont(new Font("Times new roman",Font.BOLD,20));

        stu_branch.setBounds(30,170,400,40);
        stu_branch.setFont(new Font("Times new roman",Font.BOLD,20));

        tf_stu_name.setBounds(210,95,200,30);
        tf_stu_name.setFont(new Font("Times new roman",Font.BOLD,20));


        createPass.setBounds(210,175,200,30);
        createPass.setFont(new Font("Times new roman",Font.BOLD,20));

        conPass.setBounds(210,135,200,30);
        conPass.setFont(new Font("Times new roman",Font.BOLD,20));


        //105 30


        btn_back.addActionListener(this);
        btn_delete.addActionListener(this);

        jp.setBounds(200,120,500,300);
        jp.setVisible(true);
        jp.setLayout(null);
        jp.setBackground(Color.white);

        btn_back.addActionListener(this);
        btn_delete.addActionListener(this);



        setTitle("ADD LIBRARIAN : CENTRAL LIBRARY");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }

    public static void main(String[] args) {
        new AddLibrarian();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btn_back) {
            new admin_page().setVisible(true);
            dispose();
        }

        if(ae.getSource() == btn_delete){
            String ID = tf_search.getText();
            String Name = tf_stu_name.getText();

            String CreatePass = createPass.getText();
            String ConfirmPass = conPass.getText();


            try {

                if (tf_search.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {

                    Conn c1 = new Conn();
                    String q2 = "insert into librariandetails values('"+ID+"','"+Name+"','"+ConfirmPass+"')";
                    c1.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Librarian Added Successfully");

                    new AddLibrarian().setVisible(true);
                    dispose();

                }

            } catch (Exception e) {
                System.out.println(e);
                //JOptionPane.showMessageDialog(null,"Librarian ID already exist!!!");
            }

        }


    }
}

