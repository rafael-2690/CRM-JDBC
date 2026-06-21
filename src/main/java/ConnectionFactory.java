import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection conection;

    public static void connectionCreate(){
        String url = "jdbc:postgresql://localhost:5432/connection-factory";
        String username = "postgres";
        String password = "postgres";

        try{
            conection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Created");

        }catch(SQLException e){
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }
    public static Connection getConnection(){
        return conection;
    }
}
