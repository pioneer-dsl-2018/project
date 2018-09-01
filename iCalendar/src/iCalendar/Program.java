package iCalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.MatchResult;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;
import net.fortuna.ical4j.validate.ValidationException;

public class Program {
	
	static net.fortuna.ical4j.model.Calendar cal = new net.fortuna.ical4j.model.Calendar();
	static HashMap<String, CEvent> events = new HashMap<String, CEvent>();
	static HashMap<String, CEvent> names = new HashMap<String, CEvent>();
	static int UID = 1;
	
	public static void main(String[] args) throws ParseException, FileNotFoundException, SocketException {
		
		System.out.println("For convenience, please store all text files inside the res folder.");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the file name: ");
		String fileName = sc.nextLine();
		
		
		cal.getProperties().add(new ProdId("-//Events Calendar//iCal4j 2.0//EN"));
		cal.getProperties().add(Version.VERSION_2_0);
		cal.getProperties().add(CalScale.GREGORIAN);
		Scanner s;
		String boo = "n";
		while(boo.equals("n")) {
				try {
					s = new Scanner(new File("res/" + fileName + ".txt"));
					while (s.hasNextLine()) {
						String str = s.nextLine();
						Scanner token = new Scanner(str);
						String identifier = token.next();
						if (identifier.equalsIgnoreCase("Repeat:")) {
							parseRepeat(str);
							enterRepeat();
							
						} else if (identifier.equalsIgnoreCase("ADE:")) {
							parseADE(str.substring(5));
						} else if (identifier.equalsIgnoreCase("Repeat")){
							parseRepeatAll(str);
							
						} else {
							parse(str);	
						}
					}
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
			System.out.println(cal.toString());
			System.out.println("Is this file what you wanted?(y/n)");
			boo = sc.nextLine();
			if (boo.equals("n")) {
				System.out.println("Do you wish to exit this program?(y/n)");
				String boo2 = sc.nextLine();
				if (boo2.equals("n")) {
					System.out.println("Initializing...");
					initialize();
				} else {
					System.out.println("Ending...");
					System.exit(0);
				}
			} else {
				saveFinal();
			}
			sc.close();
		}
		
	
		
	}
	
	private static void parseRepeatAll(String str) throws ParseException {
		
		for (String des : names.keySet()) {
			
	    	CEvent temp = names.get(des);
	    
			String type = str.substring(str.lastIndexOf(" ") + 1);
			
			if (type.equalsIgnoreCase("daily")) {
				
				events.put("FREQ=DAILY;INTERVAL=1", temp);
				
			} else if (type.equalsIgnoreCase("weekly")) {
				
				
				events.put("FREQ=DAILY;INTERVAL=7", temp);
				
			} else if (type.equalsIgnoreCase("monthly")) {
				
				String code = temp.getStartDate().getDate().toString();
				
				int date = Integer.parseInt(code.substring(6, 8));
				
				events.put("FREQ=MONTHLY;BYMONTHDAY=" + date + ";INTERVAL=1", temp);
				
			} else if (type.equalsIgnoreCase("annually")) {
				
				String code = temp.getStartDate().getDate().toString();
				int month = Integer.parseInt(code.substring(4, 6));
				int date = Integer.parseInt(code.substring(6, 8));
				System.out.println(code);
				events.put("FREQ=YEARLY;BYMONTH=" + month + ";BYMONTHDAY=" + date, temp);
				
			} else if (type.equalsIgnoreCase("days")) {
				
				String[] words = str.split(" ");
				String penultimate = words[words.length - 2];
				  try
			        {
			            int interval = Integer.parseInt(penultimate);
			            events.put("FREQ=DAILY;INTERVAL=" + interval, temp);
			            
			        } 
			        catch (NumberFormatException e) 
			        {
			            System.out.println(penultimate + " is not a valid integer number");
			        }
				
			} else if (type.equalsIgnoreCase("weeks")) {
				
				String[] words = str.split(" ");
				String penultimate = words[words.length - 2];
				  try
			        {
			            int interval = Integer.parseInt(penultimate);
			            events.put("FREQ=DAILY;INTERVAL=" + interval * 7, temp);
			            
			        } 
			        catch (NumberFormatException e) 
			        {
			            System.out.println(penultimate + " is not a valid integer number");
			        }
				
			} else if (type.equalsIgnoreCase("months")) {
				
				String[] words = str.split(" ");
				String penultimate = words[words.length - 2];
				  try
			        {
					  String code = temp.getStartDate().getDate().toString();
					  int date = Integer.parseInt(code.substring(6, 8));
					  int interval = Integer.parseInt(penultimate);
					  
			          events.put("FREQ=MONTHLY;BYMONTHDAY=" + date + ";INTERVAL=" + interval, temp); 
			            
			        } 
			        catch (NumberFormatException e) 
			        {
			            System.out.println(penultimate + " is not a valid integer number");
			        }
				
			} else {
			
				System.out.println("{" + str + "}" + " is not a valid input.");
			}
			enterRepeat();
		
		}
		
	}

	private static void saveFinal() throws FileNotFoundException {
		
		FileOutputStream fout = new FileOutputStream("res/mycalendar.ics");

		CalendarOutputter outputter = new CalendarOutputter();
		try {
			System.out.println("Generating ics file...");
			outputter.output(cal, fout);
			System.out.println("Done");
			System.out.println("Have a great day!");
			System.exit(0);
		} catch (ValidationException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void initialize() {
		
		cal.getProperties().clear();
		events.clear();
		names.clear();
		UID = 1;
	}

	private static void parseADE(String str) throws SocketException {
	
		int end = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				end = i;
			}
		}
		
		String description = str.substring(1, end);
		
		String date = str.substring(end + 5);
		
		CEvent e = new CEvent(date, description);
		
		UidGenerator ug = new UidGenerator("" + UID);
	    e.getProperties().add(ug.generateUid());
	    UID++;
		
		names.put(description, e);
		cal.getComponents().add(e);
	}

	private static void enterRepeat() throws ParseException {
		
		int x = events.size();
		for (String key: events.keySet()) {
			
			x = x - 1;
			String rule = key;
			
			if (x == 0) {
				events.get(key).getProperties().add(new RRule(rule));
			}
		}
		
	}

	private static void parseRepeat(String str) {
	
		int start = 9;
		int end = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				end = i;
			}
		}
		
		
		String description = str.substring(start, end);
		for (String des : names.keySet()) {

			
		    if (des.equalsIgnoreCase(description)) {
		    	CEvent temp = names.get(des);
		    
				String type = str.substring(str.lastIndexOf(" ") + 1);
				
				if (type.equalsIgnoreCase("daily")) {
					
					events.put("FREQ=DAILY;INTERVAL=1", temp);
					
				} else if (type.equalsIgnoreCase("weekly")) {
					
					
					events.put("FREQ=DAILY;INTERVAL=7", temp);
					
				} else if (type.equalsIgnoreCase("monthly")) {
					
					String code = temp.getStartDate().getDate().toString();
					
					int date = Integer.parseInt(code.substring(6, 8));
					
					events.put("FREQ=MONTHLY;BYMONTHDAY=" + date + ";INTERVAL=1", temp);
					
				} else if (type.equalsIgnoreCase("annually")) {
					
					String code = temp.getStartDate().getDate().toString();
					int month = Integer.parseInt(code.substring(4, 6));
					int date = Integer.parseInt(code.substring(6, 8));
					System.out.println(code);
					events.put("FREQ=YEARLY;BYMONTH=" + month + ";BYMONTHDAY=" + date, temp);
					
				} else if (type.equalsIgnoreCase("days")) {
					
					String[] words = str.split(" ");
					String penultimate = words[words.length - 2];
					  try
				        {
				            int interval = Integer.parseInt(penultimate);
				            events.put("FREQ=DAILY;INTERVAL=" + interval, temp);
				            
				        } 
				        catch (NumberFormatException e) 
				        {
				            System.out.println(penultimate + " is not a valid integer number");
				        }
					
				} else if (type.equalsIgnoreCase("weeks")) {
					
					String[] words = str.split(" ");
					String penultimate = words[words.length - 2];
					  try
				        {
				            int interval = Integer.parseInt(penultimate);
				            events.put("FREQ=DAILY;INTERVAL=" + interval * 7, temp);
				            
				        } 
				        catch (NumberFormatException e) 
				        {
				            System.out.println(penultimate + " is not a valid integer number");
				        }
					
				} else if (type.equalsIgnoreCase("months")) {
					
					String[] words = str.split(" ");
					String penultimate = words[words.length - 2];
					  try
				        {
						  String code = temp.getStartDate().getDate().toString();
						  int date = Integer.parseInt(code.substring(6, 8));
						  int interval = Integer.parseInt(penultimate);
						  
				          events.put("FREQ=MONTHLY;BYMONTHDAY=" + date + ";INTERVAL=" + interval, temp); 
				            
				        } 
				        catch (NumberFormatException e) 
				        {
				            System.out.println(penultimate + " is not a valid integer number");
				        }
					
				} else {
				
					System.out.println("{" + str + "}" + " is not a valid input.");
				}
			
		    } else {
		    	
		    }
		}
		
		
		
	}

	private static void parse(String str) throws SocketException {
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
	
	private static void parseEvent(String str) throws SocketException {
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
	     CEvent e = new CEvent(startDT, endDT, description);
	     
	     UidGenerator ug = new UidGenerator("" + UID);
	     e.getProperties().add(ug.generateUid());
	     UID++;
	   
	     names.put(description, e); 
	     cal.getComponents().add(e);
	}


	
	
	
	
	
	private static void parseEvent1(String str) throws SocketException {
		
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
	     CEvent e = new CEvent(startDT, endDT, description);
	    
	     UidGenerator ug = new UidGenerator("" + UID);
	     e.getProperties().add(ug.generateUid());
	     UID++;
	     
	     names.put(description, e);
	     cal.getComponents().add(e);
	    
	}
}

	

	
