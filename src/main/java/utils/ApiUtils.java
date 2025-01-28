package utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;
public class ApiUtils {
    private static final String API_URL = "https://parabank.parasoft.com/parabank/services/bank/openapi.yaml";

    public static String[] getRandomUserFromApi() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                List<User> users = mapper.readValue(connection.getInputStream(),
                        mapper.getTypeFactory().constructCollectionType(List.class, User.class));

                // Retrieve a random user
                int randomIndex = new Random().nextInt(users.size());
                User selectedUser = users.get(randomIndex);
                return new String[]{selectedUser.getUsername(), selectedUser.getPassword()};
            } else {
                throw new RuntimeException("Failed to fetch users: " + connection.getResponseMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"", ""}; // Return empty credentials in case of error
        }
    }

    // Helper class for mapping API response
    private static class User {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
