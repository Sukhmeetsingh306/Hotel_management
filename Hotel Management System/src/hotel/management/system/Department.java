package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
    
        JTable ltable;
        JButton back;
        
    Department() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel ldep = new JLabel("Department");
        ldep.setBounds(180, 10, 100, 20);
        ldep.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(ldep);
        
        JLabel lbg = new JLabel("Budget");
        lbg.setBounds(400, 10, 100, 20);
        lbg.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lbg);
                             
        ltable = new JTable();
        ltable.setBounds(0, 50, 700, 350);
        add(ltable);
        try {
            Conn cr = new Conn();
            
            ResultSet rs = cr.s.executeQuery("select * from Departments order by department");
            ltable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(280, 400, 120, 30);
        back.setFont(new Font("Tohoma", Font.PLAIN, 12));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 200, 700, 480);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Receptions();
    }
    
    public static void main(String[] args) {
        new Department();
    }
    
}