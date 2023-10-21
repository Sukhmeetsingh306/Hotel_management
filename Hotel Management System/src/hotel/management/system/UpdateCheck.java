//this slide is update status

package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField trom, tnam, tchecktime, tdep, tpend;
    JButton jcheck, jupdate, jback;
    
    UpdateCheck() {
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel text = new JLabel("Update Status");
    text.setBounds(90, 20, 200, 30);
    text.setFont(new Font("Tohoma", Font.PLAIN, 20));
    text.setForeground(Color.BLACK);
    add(text);
    
    JLabel lbid = new JLabel("Customer id");
    lbid.setBounds(30, 80, 100, 20);
    lbid.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lbid.setForeground(Color.BLACK);
    add(lbid);
    
    ccustomer = new Choice();
    ccustomer.setBounds(200, 80, 150, 25);
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
    lrom.setBounds(30, 120, 120, 20);
    lrom.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lrom.setForeground(Color.BLACK);
    add(lrom);
    
    trom = new JTextField();
    trom.setBounds(200, 120, 150, 25);
    trom.setFont(new Font("Tohoma", Font.PLAIN, 16));
    trom.setForeground(Color.BLACK);
    add(trom);
    
    JLabel lname = new JLabel("Name");
    lname.setBounds(30, 160, 120, 20);
    lname.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lname.setForeground(Color.BLACK);
    add(lname);
    
    tnam = new JTextField();
    tnam.setBounds(200, 160, 150, 25);
    tnam.setFont(new Font("Tohoma", Font.PLAIN, 16));
    tnam.setForeground(Color.BLACK);
    add(tnam);
    
    JLabel lcheck = new JLabel("Checkin Time");
    lcheck.setBounds(30, 200, 120, 20);
    lcheck.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lcheck.setForeground(Color.BLACK);
    add(lcheck);
    
    tchecktime = new JTextField();
    tchecktime.setBounds(200, 200, 150, 25);
    tchecktime.setFont(new Font("Tohoma", Font.PLAIN, 16));
    tchecktime.setForeground(Color.BLACK);
    add(tchecktime);
    
    JLabel lpaid = new JLabel("Amount Paid");
    lpaid.setBounds(30, 240, 120, 20);
    lpaid.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lpaid.setForeground(Color.BLACK);
    add(lpaid);
    
    tdep = new JTextField();
    tdep.setBounds(200, 240, 150, 25);
    tdep.setFont(new Font("Tohoma", Font.PLAIN, 16));
    tdep.setForeground(Color.BLACK);
    add(tdep);
    
    JLabel lpend = new JLabel("Pending Amount");
    lpend.setBounds(30, 280, 120, 20);
    lpend.setFont(new Font("Tohoma", Font.PLAIN, 16));
    lpend.setForeground(Color.BLACK);
    add(lpend);
    
    tpend = new JTextField();
    tpend.setBounds(200, 280, 150, 25);
    tpend.setFont(new Font("Tohoma", Font.PLAIN, 16));
    tpend.setForeground(Color.BLACK);
    add(tpend);
    
    jcheck = new JButton("Check");
    jcheck.setBounds(35, 330, 80, 25);
    jcheck.setFont(new Font("Tohoma", Font.PLAIN, 12));
    jcheck.setBackground(Color.WHITE);
    jcheck.setForeground(Color.BLACK);
    jcheck.addActionListener(this);
    add(jcheck);
    
    jupdate = new JButton("Update");
    jupdate.setBounds(230, 330, 80, 25);
    jupdate.setFont(new Font("Tohoma", Font.PLAIN, 12));
    jupdate.setBackground(Color.WHITE);
    jupdate.setForeground(Color.BLACK);
    jupdate.addActionListener(this);
    add(jupdate);
    
    jback = new JButton("Back");
    jback.setBounds(130, 330, 80, 25);
    jback.setFont(new Font("Tohoma", Font.PLAIN, 12));
    jback.setBackground(Color.WHITE);
    jback.setForeground(Color.BLACK);
    jback.addActionListener(this);
    add(jback);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
    JLabel image =new JLabel(i1);
    image.setBounds(400, 50, 500, 300);
    add(image);

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(300, 200 , 980 ,500);
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
                    tnam.setText(rs.getString("name"));
                    tdep.setText(rs.getString("deposit"));
                    tchecktime.setText(rs.getString("checkin"));
                }
                
                ResultSet rs2 = cb.s.executeQuery("select * from rooms where room = ' " + trom.getText()+"'");
                while(rs2.next()) {
                    String price = rs2.getString("price");
                    int amountpaid = Integer.parseInt(price) - Integer.parseInt(tdep.getText());
                    tpend.setText("" + amountpaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
                       
        } else if (ae.getSource() == jupdate) {
            String number = ccustomer.getSelectedItem();
            String room = trom.getText();
            String name = tnam.getText();
            String checkin = tchecktime.getText();
            String deposit = tdep.getText();
            
            if(ccustomer.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(trom.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(tnam.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(tchecktime.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(tdep.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            try{
                Conn cc = new Conn();
                cc.s.executeUpdate("update customer set room ='"+room+"', checkin =  '"+checkin+"', deposit = '"+deposit+"' where num ='"+number+"' " );
                
                JOptionPane.showMessageDialog(null, "Data Updated");
                
                setVisible(false);
                new Receptions();
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        } else {        // we also implments else if at the place of the else as by making the (else if(ae.getSource() == jback)
            setVisible(false);
            new Receptions();
        }
    }
    
    public static void main(String[] args) {
        new UpdateCheck(); 
    }
}


