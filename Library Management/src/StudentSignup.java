import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentSignup extends JFrame implements ActionListener {
    JLabel lb_head,lb_page1,lb_name, lb_father, lb_ID, lb_course, lb_branch,bg, lb_year, lb_sem, lb_password, lb_conPass;
    JTextField tf_name, tf_father, tf_ID;
    JPasswordField pass , conPass;
    JButton btn_add,btn_back;
    JComboBox cb_course, cb_branch, cb_year, cb_sem;
    JPanel jp;

    String st_course[] = {"B.tech","M.Tech","BCA","MCA","BBA","MBA"};
    String st_branch[] = {"Computer Science","Mechanical","Electrical","Finance","Marketing"};
    String st_year[] = {"First","Second","Third","Fourth"};
    String st_sem[] = {"One","Two","Three","Four","Five","Six","Seven","Eight"};

    public StudentSignup(){

        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("Student Signup");
        lb_name  = new JLabel("Name:");
        lb_father = new JLabel("Father's Name:");
        lb_ID = new JLabel("Student ID:");
        lb_course = new JLabel("Course:");
        lb_branch = new JLabel("Branch:");
        lb_year = new JLabel("Year:");
        lb_sem = new JLabel("Semester:");
        lb_password = new JLabel("Create Password:");
        lb_conPass = new JLabel("Confirm Password:");

        tf_name = new JTextField(30);
        tf_father = new JTextField(30);
        tf_ID = new JTextField(30);

        cb_course = new JComboBox(st_course);
        cb_branch = new JComboBox(st_branch);
        cb_year = new JComboBox(st_year);
        cb_sem = new JComboBox(st_sem);

        btn_add = new JButton("Add");
        btn_back = new JButton("Back");

        pass = new JPasswordField();
        conPass = new JPasswordField();

        jp = new JPanel();

        add(lb_head);
        jp.add(lb_page1);
        jp.add(lb_name);
        jp.add(lb_father);
        jp.add(lb_ID);
        jp.add(lb_course);
        jp.add(lb_branch);
        jp.add(lb_year);
        jp.add(lb_sem);
        jp.add(tf_name);
        jp.add(tf_father);
        jp.add(tf_ID);
        jp.add(cb_course);
        jp.add(cb_branch);
        jp.add(cb_year);
        jp.add(cb_sem);
        jp.add(btn_add);
        jp.add(btn_back);
        jp.add(lb_password);
        jp.add(lb_conPass);
        jp.add(pass);
        add(jp);
        jp.add(conPass);


        lb_head.setBounds(260,10,400,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,38));
        lb_head.setForeground(Color.WHITE);
        //lb_head.setBackground(Color.BLACK);

        lb_page1.setBounds(170,5,700,40);
        lb_page1.setFont(new Font("Times new roman",Font.BOLD,20));

        lb_ID.setBounds( 76,70,100,40);
        lb_ID.setFont(new Font("Arial",Font.BOLD,18));

        lb_name.setBounds(118,100,200,40);
        lb_name.setFont(new Font("Arial",Font.BOLD,18));

        lb_father.setBounds(45,130,200,40);
        lb_father.setFont(new Font("Arial",Font.BOLD,18));

        lb_course.setBounds(108,160,200,40);
        lb_course.setFont(new Font("Arial",Font.BOLD,18));

        lb_branch.setBounds(108,190,200,40);
        lb_branch.setFont(new Font("Arial",Font.BOLD,18));

        lb_year.setBounds(132,220,200,40);
        lb_year.setFont(new Font("Arial",Font.BOLD,18));

        lb_sem.setBounds(89,250,200,40);
        lb_sem.setFont(new Font("Arial",Font.BOLD,18));


        tf_ID.setBounds( 190,78,250,25);
        tf_ID.setFont(new Font("Arial",Font.BOLD,18));

        tf_name.setBounds( 190,108,250,25);
        tf_name.setFont(new Font("Arial",Font.BOLD,18));

        tf_father.setBounds( 190,138,250,25);
        tf_father.setFont(new Font("Arial",Font.BOLD,18));

        cb_course.setBounds( 190,168,250,25);
        cb_course.setFont(new Font("Arial",Font.BOLD,18));
        cb_course.setBackground(Color.WHITE);

        cb_branch.setBounds( 190,198,250,25);
        cb_branch.setFont(new Font("Arial",Font.BOLD,18));
        cb_branch.setBackground(Color.WHITE);

        cb_year.setBounds( 190,228,250,25);
        cb_year.setFont(new Font("Arial",Font.BOLD,18));
        cb_year.setBackground(Color.WHITE);


        cb_sem.setBounds( 190,258,250,25);
        cb_sem.setFont(new Font("Arial",Font.BOLD,18));
        cb_sem.setBackground(Color.WHITE);

        btn_back.setBounds( 85,360,100,25);
        btn_back.setFont(new Font("Arial",Font.BOLD,18));
        btn_back.setForeground(Color.WHITE);
        btn_back.setBackground(Color.BLACK);

        btn_add.setBounds( 320,360,100,25);
        btn_add.setFont(new Font("Arial",Font.BOLD,18));
        btn_add.setForeground(Color.WHITE);
        btn_add.setBackground(Color.BLACK);

        lb_password.setBounds(24,280,200,40);
        lb_password.setFont(new Font("Arial",Font.BOLD,18));

        lb_conPass.setBounds(10,310,200,40);
        lb_conPass.setFont(new Font("Arial",Font.BOLD,18));

        pass.setBounds( 190,288,250,25);
        pass.setFont(new Font("Arial",Font.BOLD,18));

        conPass.setBounds( 190,318,250,25);
        conPass.setFont(new Font("Arial",Font.BOLD,18));

        btn_add.addActionListener(this);
        btn_back.addActionListener(this);

        jp.setBounds(200,80,500,400);
        jp.setVisible(true);
        jp.setLayout(null);
        jp.setBackground(Color.white);

        ImageIcon img = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        add(bg);
        bg.setBounds(0,0,900,1000);


        setTitle("ADD STUDENT : CENTRAL LIBRARY");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new StudentSignup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==btn_back) {
            new admin_page().setVisible(true);
            dispose();
        }

        if(ae.getSource() == btn_add){
            String ID = tf_ID.getText();
            String Name = tf_name.getText();
            String FName = tf_father.getText();

            String Course = cb_course.getSelectedItem().toString();
            String Branch = cb_branch.getSelectedItem().toString();
            String Year = cb_year.getSelectedItem().toString();
            String Semester = cb_sem.getSelectedItem().toString();

            String CreatePass = pass.getText();
            String ConfirmPass = conPass.getText();


                try {

                    if (tf_ID.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fill all the required fields");
                    } else {

                        Conn c1 = new Conn();
                        String q1 = "insert into studentdetails values('"+ID+"','"+Name+"','"+FName+"','"+Course+"','"+Branch+"','"+Year+"','"+Semester+"','"+ConfirmPass+"')";
                        c1.s.executeUpdate(q1);

                        JOptionPane.showMessageDialog(null, "Student Added Successfully");
                        new StudentSignup().setVisible(true);
                        dispose();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Student ID already exist!!");
                }

            }



        }


    }



