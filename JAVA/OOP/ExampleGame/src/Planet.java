package OOP.ExampleGame.src;
//import java.awt.Graphics2D;
//import java.awt.Canvas;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

//SpaceBody Class ---> Planet Class

public class Planet extends SpaceBody{
  
    private boolean hasAtmosphere;
    private boolean isGasGiant;
    //List of Atmospheric components: Gas types
    private List<String> atmoshpere;

    //Lists of plants, animals, and moons for each planet
    private List<Object> plants;
    private List<Object> animals;
    private List<Object> moons;
    private boolean hasOcean;
    private Object planetModel;
    private Shape planetShape;

    public Planet(){
        //@TODO
        planetShape = new Ellipse2D.Double(100,100,100,100);
    }

    /**
     * @return planetShape
     */
    public Shape getShape(){
        return planetShape;
    }

    public boolean isHasOcean() {
        return hasOcean;
    }

    public void setHasOcean(boolean hasOcean) {
        this.hasOcean = hasOcean;
    }

    public Object getPlanetModel() {
        return planetModel;
    }

    public void setPlanetModel(Object planetModel) {
        this.planetModel = planetModel;
    }

     public boolean isGasGiant() {
        return isGasGiant;
    }

    public void setGasGiant(boolean isGasGiant) {
        this.isGasGiant = isGasGiant;
    }

    public boolean isHasAtmosphere() {
        return hasAtmosphere;
    }

    public void setHasAtmosphere(boolean hasAtmosphere) {
        this.hasAtmosphere = hasAtmosphere;
    }

    public List<String> getAtmoshpere() {
        return atmoshpere;
    }

    public void setAtmoshpere(List<String> atmoshpere) {
        this.atmoshpere = atmoshpere;
    }

    public List<Object> getPlants() {
        return plants;
    }

    public void setPlants(List<Object> plants) {
        this.plants = plants;
    }

    public List<Object> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Object> animals) {
        this.animals = animals;
    }

    public List<Object> getMoons() {
        return moons;
    }

    public void setMoons(List<Object> moons) {
        this.moons = moons;
    }

}
