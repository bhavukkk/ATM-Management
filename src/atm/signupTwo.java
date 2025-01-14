package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signupTwo extends JFrame implements ActionListener {
    JTextField panTextfield,aadharTextfield;
    JComboBox religionbox,incomebox,categorybox,edubox,ocubox;
    JButton next;
    JRadioButton yes,no,yes1,no1;
    String formno;
    signupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Registration Form - PAGE 2");
        getContentPane().setBackground(Color.WHITE);

        JLabel ad = new JLabel("PAGE 2: Additional Details");
        ad.setFont(new Font("Raleway",Font.BOLD,30));
        ad.setBounds(270,50,500,100);
        add(ad);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,15));
        religion.setBounds(200,150,500,100);
        add(religion);

        String valreligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionbox = new JComboBox<>(valreligion);
        religionbox.setBounds(350,185,300,30);
        religionbox.setBackground(Color.WHITE);
        add(religionbox);

        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway",Font.BOLD,15));
        category.setBounds(200,200,500,100);
        add(category);

        String valcategory[] = {"General","OBC","SC/ST","Other"};
        categorybox = new JComboBox<>(valcategory);
        categorybox.setBounds(350,235,300,30);
        categorybox.setBackground(Color.WHITE);
        add(categorybox);

        JLabel income = new JLabel("Annual Income:");
        income.setFont(new Font("Raleway",Font.BOLD,15));
        income.setBounds(200,250,500,100);
        add(income);

        String valincome[] = {"Null","<1,00,000","<2,50,000","<5,00,000","Upto 10 Lakh"};
        incomebox = new JComboBox<>(valincome);
        incomebox.setBounds(350,285,300,30);
        incomebox.setBackground(Color.WHITE);
        add(incomebox);

        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway",Font.BOLD,15));
        education.setBounds(200,300,500,100);
        add(education);

        String valedu[] = {"Null","Matric Pass","12th Pass","UG","PG"};
        edubox = new JComboBox<>(valedu);
        edubox.setBounds(350,335,300,30);
        edubox.setBackground(Color.WHITE);
        add(edubox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,15));
        occupation.setBounds(200,350,500,100);
        add(occupation);

        String valocu[] = {"Salaried","Business","Retired","Home-Maker","Self-Employed","Others"};
        ocubox = new JComboBox<>(valocu);
        ocubox.setBounds(350,385,300,30);
        ocubox.setBackground(Color.WHITE);
        add(ocubox);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(200,400,500,100);
        add(pan);

        panTextfield = new JTextField();
        panTextfield.setBounds(350,435,300,30);
        panTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        add(panTextfield);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,15));
        aadhar.setBounds(200,450,500,100);
        add(aadhar);

        aadharTextfield = new JTextField();
        aadharTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        aadharTextfield.setBounds(350,485,300,30);
        add(aadharTextfield);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,15));
        senior.setBounds(200,500,500,100);
        add(senior);

        yes = new JRadioButton("YES");
        yes.setBounds(350,535,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("NO");
        no.setBounds(500,535,100,30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup group = new ButtonGroup();
        group.add(yes);
        group.add(no);

        JLabel exist = new JLabel("Existing Account:");
        exist.setFont(new Font("Raleway",Font.BOLD,15));
        exist.setBounds(200,550,500,100);
        add(exist);

        yes1 = new JRadioButton("YES");
        yes1.setBounds(350,585,100,30);
        yes1.setBackground(Color.WHITE);
        add(yes1);

        no1 = new JRadioButton("NO");
        no1.setBounds(500,585,100,30);
        no1.setBackground(Color.WHITE);
        add(no1);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(yes1);
        group1.add(no1);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(550,700,100,30);
        next.addActionListener(this);
        add(next);

        setSize(800, 800);
        setVisible(true);
        setLocation(350,20);
    }
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionbox.getSelectedItem();
        String category = (String) categorybox.getSelectedItem();
        String income = (String) incomebox.getSelectedItem();
        String education = (String) edubox.getSelectedItem();
        String occupation = (String) ocubox.getSelectedItem();
        String pan = panTextfield.getText();
        String aadhar = aadharTextfield.getText();

        String senior;
        if (yes.isSelected()) {
            senior = "YES";
        } else if (no.isSelected()) {
            senior = "NO";
        } else {
            senior = "";
        }
        String exist;
        if (yes1.isSelected()) {
            exist = "YES";
        } else if (no1.isSelected()) {
            exist = "NO";
        } else {
            exist = "";
        }
        if(pan.equals("")||aadhar.equals("")||senior.equals("")||exist.equals("")){
            String querry = null;
            if(pan.equals("")){
                JOptionPane.showMessageDialog(null,"PAN Number is required!");
            }
            if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Number is required!");
            }
            if(senior.equals("")){
                JOptionPane.showMessageDialog(null,"Senior Citizen field needs to be filled!");
            }
            if(exist.equals("")){
                JOptionPane.showMessageDialog(null,"Existing Account field needs to be filled!");
            }
        }else {
            String querry = "insert into signuptwo values('" + formno + "','" +religion+ "','" +category+ "','" +income+ "','" +education+ "','" +occupation+ "','" +pan+ "','" +aadhar+ "','" +senior+ "','" +exist+ "')";
            conn c = new conn();
            try {
                c.s.executeUpdate(querry);
            } catch (Exception e) {
                System.out.println(e);
            }
            setVisible(false);
            new signupThree(formno).setVisible(true);
        }
    }
    public static void main (String[] args){
        new signupTwo("");
    }
}