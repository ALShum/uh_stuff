package edu.uhmanoa.ics314.s14.iCal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CalendarMain {
	public static Events event1 = new Events();
	public static File eventFile = new File("events.ics");

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("New Event");

		//Version
		boolean versionDone = false;
		String uiVersion = "";
		while(versionDone != true){
			System.out.println("Enter the Calendar version:");
			uiVersion = scan.nextLine();
			if((event1.eVersion(uiVersion)) == true){
				versionDone = true;
			}
		}
	
		//Classification
		boolean classificationDone = false;
		String uiClassification = "";
		while(classificationDone != true){
			System.out.println("Enter the event classification:");
			uiClassification = scan.nextLine();
			if((event1.eClassification(uiClassification)) == true) {
				classificationDone = true;
			}
		}

		//Geographic Position
		boolean geoPosDone = false;
		String uiGeoPos = "";
		while(geoPosDone != true){
			System.out.println("Enter the geographic position:");
			uiGeoPos = scan.nextLine();
			if((event1.eGeoPosition(uiGeoPos)) == true) {
				geoPosDone = true;
			}
		}
	
		//Priority
		boolean priorityDone = false;
		String uiPriority = "";
		while(priorityDone != true){
			System.out.println("Enter the event priority:");
			uiPriority = scan.nextLine();
			if((event1.ePriority(uiPriority)) == true) {
				priorityDone = true;
			}
		}
	
		//Summary
		boolean summaryDone = false;
		String uiSummary = "";
		while(summaryDone != true){
			System.out.println("Enter a summary of the event:");
			uiSummary = scan.nextLine();
			if((event1.eSummary(uiSummary)) == true) {
				summaryDone = true;
			}
		}
	
		//DTSTART
		boolean DTSTARTDone = false;
		String uiDTSTART = "";
		while(DTSTARTDone != true){
			System.out.println("Enter the event start time:");
			uiDTSTART = scan.nextLine();
			if((event1.eDTStart(uiDTSTART)) == true) {
				DTSTARTDone = true;
			}
		}

		//DTEND
		boolean DTENDDone = false;
		String uiDTEND = "";
		while(DTENDDone != true){
			System.out.println("Enter the event end time:");
			uiDTEND = scan.nextLine();
			if((event1.eDTEnd(uiDTEND)) == true) {
				DTENDDone = true;
			}
		}

		//Time Zone Identifier
		boolean timeZoneDone = false;
		String uiTimeZone = "";
		while(timeZoneDone != true){
			System.out.println("Enter the Calendar version:");
			uiTimeZone = scan.nextLine();
			if((event1.eTimeZone(uiTimeZone)) == true) {
				timeZoneDone = true;
			}
		}

		try {
			exportICS();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	* This function will export the current calendar to
	* a .ics file
	*/
	public void exportICS() {
		System.out.println("Exporting to .ics file");
		FileOutputStream fout = new FileOutputStream(eventFile);
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
		writer.write("BEGIN:VEVENT");
		writer.write("\r\n");
		writer.write("DTSTART:" + event1.event.getDTStart());
		writer.write("\r\n");
		writer.write("DTEND:" + event1.event.getDTEnd());
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
