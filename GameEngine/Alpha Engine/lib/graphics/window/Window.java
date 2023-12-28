import java.awt.*;
import javax.swing.*;

/**
 * Window
 */
public class Window {

    public void CreateWindow(){
        JFrame frame = new JFrame("Alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,  0, 500, 500);

        JLabel label = new JLabel("Test", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(300,100));
        frame.getContentPane().add(label, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}