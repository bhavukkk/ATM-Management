package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class miniStatement extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    miniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/bg1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel i7 = new JLabel(i6);
        i7.setBounds(0,0,800,480);
        add(i7);

        JLabel l1 = new JLabel("Swiss Bank");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Raleway" , Font.BOLD,13));
        l1.setBounds(280,20,100,20);
        i7.add(l1);

        JLabel card = new JLabel();
        card.setBounds(30,70,300,30);
        i7.add(card);

        JLabel mini = new JLabel();
        mini.setBounds(30,100,650,200);
        i7.add(mini);

        back = new JButton("Back");
        back.setBounds(550,400,70,25);
        back.addActionListener(this);
        i7.add(back);


        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                card.setText("Card Number:       XXXXXXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from Accounts where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("t_ID") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("utr") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("typeOftransaction") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        setSize(650,500);
        setLocation(450,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            new transactions(pinNumber);
        }
    }
    public static void main(String[] args) {
        new miniStatement("");
    }
}
