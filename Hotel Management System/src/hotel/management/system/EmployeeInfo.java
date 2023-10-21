package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    
        JTable ltable;
        JButton back;
        
    EmployeeInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lname = new JLabel("Name");
        lname.setBounds(40, 10, 100, 20);
        lname.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lname);
        
        JLabel lage = new JLabel("Age");
        lage.setBounds(150, 10, 100, 20);
        lage.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lage);
        
        JLabel lgender = new JLabel("Gender");
        lgender.setBounds(250, 10, 100, 20);
        lgender.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lgender);
        
        JLabel ljb = new JLabel("Job");
        ljb.setBounds(370, 10, 100, 20);
        ljb.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(ljb);
        
        JLabel lsal = new JLabel("Salary");
        lsal.setBounds(470, 10, 100,20);
        lsal.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lsal);
        
        JLabel lph = new JLabel("Phone");
        lph.setBounds(585, 10, 100, 20);
        lph.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lph);
                   
        JLabel lemail = new JLabel("Email");
        lemail.setBounds(670, 10, 100, 20);
        lemail.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lemail);
        
        JLabel lad = new JLabel("Aadhar");
        lad.setBounds(800, 10, 100, 20);
        lad.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lad);
        
        JLabel lep = new JLabel("Experience");
        lep.setBounds(900, 10, 100, 20);
        lep.setFont(new Font("Tohoma", Font.BOLD, 14));
        add(lep);
        
        ltable = new JTable();
        ltable.setBounds(0, 40, 1000, 400);
        add(ltable);
        try {
            Conn cr = new Conn();
            
            ResultSet rs = cr.s.executeQuery("select * from employee order by name;");
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
        new EmployeeInfo();
    }
    
}
