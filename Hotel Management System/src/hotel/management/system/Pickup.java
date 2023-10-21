package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener {
    
        JTable ltable;
        JButton back, add;
        Choice typeoc;
        JRadioButton Avail, nAvail, allr;
        
    Pickup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lsrom = new JLabel("Pickup Service");
        lsrom.setBounds(400, 30,2100, 20);
        lsrom.setFont(new Font("Tohoma", Font.BOLD, 20));
        add(lsrom);
        
        JLabel lbedm = new JLabel("Type of Car");
        lbedm.setBounds(50, 100, 100, 20);
        lbedm.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lbedm);
        
        typeoc = new Choice();
        typeoc.setBounds(150,100,200,25);
        typeoc.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(typeoc);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from drivers order by name");
            while(rs.next()) {
                typeoc.add(rs.getString("brand"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lroom = new JLabel("Name");
        lroom.setBounds(50, 160, 100, 20);
        lroom.setFont(new Font("Tohoma", Font.BOLD, 10));
        add(lroom);
        
        JLabel lavailable = new JLabel("Age");
        lavailable.setBounds(200, 160, 100, 20);
        lavailable.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lavailable);
        
        JLabel lcleaning = new JLabel("Gender");
        lcleaning.setBounds(330, 160, 100, 20);
        lcleaning.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lcleaning);
        
        JLabel lprice = new JLabel("Company");
        lprice.setBounds(460, 160, 100,20);
        lprice.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lprice);
        
        JLabel lbed = new JLabel("Brand");
        lbed.setBounds(630, 160, 100, 20);
        lbed.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lbed);

        JLabel lava = new JLabel("Available");
        lava.setBounds(740, 160, 100, 20);
        lava.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lava);
        
        JLabel lloc = new JLabel("Location");
        lloc.setBounds(870, 160, 100, 20);
        lloc.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lloc);
        
        ltable = new JTable();
        ltable.setBounds(0, 200, 1000, 400);
        add(ltable);
        try {
            Conn cr = new Conn();
            
            ResultSet rs = cr.s.executeQuery("select * from drivers order by name");
            ltable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Submit");
        add.setBounds(670, 20, 120, 20);
        add.setFont(new Font("Tohoma", Font.PLAIN, 12));
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(820, 20, 120, 20);
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
        if(ae.getSource() == add) {
            try {
                Conn in = new Conn();
                
                String qury1 = "select * from drivers where brand = '"+typeoc.getSelectedItem()+"'";
                
                
                ResultSet rs;
             
                rs = in.s.executeQuery(qury1);
               
                ltable.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Receptions();
        }
    }
    
    public static void main(String[] args) {
        new Pickup();
    }
    
}