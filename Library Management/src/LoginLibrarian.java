import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginLibrarian extends JFrame implements ActionListener{
    JLabel lb1, lb2, lb3, test, page, bg,admin;
    JTextField tf1;
    JPasswordField tf2;
    JButton btn1, btn3, btn4, back;
    JPanel panel;


    public LoginLibrarian() {


        lb1 = new JLabel("CENTRAL LIBRARY");
        lb2 = new JLabel("User ID:");
        lb3 = new JLabel("Password:");
        test = new JLabel("");
        page = new JLabel("Librarian Login");
        //page.setForeground(Color.WHITE);

        tf1 = new JTextField(20);
        tf2 = new JPasswordField(20);

        btn1 = new JButton("Login");
        btn3 = new JButton("Clear");
        btn4 = new JButton("Demo");
        back = new JButton("Back");



        lb1.setFont(new Font("Times new roman",Font.BOLD,34));
        lb1.setBounds(300,10,400,100);
        lb1.setForeground(Color.WHITE);

        //ID
        lb2.setFont(new Font("Times new roman", Font.PLAIN, 18));
        lb2.setBounds(40, 80, 300, 50);


        //ID_Textfield
        tf1.setFont(new Font("Times new roman",Font.PLAIN,20));
        tf1.setBounds(130,90,300,30);

        //PIN
        lb3.setFont(new Font("Times new roman",Font.PLAIN,18));
        lb3.setBounds(30,130,300,50);

        //PIN_Textfield
        tf2.setFont(new Font("Times new roman",Font.PLAIN,20));
        tf2.setBounds(130,140,300,30);

        page.setBounds(115,35,300,50);
        page.setFont(new Font("Times new roman",Font.BOLD,40));



        //Login
        btn1.setBounds(129,190,300,30);
        btn1.setBackground(Color.black);
        btn1.setForeground(Color.white);



        btn3.setBounds(285,241,145,30);
        //back.setBounds(130,140,145,30);
        btn3.setBackground(Color.black);
        btn3.setForeground(Color.white);
        back.setBounds(128, 240, 145, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);

        getContentPane().setBackground(Color.WHITE);
        setTitle("LIBRARIAN LOGIN : CENTRAL LIBRARY");

        panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBounds(200,150,500,300);
        panel.setBackground(Color.WHITE);

        add(lb1);
        panel.add(lb2);
        panel.add(tf1);
        panel.add(lb3);
        panel.add(tf2);
        panel.add(btn1);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(back);
        panel.add(page);
        panel.add(test);
        add(panel);


        ImageIcon img1 = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("", img1, JLabel.CENTER);
        add(bg);
        bg.setBounds(0, 0, 900, 1000);

        ImageIcon img = new ImageIcon("Icon\\student.png");
        admin = new JLabel("",img,JLabel.CENTER);
        add(admin);
        panel.add(admin);
        admin.setBounds(100,0,400,300);
        admin.setVisible(true);


        btn1.addActionListener(this);
        btn3.addActionListener(this);
        back.addActionListener(this);
        btn4.addActionListener(this);


    }

    public static void main(String[] args) {
        new LoginLibrarian();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn3) {
            tf1.setText("");
            tf2.setText("");
        }

//        String ID = tf1.getText();
//        String Pass = String.valueOf(tf2.getPassword());

        if(e.getSource()== btn1){
            try {
                int id = Integer.parseInt(tf1.getText());
                String pass = tf2.getText();

                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1", "root", "123");

                String q1 = "select * from librariandetails where Librarian_ID = ? and password = ?";

                ps = con.prepareStatement(q1);
                ps.setInt(1, id);
                ps.setString(2,pass);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    new librarian_page().setVisible(true);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect ID or Password");
                }
            }
            catch(Exception aq){
                System.out.println(aq);
            }
        }

        if(e.getSource()== back){
            new Role().setVisible(true);
            dispose();
        }

    }
}

