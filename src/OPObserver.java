import java.sql.SQLException;

/*
* OPObserver - Interface for the observer in the Observer Pattern
*/
public interface OPObserver {
	 void update1(); //update the current available stock
	 void update2() throws SQLException; //clear securities account of this Observer
	 boolean equals(OPObserver other);
	 String getName();
}
