import java.sql.*;

public class DatabaseRetrieval {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/testdb";

        String username = "root";
        String password = "root";

        String query =
                "SELECT id, name, email FROM users";

        try {

            // Step 1: Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection con =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            System.out.println(
                    "Database connected successfully.\n"
            );

            // Step 3: Create PreparedStatement
            PreparedStatement ps =
                    con.prepareStatement(query);

            // Step 4: Execute SQL query
            ResultSet rs = ps.executeQuery();

            // Step 5: Process ResultSet
            System.out.println("USER DETAILS");
            System.out.println("============");

            boolean found = false;

            while (rs.next()) {

                found = true;

                int id =
                        rs.getInt("id");

                String name =
                        rs.getString("name");

                String email =
                        rs.getString("email");

                // Step 6: Display retrieved data
                System.out.println("ID    : " + id);
                System.out.println("Name  : " + name);
                System.out.println("Email : " + email);
                System.out.println("--------------------");
            }

            if (!found) {
                System.out.println("No records found.");
            }

            // Step 7: Close resources
            rs.close();
            ps.close();
            con.close();

            System.out.println(
                    "\nDatabase connection closed."
            );

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "JDBC Driver not found."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: "
                    + e.getMessage()
            );
        }
    }
}