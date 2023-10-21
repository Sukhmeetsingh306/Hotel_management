package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Receptions extends JFrame implements ActionListener {
 
    JButton tcustomer, troomm, tdep, temp, tcsi, tmai, tser, tupr, tups, tpic, tcho, tlog ;
    
    Receptions() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout (null);
        
        tcustomer = new JButton("New Customer Form");
        tcustomer.setBounds(10, 30, 200, 30);
        tcustomer.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tcustomer.setBackground(Color.WHITE);
        tcustomer.setForeground(Color.BLACK);
        tcustomer.addActionListener(this);
        add(tcustomer);
        
        troomm = new JButton("Rooms");
        troomm.setBounds(10, 70, 200, 30);
        troomm.setFont(new Font("Tohoma", Font.PLAIN, 14));
        troomm.setBackground(Color.WHITE);
        troomm.setForeground(Color.BLACK);
        troomm.addActionListener(this);
        add(troomm);
        
        tdep = new JButton("Department");
        tdep.setBounds(10, 110, 200, 30);
        tdep.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tdep.setBackground(Color.WHITE);
        tdep.setForeground(Color.BLACK);
        tdep.addActionListener(this);
        add(tdep);
        
        temp = new JButton("All Employees");
        temp.setBounds(10, 150, 200, 30);
        temp.setFont(new Font("Tohoma", Font.PLAIN, 14));
        temp.setBackground(Color.WHITE);
        temp.setForeground(Color.BLACK);
        temp.addActionListener(this);
        add(temp);
        
        tcsi = new JButton("Customer Info");
        tcsi.setBounds(10, 190, 200, 30);
        tcsi.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tcsi.setBackground(Color.WHITE);
        tcsi.setForeground(Color.BLACK);
        tcsi.addActionListener(this);
        add(tcsi);
        
        tmai = new JButton("Manager Info");
        tmai.setBounds(10, 230, 200, 30);
        tmai.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tmai.setBackground(Color.WHITE);
        tmai.setForeground(Color.BLACK);
        tmai.addActionListener(this);
        add(tmai);
        
        tcho = new JButton("Checkout");
        tcho.setBounds(10, 270, 200, 30);
        tcho.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tcho.setBackground(Color.WHITE);
        tcho.setForeground(Color.BLACK);
        tcho.addActionListener(this);
        add(tcho);
        
        tups = new JButton("Update Status");
        tups.setBounds(10, 310, 200, 30);
        tups.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tups.setBackground(Color.WHITE);
        tups.setForeground(Color.BLACK);
        tups.addActionListener(this);
        add(tups);
        
        tupr = new JButton("Update Room Status");
        tupr.setBounds(10, 350, 200, 30);
        tupr.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tupr.setBackground(Color.WHITE);
        tupr.setForeground(Color.BLACK);
        tupr.addActionListener(this);
        add(tupr);
        
        tpic = new JButton("Pickup Service");
        tpic.setBounds(10, 390, 200, 30);
        tpic.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tpic.setBackground(Color.WHITE);
        tpic.setForeground(Color.BLACK);
        tpic.addActionListener(this);
        add(tpic);
        
        tser = new JButton("Search Room");
        tser.setBounds(10, 430, 200, 30);
        tser.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tser.setBackground(Color.WHITE);
        tser.setForeground(Color.BLACK);
        tser.addActionListener(this);
        add(tser);
        
        tlog = new JButton("Logout");
        tlog.setBounds(10, 470, 200, 30);
        tlog.setFont(new Font("Tohoma", Font.PLAIN, 14));
        tlog.setBackground(Color.WHITE);
        tlog.setForeground(Color.BLACK);
        tlog.addActionListener(this);
        add(tlog);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500,470);
        add(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(350, 200, 800, 570);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == tcustomer) {
            setVisible(false);
            new AddCustomers();
        } else if (ae.getSource() == troomm ) {
            setVisible(false);
            new AllRooms();
        } else if (ae.getSource() == tdep) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == temp) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == tcsi) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == tmai) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == tser) {
            setVisible(false);
            new SearchRoom();
        } else if(ae.getSource() == tups) {
            setVisible(false);
            new UpdateCheck();
        } else if(ae.getSource() == tupr) {
            setVisible(false);
            new UpdateRoom();
        } else if(ae.getSource() == tpic) {
            setVisible(false);
            new Pickup();
        } else if (ae.getSource() == tcho) {
            setVisible(false);
            new Checkout();
        } else if (ae.getSource() == tlog) {
            setVisible(false);
            new Dashboard();
        }
        
    }
    
    public static void main(String[] args) {
        new Receptions();
    }
}
