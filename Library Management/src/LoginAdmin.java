import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;


public class LoginAdmin extends JFrame implements ActionListener {
    JLabel lb1,lb2,lb3,test,page,bg,admin;
    JTextField tf1;
    JPasswordField tf2;
    JButton btn1,btn3,btn4, back;
    JPanel jp;


    public LoginAdmin(){


        lb1 = new JLabel("CENTRAL LIBRARY");
        lb2 = new JLabel("User ID:");
        lb3 = new JLabel("Password:");
        test = new JLabel("");
        page = new JLabel("Admin Login");

        tf1 = new JTextField(20);
        tf2 = new JPasswordField(20);

        btn1 = new JButton("Login");
        btn3 = new JButton("Clear");
        btn4 = new JButton("Demo");
        back = new JButton("Back");

        jp = new JPanel();

        add(lb1);
        jp.add(lb2);
        jp.add(tf1);
        jp.add(lb3);
        jp.add(tf2);
        jp.add(btn1);
        jp.add(btn3);
        jp.add(btn4);
        jp.add(back);
        jp.add(page);
        //jp.add(bg2);
        add(jp);
        add(test);


        jp.setBounds(200,120,500,300);
        jp.setVisible(true);
        jp.setLayout(null);
        jp.setBackground(Color.white);

        //ANYTIME BANK

        page.setBounds(175,35,300,40);
        page.setFont(new Font("Times new roman",Font.BOLD,40));


        lb1.setFont(new Font("Times new roman",Font.BOLD,34));
        lb1.setBounds(265,10,400,100);
        lb1.setForeground(Color.WHITE);

        //ID
        lb2.setFont(new Font("Times new roman",Font.PLAIN,18));
        lb2.setBounds(43,80,300,50);

        //ID_Textfield
        tf1.setFont(new Font("Times new roman",Font.PLAIN,20));
        tf1.setBounds(130,90,300,30);

        //PIN
        lb3.setFont(new Font("Times new roman",Font.PLAIN,18));
        lb3.setBounds(30,130,300,50);

        //PIN_Textfield
        tf2.setFont(new Font("Times new roman",Font.PLAIN,20));
        tf2.setBounds(130,140,300,30);

        btn1.setForeground(Color.white);
        btn1.setBackground(Color.black);

        btn3.setForeground(Color.white);
        btn3.setBackground(Color.black);

        back.setForeground(Color.white);
        back.setBackground(Color.black);

        //Login
        btn1.setBounds(129,190,300,30);


        //Clear
        btn3.setBounds(285,241,145,30);
        back.setBounds(130,241,145,30);

        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);

        getContentPane().setBackground(Color.WHITE);
        setTitle("ADMIN LOGIN : CENTRAL LIBRARY");

        btn3.addActionListener(this);
        btn1.addActionListener(this);
        back.addActionListener(this);

        ImageIcon img = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        add(bg);
        bg.setBounds(0,0,900,1000);

        ImageIcon img1 = new ImageIcon("Icon\\Admin.png");
        admin = new JLabel("",img1,JLabel.CENTER);
        add(admin);
        jp.add(admin);
        admin.setBounds(80,0,400,300);
        admin.setVisible(true);

    }

    public static void main(String[] args) {
        new LoginAdmin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn3) {
            tf1.setText("");
            tf2.setText("");
        }

        String ID = tf1.getText();
        String Pass = tf2.getText();
        if(e.getSource()== btn1){
            if(ID.equals("1") && Pass.equals("1")){
                new admin_page().setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect ID or Password");
            }
        }

        if(e.getSource()== back){
            new Role().setVisible(true);
            dispose();
        }

    }
}

