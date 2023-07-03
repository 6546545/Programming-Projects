package OOP;

public class SpaceBody {
    private String type;
    private String name;
    private int bodySize;
    private double gravity;

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
    public int getBodySize() {
        return bodySize;
    }
    public void setBodySize(int bodySize) {
        this.bodySize = bodySize;
    }
    public double getGravity() {
        return gravity;
    }
    public void setGravity(long gravity) {
        this.gravity = gravity;
    }


}
