package iCalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
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
		
		System.out.println("For convenience, please store all text files inside the res folder.");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the file name: ");
		String fileName = sc.nextLine();
		sc.close();
		
		cal.getProperties().add(new ProdId("-//Events Calendar//iCal4j 2.0//EN"));
		cal.getProperties().add(CalScale.GREGORIAN);
		Scanner s;
		
			try {
				s = new Scanner(new File("res/" + fileName + ".txt"));
				while (s.hasNextLine()) {
					parse(s.nextLine());
				}
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
		System.out.println(cal.toString());
	}
	
	private static void parse(String str) {
		String[] splited = str.split("\\s+");
		int index = 0;
		ArrayList <String> str2 = new ArrayList<String>(splited.length);
		String test = "";
		
		for (int i = 0; i < splited.length; i++ ) {
			str2.add(splited[i]);
		}
		
		for (int i = 0; i < splited.length; i++) {
			if (splited[i].charAt(splited[i].length() - 1) == ':') {
				index = i;
				break;
			}
		}
		
		
		
		if (splited.length - index == 12) {
			if(!(splited[index + 1].equalsIgnoreCase("Starts") || (splited[index + 2].equalsIgnoreCase("at")) || (splited[index + 5].equalsIgnoreCase("Ends")) || (splited[index + 6].equalsIgnoreCase("at")) || (splited[index + 9].equalsIgnoreCase("Beginning")) || (splited[index + 10].equalsIgnoreCase("date:")))) {
				
				str2.set(index + 1, "Starts");
				str2.set(index + 2, "at");
				str2.set(index + 5, "Ends");
				str2.set(index + 6, "at");
				str2.set(index + 9, "Beginning");
				str2.set(index + 10, "date:");
				for (int i = 0; i < str2.size(); i++) {
					test += str2.get(i) + " ";
				}
				
				System.out.println("You have entered: {" + str + "}");
				System.out.println("Do you mean: {" + test + "}? (Yes or No)");
				Scanner check = new Scanner(System.in);
				String ans = check.nextLine();
				check.close();
				if (ans.equalsIgnoreCase("yes")) {
					parseEvent(test);
				} else {
					System.out.println("Please revise the input string to fit one of the 2 formats supported.");
					System.out.println("Format 1:{Event name: Starts at _:__ _.m. Ends at _:__ _.m. Beginning date: _/__/____}");
					System.out.println("Format 2:{Event name: Starts at _:__ Ends at _:__ Beginning date: _/__/____}");
					System.out.println("Program ending...");
					System.exit(0);
				}
				
			} else {
				parseEvent(str);
			}
							
			
		} else if (splited.length - index == 10) {
			if(!(splited[index + 1].equalsIgnoreCase("Starts") || (splited[index + 2].equalsIgnoreCase("at")) || (splited[index + 4].equalsIgnoreCase("Ends")) || (splited[index + 5].equalsIgnoreCase("at")) || (splited[index + 7].equalsIgnoreCase("Beginning")) || (splited[index + 8].equalsIgnoreCase("date:")))) {
				
				str2.set(index + 1, "Starts");
				str2.set(index + 2, "at");
				str2.set(index + 4, "Ends");
				str2.set(index + 5, "at");
				str2.set(index + 7, "Beginning");
				str2.set(index + 8, "date:");
				for (int i = 0; i < str2.size(); i++) {
					test += str2.get(i) + " ";
				}
				
				System.out.println("You have entered: {" + str + "}");
				System.out.println("Do you mean: {" + test + "}");
				Scanner check2 = new Scanner(System.in);
				String ans = check2.nextLine();
				check2.close();
				if (ans.equalsIgnoreCase("yes")) {
					parseEvent(test);
				} else {
					System.out.println("Please revise the input string to fit one of the 2 formats supported.");
					System.out.println("Format 1:{Event name: Starts at _:__ _.m. Ends at _:__ _.m. Beginning date: _/__/____}");
					System.out.println("Format 2:{Event name: Starts at _:__ Ends at _:__ Beginning date: _/__/____}");
					System.out.println("Program ending...");
					System.exit(0);
				}
				
			} else {
				parseEvent1(str);
			}
		} else {
			System.out.println("Invalid file format- Please set the input strings in 1 of 2 formats:");
			System.out.println("Format 1:{Event name: Starts at _:__ _.m. Ends at _:__ _.m. Beginning date: _/__/____}");
			System.out.println("Format 2:{Event name: Starts at _:__ Ends at _:__ Beginning date: _/__/____}");
			System.out.println("Program ending...");
			System.exit(0);
		}
		
		
	}
	
	private static void parseEvent(String str) {
		//String str = "Robotics meet: Sturts at 5:30 Ends at 8:00 Beginning date: 8/31/2018";
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
		
		//str = "Robotics meet: Sturts at 5:30 Ends at 8:00 Beginning date: 8/31/2018";
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
		
		Scanner startSc = new Scanner(splited[index + 3]);
		 startSc.findInLine("(\\d+):(\\d+)");
	     MatchResult sResult = startSc.match();
	     int startHour = Integer.parseInt(sResult.group(1));
		 int startMin = Integer.parseInt(sResult.group(2));
	   
	     startSc.close(); 
	
	     Scanner endSc = new Scanner(splited[index + 6]);
		 endSc.findInLine("(\\d+):(\\d+)");
	     MatchResult eResult = endSc.match();
	     int endHour = Integer.parseInt(eResult.group(1));
		 int endMin = Integer.parseInt(eResult.group(2));
	   
	     endSc.close(); 
		
	
		
		
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
}

	

	
