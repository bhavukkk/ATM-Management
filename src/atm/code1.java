//package tuition;
package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class code1 extends JFrame implements ActionListener {
    String passing,book_id,s_name,p_name,mob,s_email,s_grade,sc_name,s_address,s_state,t_id,card_no,cvv,upi;
    JTextField pay;
    JButton submit;
    code1(String username,String b_id,String name,String pa_name,String mob_no,String st_email,String st_grade,String sc_name,String st_address,String st_state,String t_id,String card_num,String cvv,String upi){
        this.passing = username;
        this.book_id = b_id;
        this.s_name = name;
        this.p_name = pa_name;
        this.mob = mob_no;
        this.s_email = st_email;
        this.s_grade = st_grade;
        this.sc_name = sc_name;
        this.s_address = st_address;
        this.s_state = st_state;
        this.t_id = t_id;
        this.card_no = card_num;
        this.cvv = cvv;
        this.upi = upi;

        setTitle("Payment Page - 2");
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/education_bg4.jpg"));
        Image i1 = i.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,700,700);
        add(i3);

        JLabel head = new JLabel("Please submit to proceed your transaction");
        head.setForeground(Color.black);
        head.setFont(new Font("Arial",Font.BOLD,16));
        head.setBounds(185,200,400,50);
        i3.add(head);

        JLabel pay1 = new JLabel("Amount to be paid:");
        pay1.setForeground(Color.black);
        pay1.setFont(new Font("Arial",Font.BOLD,18));
        pay1.setBounds(210,270,200,50);
        i3.add(pay1);

        pay = new JTextField();
        pay.setFocusable(false);
        pay.setText("₹99");
        pay.setFont(new Font("Arial",Font.PLAIN,18));
        pay.setBounds(400,280,70,30);
        i3.add(pay);

        submit = new JButton("Submit");
        submit.setBounds(290,415,100,30);
        submit.setFocusPainted(false);
        float hue = 0.05f;        // Hue for brown (between 0 and 1)
        float saturation = 0.65f; // Saturation level (between 0 and 1)
        float brightness = 0.55f; // Brightness level (between 0 and 1)
        int rgb = Color.HSBtoRGB(hue, saturation, brightness);
        submit.setBackground(new Color(rgb));
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        i3.add(submit);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(700,700));
        i3.add(panel);

        JLabel upper = new JLabel();
        upper.setBackground(Color.orange);
        upper.setOpaque(true);
        upper.setBounds(145,180,400,300);
        i3.add(upper);

        setSize(700,700);
        setVisible(true);
        setLocation(400,50);
        SwingUtilities.invokeLater(() -> {
            panel.requestFocusInWindow();  // Set focus on panel instead of the text field
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        if(ae.getSource() == submit){
//            conn c = new conn();
//            String query = "insert into bookingtutor values('" + book_id + "','" + s_name + "','" + p_name + "','" + mob + "','" + s_email + "','" + s_grade + "','" + sc_name + "','" + s_address + "','" + s_state + "','" + t_id + "','" + card_no + "','" + cvv + "','" + upi + "')";
//            JOptionPane.showMessageDialog(null,"<html>Your booking has been confirmed<br>Your Booking ID:" +book_id+ "<br><br>Please note it or take a screenshot for further reference.</html>");
//            new home_page(passing).setVisible(true);
//            try {
//                c.s.executeQuery(query);
//            } catch (SQLException se) {
//                System.out.println(se);
//            }
//        }
    }
//    public static void main(String[] args) {
//        new payment2("","","","","","","","","","","","","","");
//    }
//
 }

