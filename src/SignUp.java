import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
    /*
    *  Class for creating new users
    * */
public class SignUp extends JFrame implements ActionListener
{
	//Swing things
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel welcome;
	private static JLabel userlabel;
	private static JLabel passlabel;
	private static JTextField userText;
	private static JPasswordField passText;
	private static JButton button;
	private static JLabel success;
	
    // No-arg constructor to construct an instance o JFrame
    public SignUp () 
    {
    	//This stuff isnt used, I did it all in main. will change later
	    setTitle( "Sign" );
	    setSize( 500, 500 );
	    setLocation( 400, 100 );
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    setVisible( true );
    }
 
    public static void main( String[] args ) 
    {
    // Create an instance of TestFrame
    //SignUp signupframe = new SignUp();
    // Create an instance of JFrame() explicitly
    frame = new JFrame();
    frame.setTitle( "Sign up" );
    frame.setSize( 500, 500 );
    frame.setLocation( 400, 100 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    //create a panel
    panel= new JPanel();
    frame.add(panel);
    panel.setLayout(null);
    
    //Add welcome text
    welcome= new JLabel("Welcome to our Bank, Please sign up!");
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
    button.addActionListener(new SignUp());
    
    //Check for success
    success= new JLabel("");
    success.setBounds(10, 110, 300, 25);
    panel.add(success);
    //success.setText(text);
    
    
    frame.setVisible( true );
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String username= userText.getText();
		String password= passText.getText();
		if (!username.equals("") && !password.equals(""))
		{
			Customer c1= new Customer(username, password);

		}
		else {
		System.out.println("Incorrect input, please try again");
		}
		
	}
}