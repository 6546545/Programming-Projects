import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO<User> {
    private String userURL;
    private String userName;
    private String userPassword;

    private static final String INSERT_USER_SQL = "";
    private static final String SELECT_USER_BY_ID = "";
    private static final String SELECT_ALL_USERS = "";
    private static final String DELETE_USERS_SQL = "";
    private static final String UPDATE_USERS_SQL = "";


    public UserDAO(){

    }
    private Connection getConnection(){
        Connection connection = null;
        return connection;
    }
    public void isertUser(User user) {
        
    } 
    public User selectUser(int i) {
        return null;
        
    }
    public List<User> selectAllUsers(){
        return null;

    }
    public boolean deleteUser(int i) {
        return false;
        
    }
    public boolean updateUser(User user) {
        return false;
        
    }
    private static void printSQLException(SQLException sqlex) {
        
    }
}
