package Core;
import javax.swing.JFrame;

public class Window extends JFrame {
    private int w;
    private int h;

    public Window(int width, int height){
        w = width;
        h = height;
    }
    
    public void setUpGUI(){
        setSize(w, h);
        setTitle("Test Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
