package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    String pinNumber;
    JTextField amount;
    deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("Deposit - Page 5");
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,800);
        add(i4);

        JLabel text = new JLabel("Please enter the amount you want to deposit");
        text.setBounds(160,290,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        i4.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        amount.setBounds(175,350,250,25);
        add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(350,433,100,25);
        deposit.addActionListener(this);
        i4.add(deposit);

        back = new JButton("Back");
        back.setBounds(350,463,100,25);
        back.addActionListener(this);
        i4.add(back);

        setSize(800,800);
        setLocation(350,20);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            new transactions(pinNumber);
        }else if (ae.getSource() == deposit){
            String am = amount.getText();
            int a = Integer.parseInt(am);
            if(a<500){
                JOptionPane.showMessageDialog(null,"Minimum Rs 500 can be deposited");
                return;
            }
            Random random = new Random();
            String t_ID = "T2404" + String.format("%18d", random.nextLong(1000000000000000000L));
            String utr = "44" + String.format("%10d", random.nextLong(10000000000L));
            Date date = new Date();
            String typeOftransaction = "Deposit";
            if (am.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter some amount");
            }else{
               try {
                   conn c = new conn();
                   String querry = "insert into Accounts values('" +pinNumber+ "','" +date+ "','" +t_ID+ "','" +utr+ "','" +typeOftransaction+ "','" +am+ "')";
                   c.s.executeUpdate(querry);
                   JOptionPane.showMessageDialog(null,"Rs "+am+" deposited successfully");
                   setVisible(false);
                   new transactions(pinNumber).setVisible(true);
               }catch (Exception e){
                   System.out.println(e);
               }
            }
        }
    }
    public static void main(String[] args) {
        new deposit("");
    }
}
