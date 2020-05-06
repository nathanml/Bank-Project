import java.sql.SQLException;

/*
* OPObserver - Interface for the observer in the Observer Pattern
*/
public interface OPSubject {
	boolean registerObserver(OPObserver customer);
	boolean unregisterObserver(OPObserver customer) throws SQLException;
	void notifyObserver();
}
