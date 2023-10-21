package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lroomn, tchin , tchou;
    JButton jchout, jback;
    
    Checkout() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lhead = new JLabel("Checkout");
        lhead.setBounds(100, 20, 100, 30);
        lhead.setForeground(Color.BLACK);
        lhead.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(lhead);
        
        JLabel lid = new JLabel("Customer id");
        lid.setBounds(30, 80, 100, 30);
        lid.setForeground(Color.BLACK);
        lid.setFont(new Font("Tohoma", Font.PLAIN, 14));
        add(lid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 30);
        ccustomer.setForeground(Color.BLACK);
        add(ccustomer);
   
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel limg = new JLabel(i3);
        limg.setBounds(310, 80, 20, 20);
        add(limg);
        
        JLabel lrom = new JLabel("Room number");
        lrom.setBounds(30, 130, 100, 30);
        lrom.setForeground(Color.BLACK);
        lrom.setFont(new Font("Tohoma", Font.PLAIN, 14));
        add(lrom);
        
        lroomn = new JLabel();
        lroomn.setBounds(150, 130, 100, 30);
        lroomn.setForeground(Color.BLACK);
        lroomn.setFont(new Font("Tohoma", Font.PLAIN, 14));
        add(lroomn);
        
        JLabel lchin = new JLabel("Checkin Time");
        lchin.setBounds(30, 180, 100, 30);
        lchin.setForeground(Color.BLACK);
        lchin.setFont(new Font("Tohoma", Font.PLAIN, 14));
        add(lchin);
        
        tchin = new JLabel();
        tchin.setBounds(150, 180, 100, 30);
        tchin.setForeground(Color.BLACK);
        tchin.setFont(new Font("Tohoma", Font.PLAIN, 14));
        add(tchin);
        
        JLabel lchou = new JLabel("Checkout Time");
        lchou.setBounds(30, 230, 100, 30);
        lchou.setForeground(Color.BLACK);
        lchou.setFont(new Font("Tohoma", Font.PLAIN, 14));
        add(lchou);
        
        
        Date date = new Date();
        tchou = new JLabel("" + date);
        tchou.setBounds(150, 230, 160, 30);
        tchou.setForeground(Color.BLACK);
        tchou.setFont(new Font("Tohoma", Font.PLAIN, 12));
        add(tchou);
        
        jchout = new JButton("Checkout");
        jchout.setBounds(40, 280, 120,30);
        jchout.setFont(new Font("Tohoma", Font.PLAIN, 12));
        jchout.setBackground(Color.WHITE);
        jchout.setForeground(Color.BLACK);
        jchout.addActionListener(this);
        add(jchout);
    
        jback = new JButton("Back");
        jback.setBounds(180, 280, 120, 30);
        jback.setFont(new Font("Tohoma", Font.PLAIN, 12));
        jback.setBackground(Color.WHITE);
        jback.setForeground(Color.BLACK);
        jback.addActionListener(this);
        add(jback);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel limge = new JLabel(i6);
        limge.setBounds(350, 50, 400, 250);
        add(limge);
        
        
        
         try {
       
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                ccustomer.add(rs.getString("num"));
                lroomn.setText(rs.getString("room"));
                tchin.setText(rs.getString("checkin"));
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 200, 800,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == jchout) {
           
            String query1 = "delete from customer where num = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update rooms set available = 'Available' where room = '"+lroomn.getText()+"'";
            
            try{
                Conn cd = new Conn();
                cd.s.executeUpdate(query1);
                cd.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout Sucess");
                
                setVisible(false);
                new Receptions();
                
            }catch(Exception e) {
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == jback) {
            setVisible(false);
            new Receptions();
        }
    }
    
    public static void main(String[] args) {
       new Checkout();
    } 
}


// as per the project is completed on date 1-April-2023 at 1:30 AM