package iCalendar;


import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;

public class CEvent extends VEvent{
	
	VEvent result;

	public CEvent(String startDate, String endDate, String description) {
		super(new Date(new dateTime(startDate).getTime()), new Date(new dateTime(endDate).getTime()), description);
	
	}

}
