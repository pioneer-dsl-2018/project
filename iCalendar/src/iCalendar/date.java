package iCalendar;

import java.util.GregorianCalendar;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class date{
	
private java.util.Calendar cal = new GregorianCalendar();




	public date(String info) {
		
		  Scanner s = new Scanner(info);
		     s.findInLine("(\\d+)/(\\d+)/(\\d+)");
		     MatchResult result = s.match();
		     int month = Integer.parseInt(result.group(1)) - 1;
			 int day = Integer.parseInt(result.group(2));
		     int year = Integer.parseInt(result.group(3)); 
		  	
		     s.close(); 		    
		cal.clear();
		cal.set(year, month, day);
		
	}

	
	public java.util.Calendar getTime(){
		return cal;
	}
	
	

}
