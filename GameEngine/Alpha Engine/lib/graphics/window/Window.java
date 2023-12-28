import java.awt.*;
import javax.swing.*;

/**
 * Window
 */
public class Window {

    private static void CreateWindow(){
        JFrame frame = new JFrame("Alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}