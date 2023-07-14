package OOP.ExampleGame.src;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Canvas;
import java.awt.Color;


public class Test {
    public static void main(String[] args) {
        JFrame window = new JFrame("Test Window");
        JTextField title = new JTextField("Title");
        Canvas canvas = new Canvas();
        
        canvas.setBackground(Color.BLACK);
        
        title.setEditable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(canvas, 0);
        
        window.setSize(1920, 1080);
        window.setVisible(true);

        System.setProperty("sun.awt.noerasebackground", "true");
        //new Universe();
    


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
