import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
    /*
    *  Class for signing in a user
    * */
public class SignIn extends JFrame implements ActionListener
{
	//Swing things
	private static JPanel panel;
	private static JLabel welcome;
	private static JLabel userlabel;
	private static JLabel passlabel;
	private static JTextField userText;
	private static JPasswordField passText;
	private static JButton button;
	
    // No-arg constructor to construct an instance of JFrame
    public SignIn () 
    {

    }

    public void initializeframe() {

        setTitle( "Sign In" );
        setSize( 500, 500 );
        setLocation( 400, 100 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //create a panel
        panel= new JPanel();
        add(panel);
        panel.setLayout(null);

        //Add welcome text
        welcome= new JLabel("Welcome to our Bank, Please sign in!");
        panel.add(welcome);


        //Create label and textbox for username
        userlabel= new JLabel("Username:");
        userlabel.setBounds(10, 20, 80, 25);
        panel.add(userlabel);

        userText= new JTextField();
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        //Create label and textbox for password
        passlabel= new JLabel("Password:");
        passlabel.setBounds(10, 50, 80, 25);
        panel.add(passlabel);

        passText= new JPasswordField();
        passText.setBounds(100, 50, 165, 25);
        panel.add(passText);

        //Create button
        button= new JButton("Sign up");
        button.setBounds(10, 80, 80, 25);
        panel.add(button);
        button.addActionListener(new SignIn());
    }

    //just for testing purposes
    public static void main( String[] args ) 
    {
    	SignIn si= new SignIn();
    	si.initializeframe();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
        setVisible( true );
		String username= userText.getText();
		String password= passText.getText();
		
		//check if user exists in database already
		if (!username.equals("") && !password.equals(""))
		{
			//make customer object
			Customer c1= new Customer();
			System.out.println("You have successfully signed in!");
			
			//alert listener
			//give customer to ATM
			
		}
		else {
		System.out.println("Incorrect input, please try again");
		}
		
	}
}