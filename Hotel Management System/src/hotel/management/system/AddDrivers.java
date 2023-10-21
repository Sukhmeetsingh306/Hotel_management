package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {
    
    JTextField lname, tage, tcar, tcarm, tlocat;
    JRadioButton rmale, rfemale;
    JComboBox tavail;
    JButton ldrive, lcancel;
    
    AddDrivers() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Driver");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(heading);
        
        JLabel tname = new JLabel("Name");
        tname.setBounds(60, 80, 120, 20);
        tname.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tname);
        
        lname = new JTextField();
        lname.setBounds(200, 80, 150, 30);
        lname.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lname);
        
        JLabel lage = new JLabel("Age");
        lage.setBounds(60, 120, 120, 20);
        lage.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lage);
        
        tage = new JTextField();
        tage.setBounds(200, 120, 150, 30);
        tage.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tage);
        
        JLabel lgender = new JLabel("Gender");
        lgender.setBounds(60, 160, 120, 20);
        lgender.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(200, 160, 80, 30);
        rmale.setFont(new Font("Tohoma", Font.PLAIN, 14));
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(280, 160, 80, 30);
        rfemale.setFont(new Font("Tohoma", Font.PLAIN, 14));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        JLabel lcar = new JLabel("Car Company");
        lcar.setBounds(60, 200, 120, 20);
        lcar.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lcar);
        
        tcar = new JTextField();
        tcar.setBounds(200, 200, 150, 30);
        tcar.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tcar);
        
        JLabel lcarm = new JLabel("Car Name");
        lcarm.setBounds(60, 240, 120, 20);
        lcarm.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lcarm);
        
        tcarm = new JTextField();
        tcarm.setBounds(200, 240, 150, 30);
        tcarm.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tcarm);
        
        JLabel lavail = new JLabel("Available");
        lavail.setBounds(60, 280, 120, 20);
        lavail.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lavail);
        
        String str[] = {
            "Available", "Not Available", "Repairing", "Washing"
        };
        tavail = new JComboBox(str);
        tavail.setBounds(200, 280, 150, 30);
        tavail.setFont(new Font("Tohoma", Font.PLAIN, 17));
        tavail.setBackground(Color.WHITE);
        tavail.setForeground(Color.BLACK);
        add(tavail);
        
        JLabel llocat = new JLabel("Location");
        llocat.setBounds(60, 320, 120, 20);
        llocat.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(llocat);
        
        tlocat = new JTextField();
        tlocat.setBounds(200, 320, 150, 30);
        tlocat.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(tlocat);
        
        ldrive = new JButton("Add Driver");
        ldrive.setBounds(60, 370, 120, 20);
        ldrive.setFont(new Font("Tohoma", Font.PLAIN, 12));
        ldrive.setBackground(Color.WHITE);
        ldrive.setForeground(Color.BLACK);
        ldrive.addActionListener(this);
        add(ldrive);
        
        lcancel = new JButton("Cancel");
        lcancel.setBounds(200, 370, 120, 20);
        lcancel.setFont(new Font("Tohoma", Font.PLAIN, 13));
        lcancel.setBackground(Color.WHITE);
        lcancel.setForeground(Color.BLACK);
        lcancel.addActionListener(this);
        add(lcancel);
                       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(420, 70, 500, 300);
        add(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(330, 220, 1000, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == ldrive) {
            
            String name = lname.getText();
            String age = tage.getText();
        
            String gender = null;
            if(rmale.isSelected()) {
                gender = "MALE";
            }else if(rfemale.isSelected()) {
                gender = "FEMALE";
            }
        
            String company = tcar.getText();
            String brand = tcarm.getText();
            String avail = (String)tavail.getSelectedItem();
            String locat = tlocat.getText();
            
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(age.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(company.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(brand.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
            
            if(locat.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Details");
                return;
            }
        
            try {
                Conn conn = new Conn();
                
                String query = "insert into drivers values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+brand+"', '"+avail+"','"+locat+"')";
                
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Driver Added");
                
                setVisible(false);
                
            } catch(Exception e) {
                e.printStackTrace();
            }
        
        } else if (ae.getSource() == lcancel) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddDrivers();
    }
}
