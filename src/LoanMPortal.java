import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanMPortal extends JFrame implements ActionListener {
    private static JPanel panel;
    private static JTable loans;
    private static JButton update;

    public LoanMPortal()
    {
        setTitle("ALL LOANS");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        JLabel text = new JLabel("View all loans");
        panel = new JPanel();
        update = new JButton ("Update");
        update.addActionListener (this);
        add(panel);
        panel.add(text);
        panel.add(update);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible (true);
        ResultSet rsLoans = null;
        try {
            rsLoans = DBConnect.viewAllLoans ();
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        ManagerPortal.generateTable (rsLoans, loans);
    }
    
}
