import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
    /*
    *  Class for signing in a manager, extends signin
    * */
public class ManagerSignIn extends SignIn
{

    // No-arg constructor to construct an instance of JFrame
    public ManagerSignIn()
    {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible( true );
    }

    //just for testing purposes
    public static void main( String[] args ) 
    {
        //ManagerSignIn si= new ManagerSignIn();
        //si.initializeframe();
    }
   
}