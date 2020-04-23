import javax.swing.*;
    /*
    *  Class for creating new users
    * */
public class SignUp extends JFrame 
{
    // No-arg constructor to construct an instance o JFrame
    public SignUp () {
    setTitle( "Window 1" );
    setSize( 350, 350 );
    setLocation( 200, 100 );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setVisible( true );
 }
 public static void main( String[] args ) 
 {
    // Create an instance of TestFrame
    SignUp tf = new SignUp();
    // Create an instance of JFrame() explicitly


    JFrame frame = new JFrame();
    frame.setTitle( "Sign up" );
    frame.setSize( 500, 500 );
    frame.setLocation( 750, 100 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible( true );

    JPanel panel= new JPanel();
    }
}