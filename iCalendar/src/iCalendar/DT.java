package iCalendar;

import java.util.Date;
import java.util.GregorianCalendar;

public class DT {

	private java.util.Calendar cal = new GregorianCalendar();
	
	
	public DT(int month, int day, int year, int hour, int min) {	    
			
		cal.clear();	
		cal.set(year, month, day, hour, min);
	}
	
	public Date getDT() {
		
		return cal.getTime();
	}

}
