import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5444/test1";
        String username = "postgres";
        String password = "postgres";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Qosuldu. GETDIK!");
        } catch (SQLException e) {
            System.err.println("Qosulmadi!");
            e.printStackTrace();
        }
    }
}
