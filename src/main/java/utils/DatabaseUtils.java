package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class DatabaseUtils {
    private static final String DB_URL = "jdbc.url=jdbc:hsqldb:hsql://localhost:9002/parabank";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    // Fetch a random registered user
    public static String[] getRandomUser() {
        List<String[]> users = new ArrayList<>();
        String query = "SELECT username, password FROM registered_users";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                users.add(new String[]{username, password});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!users.isEmpty()) {
            int randomIndex = new Random().nextInt(users.size());
            return users.get(randomIndex);
        } else {
            throw new RuntimeException("No users found in the database");
        }
    }
}
