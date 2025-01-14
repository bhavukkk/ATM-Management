package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class sc extends JFrame implements ActionListener {
    JButton signin,clear,register;
    JTextField cardTextField;
    JPasswordField pinTextField;
    sc(){
        setTitle("Automated Teller Machine");
        setLayout(null);

        //Adding ATM icon
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

        //Adding Welcome Message
        JLabel welcome = new JLabel("TUTE-IT-UP");
        welcome.setFont(new Font("Times New Roman",Font.BOLD,38));
        welcome.setBounds(330,20,400,100);
        welcome.setForeground(Color.BLACK);
        i7.add(welcome);

        JLabel cardno = new JLabel("Username");
        cardno.setFont(new Font("Times New Roman",Font.BOLD,20));
        cardno.setBounds(250,130,400,100);
        cardno.setForeground(Color.BLACK);
        i7.add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(370,170,200,23);
        i7.add(cardTextField);

        JLabel pin = new JLabel("Password:");
        pin.setFont(new Font("Times New Roman",Font.BOLD,20));
        pin.setBounds(250,200,400,100);
        pin.setForeground(Color.BLACK);
        i7.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(370,240,200,23);
        i7.add(pinTextField);

        signin = new JButton("SIGN IN");
        signin.setBounds(250,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        i7.add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(470,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        i7.add(clear);

        register = new JButton("REGISTER");
        register.setBounds(360,360,100,33);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        i7.add(register);

        getContentPane().setBackground(Color.CYAN);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == signin){
            conn c = new conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '" +pinNumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"You Have Successfully Logged In!");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == register){
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new sc();
    }
}
