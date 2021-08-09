import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class librarian_page extends JFrame implements ActionListener{
    JLabel lb_head,lb_page1,lb1,admin;
    JButton btn_view_book,add_books,delete_books,issued_books,issue_book_btn,btn_return_book , logout;


    public librarian_page(){
        //labels
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("LIBRARIAN PAGE");
        lb_head.setBounds(250,10,400,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,38));
        lb_head.setForeground(Color.white);

        lb_page1.setBounds(350,60,700,40);
        lb_page1.setFont(new Font("Times new roman",Font.BOLD,20));
        lb_page1.setForeground(Color.white);

        //buttons
        btn_view_book = new JButton("View Books");
        logout = new JButton("Logout");
        add_books = new JButton("Add Books");
        delete_books = new JButton("Delete Books");
        issue_book_btn = new JButton("Issue Book");
        issued_books = new JButton("Issued Books");
        btn_return_book = new JButton("Return Books");


        //view book image
        ImageIcon add_stu_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\viewbook.png"));
        Image asi2 = add_stu_img1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon asi3 = new ImageIcon(asi2);
        JLabel l1 = new JLabel(asi3);
        l1.setBounds(60, 110, 150, 200);
        add(l1);

        //Add book
        ImageIcon del_stu_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\add.png"));
        Image dsi2 = del_stu_img1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon dsi3 = new ImageIcon(dsi2);
        JLabel l2 = new JLabel(dsi3);
        l2.setBounds(350, 110, 150, 200);
        add(l2);


        //Delete Book
        ImageIcon view_stu_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\bookdel.png"));
        Image vsi2 = view_stu_img1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon vsi3 = new ImageIcon(vsi2);
        JLabel l3 = new JLabel(vsi3);
        l3.setBounds(650, 110, 150, 200);
        add(l3);

        //Issued Book
        ImageIcon add_lib_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\agenda.png"));
        Image ali2 = add_lib_img1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon ali3 = new ImageIcon(ali2);
        JLabel l4 = new JLabel(ali3);
        l4.setBounds(50, 310, 150, 200);
        add(l4);


        //REturn book
        ImageIcon ret_stu_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\bookreturn.png"));
        Image dsi6 = ret_stu_img1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon dsi7 = new ImageIcon(dsi6);
        JLabel l6 = new JLabel(dsi7);
        l6.setBounds(350, 315, 150, 200);
        add(l6);

        // Issue book
        ImageIcon del_lib_img1 = new ImageIcon(ClassLoader.getSystemResource("icon2\\bookissue.png"));
        Image dli2 = del_lib_img1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon dli3 = new ImageIcon(dli2);
        JLabel l5 = new JLabel(dli3);
        l5.setBounds(640, 310, 150, 200);
        add(l5);


        //button properties
        btn_view_book.setBounds(50,270,150,30);


        add_books.setBounds(350, 270, 150, 30);
        btn_return_book.setBounds(350, 470, 150, 30);
        delete_books.setBounds(650, 270, 150, 30);
        issued_books.setBounds(50, 470, 150, 30);
        issue_book_btn.setBounds(650, 470, 150, 30);

        logout.setBounds(375,510,100,40);
        logout.setFont(new Font("times new roman",Font.BOLD,20));

        logout.setForeground(Color.white);
        logout.setBackground(Color.black);

        btn_view_book.setForeground(Color.white);
        btn_view_book.setBackground(Color.black);

        add_books.setForeground(Color.white);
        add_books.setBackground(Color.black);

        btn_return_book.setForeground(Color.white);
        btn_return_book.setBackground(Color.black);

        delete_books.setForeground(Color.white);
        delete_books.setBackground(Color.black);

        issued_books.setForeground(Color.white);
        issued_books.setBackground(Color.black);

        issue_book_btn.setForeground(Color.white);
        issue_book_btn.setBackground(Color.black);


        add(lb_head);
        add(lb_page1);
        add(btn_view_book);
        add(add_books);
        add(delete_books);
        add(issue_book_btn);
        add(issued_books);
        add(btn_return_book);
        add(logout);

        ImageIcon img1 = new ImageIcon("Icon\\bg21.jpg");
        admin = new JLabel("",img1,JLabel.CENTER);
        add(admin);
        //jp.add(admin);
        admin.setBounds(0,0,900,1000);
        admin.setVisible(true);



        setLayout(null);
        setSize(900,600);
        setVisible(true);
        setTitle("LIBRARIAN PAGE : CENTRAL LIBRARY");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);


        logout.addActionListener(this);
        add_books.addActionListener(this);
        delete_books.addActionListener(this);
        btn_view_book.addActionListener(this);
        issued_books.addActionListener(this);
        issue_book_btn.addActionListener(this);
        btn_return_book.addActionListener(this);

    }


    public static void main(String[] args) {
        new librarian_page();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btn_return_book){
            new return_book().setVisible(true);
        }

        if(e.getSource()==logout){
            new LoginLibrarian().setVisible(true);
            dispose();
        }

        if(e.getSource()==add_books){
            new add_books().setVisible(true);
            dispose();
        }

        if(e.getSource()==delete_books){
            new delete_book().setVisible(true);
            dispose();
        }

        if(e.getSource()== btn_view_book){
           new ViewBook().setVisible(true);

        }
        if(e.getSource()== issued_books){
            new Issued_Books().setVisible(true);

        }

        if(e.getSource()== issue_book_btn){
            new issue_book<>().setVisible(true);
            dispose();
        }



    }
}
