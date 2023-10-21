package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    
    JTextField troom, tprice ;
    JComboBox tavailable, tcleaning, tbed;
    JButton taddroom, tcancel;
   
    AddRooms() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tohoma", Font.PLAIN, 17));       
        add(heading);
        
        JLabel lroom = new JLabel("Room Number");
        lroom.setBounds(60, 80, 120, 20);
        lroom.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lroom);
        
        troom = new JTextField();
        troom.setBounds(200, 80, 150, 30);
        troom.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(troom);
        
        JLabel lavailable = new JLabel("Available");
        lavailable.setBounds(60, 120, 120, 20);
        lavailable.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lavailable);
        
        String str[] = {
            "Available", "Not Available"
        };
        tavailable = new JComboBox(str);
        tavailable.setBounds(200, 120, 150, 30);
        tavailable.setFont(new Font("Tohoma", Font.PLAIN, 17));
        tavailable.setBackground(Color.white);
        add(tavailable);
        
        JLabel lcleaning = new JLabel("Cleaning Status");
        lcleaning.setBounds(60, 160, 120, 20);
        lcleaning.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lcleaning);
        
        String str1[] = {
            "Cleaned", "Not Cleaned", "Cleaning"
        };
        tcleaning = new JComboBox(str1);
        tcleaning.setBounds(200, 160, 150, 30);
        tcleaning.setFont(new Font("Tohoma", Font.PLAIN, 17));
        tcleaning.setBackground(Color.WHITE);
        add(tcleaning);
        
        JLabel lprice = new JLabel("Price");
        lprice.setBounds(60, 200, 120,20);
        lprice.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lprice);
        
        tprice = new JTextField();
        tprice.setBounds(200, 200, 150, 30);
        tprice.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tprice);
        
        JLabel lbed = new JLabel("Bed Type");
        lbed.setBounds(60, 240, 120, 20);
        lbed.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lbed);
        
        String str2[] = {
            "Single Bed", "Double Bed", "Two Single Bed"
        };
        tbed = new JComboBox(str2);
        tbed.setBounds(200, 240, 150 ,30);
        tbed.setFont(new Font("Tohoma", Font.PLAIN, 17));
        tbed.setBackground(Color.WHITE);
        add(tbed);
        
        taddroom = new JButton("Add Room");
        taddroom.setBounds(60, 300, 100, 20);
        taddroom.setFont(new Font("Tohoma", Font.PLAIN, 12));
        taddroom.setBackground(Color.WHITE);
        taddroom.setForeground(Color.BLACK);
        taddroom.addActionListener(this);
        add(taddroom);
        
        tcancel = new JButton("Cancel");
        tcancel.setBounds(210, 300, 100, 20);
        tcancel.setFont(new Font("Tohoma", Font.PLAIN,13));
        tcancel.setBackground(Color.WHITE);
        tcancel.setForeground(Color.BLACK);
        tcancel.addActionListener(this);
        add(tcancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(330, 220, 940, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == taddroom) {
            String room = troom.getText();
            String available = (String) tavailable.getSelectedItem();
            String cleaning = (String) tcleaning.getSelectedItem();
            String price = tprice.getText();
            String bed = (String) tbed.getSelectedItem();
            
            if(room.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(price.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            try {
                Conn conn = new Conn();
                
                String qery = "insert into rooms values('"+room+"', '"+available+"', '"+cleaning+"', '"+price+"', '"+bed+"')";
                
                conn.s.executeUpdate(qery);
                
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                
                setVisible(false);
                
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == tcancel) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }
}
