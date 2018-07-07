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
	
	static net.fortuna.ical4j.model.Calendar cal = new net.fortuna.ical4j.model.Calendar();
	
	public static void main(String[] args) throws ParseException {
		
		cal.getProperties().add(new ProdId("-//Events Calendar//iCal4j 2.0//EN"));
		cal.getProperties().add(CalScale.GREGORIAN);
		
		Scanner s = new Scanner("Robotics meet: Sturts at 5:30 p.m. Ends at 8:00 p.m. Beginning date: 8/31/2018");
		while (s.hasNextLine()) {
			parseEvent(s.nextLine());
		}
		System.out.println(cal.toString());
	}
	
	private static void parseEvent(String str) {
		//String str = "Robotics meet: Sturts at 5:30 p.m. Ends at 8:00 p.m. Beginning date: 8/31/2018";
		
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
	     
	     cal.getComponents().add(new CEvent(month, day, year, startHour, startMin, endHour, endMin, description));
	}
}
