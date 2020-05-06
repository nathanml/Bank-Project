import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeMPortal extends JFrame implements ActionListener {
    private static JPanel panel;
    private static JTable loans;
    private static JButton update;
    private static JTextField monthf;
    private static JTextField dayf;
    private static JTextField yearf;
    private static Clock clock;

    public TimeMPortal()
    {
        setTitle("Change Time");
        setSize( 500, 500 );
        setLocation( 400, 100 );
        clock= Bank.getCurrentTime();
        
        JLabel text = new JLabel("The current time is "+ clock.toString());
        JLabel monthtext = new JLabel("Enter the month:");
        JLabel daytext = new JLabel("Enter the day:");
        JLabel yeartext = new JLabel("Enter the year:");
        monthf= new JTextField();
        dayf= new JTextField();
        yearf= new JTextField();
        panel = new JPanel();
        panel.setLayout(new GridLayout(10,1));
        update = new JButton ("Update");
        update.addActionListener (this);
        
        add(panel);
        panel.add(text);
        panel.add(monthtext);
        panel.add(monthf);
        panel.add(daytext);
        panel.add(dayf);
        panel.add(yeartext);
        panel.add(yearf);
        panel.add(update);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int month= Integer.parseInt(monthf.getText());
        int day= Integer.parseInt(dayf.getText());
        int year= Integer.parseInt(yearf.getText());
        clock.setClock(day, month, year);
        
        //go back
        ManagerPortal mp = new ManagerPortal(Main.bm);
    }
    
}
