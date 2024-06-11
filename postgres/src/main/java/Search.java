import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Search {
    public void searchName(int p_id) {
        String url = "jdbc:postgresql://localhost:5444/test1";
        String username = "postgres";
        String password = "postgres";
        String searchNm = "SELECT username, password FROM users WHERE id = " + p_id;
            try (Connection connection = DriverManager.getConnection(url, username, password);
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(searchNm);
                while (resultSet.next()) {
                    String usernm = resultSet.getString("username");
                    String pass = resultSet.getString("password");
                    System.out.println("Username: " + usernm + ", Password: " + pass);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        Search search = new Search();
        search.searchName(2);
    }
}