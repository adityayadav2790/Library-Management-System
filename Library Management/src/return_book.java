import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class return_book<issue_lb> extends JFrame implements ActionListener {
    JLabel lb_head,lb_page1,book_id,book_Name,author_name,price,genre,book_details_lbl ,return_lb  , bg; // PANEL 1
    JLabel lb_name,lb_father,lb_ID,lb_course,lb_branch,lb_year,lb_sem , lb_stu_head; // PANEL 2
    JTextField book_id_tf1,book_name_tf2,author_tf,price_tf,genre_tf;   // PANEL 1
    JTextField name_tf,father_tf,id_tf,course_tf,branch_tf,year_tf,sem_tf  , issue_date_tf;  // PANEL 2
    JButton return_btn,back,search_book_btn,search_student_btn,clr_book,clr_student  , date_btn;
    JPanel panel1,panel2;


    public return_book(){
        //Labels
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("RETURN BOOKS");
        return_lb = new JLabel("RETURN DATE");
        // label panel 1
        book_details_lbl = new JLabel("  Book Details  ");
        book_id = new JLabel("Book ID :");
        book_Name = new JLabel("Book Name :");
        author_name = new JLabel("Author Name :");
        price = new JLabel("Price :");
        genre = new JLabel("Genre :");

        panel1 = new JPanel();

        //Label properties
        lb_head.setBounds(290,20,400,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,30));
        lb_head.setForeground(Color.white);
        lb_head.setBackground(Color.black);

        lb_page1.setBounds(370,80,700,40);
        lb_page1.setFont(new Font("Times new roman",Font.BOLD,20));
        lb_page1.setForeground(Color.white);
        lb_page1.setBackground(Color.black);

        return_lb.setBounds(280,500,400,30);
        return_lb.setFont(new Font("Arial",Font.BOLD,16));


        // panel 1 Properties
        book_details_lbl.setBounds(110,0,400,40);
        book_details_lbl.setFont(new Font("Arial",Font.BOLD,16));

        book_id.setBounds(70,50,300,40);
        book_id.setFont(new Font("Arial",Font.BOLD,16));

        book_Name.setBounds(42,80,300,40);
        book_Name.setFont(new Font("Arial",Font.BOLD,16));

        author_name.setBounds(30,110,300,40);
        author_name.setFont(new Font("Arial",Font.BOLD,16));

        price.setBounds(90,140,300,40);
        price.setFont(new Font("Arial",Font.BOLD,16));

        genre.setBounds(80,170,300,40);
        genre.setFont(new Font("Arial",Font.BOLD,16));

        //Text Fields Panel 1
        book_id_tf1 = new JTextField(70);
        book_name_tf2 = new JTextField(70);
        author_tf = new JTextField(70);
        price_tf = new JTextField(70);
        genre_tf = new JTextField(70);
        issue_date_tf = new JTextField(70);

        //Text Fields Properties panel 1
        book_id_tf1.setBounds(160,60,100,20);
        book_id_tf1.setFont(new Font("Arial",Font.BOLD,16));

        book_name_tf2.setBounds(160,90,130,20);
        book_name_tf2.setFont(new Font("Arial",Font.BOLD,16));
        book_name_tf2.setEditable(false);

        author_tf.setBounds(160,120,130,20);
        author_tf.setFont(new Font("Arial",Font.BOLD,16));
        author_tf.setEditable(false);

        price_tf.setBounds(160,150,130,20);
        price_tf.setFont(new Font("Arial",Font.BOLD,16));
        price_tf.setEditable(false);

        genre_tf.setBounds(160,180,130,20);
        genre_tf.setFont(new Font("Arial",Font.BOLD,16));
        genre_tf.setEditable(false);

        issue_date_tf.setBounds(410,505,130,20);
        issue_date_tf.setFont(new Font("Arial",Font.BOLD,16));
        issue_date_tf.setEditable(false);

        //PANEL 2
        //Labels
        panel2 = new JPanel();
        lb_ID = new JLabel("Student Id :");
        lb_name = new JLabel("Name :");
        lb_father = new JLabel("Father's Name :");
        lb_course = new JLabel("Course :");
        lb_branch = new JLabel("Branch :");
        lb_year = new JLabel("Year :");
        lb_sem = new JLabel("Semester :");
        lb_stu_head = new JLabel("Student Details");

        // Label Properties panel 2
        lb_ID.setBounds(50,50,300,40);
        lb_ID.setFont(new Font("Arial",Font.BOLD,16));

        lb_name.setBounds(85,80,300,40);
        lb_name.setFont(new Font("Arial",Font.BOLD,16));

        lb_stu_head.setBounds(130,0,400,40);
        lb_stu_head.setFont(new Font("Arial",Font.BOLD,16));

        lb_father.setBounds(20,110,300,40);
        lb_father.setFont(new Font("Arial",Font.BOLD,16));

        lb_course.setBounds(75,140,300,40);
        lb_course.setFont(new Font("Arial",Font.BOLD,16));

        lb_branch.setBounds(75,170,300,40);
        lb_branch.setFont(new Font("Arial",Font.BOLD,16));

        lb_year.setBounds(95,200,300,40);
        lb_year.setFont(new Font("Arial",Font.BOLD,16));

        lb_sem.setBounds(59,230,300,40);
        lb_sem.setFont(new Font("Arial",Font.BOLD,16));

        // Text Fields panel 2
        id_tf = new JTextField(30);
        name_tf = new JTextField(30);
        father_tf = new JTextField(30);
        course_tf = new JTextField(30);
        branch_tf = new JTextField(30);
        year_tf = new JTextField(30);
        sem_tf = new JTextField(30);
        // Text fields properties panel 2
        id_tf.setBounds(150,60,100,20);
        id_tf.setFont(new Font("Arial",Font.BOLD,14));

        name_tf.setBounds(150,90,150,20);
        name_tf.setFont(new Font("Arial",Font.BOLD,14));
        name_tf.setEditable(false);

        father_tf.setBounds(150,120,150,20);
        father_tf.setFont(new Font("Arial",Font.BOLD,14));
        father_tf.setEditable(false);

        course_tf.setBounds(150,150,150,20);
        course_tf.setFont(new Font("Arial",Font.BOLD,14));
        course_tf.setEditable(false);

        branch_tf.setBounds(150,180,150,20);
        branch_tf.setFont(new Font("Arial",Font.BOLD,14));
        branch_tf.setEditable(false);

        year_tf.setBounds(150,210,150,20);
        year_tf.setFont(new Font("Arial",Font.BOLD,14));
        year_tf.setEditable(false);

        sem_tf.setBounds(150,240,150,20);
        sem_tf.setFont(new Font("Arial",Font.BOLD,14));
        sem_tf.setEditable(false);


        add(panel2);
        panel2.setLayout(null);
        panel2.setVisible(true);
        panel2.setBounds(500,150,350,320);

        // button panel 2 wit properties
        search_student_btn = new JButton("SEARCH");
        search_student_btn.setBounds(260,60,80,18);
        search_student_btn.setFont(new Font("Arial",Font.BOLD,9));
        search_student_btn.setForeground(Color.white);
        search_student_btn.setBackground(Color.black);

        clr_student = new JButton("CLEAR");
        clr_student.setBackground(Color.black);
        clr_student.setForeground(Color.white);
        clr_student.setBounds(140,280,80,20);
        //  clr_student.setFont(new Font("Arial",Font.BOLD,10));


        panel2.add(lb_ID);
        panel2.add(lb_name);
        panel2.add(lb_father);
        panel2.add(lb_course);
        panel2.add(lb_branch);
        panel2.add(lb_year);
        panel2.add(lb_sem);
        panel2.add(id_tf);
        panel2.add(name_tf);
        panel2.add(father_tf);
        panel2.add(course_tf);
        panel2.add(branch_tf);
        panel2.add(year_tf);
        panel2.add(sem_tf);
        panel2.add(search_student_btn);
        panel2.add(clr_student);
        panel2.add(lb_stu_head);

        //Buttons panel 1
        return_btn = new JButton("RETURN");
        back = new JButton("BACK");
        search_book_btn = new JButton("SEARCH");
        date_btn = new JButton("DATE");

        clr_book = new JButton("CLEAR");

        //Button Properties panel 1
        return_btn.setBounds(400,530,110,20);
        return_btn.setForeground(Color.white);
        return_btn.setBackground(Color.black);

        back.setBounds(80,500,100,30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);

        search_book_btn.setBounds(265,60,80,18);
        search_book_btn.setFont(new Font("Arial",Font.BOLD,9));
        search_book_btn.setForeground(Color.white);
        search_book_btn.setBackground(Color.black);

        clr_book.setBounds(140,280,80,20);

        clr_book.setForeground(Color.white);
        clr_book.setBackground(Color.black);

        add(lb_head);
        add(lb_page1);
        add(panel1);
        panel1.setVisible(true);
        panel1.setBounds(40,150,350,320);
        panel1.setLayout(null);

        panel1.add(book_Name);
        panel1.add(book_id);
        panel1.add(genre_tf);
        panel1.add(book_id_tf1);
        panel1.add(book_name_tf2);
        panel1.add(price_tf);
        panel1.add(author_tf);
        panel1.add(book_Name);
        panel1.add(author_name);
        panel1.add(price);
        panel1.add(genre);
        panel1.add(book_details_lbl);
        panel1.add(search_book_btn);
        panel1.add(clr_book);
        add(issue_date_tf);
        add(date_btn);

        add(return_btn);
        add(back);
        add(return_lb);
        ImageIcon img1 = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("", img1, JLabel.CENTER);
        add(bg);
        bg.setBounds(0, 0, 900, 1000);


        String DateFormat="yyyy/MM/dd";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DateFormat);
        String date = format.format(cal.getTime());

        issue_date_tf.setText(date);
        issue_date_tf.setEditable(false);

        search_student_btn.addActionListener(this);
        date_btn.addActionListener(this);
        search_book_btn.addActionListener(this);
        return_btn.addActionListener(this);
        back.addActionListener(this);
        clr_student.addActionListener(this);
        clr_book.addActionListener(this);

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("RETURN BOOKS : CENTRAL LIBRARY");
        getContentPane().setBackground(Color.WHITE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        setSize(900,600);

    }

    public static void main(String[] args) {
        new return_book();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==back){
            new librarian_page().setVisible(true);
            dispose();
        }

        if(e.getSource()==return_btn){
            try {
                int id = Integer.parseInt(book_id_tf1.getText());
                String BookName = book_name_tf2.getText();
                int sid = Integer.parseInt(id_tf.getText());
                String sName = name_tf.getText();
                String rdate = issue_date_tf.getText();

                Conn c1 = new Conn();
                String q1 = "Delete from issuebook where Book_ID="+id+" and Student_ID ="+sid+"";
                c1.s.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"Book Returned Successfully");

            }
            catch(Exception aq){
                System.out.println(aq);
                JOptionPane.showMessageDialog(null,"No such Book is Issued!!");
            }


        }

        if(e.getSource()==search_student_btn){
            try {
                int id = Integer.parseInt(id_tf.getText());

                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1", "root", "123");

                String q1 = "select Name,FatherName,Course,Branch,Year,Semester from StudentDetails where Student_ID = ?";

                ps = con.prepareStatement(q1);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    name_tf.setText(rs.getString("Name"));
                    father_tf.setText(rs.getString("FatherName"));
                    course_tf.setText(rs.getString("Course"));
                    branch_tf.setText(rs.getString("Branch"));
                    year_tf.setText(rs.getString("Year"));
                    sem_tf.setText(rs.getString("Semester"));
                }

                else{
                    JOptionPane.showMessageDialog(null,"No such Student!!");
                    name_tf.setText("");
                    father_tf.setText("");
                    course_tf.setText("");
                    branch_tf.setText("");
                    year_tf.setText("");
                    sem_tf.setText("");
                }
            }
            catch(Exception aq){
                System.out.println(aq);
            }


        }

        if(e.getSource()==clr_book){
            book_name_tf2.setText("");
            author_tf.setText("");
            price_tf.setText("");
            genre_tf.setText("");
            book_id_tf1.setText("");
        }

        if(e.getSource()==clr_student){
            name_tf.setText("");
            father_tf.setText("");
            id_tf.setText("");
            course_tf.setText("");
            branch_tf.setText("");
            year_tf.setText("");
            sem_tf.setText("");
        }


        if(e.getSource()==search_book_btn){
            try {
                int id = Integer.parseInt(book_id_tf1.getText());

                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/library?characterEncoding=latin1", "root", "123");

                String q1 = "select Book_Name,Author,Price,Genre from Books where Book_ID = ?";

                ps = con.prepareStatement(q1);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    book_name_tf2.setText(rs.getString("Book_Name"));
                    author_tf.setText(rs.getString("Author"));
                    price_tf.setText(rs.getString("Price"));
                    genre_tf.setText(rs.getString("Genre"));
                }

                else{
                    JOptionPane.showMessageDialog(null,"No such Book!!");
                    book_name_tf2.setText("");
                    author_tf.setText("");
                    price_tf.setText("");
                    genre_tf.setText("");
                }
            }
            catch(Exception aq){
                System.out.println(aq);

            }


        }
    }
}

