package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

public class fastCash extends JFrame implements ActionListener {
    JButton deposit, five,two, ten, fivet, one, back;
    String pinNumber;
    fastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("FastCash - Page 7");
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,800);
        add(i4);

        JLabel text = new JLabel("Select the Withdrawal Amount");
        text.setBounds(185,290,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        i4.add(text);

        five = new JButton("Rs 5000");
        five.setBounds(150,433,100,25);
        five.addActionListener(this);
        i4.add(five);

        one = new JButton("Rs 10000");
        one.setBounds(150,463,100,25);
        one.addActionListener(this);
        i4.add(one);

        two = new JButton("Rs 500");
        two.setBounds(350,403,100,25);
        two.addActionListener(this);
        i4.add(two);

        fivet = new JButton("Rs 1000");
        fivet.setBounds(350,433,100,25);
        fivet.addActionListener(this);
        i4.add(fivet);

        ten = new JButton("Rs 2000");
        ten.setBounds(350,463,100,25);
        ten.addActionListener(this);
        i4.add(ten);

        back = new JButton("Back");
        back.setBounds(380,493,70,25);
        back.addActionListener(this);
        i4.add(back);

        setSize(800,800);
        setLocation(350,20);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
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
                if(ae.getSource()!=back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Random random = new Random();
                String t_ID = "T2404" + String.format("%18d", random.nextLong(1000000000000000000L));
                String utr = "44" + String.format("%10d", random.nextLong(10000000000L));
                Date date = new Date();
                String  typeOftransaction = "Withdraw";
                String query = "insert into Accounts values('" +pinNumber+ "','" +date+ "','" +t_ID+ "','" +utr+ "','" +typeOftransaction+ "','" +amount+ "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited successfully");
                setVisible(false);
                new transactions(pinNumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new fastCash("");
    }
}
