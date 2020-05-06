import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;


public class ManagerPortal extends JFrame implements ActionListener {
	private BankManager bm;
	public static String[] options = {"", "Check on Customer", "Transactions", "Loan"};
	public static JComboBox cbList = new JComboBox(options);
	JLabel text = new JLabel("Welcome to the Manager Portal");
	JPanel panel = new JPanel();
	JButton update;
	JTextField clientname;
	
    /*
    * Class for the bank manager's portal
    * */
    public ManagerPortal(BankManager bankmanager) {
    	super("Manager Portal");
    	bm = bankmanager;
    	setSize(500, 600);
    	setLocation(400, 100);
    	setResizable(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    	cbList.addActionListener(this);
    	panel.add(cbList);
    	panel.add(text);
    	add(panel);
    	setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	if (e.getSource() == cbList) 
    	{
    		JComboBox cb = (JComboBox) e.getSource();
    		String msg = (String)cb.getSelectedItem();
    		switch (msg) 
    		{
    		case "Check on Customer": 
    			JOptionPane.showMessageDialog(panel, "You will be directed to the check customer page.");
    			CheckCustomer check = new CheckCustomer();
    			check.setVisible(true);
    			break;
    		case "Transactions":
    			JOptionPane.showMessageDialog(panel, "You will be directed to the Transactions.");
    			CheckTransaction t = new CheckTransaction ();
    			t.setVisible(true);
    			break;
    		case "Loan":
    			JOptionPane.showMessageDialog(panel, "You will be directed to the Loan Portal.");
    			LoanMPortal loan = new LoanMPortal();
    			loan.setVisible(true);
    			break;
    		default: 
    			break;
    		}
    	}
    }

    public static void generateTable(ResultSet rs, JTable t)
	{
		try {
			ResultSetMetaData metaData = rs.getMetaData ();
			int numberOfColumns = metaData.getColumnCount ();
			Vector columnNames = new Vector ();

			// Get the column names
			for (int column = 0; column < numberOfColumns; column++) {
				columnNames.addElement (metaData.getColumnLabel (column + 1));
			}

			// Get all rows.
			Vector rows = new Vector ();

			while (rs.next ()) {
				Vector newRow = new Vector ();

				for (int i = 1; i <= numberOfColumns; i++) {
					newRow.addElement (rs.getObject (i));
				}

				rows.addElement (newRow);
			}
			t = new JTable (rows, columnNames);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}


    public static void main(String[] args) 
    {
    	BankManager bm = new BankManager("username", "password");
    	ManagerPortal mp = new ManagerPortal(bm);
    }
}
