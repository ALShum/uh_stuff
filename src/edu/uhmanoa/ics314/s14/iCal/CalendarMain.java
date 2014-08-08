package edu.uhmanoa.ics314.s14.iCal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Katrina Schenk
 */
public class CalendarMain {
	public static Events e = new Events();
	public static File eventFile = new File("events.ics");

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("New Event");		

		//Classification
		boolean classificationDone = false;
		String uiClassification = "";
		while(!classificationDone) {
			System.out.println("Enter the event classification:");
			uiClassification = scan.nextLine();
			classificationDone = e.eClassification(uiClassification);
		}

		//Geographic Position
		boolean geoPosDone = false;
		String uiGeoPos = "";
		while(!geoPosDone){
			System.out.println("Enter the geographic position:");
			uiGeoPos = scan.nextLine();
			geoPosDone = e.eGeoPosition(uiGeoPos);
		}

		//Priority
		boolean priorityDone = false;
		String uiPriority = "";
		while(!priorityDone){
			System.out.println("Enter the event priority:");
			uiPriority = scan.nextLine();
			priorityDone = e.ePriority(uiPriority);
		}

		//Summary
		boolean summaryDone = false;
		String uiSummary = "";
		while(!summaryDone){
			System.out.println("Enter a summary of the event:");
			uiSummary = scan.nextLine();
			summaryDone = e.eSummary(uiSummary);
		}

		//DTSTART
		boolean DTSTARTDone = false;
		String uiDTSTART = "";
		while(!DTSTARTDone){
			System.out.println("Enter the event start time:");
			uiDTSTART = scan.nextLine();			
			DTSTARTDone = e.eDTStart(uiDTSTART);
		}

		//DTEND
		boolean DTENDDone = false;
		String uiDTEND = "";
		while(!DTENDDone){
			System.out.println("Enter the event end time:");
			uiDTEND = scan.nextLine();
			DTENDDone = e.eDTEnd(uiDTEND);
		}

		//Time Zone Identifier
		boolean timeZoneDone = false;
		String uiTimeZone = "";
		while(!timeZoneDone){
			System.out.println("Enter timezone version:");
			uiTimeZone = scan.nextLine();			
			timeZoneDone = e.eTimeZone(uiTimeZone);
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
			writer.write("VERSION:" + e.getVersion());
			writer.write("\r\n");
			writer.write("PRODID:-//ics314//iCal_Ngauamo_Schenk_Shum");
			writer.write("\r\n");
			writer.write("CALSCALE:GREGORIAN");
			writer.write("\r\n");
			writer.write("METHOD:" + e.getClassification());
			writer.write("\r\n");
			writer.write("X-WR-TIMEZONE:" + e.getTimeZone());
			writer.write("\r\n");
			writer.write("BEGIN:VTIMEZONE");
			writer.write("\r\n");
			writer.write("TZID:" + e.getTimeZone());
			writer.write("\r\n");
			writer.write("END:VTIMEZONE");
			writer.write("\r\n");	
			writer.write("BEGIN:VEVENT");
			writer.write("\r\n");	
			writer.write("DTSTART;TZID=" + e.getTimeZone() + ":" + e.getDTStart());
			writer.write("\r\n");
			writer.write("DTEND;TZID=" + e.getTimeZone() + ":" + e.getDTEnd());
			writer.write("\r\n");	
			writer.write("LOCATION:" + e.getGeoPosition());
			writer.write("\r\n");
			writer.write("SUMMARY:" + e.getSummary());
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