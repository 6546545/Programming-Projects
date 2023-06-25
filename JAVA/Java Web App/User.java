/**
 * User
 */
public class User {
    protected int id;
    protected String name, email, country;

    public User(){

    }
    /**
     * @param name
     * @param email
     * @param country
     */
    public User(String name, String email, String country) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
    }

    /**
     * @param id
     * @param name
     * @param email
     * @param country
     */
    public User(int id, String name, String email, String country) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }
    
    /**
     * @return
     */
    public int getId() {
        return id;
    }
    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }    
    /**
     * @return
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    





}