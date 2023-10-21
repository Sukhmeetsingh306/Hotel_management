package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tage, temail, taadhar, tname, tsalary, tphone, texperience ;
    JButton bsubmit;
    JRadioButton rmale, rfemale;
    JComboBox tjob;
    
    AddEmployee() {
        setLayout(null);
        
        JLabel lname = new JLabel("NAME");          // text of the name
        lname.setBounds(60, 30, 120, 30);
        lname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lname);
        
        tname = new JTextField();            //display of the name
        tname.setBounds(200, 30, 150,30);
        add(tname);
        
        JLabel lage = new JLabel("AGE");            //text of the age
        lage.setBounds(60, 80, 120, 30);
        lage.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lage);
        
        tage = new JTextField();             // display of the age
        tage.setBounds(200, 80, 150,30);
        add(tage);
        
        JLabel lgender = new   JLabel("GENDER");    //text of the gender
        lgender.setBounds(60, 130, 120, 30);
        lgender.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lgender);
        
        rmale = new JRadioButton("Male");  //display of the gender male
        rmale.setBounds(200, 130, 70,30);
        rmale.setFont(new Font("Tohoma", Font.PLAIN, 14));
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");  // display of the gender female
        rfemale.setBounds(280, 130, 100, 30);
        rfemale.setFont(new Font("Tohoma", Font.PLAIN, 14));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
                
        JLabel ljob = new JLabel("JOB");        //text of the job
        ljob.setBounds(60, 180, 120, 30);
        ljob.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(ljob);
        
        String str[] = {
            "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Serivce", "Chief", "Waiter/Waitrees","Manager", "Accountant"
        };
        tjob = new JComboBox(str);        // to display the job option 
        tjob.setBounds(200, 180, 150, 30);
        tjob.setBackground(Color.WHITE);
        tjob.setFont(new Font("Tohoma", Font.PLAIN, 14));
        add(tjob);
        
        JLabel lsalary = new JLabel("SALARY");      //text salary
        lsalary.setBounds(60, 230, 120, 30);
        lsalary.setFont(new Font("Tohoma", Font.PLAIN, 17));
        add(lsalary);
        
        tsalary = new JTextField();          //display salary
        tsalary.setBounds(200, 230, 150, 30);
        add(tsalary);
        
        JLabel lphone = new JLabel("PHONE");        //text phone
        lphone.setBounds(60, 280, 120, 30);
        lphone.setFont(new Font("Tohoma", Font.PLAIN,17));
        add(lphone);
        
        tphone = new JTextField();           //display phone
        tphone.setBounds(200, 280, 150, 30);
        tphone.setFont(new Font("Tohona", Font.PLAIN, 17));
        add(tphone);
        
        JLabel lemail = new JLabel("EMAIL");      //text email
        lemail.setBounds(60, 330, 120, 30);
        lemail.setFont(new Font("Tohona", Font.PLAIN, 17));
        add(lemail);
        
        temail = new JTextField();          //display email
        temail.setBounds(200, 330, 150, 30);
        add(temail);
        
        JLabel laadhar = new JLabel("AADHAR");      //text aadhar
        laadhar.setBounds(60, 380, 120, 30);
        laadhar.setFont(new Font("Tohona", Font.PLAIN, 17));
        add(laadhar);
        
        taadhar = new JTextField();          //display aadhar 
        taadhar.setBounds(200, 380, 150, 30);
        add(taadhar);
        
        JLabel lexperience = new JLabel("EXPERIENCE");      //text experience
        lexperience.setBounds(60, 430, 120 ,30);
        lexperience.setFont(new Font("Tohona", Font.PLAIN, 17));
        add(lexperience);
        
        texperience = new JTextField();
        texperience.setBounds(200, 430, 150, 30);
        add(texperience);
        
        bsubmit = new JButton("SUBMIT");     //displau submit button
        bsubmit.setBounds(200, 480,  100, 30);
        bsubmit.setBackground(Color.WHITE);
        bsubmit.setForeground(Color.BLACK);
        bsubmit.addActionListener(this);
        add(bsubmit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60 , 450, 370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(350, 200 ,850, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tname.getText();
        String age = tage.getText();
        String salary = tsalary.getText();
        String phone = tphone.getText();
        String email = temail.getText();
        String aadhar = taadhar.getText();
        String experience = texperience.getText();
        
        if(name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name not present");
            return;
        }
        
        if(age.equals("")) {
            JOptionPane.showMessageDialog(null,"Age not present");
            return;
        }
        
        if(experience.equals("")) {
            JOptionPane.showMessageDialog(null,"Experience not present");
            return;
        }
        
        if(aadhar.equals("")) {
            JOptionPane.showMessageDialog(null,"Aadhar not present");
            return;
        }
        
        if(salary.equals("")) {
            JOptionPane.showMessageDialog(null,"Salary not present");
            return;
        }
        
        if(phone.equals("")) {
            JOptionPane.showMessageDialog(null,"Phone not present");
            return;
        }
        
        String gender = null;
        
        if(rmale.isSelected()) {
            gender = "MALE";
        } else if(rfemale.isSelected()){
            gender = "FEMALE";
        }
        
        String job = (String)tjob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query5 = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"' , '"+experience+"')";
            
            conn.s.executeUpdate(query5);       // whem weinsert inthe sql
            
            JOptionPane.showMessageDialog(null, "Emplyee Added Sucessfully");
            
            setVisible(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
    
}
