package CFD_Web;

public class Mesh {
    private int i_min, i_max;
    private int j_min, j_max;
    private int width, height;
    private int lx, ly;

    private double[][] x_iMax,y_jMax, x_m, y_m, x_i, y_j;

    public Mesh(){
        i_min = 2;
        j_min = 2;
        width = 0;
        height = 0;
        i_max = i_min + width - 1;
        j_max = j_min + height - 1;

        lx = 10;
        ly = 10;
        

        x_i = new double[i_min][i_max+1];
        y_j = new double[j_min][j_max+1];
        x_m = new double[i_min][i_max];
        y_m = new double[j_min][j_min];


        for (int i = 0; i < width+1; i+= (lx-i_min / (width+1))){
            
        }

    }






    public int getI_min() {
        return i_min;
    }
    public void setI_min(int i_min) {
        this.i_min = i_min;
    }
    public int getI_max() {
        return i_max;
    }
    public void setI_max(int i_max) {
        this.i_max = i_max;
    }
    public int getJ_min() {
        return j_min;
    }
    public void setJ_min(int j_min) {
        this.j_min = j_min;
    }
    public int getJ_max() {
        return j_max;
    }
    public void setJ_max(int j_max) {
        this.j_max = j_max;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

 
}
