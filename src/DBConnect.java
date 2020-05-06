import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
                                  double balanceUSD, double balanceYen, String type, int d, int m, int y) throws SQLException
    {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        s.executeUpdate ("INSERT INTO accounts VALUES (" + accountID + ", '"+ name + "', "+id+"," + balanceEuro +
                "," + balancePound + "," + balanceUSD + "," + balanceYen + ",'"+type+"'," + d + ","+m+","+y +");");
        System.out.println("ACCOUNT successfully added to DB");
    }

    public static void addTransaction(int transactionID, String memo, LocalDate date, int id, double amountEuro,
                                      double amountPound, double amountUSD, double amountYen) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        s.executeUpdate ("INSERT INTO TRANSACTIONS VALUES (" + transactionID + ", " + memo + ", " + date + "," + id +
                "," + amountEuro + "," + amountPound + "," + amountUSD + "," + amountYen);
    }

    public static void addLoan(int loanID, String name, Clock dueDate, String collateral, double interestRate, int id,
                               double amountEuro, double amountPound, double amountUSD, double amountYen) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        s.executeUpdate ("INSERT INTO LOANS VALUES (" + loanID + ", " + name + ", " + dueDate + "," + collateral +
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

    public static String getPassword(String username) throws SQLException{
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res = "select password from customers where username= '" + username + "'";
        ResultSet rs=s.executeQuery(sql_res);
        return (rs.getString (0));
    }

    public static Customer getCustomer(String username) throws SQLException {
        Customer ret = null;
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from customers where username= '" + username + "'";
        ResultSet rs=s.executeQuery(sql_res);
        try{
            while(rs.next ())
            {
                int ID = rs.getInt (1);
                String firstName = rs.getString ("firstName");
                String lastName = rs.getString ("lastName");
                String password = rs.getString("pass");
                ret = new Customer (ID, firstName, lastName, username, password);
            }
        }finally {
            rs.close ();
        }
        //Create customer from rowv

        //Add checking accounts
        sql_res = "select * from accounts where customerID="+ret.getID () + " AND type = 'Checking'";
        rs = s.executeQuery (sql_res);
        try{
            while(rs.next ())
            {
                int accountID = rs.getInt ("accountID");
                String name = rs.getString ("name");
                double balance = rs.getDouble ("balanceUSD");
                int date = rs.getInt ("date");
                int month = rs.getInt ("month");
                int year = rs.getInt ("year");
                Clock c = new Clock(date,month,year);
                CheckingAccount a = new CheckingAccount (accountID,name,balance,c,ret);
                ret.addCheckingAccount (a);
            }
        }finally {
            rs.close ();
        }

        //Add Savings accounts
        sql_res = "select * from accounts where customerID="+ret.getID () + " AND type = 'Savings'";
        rs = s.executeQuery (sql_res);

        try{
            while(rs.next ())
            {
                int accountID = rs.getInt ("accountID");
                String name = rs.getString ("name");
                double balance = rs.getDouble ("balanceUSD");
                int date = rs.getInt ("date");
                int month = rs.getInt ("month");
                int year = rs.getInt ("year");
                Clock c = new Clock(date,month,year);
                SavingsAccount a = new SavingsAccount (accountID,name,balance,c,ret);
                ret.addSavingsAccount (a);
            }
        }finally {
            rs.close ();
        }

        //Add Securities accounts
        sql_res = "select * from accounts where customerID="+ret.getID () + " AND type = 'Securities'";
        rs = s.executeQuery (sql_res);
        try{
            while(rs.next ())
            {
                int accountID = rs.getInt ("accountID");
                String name = rs.getString ("name");
                double balance = rs.getDouble ("balanceUSD");
                int date = rs.getInt ("date");
                int month = rs.getInt ("month");
                int year = rs.getInt ("year");
                Clock c = new Clock(date,month,year);
                SecuritiesAccount a = new SecuritiesAccount (accountID,name,balance,c,ret);
                ret.addSecuritiesAccount (a);
            }
        }finally {
            rs.close ();
        }
        return ret;
    }

    public static ResultSet getLoans(int id) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from loans where customerID= " + id;
        ResultSet rs=s.executeQuery(sql_res);
        return rs;
    }

    public static ResultSet getStocks(int id) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from stocks where customerID= " + id;
        ResultSet rs=s.executeQuery(sql_res);
        return rs;
    }

    public static ResultSet getTransactions(int d, int m, int y) throws SQLException {
        establishConnection ();
        Statement s= conn. createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from transactions where day= " + d + " AND " + "month = " + m + " AND " + "year = " + y;
        ResultSet rs = s.executeQuery (sql_res);
        return rs;
    }

    public static ResultSet viewAllLoans() throws SQLException {
        establishConnection ();
        Statement s= conn. createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from loans";
        ResultSet rs = s.executeQuery (sql_res);
        return rs;
    }

    public static ResultSet getAccounts(int id) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from accounts where customerID= " + id + ";";
        ResultSet rs=s.executeQuery(sql_res);
        return rs;
    }

    public static ResultSet getCheckingAccounts(int id) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from accounts where customerID = " + id + " AND type = 'Checking';";
        ResultSet rs=s.executeQuery(sql_res);
        return rs;
    }

    public static ResultSet getSavingsAccounts(int id) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from accounts where customerID= " + id + " AND type = 'Savings';";
        ResultSet rs=s.executeQuery(sql_res);
        return rs;
    }

    public static ResultSet getSecuritiesAccounts(int id) throws SQLException {
        establishConnection ();
        Statement s= conn.createStatement ();
        s.executeQuery ("USE bankdb");
        String sql_res= "select * from accounts where customerID= " + id + " AND type = 'Securities';";
        ResultSet rs=s.executeQuery(sql_res);
        return rs;
    }
}