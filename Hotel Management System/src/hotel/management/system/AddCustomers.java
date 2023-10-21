// there is error in this class at the add button

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomers extends JFrame implements ActionListener {
    
    JComboBox tid;
    JTextField tnum, tnam, tcountry ,tdep;
    JRadioButton rmal, rfemal;
    Choice trom;
    JLabel tchecktime;
    JButton add, tcan;
    
    AddCustomers() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel ltext = new JLabel("NEW CUSTOMER FORM");
        ltext.setBounds(200, 20, 300, 30);
        ltext.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(ltext);
        
        JLabel lid = new JLabel("ID");
        lid.setBounds(30, 80, 120, 20);
        lid.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lid);
        
        String str[] = {
            "Aadhar Card", "Passport", "Driving License","Voter-id"
        };
        tid = new JComboBox(str);
        tid.setBounds(200, 80, 150, 20);
        tid.setBackground(Color.WHITE);
        tid.setForeground(Color.BLACK);
        add(tid);
        
        JLabel lnum = new JLabel("Number");
        lnum.setBounds(30, 120, 120, 20);
        lnum.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lnum);
        
        tnum = new JTextField();
        tnum.setBounds(200, 120, 150, 20);
        tnum.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tnum);
        
        JLabel lnam = new JLabel("Name");
        lnam.setBounds(30, 160, 120, 20);
        lnam.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lnam);
        
        tnam = new JTextField();
        tnam.setBounds(200, 160, 150, 20);
        tnam.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tnam);
        
        JLabel lgen = new JLabel("Gender");
        lgen.setBounds(30, 200, 120, 20);
        lgen.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lgen);
        
        rmal = new JRadioButton("Male");
        rmal.setBounds(200, 200, 70, 20);
        rmal.setFont(new Font("Tohoma", Font.PLAIN, 15));
        rmal.setBackground(Color.WHITE);
        rmal.setForeground(Color.BLACK);
        add(rmal);
        
        rfemal = new JRadioButton("Female");
        rfemal.setBounds(270, 200, 100, 20);
        rfemal.setFont(new Font("Tohoma", Font.PLAIN, 15));
        rfemal.setBackground(Color.WHITE);
        rfemal.setForeground(Color.BLACK);
        add(rfemal);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmal);
        bg.add(rfemal);
        
        JLabel lcountry = new JLabel("Country");
        lcountry.setBounds(30, 240, 120, 20);
        lcountry.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lcountry);
        
        tcountry = new JTextField();
        tcountry.setBounds(200, 240, 150, 20);
        tcountry.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tcountry);
        
        JLabel lrom = new JLabel("Room Number");
        lrom.setBounds(30, 280, 120, 20);
        lrom.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lrom);
        
        trom = new Choice();        
        try {
            
            Conn con = new Conn();
            
            String query = "select * from rooms order by room";
            
            ResultSet rs = con.s.executeQuery(query);      // to run it in the loop
            
            while(rs.next()) {
                trom.add(rs.getString("room"));
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }        
        trom.setBounds(200, 280, 150, 20);
        trom.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(trom);
        
        JLabel lct = new JLabel("Check-in Time");
        lct.setBounds(30, 320, 120, 20);
        lct.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lct);
        
        Date date = new Date();
        tchecktime = new JLabel("" + date);
        tchecktime.setBounds(200, 320, 160, 20);
        tchecktime.setFont(new Font("Tohoma", Font.PLAIN, 11));
        add(tchecktime);
        
        JLabel ldep = new JLabel("Deposit");
        ldep.setBounds(30, 360, 120, 20);
        ldep.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(ldep);
        
        tdep = new JTextField();
        tdep.setBounds(200, 360, 150, 20);
        tdep.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tdep);
               
        add = new JButton("Add Customer");
        add.setBounds(35, 400, 120, 20);
        add.setFont(new Font("Tohoma", Font.PLAIN, 12));
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        tcan = new JButton("Back");
        tcan.setBounds(200, 400, 120, 20);
        tcan.setFont(new Font("Tohoma", Font.PLAIN, 12));
        tcan.setBackground(Color.WHITE);
        tcan.setForeground(Color.BLACK);
        tcan.addActionListener(this);
        add(tcan);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50 , 300, 400);
        add(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(350, 200, 800, 550);
        setVisible(true);
    }
    
    /*public void actionPerformed(ActionEvent ae) { 
            if(ae.getSource() == add) {
            
            String id = (String)tid.getSelectedItem();
            String number = tnum.getText();
            String name = tnam.getText();
            
            String gender = null;
            try {
                if(rmal.isSelected()) {
                    gender = "Male";
                } else if (rfemal.isSelected()) {
                    gender = "Female";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            String country = tcountry.getText();
            String room = trom.getSelectedItem();
            String checkin = tchecktime.getText();
            String deposit = tdep.getText();
            
            if(tid.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(tnum.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(tnam.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(tcountry.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(trom.equals("")) {
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
            
            try {
                
                Conn connn = new Conn();
                
                String query = "insert into addomer values('"+id+"', '"+number+"', '"+name+"' '"+gender+"', '"+country+"', '"+room+"', '"+checkin+"', '"+deposit+"')";
                String query2 = "update rooms set available = 'Occupied' where room = '"+room+"'";
                
                connn.s.executeUpdate(query);
                connn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Added");
                
                setVisible(false);
                
                new Receptions();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if (ae.getSource() == tcan) {
            setVisible(false);
            
            new Receptions();
        }*/
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == tcan ) {
            
            setVisible(false);
            
            new Receptions();
            
        }else if (ae.getSource() == add) {
            
            String id = (String) tid.getSelectedItem();
            String number = tnum.getText();
            String name = tnam.getText();
            
            
            if(id.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
                        
            String gender = null;
            
                if(rmal.isSelected()) {
                    gender = "Male";
                } else if (rfemal.isSelected()) {
                    gender = "Female";
                }
            
            String country = tcountry.getText();
            String room = trom.getSelectedItem();
            String checkin = tchecktime.getText();
            String deposit = tdep.getText();

            if(country.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(room.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(checkin.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(deposit.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }

            /*try {
                
                Conn kon = new Conn();
                
                String query1 = "insert into Customers values('"+id+"', '"+num+"', '"+name+"' '"+gender+"', '"+country+"', '"+room+"', '"+checkin+"', '"+deposit+"')";
                String query2 = "update rooms set available = 'Occupied' where room = '"+room+"'";
                
                kon.s.executeUpdate(query1);
                kon.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Added");
                
                setVisible(false);
                
                new Receptions();
                
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            
            try {         
                
                Conn cn = new Conn();
                
                String qury = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+checkin+"', '"+deposit+"')";
                String qry = "update rooms set available = 'Occupied' where room = '"+room+"'";
                
                cn.s.executeUpdate(qury);
                cn.s.executeUpdate(qry);
                
                JOptionPane.showMessageDialog(null,"Customer Added" );
                
                setVisible(false);   
            
                new Receptions();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
       }
    } 
    
    public static void main(String[] args) {
        new AddCustomers();
    }
}
