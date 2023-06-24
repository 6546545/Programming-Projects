/**
 * User
 */
public class User {
    private int id;
    private String name, email, country;

    public User() {
        
    }
    public User(String nameString, String emailString, String countryString){


    }
    public User(int id, String nameString, String emailString, String countryString){
        
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }    
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    





}