package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class sc1 extends JFrame implements ActionListener {
    JButton signin,clear,register;
    JTextField cardTextField;
    JPasswordField pinTextField;
    sc1(){
        setTitle("Automated Teller Machine");
        setLayout(null);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bg1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel i7 = new JLabel(i6);
        i7.setBounds(0,0,800,480);
        add(i7);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setLayout(null);
        label.setBounds(200,20,100,100);
        i7.add(label);

        JLabel welcome = new JLabel("TUTE-IT-UP");
        welcome.setFont(new Font("Times New Roman",Font.BOLD,38));
        welcome.setBounds(330,20,400,100);
        welcome.setForeground(Color.BLACK);
        i7.add(welcome);

        signin = new JButton("SIGN IN");
        signin.setBounds(350,150,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        i7.add(signin);

        getContentPane().setBackground(Color.CYAN);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == signin){
            JOptionPane.showMessageDialog(null,"You Payment has been successfully done.\nThank You! Have a great day!");
        }
    }
    public static void main(String[] args) {
        new sc1();
    }
}
