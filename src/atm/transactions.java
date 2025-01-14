package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transactions extends JFrame implements ActionListener {
    JButton deposit,withdraw,ms,be,pc,fastCash,exit;
    String pinNumber;
    transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("Transactions - Page 4");
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,800);
        add(i4);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(185,290,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        i4.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(150,403,100,25);
        deposit.addActionListener(this);
        i4.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(150,433,100,25);
        withdraw.addActionListener(this);
        i4.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(150,463,100,25);
        fastCash.addActionListener(this);
        i4.add(fastCash);

        ms = new JButton("Mini Statement");
        ms.setBounds(330,403,120,25);
        ms.addActionListener(this);
        i4.add(ms);

        pc = new JButton("Pin Change");
        pc.setBounds(350,433,100,25);
        pc.addActionListener(this);
        i4.add(pc);

        be = new JButton("Balance Enquiry");
        be.setBounds(320,463,130,25);
        be.addActionListener(this);
        i4.add(be);

        exit = new JButton("Exit");
        exit.setBounds(380,493,70,25);
        exit.addActionListener(this);
        i4.add(exit);

        setSize(800,800);
        setLocation(350,20);
        //setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new login().setVisible(true);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new deposit(pinNumber).setVisible(true);
        }else if(ae.getSource() == withdraw){
            setVisible(false);
            new withdraw(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new fastCash(pinNumber).setVisible(true);
        }else if(ae.getSource() == pc){
            setVisible(false);
            new pinChange(pinNumber).setVisible(true);
        }else if(ae.getSource() == be){
            setVisible(false);
            new balanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource() == ms){
            setVisible(false);
            new miniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new transactions("");
    }
}
