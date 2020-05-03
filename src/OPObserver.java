/*
* OPObserver - Interface for the observer in the Observer Pattern
*/
public interface OPObserver {
	 boolean registerObserver(OPObserver customer, int initBalance);
	 boolean unregisterObserver(OPObserver customer);
	 void notifyObserver();
}