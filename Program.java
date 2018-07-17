package iCalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.MatchResult;

import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.RRule;

public class Program {
	
	static net.fortuna.ical4j.model.Calendar cal = new net.fortuna.ical4j.model.Calendar();
	
	public static void main(String[] args) throws ParseException {
		
		cal.getProperties().add(new ProdId("-//Events Calendar//iCal4j 2.0//EN"));
		cal.getProperties().add(CalScale.GREGORIAN);
		Scanner s;
		try {
			s = new Scanner(new File("res/dfghj.txt"));
			while (s.hasNextLine()) {
				parseEvent(s.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Scanner s = new Scanner("Robotics meet: Sturts at 5:30 p.m. Ends at 8:00 p.m. Beginning date: 8/31/2018");
		
		System.out.println(cal.toString());
	}
	
	private static void parseEvent(String str) {
		//String str = "Robotics meet: Sturts at 5:30 p.m. Ends at 8:00 p.m. Beginning date: 8/31/2018";
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		TimeZone timezone = registry.getTimeZone("America/Mexico_City");
		VTimeZone tz = ((net.fortuna.ical4j.model.TimeZone) timezone).getVTimeZone();
		
		String[] splited = str.split("\\s+");
		
		int index = 0;
		String text = "";
		for (int i = 0; i < splited.length; i++) {
			if (splited[i].charAt(splited[i].length() - 1) == ':') {
				index = i;
				break;
			}
		}
		for (int i = 0; i <= index; i++) {
			text += splited[i];
			text += " ";
		}
		
		String description = text.substring(0, text.length() - 2);
	
		if (!splited[index + 1].equalsIgnoreCase("Starts")) {
			System.out.println("you have entered " + splited[index + 1] + ", do you mean Starts?");
		}
		int startHour = Integer.parseInt("" + splited[index + 3].charAt(0));
		int startMin = Integer.parseInt(splited[index + 3].substring(2, 4));
		
		
		
		int endHour = Integer.parseInt("" + splited[index + 7].charAt(0));
		int endMin = Integer.parseInt(splited[index + 7].substring(2, 4));
		
		
		if(splited[index + 4].equals("p.m.")) {
			startHour += 12;
		}
		if(splited[index + 8].equals("p.m.")) {
			endHour += 12;
		}
		
		Scanner sc = new Scanner(splited[splited.length - 1]);
		 sc.findInLine("(\\d+)/(\\d+)/(\\d+)");
	     MatchResult result = sc.match();
	     int month = Integer.parseInt(result.group(1));
		 int day = Integer.parseInt(result.group(2));
	     int year = Integer.parseInt(result.group(3));
	     sc.close(); 
	     
	     java.util.Calendar start = new dateTime(month, day, year, startHour, startMin).getTime();
	     java.util.Calendar end = new dateTime(month, day, year, endHour, endMin).getTime();
	     
	     DateTime startDT = new DateTime(start.getTime());
	     DateTime endDT = new DateTime(end.getTime());
	     
	     cal.getComponents().add(new CEvent(startDT, endDT, description));
	}


	
	
	
	
	
	private static void parseEvent1(String str) {
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		TimeZone timezone = registry.getTimeZone("America/Mexico_City");
		VTimeZone tz = ((net.fortuna.ical4j.model.TimeZone) timezone).getVTimeZone();

		 // Start Date is on: April 1, 2008, 9:00 am
		java.util.Calendar startDate = new GregorianCalendar();
		startDate.setTimeZone(timezone);
		startDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL);
		startDate.set(java.util.Calendar.DAY_OF_MONTH, 1);
		startDate.set(java.util.Calendar.YEAR, 2008);
		startDate.set(java.util.Calendar.HOUR_OF_DAY, 9);
		startDate.set(java.util.Calendar.MINUTE, 0);
		startDate.set(java.util.Calendar.SECOND, 0);

		 // End Date is on: April 1, 2008, 13:00
		java.util.Calendar endDate = new GregorianCalendar();
		endDate.setTimeZone(timezone);
		endDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL);
		endDate.set(java.util.Calendar.DAY_OF_MONTH, 1);
		endDate.set(java.util.Calendar.YEAR, 2008);
		endDate.set(java.util.Calendar.HOUR_OF_DAY, 13);
		endDate.set(java.util.Calendar.MINUTE, 0);	
		endDate.set(java.util.Calendar.SECOND, 0);
		
		java.util.Calendar end2 = new GregorianCalendar();
		end2.clear();
		end2.set(2008, 4, 1, 13, 0);

		// Create the event
		String eventName = "Progress Meeting";
		DateTime start = new DateTime(startDate.getTime());
		DateTime end = new DateTime(end2.getTime());
		VEvent meeting = new VEvent(start, end, eventName);

		// add timezone info..
		//meeting.getProperties().add(tz.getTimeZoneId());

		

		// Create a calendar
		net.fortuna.ical4j.model.Calendar icsCalendar = new net.fortuna.ical4j.model.Calendar();
		icsCalendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
		icsCalendar.getProperties().add(CalScale.GREGORIAN);


		// Add the event and print
		icsCalendar.getComponents().add(meeting);
		System.out.println(icsCalendar);
	}
}

	

	
