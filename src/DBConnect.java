import java.sql.*;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class DBConnect {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        } catch (Exception ex) {
            // handle the error
        }

        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/bankdb",
                            "root", "password");

            Statement stmt = conn.createStatement ();
            ResultSet Res = stmt.executeQuery ("s");
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}