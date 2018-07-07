package iCalendar;


import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;

public class CEvent extends VEvent{
	
	VEvent result;
	static java.util.Calendar cal = new GregorianCalendar();

	public CEvent(String startDate, String endDate, String description) {
		super(new Date(new dateTime(startDate).getTime()), new Date(new dateTime(endDate).getTime()), description);
	
	}
	
	public CEvent(int month, int date, int year, int sHour, int sMinute, int eHour, int eMinute, String description) {
		super(new Date(new dateTime(month, date, year, sHour, sMinute).getTime()), new Date(new dateTime(month, date, year, eHour, eMinute).getTime()), description);
	
	}

}
