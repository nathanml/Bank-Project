/*
* OPObserver - Interface for the observer in the Observer Pattern
*/
public interface OPObserver {
	 String update1();
	 void update2();
	 boolean equals(OPObserver other);
	 String getName();
}
