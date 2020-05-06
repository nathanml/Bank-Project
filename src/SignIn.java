import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
    /*
    *  Class for signing in a user
    * */
public class SignIn extends JFrame implements ActionListener
{
	//Swing things
	protected static JPanel panel;
	protected static JLabel welcome;
	protected static JLabel fnamelabel;
	protected static JLabel lnamelabel;
	protected static JLabel userlabel;
	protected static JLabel passlabel;
	protected static JTextField fnameText;
	protected static JTextField lnameText;
	protected static JTextField userText;
	protected static JPasswordField passText;
	protected static JButton button;
	
    // No-arg constructor to construct an instance of JFrame
    public SignIn () 
    {

    }

    public void initializeframe() {
        setTitle( "Sign up" );
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //create a panel
        panel= new JPanel();
        add(panel);
        panel.setLayout(null);

        //Add welcome text
        welcome= new JLabel("Welcome to our Bank, Please sign up!");
        panel.add(welcome);

        //Create label and textbox for first name
        fnamelabel= new JLabel("First Name:");
        fnamelabel.setBounds(10, 20, 80, 25);
        panel.add(fnamelabel);

        fnameText= new JTextField();
        fnameText.setBounds(100, 20, 165, 25);
        panel.add(fnameText);

        //Create label and textbox for last name
        lnamelabel= new JLabel("Last Name:");
        lnamelabel.setBounds(10, 50, 80, 25);
        panel.add(lnamelabel);

        lnameText= new JTextField();
        lnameText.setBounds(100, 50, 165, 25);
        panel.add(lnameText);

        //Create label and textbox for username
        userlabel= new JLabel("Username:");
        userlabel.setBounds(10, 80, 80, 25);
        panel.add(userlabel);

        userText= new JTextField();
        userText.setBounds(100,80,165,25);
        panel.add(userText);

        //Create label and textbox for password
        passlabel= new JLabel("Password:");
        passlabel.setBounds(10, 110, 80, 25);
        panel.add(passlabel);

        passText= new JPasswordField();
        passText.setBounds(100, 110, 165, 25);
        panel.add(passText);

        //Create button
        button= new JButton("Sign up");
        button.setBounds(10, 140, 80, 25);
        panel.add(button);
        button.addActionListener(new SignInListener());
    }

    private class SignInListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstname= fnameText.getText();
            String lastname= lnameText.getText();
            String username= userText.getText();
            String password= passText.getText();

            try {
                if(DBConnect.hasUsername(username))
                {
                    JOptionPane.showMessageDialog(panel,"That username is already in use. Please try a different one.");
                }
                else if (!username.equals("") && !password.equals(""))
                {
                    //add user to database
                    try {
                        Customer c1= new Customer(firstname, lastname, username, password);
                        ATM atm = new ATM(c1);
                        atm.initialize ();
                    } catch (SQLException ex) {
                        ex.printStackTrace ();
                    }
                    System.out.println("You have successfully signed up!");

                    //alert listener
                }
                else {
                    JOptionPane.showMessageDialog(panel,"Invalid input. Please try a different one.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace ();
            }
        }
    }
    //just for testing purposes
    public static void main( String[] args ) 
    {
    	//SignIn si= new SignIn();
    	//si.initializeframe();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
        setVisible( true );
	}
}