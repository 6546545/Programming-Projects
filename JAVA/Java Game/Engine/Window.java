package Engine;

import java.lang.Runtime.Version;


public class Window {
    private int w, h;
    private String title;
    private static Window WINDOW = null;

    private Window(){
        this.w = 1920;
        this.h = 1080;
        this.title = "Tile";
    }


    public Window getNeWindow(){
        if (Window.WINDOW == null) {
            Window .WINDOW = new Window();
        }
        return Window.WINDOW;
    }

    public void inti(){
    


    }
    public void loop(){}

    public void run(){
        System.out.println();
        inti();
        loop();
    }
    
}
