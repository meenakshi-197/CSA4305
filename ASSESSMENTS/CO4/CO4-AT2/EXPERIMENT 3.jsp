<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>

<head>
    <title>JSP Request Response</title>
</head>

<body>

<h2>User Details</h2>

<%
    // Step 1: Receive request from client
    String userId = request.getParameter("id");

    if (userId == null || userId.trim().isEmpty()) {

        out.println("<p>Please provide User ID.</p>");

    } else {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            // Step 2: Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish database connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "root"
            );

            // Step 4: Prepare SQL query
            String sql =
                    "SELECT id, name, email FROM users WHERE id = ?";

            ps = con.prepareStatement(sql);

            // Step 5: Set parameter
            ps.setInt(1, Integer.parseInt(userId));

            // Step 6: Execute query
            rs = ps.executeQuery();

            // Step 7: Generate dynamic response
            if (rs.next()) {

                out.println("<h3>User Information</h3>");

                out.println("<p>ID: "
                        + rs.getInt("id")
                        + "</p>");

                out.println("<p>Name: "
                        + rs.getString("name")
                        + "</p>");

                out.println("<p>Email: "
                        + rs.getString("email")
                        + "</p>");

            } else {

                out.println("<p>User not found.</p>");
            }

        } catch (Exception e) {

            out.println("<p>Error: "
                    + e.getMessage()
                    + "</p>");

        } finally {

            // Step 8: Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                out.println("<p>Closing error.</p>");
            }
        }
    }
%>

</body>
</html>