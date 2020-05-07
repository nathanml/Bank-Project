import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CheckTransaction extends JFrame implements ActionListener {

    //Swing things
    private static JPanel panel;
    private static JTextField yearText;
    private static JTextField monthText;
    private static JTextField dayText;
    private static JTable transactions;
    private static JButton submit;

    //Time variables
    private Date date = new Date();
    private LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    public CheckTransaction()
    {
        panel = new JPanel ();
        add (panel);
        setTitle ("View Transactions");
        setSize (500, 500);
        setLocation (400, 100);

        yearText = new JTextField ("Enter a year");
        //yearText.setBounds(10, 80, 80, 25);
        panel.add(yearText);

        monthText = new JTextField ("Enter a month");
        //monthText.setBounds(10, 110, 80, 25);
        panel.add(monthText);

        dayText = new JTextField ("Enter a day");
        panel.add(dayText);

        submit = new JButton ("Submit");
        panel.add(submit);
        submit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int d = Integer.parseInt (dayText.getText ());
        int m = Integer.parseInt (monthText.getText ());;
        int y = Integer.parseInt (yearText.getText ());
        ResultSet rsTransactions = null;
        try {
            rsTransactions = DBConnect.getTransactions(d,m,y);
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        if(transactions == null) panel.add(new JLabel ("No transactions from that date"));
        else {
            transactions = ManagerPortal.generateTable (rsTransactions);
            panel.add(transactions);
        }

    }
}
