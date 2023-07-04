import OOP.Planet;

public class Test {
    public static void main(String[] args) {
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
