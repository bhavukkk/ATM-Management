package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {
    JPasswordField currentpin, pinTextField,repinTextField;;
    String pinNumber;
    JButton change,back;
    pinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("Pin Change - Page 8");
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,800);
        add(i4);

        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(230,280,200,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        i4.add(text);

        JLabel currentpintext = new JLabel("Current PIN");
        currentpintext.setBounds(160,340,200,35);
        currentpintext.setForeground(Color.WHITE);
        currentpintext.setFont(new Font("System",Font.BOLD,14));
        i4.add(currentpintext);

        currentpin = new JPasswordField();
        currentpin.setBounds(350,340,100,23);
        i4.add(currentpin);

        JLabel pintext = new JLabel("New PIN");
        pintext.setBounds(160,380,200,35);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,14));
        i4.add(pintext);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(350,380,100,23);
        i4.add(pinTextField);

        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setBounds(160,420,200,35);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,14));
        i4.add(repintext);

        repinTextField = new JPasswordField();
        repinTextField.setBounds(350,420,100,23);
        i4.add(repinTextField);

        change = new JButton("Change");
        change.setBounds(350,463,100,25);
        change.addActionListener(this);
        i4.add(change);

        back = new JButton("Back");
        back.setBounds(350,493,100,25);
        back.addActionListener(this);
        i4.add(back);

        setSize(800,800);
        setLocation(350,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try {
                String current = currentpin.getText();
                String pin = pinTextField.getText();
                String rpin = repinTextField.getText();
                if(current.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter current PIN");
                    return;
                }
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                if(!pin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN match does not match");
                    return;
                }
                conn c = new conn();
                String query = "update Accounts set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
                String query1 = "update login set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
                String query2 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";

                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new login().setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == back) {
            setVisible(false);
            new transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinChange("");
    }
}
