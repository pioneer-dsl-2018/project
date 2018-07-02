package iCalendar;

import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.RRule;

public class Program {
	public static void main(String[] args) throws ParseException {
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		TimeZone timezone = registry.getTimeZone("America/Los_Angeles");
		VTimeZone tz = ((net.fortuna.ical4j.model.TimeZone) timezone).getVTimeZone();

		 // A Block Start Date is on: August 27, 2018, 8:00 am
		java.util.Calendar ABlockSD = new GregorianCalendar();
		ABlockSD.setTimeZone(timezone);
		ABlockSD.set(java.util.Calendar.MONTH, java.util.Calendar.AUGUST);
		ABlockSD.set(java.util.Calendar.DAY_OF_MONTH, 27);
		ABlockSD.set(java.util.Calendar.YEAR, 2018);
		ABlockSD.set(java.util.Calendar.HOUR_OF_DAY, 8);
		ABlockSD.set(java.util.Calendar.MINUTE, 0);
		ABlockSD.set(java.util.Calendar.SECOND, 0);

		 // A Block End Date is on: August 31, 2018, 9:30 am
		java.util.Calendar ABlockED = new GregorianCalendar();
		ABlockED.setTimeZone(timezone);
		ABlockED.set(java.util.Calendar.MONTH, java.util.Calendar.AUGUST);
		ABlockED.set(java.util.Calendar.DAY_OF_MONTH, 27);
		ABlockED.set(java.util.Calendar.YEAR, 2018);
		ABlockED.set(java.util.Calendar.HOUR_OF_DAY, 9);
		ABlockED.set(java.util.Calendar.MINUTE, 30);	
		ABlockED.set(java.util.Calendar.SECOND, 0);

		 // B Block Start Date is on: August 27, 2018, 9:30 am
		java.util.Calendar BBlockSD = new GregorianCalendar();
		BBlockSD.setTimeZone(timezone);
		BBlockSD.set(java.util.Calendar.MONTH, java.util.Calendar.AUGUST);
		BBlockSD.set(java.util.Calendar.DAY_OF_MONTH, 27);
		BBlockSD.set(java.util.Calendar.YEAR, 2018);
		BBlockSD.set(java.util.Calendar.HOUR_OF_DAY, 9);
		BBlockSD.set(java.util.Calendar.MINUTE, 30);
		BBlockSD.set(java.util.Calendar.SECOND, 0);

		 // B Block End Date is on: August 31, 2018, 11:15 am
		java.util.Calendar BBlockED = new GregorianCalendar();
		BBlockED.setTimeZone(timezone);
		BBlockED.set(java.util.Calendar.MONTH, java.util.Calendar.AUGUST);
		BBlockED.set(java.util.Calendar.DAY_OF_MONTH, 27);
		BBlockED.set(java.util.Calendar.YEAR, 2018);
		BBlockED.set(java.util.Calendar.HOUR_OF_DAY, 11);
		BBlockED.set(java.util.Calendar.MINUTE, 15);	
		BBlockED.set(java.util.Calendar.SECOND, 0);

		 // C Block Start Date is on: August 27, 2018, 11:30 am
		java.util.Calendar CBlockSD = new GregorianCalendar();
		CBlockSD.setTimeZone(timezone);
		CBlockSD.set(java.util.Calendar.MONTH, java.util.Calendar.AUGUST);
		CBlockSD.set(java.util.Calendar.DAY_OF_MONTH, 27);
		CBlockSD.set(java.util.Calendar.YEAR, 2018);
		CBlockSD.set(java.util.Calendar.HOUR_OF_DAY, 11);
		CBlockSD.set(java.util.Calendar.MINUTE, 30);
		CBlockSD.set(java.util.Calendar.SECOND, 0);

		 // C Block End Date is on: August 31, 2018, 1:00 pm
		java.util.Calendar CBlockED = new GregorianCalendar();
		CBlockED.setTimeZone(timezone);
		CBlockED.set(java.util.Calendar.MONTH, java.util.Calendar.AUGUST);
		CBlockED.set(java.util.Calendar.DAY_OF_MONTH, 27);
		CBlockED.set(java.util.Calendar.YEAR, 2018);
		CBlockED.set(java.util.Calendar.HOUR_OF_DAY, 13);
		CBlockED.set(java.util.Calendar.MINUTE, 0);	
		CBlockED.set(java.util.Calendar.SECOND, 0);

		 // D Block Start Date is on: August 27, 2018, 1:15 pm
		java.util.Calendar DBlockSD = new GregorianCalendar();
		DBlockSD.setTimeZone(timezone);
		DBlockSD.set(java.util.Calendar.MONTH, java.util.Calendar.AUGUST);
		DBlockSD.set(java.util.Calendar.DAY_OF_MONTH, 27);
		DBlockSD.set(java.util.Calendar.YEAR, 2018);
		DBlockSD.set(java.util.Calendar.HOUR_OF_DAY, 11);
		DBlockSD.set(java.util.Calendar.MINUTE, 30);
		DBlockSD.set(java.util.Calendar.SECOND, 0);

		 // D Block End Date is on: August 31, 2018, 3:00 pm
		java.util.Calendar DBlockED = new GregorianCalendar();
		DBlockED.setTimeZone(timezone);
		DBlockED.set(java.util.Calendar.MONTH, java.util.Calendar.AUGUST);
		DBlockED.set(java.util.Calendar.DAY_OF_MONTH, 27);
		DBlockED.set(java.util.Calendar.YEAR, 2018);
		DBlockED.set(java.util.Calendar.HOUR_OF_DAY, 13);
		DBlockED.set(java.util.Calendar.MINUTE, 0);	
		DBlockED.set(java.util.Calendar.SECOND, 0);

		// Create the event
		
		CEvent robotics = new CEvent("8/31/2018 @ 17:00", "8/31/2018 @ 19:00", "Robotics");
		VEvent a = new VEvent(new Date(ABlockSD.getTime()), new Date(ABlockED.getTime()), "A Block");
		VEvent b = new VEvent(new Date(BBlockSD.getTime()), new Date(BBlockED.getTime()), "B Block");
		VEvent c = new VEvent(new Date(CBlockSD.getTime()), new Date(CBlockED.getTime()), "C Block");
		VEvent d = new VEvent(new Date(DBlockSD.getTime()), new Date(DBlockED.getTime()), "D Block");

		// add recurrance
		String robRrule = "FREQ=WEEKLY;BYDAY=FR";
		String blockRrule = "FREQ=WEEKLY;BYDAY=MO,TU,WE,TH,FR";
		//robotics.getProperties().add(new RRule(robRrule));
		a.getProperties().add(new RRule(blockRrule));
		b.getProperties().add(new RRule(blockRrule));
		c.getProperties().add(new RRule(blockRrule));
		d.getProperties().add(new RRule(blockRrule));


		// add timezone info..
		net.fortuna.ical4j.model.Calendar cal = new net.fortuna.ical4j.model.Calendar();
		//robotics.getProperties().add(tz.getTimeZoneId());
		a.getProperties().add(tz.getTimeZoneId());
		b.getProperties().add(tz.getTimeZoneId());
		c.getProperties().add(tz.getTimeZoneId());
		d.getProperties().add(tz.getTimeZoneId());

		// Create a calendar
		cal.getProperties().add(new ProdId("-//Events Calendar//iCal4j 2.0//EN"));
		cal.getProperties().add(CalScale.GREGORIAN);


		// Add the event and print
		//cal.getComponents().add(robotics);
		cal.getComponents().add(a);
		cal.getComponents().add(b);
		cal.getComponents().add(c);
		cal.getComponents().add(d);

		System.out.println(cal.toString());
	}
}