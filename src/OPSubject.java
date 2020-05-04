/*
* OPObserver - Interface for the observer in the Observer Pattern
*/
public interface OPSubject {
	boolean registerObserver(OPObserver customer);
	boolean unregisterObserver(OPObserver customer);
	void notifyObserver();
}
