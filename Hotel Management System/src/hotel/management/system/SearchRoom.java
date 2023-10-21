package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    
        JTable ltable;
        JButton back, add;
        JComboBox tbedm;
        JRadioButton Avail, nAvail, allr;
        
    SearchRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lsrom = new JLabel("Search Rooms");
        lsrom.setBounds(400, 30,2100, 20);
        lsrom.setFont(new Font("Tohoma", Font.BOLD, 20));
        add(lsrom);
        
        JLabel lbedm = new JLabel("Bed Type");
        lbedm.setBounds(50, 100, 100, 20);
        lbedm.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lbedm);
        
        String str9[] = {
            "Single Bed", "Double Bed", "Two Single Bed"
        };
        tbedm = new JComboBox(str9);
        tbedm.setBounds(150, 100, 150 ,20);
        tbedm.setFont(new Font("Tohoma", Font.PLAIN, 12));
        tbedm.setBackground(Color.WHITE);
        tbedm.setForeground(Color.BLACK);
        add(tbedm);
        
        Avail = new JRadioButton("Only Show Available");
        Avail.setBounds(650, 100, 150, 20);
        Avail.setFont(new Font("Tohoma", Font.PLAIN, 12));
        Avail.setBackground(Color.WHITE);
        Avail.setForeground(Color.BLACK);
        add(Avail);
        
        nAvail = new JRadioButton("Only Show NotAvailable");
        nAvail.setBounds(800, 100, 150, 20);
        nAvail.setFont(new Font("Tohoma", Font.PLAIN, 12));
        nAvail.setBackground(Color.WHITE);
        nAvail.setForeground(Color.BLACK);
        add(nAvail);
        
        allr = new JRadioButton("All Rooms");
        allr.setBounds(540, 100, 110, 20);
        allr.setFont(new Font("Tohoma", Font.PLAIN, 12));
        allr.setBackground(Color.WHITE);
        allr.setForeground(Color.BLACK);
        add(allr);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(Avail);
        bg.add(nAvail);
        bg.add(allr);
        
        JLabel lroom = new JLabel("Room Number");
        lroom.setBounds(50, 160, 100, 20);
        lroom.setFont(new Font("Tohoma", Font.BOLD, 10));
        add(lroom);
        
        JLabel lavailable = new JLabel("Available");
        lavailable.setBounds(270, 160, 100, 20);
        lavailable.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lavailable);
        
        JLabel lcleaning = new JLabel("Cleaning Status");
        lcleaning.setBounds(450, 160, 100, 20);
        lcleaning.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lcleaning);
        
        JLabel lprice = new JLabel("Price");
        lprice.setBounds(670, 160, 100,20);
        lprice.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lprice);
        
        JLabel lbed = new JLabel("Bed Type");
        lbed.setBounds(870, 160, 100, 20);
        lbed.setFont(new Font("Tohoma", Font.BOLD, 12));
        add(lbed);
                
        ltable = new JTable();
        ltable.setBounds(0, 200, 1000, 400);
        add(ltable);
        try {
            Conn cr = new Conn();
            
            ResultSet rs = cr.s.executeQuery("select * from rooms order by room");
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
                
                String qury1 = "select * from rooms where bed = '"+tbedm.getSelectedItem()+"'";
                String qury2 = "select * from rooms where available = 'Available' AND bed = '"+tbedm.getSelectedItem()+"'";
                String qury3 = "select * from rooms where available = 'Not Available' AND bed = '"+tbedm.getSelectedItem()+"'";
                String qury4 = "select * from rooms where bed = '"+tbedm.getSelectedItem()+"'";
                
                ResultSet rs;
                
                
                if(Avail.isSelected()) {
                    rs = in.s.executeQuery(qury2);
                } else if (nAvail.isSelected()){
                    rs = in.s.executeQuery(qury3);
                }else if (allr.isSelected()) {
                    rs = in.s.executeQuery(qury4);
                } else { 
                    rs = in.s.executeQuery(qury1);
                }
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
        new SearchRoom();
    }
    
}