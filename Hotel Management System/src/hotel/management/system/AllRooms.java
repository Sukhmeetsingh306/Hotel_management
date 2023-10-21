package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class AllRooms extends JFrame implements ActionListener {
    
        JTable ltable;
        JButton back;
        
    AllRooms() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lroom = new JLabel("Room Number");
        lroom.setBounds(5, 15, 100, 20);
        lroom.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lroom);
        
        JLabel lavailable = new JLabel("Available");
        lavailable.setBounds(110, 15, 100, 20);
        lavailable.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lavailable);
        
        JLabel lcleaning = new JLabel("Cleaning Status");
        lcleaning.setBounds(200, 15, 100, 20);
        lcleaning.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lcleaning);
        
        JLabel lprice = new JLabel("Price");
        lprice.setBounds(300, 15, 100,20);
        lprice.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lprice);
        
        JLabel lbed = new JLabel("Bed Type");
        lbed.setBounds(400, 15, 100, 20);
        lbed.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lbed);
                
        ltable = new JTable();
        ltable.setBounds(0, 40, 500, 400);
        add(ltable);
        try {
            Conn cr = new Conn();
            
            ResultSet rs = cr.s.executeQuery("select * from rooms order by room");
            ltable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600,  Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(200, 500, 120, 20);
        back.setFont(new Font("Tohoma", Font.PLAIN, 12));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Receptions();
    }
    
    public static void main(String[] args) {
        new AllRooms();
    }
    
}
