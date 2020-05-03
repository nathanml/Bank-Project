import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame implements ActionListener{

    private static JPanel panel;
    public Welcome()
    {
        panel = new JPanel ();
        //panel.setLayout(null);
        add(panel);
        setTitle ("Welcome");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        JLabel text = new JLabel("Welcome to our bank!");
        //text.setLocation (5,200);
        panel.add(text);
        JButton signIn = new JButton ("Sign In");
        signIn.setBounds(10, 20, 400, 25);
        panel.add(signIn);
        JButton signUp = new JButton ("Don't have an account? Sign Up");
        signUp.setBounds(10, 40, 400, 25);
        panel.add(signUp);
        JButton managerSignIn = new JButton ("Manager Portal");
        managerSignIn.setBounds(1000, 1000, 200, 25);
        panel.add(managerSignIn);

        SignIn signInL = new SignIn ();
        signInL.initializeframe ();
        signIn.addActionListener(signInL);

        SignUp signUpL = new SignUp ();
        signUpL.initializeframe ();
        signUp.addActionListener(signUpL);

        ActionListener managerL = new ManagerSignIn ();
        managerSignIn.addActionListener(managerL);

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible (true);
        panel.setVisible( true );
    }

    public static void main(String[] args)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
