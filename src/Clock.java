/*
* Clock specifies time to Date. 
*/
public class Clock implements Comparable<Clock> {
	private int Date;
	private int Month;
	private int Year;

	public Clock(int date, int month, int year) {
		setClock(date, month, year);
	}
	/*
	* return 1 if this is later than other, 0 if they are the same
	* and -1 if this is earlier than other
	*/
	public int compareTo(Clock other) {
		int value = -1;
		if (Year > other.getYear()) {
			value = 1;
		} else if (Year == other.getYear()) {
			if (Month > other.getMonth()) {
				value = 1;
			} else if (Month == other.getMonth()) {
				if (Date > other.getDate()) {
					value = 1;
				} else if (Date == other.getDate()) {
					value = 0;
				}
			}
		}
		return value;
	}

	/*
	* Return the number of days difference between the two Clock 
	* this must be ahead of other, only returns a positive int, 
	* takes a month as 30 days, a year as 365 days.
	*/
	public int dayDifference(Clock other) {
		int dayDiff = 0;
		if (Year > other.getYear()) {
			dayDiff += (Year - other.getYear()) * 365;
		} else if (Year == other.getYear()) {
			if (Month > other.getMonth()) {
				dayDiff += (Month - other.getMonth()) * 30;
			} else if (Month == other.getMonth()) {
				if (Date > other.getDate()) {
					dayDiff += (Date - other.getDate());
				} 
			}
		}
		return dayDiff;
	}

	public boolean setClock(int d, int m, int y) {
		boolean set = false;
		if (((0 < d) && (d < 32)) && ((0<m) && (m<13)) && (0 < y)) {
			Date = d;
			Month = m;
			Year = y;
			set = true;
		}
		return set;
	}

	public boolean setToFuture(int d, int m, int y) {
		boolean set = false;
		if ((y >= Year) && (m >= Year) && (d >= Date)) {
			set = setClock(d, m, y);
		}
		return set;
	}
	public int getYear() {
		return Year;
	}
	
	public int getMonth() {
		return Month;
	}
	
	public int getDate() {
		return Date;
	}

    public static void main(String[] args)
    {

    }
}
