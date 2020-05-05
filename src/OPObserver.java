/*
* OPObserver - Interface for the observer in the Observer Pattern
*/
public interface OPObserver {
	 void update1(); //update the current available stock
	 void update2(); //clear securities account of this Observer
	 boolean equals(OPObserver other);
	 String getName();
}
