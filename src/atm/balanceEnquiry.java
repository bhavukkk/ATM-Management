package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    balanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("Balance Enquiry - Page 9");
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,800);
        add(i4);

        back = new JButton("Back");
        back.setBounds(350,463,100,25);
        back.addActionListener(this);
        i4.add(back);

        conn c = new conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from Accounts where pinNumber = '"+pinNumber+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("typeOftransaction").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            JLabel text = new JLabel("Your Current Balance is Rs "+ balance);
            text.setFont(new Font("Raleway",Font.BOLD,17));
            text.setBounds(170,320,300,50);
            text.setForeground(Color.WHITE);
            i4.add(text);

        } catch(Exception e){
            System.out.println(e);
            }

        setSize(800,800);
        setLocation(350,20);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
