import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class DBConnect {
    public static Connection conn;

    public static void establishConnection()
    {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        } catch (Exception ex) {
            // handle the error
        }

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://bank591.cblwfdq4pfu2.us-east-1.rds.amazonaws.com",
                            "admin", "password");
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void addCustomer(int customerID, String firstName, String lastName, String username, String password)
            throws SQLException
    {
        establishConnection ();
        Statement s = conn.createStatement ();
        s.executeQuery ("USE bankdb");
        s.executeUpdate ("INSERT INTO customers VALUES (" + customerID + ", '" + firstName + "', '" + lastName +
                "' , '" + username + "','" + password + "');");
    }

    public static void addAccount(int accountID, String name, int id, double balanceEuro, double balancePound,
                                  double balanceUSD, double balanceYen, String type) throws SQLException
    {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("INSERT INTO ACCOUNTS VALUES (" + accountID + ", " + name + ", " + id + "," + balanceEuro +
                "," + balancePound + "," + balanceUSD + "," + balanceYen + "," + type);
    }

    public static void addTransaction(int transactionID, String memo, LocalDate date, int id, double amountEuro,
                                      double amountPound, double amountUSD, double amountYen) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("INSERT INTO TRANSACTIONS VALUES (" + transactionID + ", " + memo + ", " + date + "," + id +
                "," + amountEuro + "," + amountPound + "," + amountUSD + "," + amountYen);
    }

    public static void addLoan(int loanID, String name, Clock dueDate, String collateral, double interestRate, int id,
                               double amountEuro, double amountPound, double amountUSD, double amountYen) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("INSERT INTO LOANS VALUES (" + loanID + ", " + name + ", " + dueDate + "," + collateral +
                "," + interestRate + "," + id + "," + amountEuro + "," + amountPound + ","+ amountUSD + "," + amountYen);
    }

    public static void main(String[] args) {

    }

    public static void addStock(int stockID, String name, int id, double valueEuro, double valuePound, double valueUSD,
                                double valueYen) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("INSERT INTO STOCKS VALUES (" + stockID + ", " + name + ", " + id + "," + valueEuro +
                "," + valuePound + ","+ valueUSD + "," + valueYen);
    }

    public static boolean hasUsername(String username) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from customers where username= '" + username + "'";
        ResultSet rs=s.executeQuery(sql_res);
        return (rs.next ());
    }
}