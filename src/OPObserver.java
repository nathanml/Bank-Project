/*
* OPObserver - Interface for the observer in the Observer Pattern
*/
public interface OPObserver {
	 String update();
	 boolean equals(OPObserver other);
	 String getName();
}
