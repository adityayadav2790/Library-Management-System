import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_page extends JFrame implements ActionListener {
    JLabel lb_head, lb_page,admin;
    //JPanel panel;
    JButton btn_viewIssuedBook, logout ;


    public Student_page(){

        btn_viewIssuedBook = new JButton("View Issued Book");
        logout = new JButton("Logout");

        ImageIcon add_stu_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\issuebookstu.png"));
        Image asi2 = add_stu_img1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon asi3 = new ImageIcon(asi2);
        JLabel l1 = new JLabel(asi3);
        l1.setBounds(350, 150, 150, 200);
        add(l1);

        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_head.setForeground(Color.WHITE);
        lb_page = new JLabel("STUDENT LOGIN");
        lb_page.setForeground(Color.WHITE);

        //panel = new JPanel();

        logout.setForeground(Color.white);
        logout.setBackground(Color.black);

        btn_viewIssuedBook.setForeground(Color.white);
        btn_viewIssuedBook.setBackground(Color.black);

        add(lb_head);
        add(lb_page);

        //add(panel);

        add(btn_viewIssuedBook);
        add(logout);
       // panel.add(btn_viewIssuedBook);

        lb_head.setBounds(250,0,400,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,38));

        lb_page.setBounds(350,40,700,40);
        lb_page.setFont(new Font("Times new roman",Font.BOLD,20));

        //panel.setBounds(40,130,800,300);
       // panel.setBackground(Color.black);

        btn_viewIssuedBook.setBounds(350,320,150,30);
        logout.setBounds(350,520,150,30);


        logout.addActionListener(this);
        btn_viewIssuedBook.addActionListener(this);


        setLayout(null);
        //panel.setLayout(null);
        setSize(900,600);
        setVisible(true);
        setTitle("STUDENT PAGE : CENTRAL LIBRARY");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon img1 = new ImageIcon("Icon\\bg21.jpg");
        admin = new JLabel("",img1,JLabel.CENTER);
        add(admin);
        //jp.add(admin);
        admin.setBounds(0,0,900,1000);
        admin.setVisible(true);





    }

    public static void main(String[] args) {
        new Student_page();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==logout){
            new LoginStudent().setVisible(true);
            dispose();
        }

        if(e.getSource()==btn_viewIssuedBook){
            new Student_issue_book_table().setVisible(true);
        }
    }
}
