import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQuery  {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5444/test1";
        String username = "postgres";
        String password = "postgres";

        String query = "ALTER TABLE employees ADD COLUMN email VARCHAR(255) UNIQUE\n;"+
                "ALTER TABLE employees ADD COLUMN salary NUMERIC CHECK(salary>0)\n;"+
                "ALTER TABLE ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;\n"+
                "ALTER TABLE employees ALTER COLUMN name SET NOT NULL;";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeQuery(query);
            System.out.println("Tables created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

