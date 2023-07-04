package OOP;

//import java.util.Vector;

public class SpaceBody {

    private String type;
    private String name;
    //Random seed gets generated to make procedurally generated objects. Seed needs to be generated from algorithms
    //Differs in usage among child classes
    private Long randSeed;

    //Differs in usage among child classes
    private int bodySize;

    private double gravity;
    //private Vector gravVector;

    public SpaceBody(){
        type = "";
        name = "";
        bodySize = 1;
        gravity = 1.0;
    }

    public SpaceBody(String typeString, String nameString, int size, double grav){
        type = typeString;
        name = nameString;
        bodySize = size;
        gravity = grav;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getRandSeed(){
        return randSeed;
    }
    public void setRandSeed(Long seed){
        this.randSeed = seed;
    }


    public int getBodySize() {
        return bodySize;
    }
    public void setBodySize(int bodySize) {
        this.bodySize = bodySize;
    }
    public double getGravity() {
        return gravity;
    }
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }


}
