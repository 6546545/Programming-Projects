
import java.awt.*;
import javax.swing.*;

/**
 * Window
 */
public class Window {
    //Constructor
    public void CreateWindow(){

        //Create JFrame
        JFrame frame = new JFrame("Alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create Label
        JLabel label = new JLabel("Test", SwingConstants.CENTER);
        
        //Add label to Frame
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Set Location and Visibility
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}