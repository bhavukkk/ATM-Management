package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class signupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextfield,fnameTextfield,emailTextfield,addTextfield,cityTextfield,stateTextfield,pinTextfield;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser date;
    signupOne(){
        setLayout(null);
        setTitle("Registration Form - PAGE 1");
        getContentPane().setBackground(Color.WHITE);
        Random ran =new Random();
        random = Math.abs((ran.nextLong()% 9000L)+1000L);

        JLabel formno = new JLabel("New Account Registration Form: " + random);
        formno.setFont(new Font("Osward",Font.BOLD,30));
        formno.setForeground(Color.BLUE);
        formno.setBounds(140,20,700,100);
        add(formno);

        JLabel pd = new JLabel("PAGE 1: Personal Details");
        pd.setFont(new Font("Raleway",Font.BOLD,20));
        pd.setBounds(270,80,500,100);
        add(pd);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(200,150,500,100);
        add(name);

        nameTextfield = new JTextField();
        nameTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        nameTextfield.setBounds(350, 185, 300, 30);
        add(nameTextfield);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(200,200,500,100);
        add(fname);

        fnameTextfield = new JTextField();
        fnameTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        fnameTextfield.setBounds(350,235,300,30);
        add(fnameTextfield);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(200,250,500,100);
        add(dob);

        date = new JDateChooser();
        date.setBounds(350,285,200,30);
        date.setForeground(Color.black);
        add(date);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(200,300,500,100);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(350,335,70,30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(500,335,70,30);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(200,350,500,100);
        add(email);

        emailTextfield = new JTextField();
        emailTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        emailTextfield.setBounds(350,385,300,30);
        add(emailTextfield);

        JLabel mar = new JLabel("Marital Status:");
        mar.setFont(new Font("Raleway",Font.BOLD,15));
        mar.setBounds(200,400,500,100);
        add(mar);

        married = new JRadioButton("Married");
        married.setBounds(350,435,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,435,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(570,435,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup marGroup = new ButtonGroup();
        marGroup.add(married);
        marGroup.add(unmarried);
        marGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(200,450,500,100);
        add(address);

        addTextfield = new JTextField();
        addTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        addTextfield.setBounds(350,485,300,30);
        add(addTextfield);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(200,500,500,100);
        add(city);

        cityTextfield = new JTextField();
        cityTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        cityTextfield.setBounds(350,535,300,30);
        add(cityTextfield);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(200,550,500,100);
        add(state);

        stateTextfield = new JTextField();
        stateTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        stateTextfield.setBounds(350,585,300,30);
        add(stateTextfield);

        JLabel pin = new JLabel("PINCODE:");
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(200,600,500,100);
        add(pin);

        pinTextfield = new JTextField();
        pinTextfield.setFont(new Font("Raleway",Font.BOLD,12));
        pinTextfield.setBounds(350,635,300,30);
        add(pinTextfield);

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
        String formno = Long.toString(random);
        String name = nameTextfield.getText();
        String fname = fnameTextfield.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }else {
            gender = "";
        }
        String email = emailTextfield.getText();
        String mar;
        if (married.isSelected()) {
            mar = "Married";
        } else if (unmarried.isSelected()) {
            mar = "Unmarried";
        } else if (other.isSelected()) {
            mar = "Other";
        }else {
            mar = "";
        }
        String address = addTextfield.getText();
        String city = cityTextfield.getText();
        String state = stateTextfield.getText();
        String pin = pinTextfield.getText();

        if(name.equals("")||fname.equals("")||dob.equals("")||gender.equals("")||email.equals("")||mar.equals("")||address.equals("")||city.equals("")||state.equals("")||pin.equals("")) {
            String querry = null;
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required!");
            }
            if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's Name is required!");
            }
            if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required!");
            }
            if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Gender is required!");
            }
            if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is required!");
            }
            if (mar.equals("")) {
                JOptionPane.showMessageDialog(null, "Marital Status is required!");
            }
            if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required!");
            }
            if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is required!");
            }
            if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is required!");
            }
            if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "PIN CODE is required!");
            }
        }else {
            String querry = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','"
                    + gender + "','" + email + "','" + mar + "'," + "'" + address + "','" + city + "','" + state + "','" + pin + "')";
                    conn c = new conn();
            try {
                c.s.executeUpdate(querry);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            setVisible(false);
            new signupTwo(formno).setVisible(true);
        }
        }
        public static void main (String[] args){
            new signupOne();
        }
    }