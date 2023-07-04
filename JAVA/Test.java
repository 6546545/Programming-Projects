import OOP.Planet;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

public class Test {
    public static void main(String[] args) {
        JFrame window = new JFrame("Test Window");
        JTextField title = new JTextField("Title");
        //title.setLocation(window.getWidth()-(0.5 * window.getWidth()), window.getHeight()-(0.5 * window.getHeight()));
        title.setEditable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(title, 0);
        window.setSize(1920, 1080);
        window.setVisible(true);


    


        Planet x= new Planet();

        x.setGasGiant(false);
        x.setHasAtmosphere(true);
        x.setName("Planet X");
        x.setType("Rocky");
        x.setGravity(-9.81);

        System.out.println(x.getGravity());
        System.out.println(x.getName());
    }
}
