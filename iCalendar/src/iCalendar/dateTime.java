package iCalendar;

import java.util.GregorianCalendar;

import java.util.Scanner;
import java.util.regex.MatchResult;

import net.fortuna.ical4j.model.DateTime;

public class dateTime{
	
private java.util.Calendar cal = new GregorianCalendar();




	public dateTime(String info) {
		
		  Scanner s = new Scanner(info);
		     s.findInLine("(\\d+)/(\\d+)/(\\d+) (@|at) (\\d+):(\\d+)");
		     MatchResult result = s.match();
		     int month = Integer.parseInt(result.group(1));
			 int day = Integer.parseInt(result.group(2));
		     int year = Integer.parseInt(result.group(3)); 
		  	 int hour = Integer.parseInt(result.group(5)); 
			 int minute = Integer.parseInt(result.group(6)); 
			 int second = 0;
		     s.close(); 		    
		cal.clear();
		cal.set(year, month, day, hour, minute, second);
		
	}

	
	public dateTime(int month, int day, int year, int hour, int min) {	    
		
		cal.clear();
		cal.set(year, month, day, hour, min);
		
	}
	
	public java.util.Calendar getTime(){
		return cal;
	}
	
	

}
