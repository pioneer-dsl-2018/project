package iCalendar;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class dateTime {
	
java.util.Calendar cal = new GregorianCalendar();


	public dateTime(String info) {
		
		  Scanner s = new Scanner(info);
		     s.findInLine("(\\d+)/(\\d+)/(\\d+) @ (\\d+):(\\d+)");
		     MatchResult result = s.match();
		     for (int i=1; i<=result.groupCount(); i++) {
		    	  System.out.println(result.group(i));
		     }
		     int month = Integer.parseInt(result.group(1));
				int day = Integer.parseInt(result.group(2));
				int year = Integer.parseInt(result.group(3)); 
				int hour = Integer.parseInt(result.group(4)); 
				int minute = Integer.parseInt(result.group(5)); 
				int second = 0;
				
				System.out.println(month+day+year+hour+minute);
		     s.close(); 		    
		
		cal.set(year, month, day, hour, minute, second);
		
	}
	
	private String parse(String input) {
		
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			
			if (input.charAt(i) == '/' || input.charAt(i) == '@' || input.charAt(i) == ':') {
				result += ' ';
			}
			else
			{
				result += input.charAt(i);
			}
		}
		return result;
	}

	public java.util.Calendar getTime() {
		
		return cal;
	}

}
