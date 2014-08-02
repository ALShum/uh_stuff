package edu.uhmanoa.ics314.s14.iCal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CalendarMain {
	public static Events event1 = new Events();
	public static File eventFile = new File("events.ics");

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("New Event");		

		//Version
		/*
		boolean versionDone = false;
		String uiVersion = "";
		while(!versionDone) {
			System.out.println("Enter the Calendar version:");
			uiVersion = scan.nextLine();
			versionDone = event1.eVersion(uiVersion);
		} */	
		event1.eVersion("");

		//Classification
		boolean classificationDone = false;
		String uiClassification = "";
		while(!classificationDone) {
			System.out.println("Enter the event classification:");
			uiClassification = scan.nextLine();
			classificationDone = event1.eClassification(uiClassification);
		}
		event1.eClassification("");

		//Geographic Position
		/*
		boolean geoPosDone = false;
		String uiGeoPos = "";
		while(!geoPosDone){
			System.out.println("Enter the geographic position:");
			uiGeoPos = scan.nextLine();
			geoPosDone = event1.eGeoPosition(uiGeoPos);
		}
		 */
		event1.eGeoPosition("");

		//Priority
		boolean priorityDone = false;
		String uiPriority = "";
		while(!priorityDone){
			System.out.println("Enter the event priority:");
			uiPriority = scan.nextLine();
			priorityDone = event1.ePriority(uiPriority);
		}

		//Summary
		boolean summaryDone = false;
		String uiSummary = "";
		while(!summaryDone){
			System.out.println("Enter a summary of the event:");
			uiSummary = scan.nextLine();
			summaryDone = event1.eSummary(uiSummary);
		}

		//DTSTART
		boolean DTSTARTDone = false;
		String uiDTSTART = "";
		while(!DTSTARTDone){
			System.out.println("Enter the event start time:");
			uiDTSTART = scan.nextLine();			
			DTSTARTDone = event1.eDTStart(uiDTSTART);
		}

		//DTEND
		boolean DTENDDone = false;
		String uiDTEND = "";
		while(!DTENDDone){
			System.out.println("Enter the event end time:");
			uiDTEND = scan.nextLine();
			DTENDDone = event1.eDTEnd(uiDTEND);
		}

		//Time Zone Identifier
		boolean timeZoneDone = false;
		String uiTimeZone = "";
		while(!timeZoneDone){
			System.out.println("Enter timezone version:");
			uiTimeZone = scan.nextLine();			
			timeZoneDone = event1.eTimeZone(uiTimeZone);
		}


		try {
			exportICS();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		scan.close();
	}


	/** 
	 * This function will export the current calendar to
	 * a .ics file
	 * @throws FileNotFoundException 
	 */
	public static void exportICS() throws FileNotFoundException {
		System.out.println("Exporting to .ics file");
		try {
			FileWriter writer = new FileWriter(eventFile);
			writer.write("BEGIN:VCALENDAR");
			writer.write("\r\n");
			writer.write("VERSION:" + event1.event.getVersion());
			writer.write("\r\n");
			writer.write("PRODID:-//ics314//iCal_Ngauamo_Schenk_Shum");
			writer.write("\r\n");
			writer.write("CALSCALE:GREGORIAN");
			writer.write("\r\n");
			writer.write("METHOD:" + event1.event.getClassification());
			writer.write("\r\n");
			writer.write("X-WR-TIMEZONE:" + event1.event.getTimeZone());
			writer.write("\r\n");
			writer.write("BEGIN:VTIMEZONE");
			writer.write("\r\n");
			writer.write("TZID:" + event1.event.getTimeZone());
			writer.write("\r\n");
			writer.write("END:VTIMEZONE");
			writer.write("\r\n");	
			writer.write("BEGIN:VEVENT");
			writer.write("\r\n");	
			writer.write("DTSTART;TZID=" + event1.event.getTimeZone() + ":" + event1.event.getDTStart());
			writer.write("\r\n");
			writer.write("DTEND;TZID=" + event1.event.getTimeZone() + ":" + event1.event.getDTEnd());
			writer.write("\r\n");	
			writer.write("LOCATION:" + event1.event.getGeoPosition());
			writer.write("\r\n");
			writer.write("SUMMARY:" + event1.event.getSummary());
			writer.write("\r\n");
			writer.write("END:VEVENT");
			writer.write("\r\n");
			writer.write("END:VCALENDAR");

			writer.flush();
			writer.close();
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}