package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    
        JTable ltable;
        JButton back;
        
    CustomerInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lid = new JLabel("ID");
        lid.setBounds(40, 10, 100, 20);
        lid.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lid);
        
        JLabel lnum = new JLabel("Number");
        lnum.setBounds(150, 10, 100, 20);
        lnum.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lnum);
        
        JLabel lname = new JLabel("Name");
        lname.setBounds(280, 10, 100, 20);
        lname.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lname);
        
        JLabel ljb = new JLabel("Gender");
        ljb.setBounds(400, 10, 100, 20);
        ljb.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(ljb);
        
        JLabel lsal = new JLabel("Country");
        lsal.setBounds(520, 10, 100,20);
        lsal.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lsal);
        
        JLabel lph = new JLabel("Room");
        lph.setBounds(670, 10, 100, 20);
        lph.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lph);
                   
        JLabel lemail = new JLabel("Check- in Time");
        lemail.setBounds(760, 10, 150, 20);
        lemail.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lemail);
        
        JLabel lep = new JLabel("Deposit");
        lep.setBounds(900, 10, 100, 20);
        lep.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lep);
        
        ltable = new JTable();
        ltable.setBounds(0, 40, 1000, 400);
        add(ltable);
        try {
            Conn cr = new Conn();
            
            ResultSet rs = cr.s.executeQuery("select * from customer order by name;");
            ltable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(420, 500, 120, 20);
        back.setFont(new Font("Tohoma", Font.PLAIN, 12));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 200, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Receptions();
    }
    
    public static void main(String[] args) {
        new CustomerInfo();
    }
    
}

