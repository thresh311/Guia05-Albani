package clases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {

	
	
	public static void main(String[] args) {
	
	DateTimeFormatter f1 =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
	System.out.println(LocalDate.parse("23-04-2021",f1));
	System.out.println(ChronoUnit.DAYS.between(LocalDate.parse("23-04-2021",f1),LocalDate.parse("22-04-2021",f1)));
	
	
	
	}
	
}
