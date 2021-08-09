import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Role extends JFrame implements ActionListener {
    JLabel lb1,lb2,test,bg,admin;
    JRadioButton rb1, rb2, rb3;
    JButton btn,back;
    JPanel jp;


    public Role(){
        lb1 = new JLabel("CENTRAL LIBRARY");
        test = new JLabel("");
        back = new JButton("");
        lb2 = new JLabel("Select Role");
        rb1 = new JRadioButton("Admin");
        rb2 = new JRadioButton("Librarian");
        rb3 = new JRadioButton("Student");
        btn = new JButton("Next");
        btn.setBorder(null);
        btn.setForeground(Color.white);
        btn.setBackground(Color.black);

        ButtonGroup bgrp = new ButtonGroup();
        bgrp.add(rb1);
        bgrp.add(rb2);
        bgrp.add(rb3);


        jp = new JPanel();

        jp.add(rb1);
        jp.add(rb2);
        jp.add(rb3);
        add(lb1);
        jp.add(lb2);
        jp.add(btn);
        add(jp);
        add(test);
        //add(back);

        lb1.setFont(new Font("Times new roman",Font.BOLD,38));
        lb1.setBounds(265,10,400,100);
        lb1.setForeground(Color.WHITE);

        //ID
        lb2.setFont(new Font("Times new roman",Font.BOLD,34));
        lb2.setBounds(180,55,300,50);

        rb1.setFont(new Font("Times new roman",Font.PLAIN,24));
        rb1.setBounds(70,140,100,40);
        //rb1.setBackground(Color.WHITE);
        rb1.setOpaque(false);

        rb2.setFont(new Font("Times new roman",Font.PLAIN,24));
        rb2.setBounds(190,140,120,40);
        //rb2.setBackground(Color.WHITE);
        rb2.setOpaque(false);

        rb3.setFont(new Font("Times new roman",Font.PLAIN,24));
        rb3.setBounds(330,140,150,40);
        //rb3.setBackground(Color.WHITE);
        rb3.setOpaque(false);

        btn.setFont(new Font("Times new roman",Font.PLAIN,18));
        btn.setBounds(200,230,90,30);

        jp.setBounds(200,120,500,300);


        jp.setVisible(true);
        jp.setLayout(null);
        jp.setBackground(Color.white);
        //jp.setBorder(BorderFactory.createBevelBorder(200));
        btn.addActionListener(this);

        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);

        getContentPane().setBackground(Color.WHITE);
        setTitle("CENTRAL LIBRARY");

        ImageIcon img = new ImageIcon("Icon\\bg21.jpg");
        bg = new JLabel("",img,JLabel.CENTER);
        add(bg);
        bg.setBounds(0,0,900,1000);

        ImageIcon img1 = new ImageIcon("Icon\\library.png");
        admin = new JLabel("",img1,JLabel.CENTER);
        add(admin);
        jp.add(admin);
        admin.setBounds(0,0,500,300);
        admin.setVisible(true);


    }

    public static void main(String[] args) {
        new Role();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(rb1.isSelected()){
            new LoginAdmin().setVisible(true);
            dispose();
        }

        if(rb2.isSelected()){
            new LoginLibrarian().setVisible(true);
            dispose();
        }

        if(rb3.isSelected()){
            new LoginStudent().setVisible(true);
            dispose();
        }
    }
}
