// The project is Started on 23-Marc-2023 at 4:00 PM

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() // as per the constructer is built on this to make the project{
    {   //setSize(1366,565);     //as per this  command is to set the sizer of the image that we are going to use sstsixe(length,breath);
        //setLocation(100,100);   //to the location of the frame it is with the screen
        
        setBounds(100,100,1366,565);  // we can use it at the place of the setlocation and setsi
        setLayout(null);    //to make the layout theat a serve is giving to us to make it null
                            
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));   // as per this is use to paste the pic in the frame as per by picking the pic and by giving its url
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565); // it need in it the location x, loaction y, length, breath
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMNT SYSTEM");     // this is use to write on to the picture 
        text.setBounds(20, 430 , 1000, 90);            // this is used to were to write the text 
        text.setForeground(Color.WHITE);                         // this is used to change the color of the text of are using 
        text.setFont(new Font("serif", Font.PLAIN, 50));    // this we have use to change the font of the text that we are  using as per to change the size,styleetc
        image.add(text);                                        // this is use to write oo nthe picture otherwiase text will be written below the picture
    
        JButton next = new JButton("NEXT");                     // in this we had made the button to go to the next slide
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font .PLAIN, 24));
        image.add(next);
        
        setVisible(true);     // this is done as per to make the frame visible to the screen
        
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
             try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }       // upto this we had posted the frame as wellas made the first page 
}
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
   
    public static void main(String[] args) {
       new HotelManagementSystem();     //object created 
    }
    
}

