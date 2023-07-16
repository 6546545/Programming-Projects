
package OOP.ExampleGame.src;
import java.lang.System.Logger;
import java.util.Random;

public abstract class GameLoop {
    protected final Logger logger = Logger.getLogger(this.getClass()); //FIX
    protected volatile GameStatus status;
    protected GameControllor controllor;
    private Thread thread;

    public GameLoop(){
        controllor = new GameControllor();
        status = GameStatus.STOPPED;
    }
    public void run(){
        status = GameStatus.RUNNING;
        thread = new Thread(this::processGameLoop); //FIX
        thread.start();
    }
    public void stop(){
        status = GameStatus.STOPPED;
    }
    public boolean isRunning(){
        return status == GameStatus.RUNNING;
    }
    protected void proccessInput(){
        try {
            int lag = new Random().nextInt(200)+50;
            Thread.sleep(lag);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());  //FIX
        }
    }
    protected void render(){
        int position = controllor.getBulletPosition(); //CHANGE TO Position
    }
    protected abstract void processGameLoop();
}
