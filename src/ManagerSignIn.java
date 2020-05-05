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
        String username= userText.getText();
        String password= passText.getText();

<<<<<<< HEAD
        if (!username.equals("") && !password.equals(""))
=======
        if (username.equals(Bank.getBankManager().getUsername()) && password.equals(Bank.getBankManager().getPassword()))
>>>>>>> b5f9293d7db143bc1ebeaca09752084c65cfc913
        {
            System.out.println("HERE");
            if (username.equals(Bank.bankManager.username) && password.equals(Bank.bankManager.password))
            {
                ManagerPortal p = new ManagerPortal ();
            }
            else {
                panel.add(new JLabel ("Incorrect username or password. Try again"));
            }

        }
    }

    //just for testing purposes
    public static void main( String[] args ) 
    {
        //ManagerSignIn si= new ManagerSignIn();
        //si.initializeframe();
    }
   
}