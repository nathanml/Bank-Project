import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ManagerPortal extends JFrame implements ActionListener {
	public static String[] options = {"", "Check on Customer", "Stock", "Loan"};
	public static JComboBox cbList = new JComboBox(options);
	JLabel text = new JLabel("Welcome to the Manager Portal");
	JPanel panel = new JPanel();
	JButton update;
	JTextField clientname;
	
    /*
    * Class for the bank manager's portal
    * */
    public ManagerPortal() {
    	super("Manager Portal");
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
    		case "Stock":
    			JOptionPane.showMessageDialog(panel, "You will be directed to the Stock Portal.");
    			StockMPortal stock = new StockMPortal();
    			stock.setVisible(true);
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
    public static void main(String[] args) 
    {
    	
    }
}
