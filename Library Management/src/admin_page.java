import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin_page extends JFrame implements ActionListener {
    JLabel lb1,page,admin;
    JButton add_std , del_std , add_lib, del_lib , view_lib , view_std, logout;

    public admin_page(){
        //label
        lb1 = new JLabel("CENTRAL LIBRARY");
        lb1.setBounds(250,0,400,100);
        lb1.setFont(new Font("times new roman",Font.BOLD,36));
        lb1.setForeground(Color.WHITE);

        page = new JLabel("ADMIN PAGE");
        page.setForeground(Color.WHITE);

        //Buttons
        add_std = new JButton("Add Student");
        del_std = new JButton("Delete Student");
        add_lib = new JButton("Add Librarian");
        del_lib = new JButton("Delete Librarian");
        view_lib = new JButton("View Librarian");
        view_std = new JButton("View Student");
        logout = new JButton("Logout");

        //add student image
        ImageIcon add_stu_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\add1.png"));
        Image asi2 = add_stu_img1.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon asi3 = new ImageIcon(asi2);
        JLabel l1 = new JLabel(asi3);
        l1.setBounds(60, 130, 150, 150);
        add(l1);

        //delete student image
        ImageIcon del_stu_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\unfollow.png"));
        Image dsi2 = del_stu_img1.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon dsi3 = new ImageIcon(dsi2);
        JLabel l2 = new JLabel(dsi3);
        l2.setBounds(360, 105, 150, 200);
        add(l2);

        //view student image
        ImageIcon view_stu_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\read.png"));
        Image vsi2 = view_stu_img1.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon vsi3 = new ImageIcon(vsi2);
        JLabel l3 = new JLabel(vsi3);
        l3.setBounds(650, 105, 150, 200);
        add(l3);

        //add librarian image
        ImageIcon add_lib_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\follow.png"));
        Image ali2 = add_lib_img1.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon ali3 = new ImageIcon(ali2);
        JLabel l4 = new JLabel(ali3);
        l4.setBounds(60, 305, 150, 200);
        add(l4);

        // delete librarian img
        ImageIcon del_lib_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\delete-user.png"));
        Image dli2 = del_lib_img1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon dli3 = new ImageIcon(dli2);
        JLabel l5 = new JLabel(dli3);
        l5.setBounds(355, 310, 150, 200);
        add(l5);

        // view librarian image
        ImageIcon view_lib_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\librarian.png"));
        Image vli2 = view_lib_img1.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon vli3 = new ImageIcon(vli2);
        JLabel l6 = new JLabel(vli3);
        l6.setBounds(665, 310, 150, 200);
        add(l6);

        //button properties
        add_std.setBounds(50,270,150,30);
        add_std.setBorderPainted(false);
        add(page);

        del_std.setBounds(350, 270, 150, 30);
        view_std.setBounds(650, 270, 150, 30);
        add_lib.setBounds(50, 470, 150, 30);
        del_lib.setBounds(350, 470, 150, 30);
        view_lib.setBounds(650,470,150,30);
        page.setBounds(360,70,300,40);
        page.setFont(new Font("times new roman",Font.BOLD,20));

        logout.setBounds(375,510,100,40);
        logout.setFont(new Font("times new roman",Font.BOLD,20));
        logout.setForeground(Color.white);
        logout.setBackground(Color.BLACK);
        // del_std.setBounds();



        //adding
        add(lb1);
        add(add_std);
        add(del_std);
        add(add_lib);
        add(del_lib);
        add(view_lib);
        add(view_std);
        add(logout);

        add_std.setForeground(Color.white);
        add_std.setBackground(Color.black);

        del_std.setForeground(Color.white);
        del_std.setBackground(Color.black);

        view_std.setForeground(Color.white);
        view_std.setBackground(Color.black);

        view_lib.setForeground(Color.white);
        view_lib.setBackground(Color.black);

        add_lib.setForeground(Color.white);
        add_lib.setBackground(Color.black);

        del_lib.setForeground(Color.white);
        del_lib.setBackground(Color.black);


        setLayout(null);
        setSize(900,600);
        setVisible(true);
        setTitle("ADMIN PAGE : CENTRAL LIBRARY");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);


        add_std.addActionListener(this);
        del_std.addActionListener(this);
        add_lib.addActionListener(this);
        del_lib.addActionListener(this);
        view_std.addActionListener(this);
        view_lib.addActionListener(this);
        logout.addActionListener(this);

        ImageIcon img1 = new ImageIcon("Icon\\bg21.jpg");
        admin = new JLabel("",img1,JLabel.CENTER);
        add(admin);
        //jp.add(admin);
        admin.setBounds(0,0,900,1000);
        admin.setVisible(true);


    }


    public static void main(String[] args) {
        new admin_page();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add_std){
            new StudentSignup().setVisible(true);
            dispose();
        }
        if(e.getSource()==del_std){
            new DeleteStudent().setVisible(true);
            dispose();
        }
        if(e.getSource()==add_lib){
            new AddLibrarian().setVisible(true);
            dispose();
        }
        if(e.getSource()==del_lib){
            new DeleteLibrarian().setVisible(true);
            dispose();
        }

        if(e.getSource()== view_std){
            new view_student().setVisible(true);
            dispose();
        }

        if(e.getSource()== view_lib){
            new view_librarian().setVisible(true);
            dispose();
        }

        if(e.getSource()==logout){
            new LoginAdmin().setVisible(true);
            dispose();
        }


    }
}
