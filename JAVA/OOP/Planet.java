package OOP;

import java.util.List;

//SpaceBody Class ---> Planet Class

public class Planet extends SpaceBody{
  
    private boolean hasAtmosphere;
    private boolean isGasGiant;
    private List<String> atmoshpere;

    private List<Object> plants;
    private List<Object> animals;
    private List<Object> moons;

    public Planet(){
        //@TODO 
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
