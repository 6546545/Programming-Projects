import java.awt.Menu;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Application {
    public static void main(String[] args) {
        JFrame window = new JFrame("Incident Management System");
        JMenu  startMenu = new JMenu("null", true);

        window.add(startMenu, 0);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setVisible(true);
    }
}
