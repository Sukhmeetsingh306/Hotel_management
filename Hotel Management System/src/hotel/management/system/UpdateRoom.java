package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField trom, tavailable, tstatus;
    JButton jcheck, jupdate, jback;
    
    UpdateRoom() {
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel text = new JLabel("Update Room Status");
    text.setBounds(90, 20, 250, 30);
    text.setFont(new Font("Tohoma", Font.PLAIN, 20));
    text.setForeground(Color.BLACK);
    add(text);
    
    JLabel lbid = new JLabel("Customer id");
    lbid.setBounds(30, 90, 100, 20);
    lbid.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lbid.setForeground(Color.BLACK);
    add(lbid);
    
    ccustomer = new Choice();
    ccustomer.setBounds(200, 90, 150, 25);
    ccustomer.setForeground(Color.BLACK);
    add(ccustomer);
    
    try {
       
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer order by name");
        while(rs.next()) {
            ccustomer.add(rs.getString("num"));
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    JLabel lrom = new JLabel("Room Number");
    lrom.setBounds(30, 140, 120, 20);
    lrom.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lrom.setForeground(Color.BLACK);
    add(lrom);
    
    trom = new JTextField();
    trom.setBounds(200, 140, 150, 25);
    trom.setFont(new Font("Tohoma", Font.PLAIN, 16));
    trom.setForeground(Color.BLACK);
    add(trom);
    
    JLabel lavailable = new JLabel("Availability");
    lavailable.setBounds(30, 190, 120, 20);
    lavailable.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lavailable.setForeground(Color.BLACK);
    add(lavailable);
    
    tavailable = new JTextField();
    tavailable.setBounds(200, 190, 150, 25);
    tavailable.setFont(new Font("Tohoma", Font.PLAIN, 16));
    tavailable.setForeground(Color.BLACK);
    add(tavailable);
     
    JLabel lcleaning = new JLabel("Cleaning Status");
    lcleaning.setBounds(30, 240, 120, 20);
    lcleaning.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lcleaning.setForeground(Color.BLACK);
    add(lcleaning);
    
    tstatus = new JTextField();
    tstatus.setBounds(200, 240, 150, 25);
    tstatus.setFont(new Font("Tohoma", Font.PLAIN, 16));
    tstatus.setForeground(Color.BLACK);
    add(tstatus);
    
    jcheck = new JButton("Check");
    jcheck.setBounds(35, 300, 80, 25);
    jcheck.setFont(new Font("Tohoma", Font.PLAIN, 12));
    jcheck.setBackground(Color.WHITE);
    jcheck.setForeground(Color.BLACK);
    jcheck.addActionListener(this);
    add(jcheck);
    
    jupdate = new JButton("Update");
    jupdate.setBounds(230, 300, 80, 25);
    jupdate.setFont(new Font("Tohoma", Font.PLAIN, 12));
    jupdate.setBackground(Color.WHITE);
    jupdate.setForeground(Color.BLACK);
    jupdate.addActionListener(this);
    add(jupdate);
    
    jback = new JButton("Back");
    jback.setBounds(130, 300, 80, 25);
    jback.setFont(new Font("Tohoma", Font.PLAIN, 12));
    jback.setBackground(Color.WHITE);
    jback.setForeground(Color.BLACK);
    jback.addActionListener(this);
    add(jback);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image =new JLabel(i3);
    image.setBounds(400, 50, 500, 300);
    add(image);

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(300, 200 , 980 ,450);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == jcheck) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where num = '"+id+"'";
            try{
                Conn cb = new Conn();
                ResultSet rs = cb.s.executeQuery(query);
                while(rs.next()){
                    trom.setText(rs.getString("room"));
                                  }
                
                ResultSet rs2 = cb.s.executeQuery("select * from rooms where room = ' " + trom.getText()+"'");
                while(rs2.next()) {
                    tavailable.setText(rs2.getString("available"));
                    tstatus.setText(rs2.getString("cleaning"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
                       
        } else if (ae.getSource() == jupdate) {
            String number = ccustomer.getSelectedItem();
            String room = trom.getText();
            String available = tavailable.getText();
            String status = tstatus.getText();
            
            try{
                Conn cc = new Conn();
                cc.s.executeUpdate("update rooms set available ='"+available+"', cleaning =  '"+status+"' where room = '"+room+"' " );
                
                JOptionPane.showMessageDialog(null, "Data Updated");
                
                setVisible(false);
                new Receptions();
            } catch(Exception e) {
                e.printStackTrace();
            }
            
            if(ccustomer.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(trom.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(tavailable.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(tstatus.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }   
        } else {        // we also implments else if at the place of the else as by making the (else if(ae.getSource() == jback)
            setVisible(false);
            new Receptions();
        }
        
        }
    
        public static void main(String[] args) {
        new UpdateRoom(); 
    }
}
