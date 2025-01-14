package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class signupThree extends JFrame implements ActionListener {
    JRadioButton saving,current,fixed,recur;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    signupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("Account Details - Page 3");
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("PAGE 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,30));
        l1.setBounds(200,50,500,100);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD,20));
        type.setBounds(150,130,500,100);
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(150,200,200,40);
        saving.setBackground(Color.WHITE);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setBounds(150,230,200,40);
        current.setBackground(Color.WHITE);
        add(current);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(400,200,300,40);
        fixed.setBackground(Color.WHITE);
        add(fixed);

        recur = new JRadioButton("Recurring Deposit Account");
        recur.setBounds(400,230,300,40);
        recur.setBackground(Color.WHITE);
        add(recur);

        ButtonGroup group = new ButtonGroup();
        group.add(saving);
        group.add(current);
        group.add(fixed);
        group.add(recur);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(150,300,200,30);
        add(card);

        JLabel num = new JLabel("XXXX-XXXX-XXXX-4146");
        num.setFont(new Font("Raleway",Font.BOLD,20));
        num.setBounds(400,300,300,30);
        add(num);

        JLabel msg1 = new JLabel("(Your 16 digit card number)");
        msg1.setFont(new Font("Raleway",Font.PLAIN,12));
        msg1.setBounds(150,320,300,20);
        add(msg1);

        JLabel msg2 = new JLabel("(It would appear on your ATM card/Cheques and statements)");
        msg2.setFont(new Font("Raleway",Font.PLAIN,12));
        msg2.setBounds(360,320,350,20);
        add(msg2);

        JLabel pin = new JLabel("PIN Number:");
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        pin.setBounds(150,350,200,30);
        add(pin);

        JLabel msg3 = new JLabel("(4 digit password)");
        msg3.setFont(new Font("Raleway",Font.PLAIN,12));
        msg3.setBounds(160,370,300,20);
        add(msg3);

        JLabel number2 = new JLabel("XXXX");
        number2.setFont(new Font("Raleway", Font.BOLD,20));
        number2.setBounds(400,350,200,30);
        add(number2);

        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD,20));
        service.setBounds(150,420,300,40);
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD,15));
        c1.setBounds(150,450,250,40);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD,15));
        c2.setBounds(150,480,250,40);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD,15));
        c3.setBounds(150,510,250,40);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("E-Mail Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD,15));
        c4.setBounds(400,450,300,40);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD,15));
        c5.setBounds(400,480,300,40);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD,15));
        c6.setBounds(400,510,300,40);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD,13));
        c7.setBounds(120,600,600,40);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBounds(150,680,100,40);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(500,680,100,40);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(800,800);
        setVisible(true);
        setLocation(350,20);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(saving.isSelected()){
                accountType = "Savings Account";
            } else if (current.isSelected()) {
                accountType = "Current Account";
            }else if(fixed.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(recur.isSelected()){
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + (5040936000000000L + Math.abs(random.nextLong() % 90000000L));
            String pinNumber =  String.format("%04d", random.nextInt(10000));//Math.abs(random.nextLong() % 9000L + 1000L);
            String facility = "";
            if(c1.isSelected()){
                facility += " ATM Card";
            }if (c2.isSelected()) {
                facility += " Internet Banking";
            }if (c3.isSelected()) {
                facility += " Mobile Banking";
            }if (c4.isSelected()) {
                facility += " E-Mail Alerts";
            }if (c5.isSelected()) {
                facility += " Cheque Books";
            }if (c6.isSelected()) {
                facility += " E-Statement";
            }

            if(accountType.equals("")||facility.equals("")){
                String querry = null;
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required!");
                }
                if(facility.equals("")){
                    JOptionPane.showMessageDialog(null,"Facilities are required!");
                }
            }else {
                String querry = "insert into signupthree values('" +formno+ "','" +accountType+ "','" +cardNumber+ "','" +pinNumber+ "','" +facility+ "')";
                String querry1 = "insert into login values('" +formno+ "','" +cardNumber+ "','" +pinNumber+ "')";
                conn c = new conn();
                try {
                    c.s.executeUpdate(querry);
                    c.s.executeUpdate(querry1);
                    JOptionPane.showMessageDialog(null,"Card Number: " + cardNumber + "\n Pin: " + pinNumber);
                    setVisible(false);
                    new deposit(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new signupThree("");
    }
}