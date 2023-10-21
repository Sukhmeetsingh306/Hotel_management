package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;       //as it willgive us the password inthe form of dots
    JButton login, cancel;
    
    Login() {
        getContentPane().setBackground(Color.WHITE);    //as per we uset the getcontentpane to change the background color of t he whole frme were as to change the color of the text we use the text name which we select
        
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
        username = new JTextField(0);        // for making the entering box in which we will enter the text 
        username.setBounds(150, 20, 150,30);
        add(username);
         
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);        //as per to change the height of the text we just have to chnge the y number to change the size of the text 
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);
      
        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);       
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 200, 600, 300);
        setVisible(true);
    }
    
        public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username ='" + user + "'and password ='" + pass + "'"; //DDL command made as per we have also done the connectination in it 
 
                ResultSet rs = c.s.executeQuery(query); // when we read from the database
                
                if(rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else { 
                    JOptionPane.showMessageDialog(null, " INVALID USERNAME OR PASSWORD");
                    setVisible(false);
                }
                
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
