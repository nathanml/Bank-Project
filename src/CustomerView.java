import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerView extends JFrame {
    //Swing things
    private static Customer customer;
    private static JPanel panel;
    private static JLabel customerID;
    private static JLabel username;
    private static JLabel firstname;
    private static JLabel lastname;
    private static JTable accounts;
    private static JTable loans;
    private static JTable stocks;

    public CustomerView(Customer c) throws SQLException {
        panel = new JPanel ();
        add (panel);
        customer = c;
        setTitle (c.getName ());
        setSize (500, 500);
        setLocation (400, 100);

        username = new JLabel ("USERNAME : " + customer.getUsername ());
        firstname = new JLabel ("FIRST NAME : " + customer.getName ());
        lastname = new JLabel ("LAST NAME : " + customer.getLastName ());
        customerID = new JLabel (String.valueOf (customer.getID ()));

        ResultSet rsAccounts = DBConnect.getAccounts (customer.getID ());
        accounts = ManagerPortal.generateTable (rsAccounts);

        ResultSet rsLoans = DBConnect.getLoans (customer.getID ());
        loans = ManagerPortal.generateTable (rsLoans);

        ResultSet rsStocks = DBConnect.getStocks (customer.getID ());
        stocks = ManagerPortal.generateTable (rsStocks);

        panel.add (username);
        panel.add (firstname);
        panel.add (lastname);
        panel.add (customerID);
        if(accounts != null) panel.add (accounts);
        if(loans != null)  panel.add (loans);
        if(stocks != null) panel.add (stocks);
    }

    public static void main() {

    }
}
