import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_books extends JFrame implements ActionListener {
    JLabel lb_head,lb_page1,book_id,book_Name,author_name,genre,price , bg;
    JTextField tf1,tf2,tf3,tf4;
    JComboBox cb1;
    JButton add_book,back;
    JPanel panel1;

    public add_books(){
        //labels
        lb_head = new JLabel("CENTRAL LIBRARY");
        lb_page1 = new JLabel("ADD BOOKS");
        book_id = new JLabel( "Book ID :");
        book_Name = new JLabel(" Book Name :");
        author_name = new JLabel("Author Name :");
        price = new JLabel(" Price :");
        genre = new JLabel("Select Genre :");

        //Label Properties
        lb_head.setBounds(270,10,400,40);
        lb_head.setFont(new Font("Times new roman",Font.BOLD,38));
        lb_head.setForeground(Color.white);

        lb_page1.setBounds(380,70,700,40);
        lb_page1.setFont(new Font("Times new roman",Font.BOLD,20));
        lb_page1.setForeground(Color.white);

        book_Name.setBounds(68,30,300,40);
        book_Name.setFont(new Font("Arial",Font.BOLD,18));

        author_name.setBounds(58,60,300,40);
        author_name.setFont(new Font("Arial",Font.BOLD,18));

        book_id.setBounds(106,90,300,40);
        book_id.setFont(new Font("Arial",Font.BOLD,18));

        price.setBounds(125,120,300,40);
        price.setFont(new Font("Arial",Font.BOLD,18));

        genre.setBounds(61,150,300,40);
        genre.setFont(new Font("Arial",Font.BOLD,18));

        //Text Fields
        tf1 = new JTextField(50);
        tf2 = new JTextField(50);
        tf3  = new JTextField(50);
        tf4 = new JTextField(50);
        //Text Fields Properties
        tf1.setBounds(220,38,190,25);
        tf1.setFont(new Font("Arial",Font.BOLD,16));
        tf2.setBounds(220,68,190,25);
        tf2.setFont(new Font("Arial",Font.BOLD,16));
        tf3.setBounds(220,98,190,25);
        tf3.setFont(new Font("Arial",Font.BOLD,16));
        tf4.setBounds(220,128,190,25);
        tf4.setFont(new Font("Arial",Font.BOLD,16));

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setVisible(true);
        panel1.setBounds(200,150,500,300);
        panel1.setBackground(Color.WHITE);


        //Combo box with Properties
        String gen[]={"Literature","Fiction","Economics and Business","Arts and Language","Novel","Reference","CSE","MBA","Civil Engg.","CBSE"};
        cb1 = new JComboBox(gen);
        cb1.setBounds(220,158,190,25);
        cb1.setBackground(Color.white);
        cb1.setForeground(Color.black);
        cb1.setFont(new Font("Arial",Font.BOLD,16));

        //Buttons
        add_book = new JButton("ADD BOOK");
        back = new JButton("BACK");
        //Button Properties
        add_book.setBounds(370,240,100,25);
        add_book.setForeground(Color.white);
        add_book.setBackground(Color.black);
        back.setBounds(30,240,100,25);
        back.setForeground(Color.white);
        back.setBackground(Color.black);

        add(lb_head);
        add(lb_page1);
        panel1.add(book_id);
        panel1.add(book_Name);
        panel1.add(author_name);
        panel1.add(price);
        panel1.add(genre);
        panel1.add(tf1);
        panel1.add(tf2);
        panel1.add(tf3);
        panel1.add(tf4);
        panel1.add(cb1);
        panel1.add(add_book);
        panel1.add(back);
        add(panel1);

        add_book.addActionListener(this);
        back.addActionListener(this);

        setLayout(null);
        setSize(900,600);
        setVisible(true);
        setTitle("ADD BOOKS : CENTRAL LIBRARY");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon img1 = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("", img1, JLabel.CENTER);
        add(bg);
        bg.setBounds(0, 0, 900, 1000);
    }

    public static void main(String[] args) {
        new add_books();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add_book){
            String ID = tf3.getText();
            String Name = tf1.getText();
            String Author = tf2.getText();
            String price = tf4.getText();

            String Genre = cb1.getSelectedItem().toString();

            try {

                if (tf3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {

                    Conn c1 = new Conn();
                    String q1 = "insert into Books values('"+ID+"','"+Name+"','"+Author+"','"+price+"','"+Genre+"')";
                    c1.s.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null, "Book Added Successfully");
                    new add_books().setVisible(true);
                    dispose();
                }

            } catch (Exception ee) {
                ee.printStackTrace();
            }

        }

        if(e.getSource()== back){
            new librarian_page().setVisible(true);
            dispose();
        }


    }
    }

