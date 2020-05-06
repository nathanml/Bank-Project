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
        button= new JButton("Sign in");
        button.setBounds(10, 140, 80, 25);
        panel.add(button);
        button.addActionListener(new SignInListener());
    }

    private class SignInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = userText.getText ();
            String password = passText.getText ();

            //check if user exists in database already
            if (!username.equals ("") && !password.equals ("")) {
                try {
                    if (DBConnect.hasUsername (username) && password.equals (DBConnect.getPassword (username))) {
                        Customer c = DBConnect.getCustomer (username);
                        ATM atm = new ATM (c);
                        atm.initialize ();
                    } else {
                        panel.add (new JLabel ("Incorrect username or password."));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace ();
                }
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