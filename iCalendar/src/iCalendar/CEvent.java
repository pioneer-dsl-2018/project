package iCalendar;


import java.util.GregorianCalendar;


import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.component.VEvent;

public class CEvent extends VEvent{
	
 	private VEvent result;
 
	java.util.Calendar cal = new GregorianCalendar();
	

	public CEvent(String startDate, String endDate, String description) {
		super(new DateTime(new Date(new dateTime(startDate).getTime())), new DateTime(new Date(new dateTime(endDate).getTime())), description);
		
	}
	
	public CEvent(int month, int day, int year, int sHour, int sMin, int eHour, int eMin, String description) {
		super(new DateTime(new DT(year, month, day, sHour, sMin).getDT()), new DateTime(new DT(year, month, day, eHour, eMin).getDT()), description);
	}

	public CEvent(DateTime startDT, DateTime endDT, String description) {
		
		super(startDT, endDT, description);
		
	}
	
	public CEvent(String date, String description) {
		super(new Date(new date(date).getTime()), description);
	}

}
