package edu.uhmanoa.ics314.s14.iCal;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CalendarGUI extends JApplet implements ActionListener{
	Events e = new Events();
	private JPanel top;
	private JPanel first;
	private JTextField versionIn, classificationIn, geoPosIn, priorityIn, 
						summaryIn, dtStartIn, dtEndIn, timeZoneIn;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8;
	JButton export;
	
	boolean vDone = false;
	boolean cDone = false;
	boolean gDone = false;
	boolean pDone = false;
	boolean sDone = false;
	boolean dtsDone = false;
	boolean dteDone = false;
	boolean tzDone = false;
	JLabel notifications;
	
	public CalendarGUI() {		
		//top level
		this.setSize(600, 400);
		this.top = new JPanel();
		this.top.setName("Create");
		top.setLayout(new BorderLayout());
		notifications = new JLabel("");
		top.add(notifications);
		
		first = new JPanel();
		first.setLayout(new BoxLayout(first, BoxLayout.PAGE_AXIS));
		
		//Version
		label1 = new JLabel("Version");
		first.add(label1);
		versionIn = new JTextField(10);
		first.add(versionIn);	
		versionIn.addActionListener(this);
		
		//Classification
		label2 = new JLabel("Classification");
		first.add(label2);
		classificationIn = new JTextField(10);
		first.add(classificationIn);
		classificationIn.addActionListener(this);
		
		//Geographic Position
		label3 = new JLabel("Geographic Position ");
		first.add(label3);
		geoPosIn = new JTextField(60);
		first.add(geoPosIn);
		geoPosIn.addActionListener(this);
		
		//Priority
		label4 = new JLabel("Priority (0-9) ");
		first.add(label4);
		priorityIn = new JTextField(5);
		first.add(priorityIn);
		priorityIn.addActionListener(this);
		
		//Summary
		label5 = new JLabel("Summary ");
		first.add(label5);
		summaryIn = new JTextField(60);
		first.add(summaryIn);
		summaryIn.addActionListener(this);
		
		//DTStart
		label6 = new JLabel("Event Start Time (yyyymmdd'T'hhmmss)");
		first.add(label6);
		dtStartIn = new JTextField(20);
		first.add(dtStartIn);
		dtStartIn.addActionListener(this);
		
		//DTEnd
		label7 = new JLabel("Event End Time (yyyymmdd'T'hhmmss)");
		first.add(label7);
		dtEndIn = new JTextField(20);
		first.add(dtEndIn);
    dtEndIn.addActionListener(this);

		
		//Time Zone
		label8 = new JLabel("Time Zone ");
		first.add(label8);
		timeZoneIn = new JTextField(30);
		first.add(timeZoneIn);
     timeZoneIn.addActionListener(this);

		
		export = new JButton("Export");
		export.addActionListener(this);
		export.setEnabled(true);
		first.add(export);
		
		this.top.add(first, BorderLayout.PAGE_START);
		top.setPreferredSize(new Dimension(600, 400));
		first.setEnabled(true);			
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == this.versionIn){
			vDone = e.eVersion(versionIn.getText());
			if(!vDone){
				invalidMessage(versionIn, label1, "Version");	
			} else {
				String newLabel1 = "Version set as: " + e.event.getVersion();
				validMessage(label1, newLabel1);
			}
		}
		if(ae.getSource() == this.classificationIn){
			cDone = e.eClassification(classificationIn.getText());
			if(!cDone){
				invalidMessage(classificationIn, label2, "Classification");
			} else {
                  Classification classification;
                        
				try{
				  classification = new Classification(e.event.getClassification());
         String newLabel2 = "Classification set as: " + e.event.getClassification();
         validMessage(label2, newLabel2);
            }
            catch (Exception e) {
						System.err.println("Invalid classification");
            }
			}
		}
		if(ae.getSource() == this.geoPosIn){
			gDone = e.eGeoPosition(geoPosIn.getText());
			if(!gDone){
				invalidMessage(geoPosIn, label3, "Geographic Position");
			} else {
				String newLabel3 = "Geographic Position set as: " + e.event.getGeoPosition();
				validMessage(label3, newLabel3);
			}			
		}
		if(ae.getSource() == this.priorityIn){
			pDone = e.ePriority(priorityIn.getText());
			if(!pDone){
				invalidMessage(priorityIn, label4, "Priority");
			} else {
				String newLabel4 = "Priority set as: " + e.event.getPriority();
				validMessage(label4, newLabel4);
			}
		}
		if(ae.getSource() == this.summaryIn){
			sDone = e.eSummary(summaryIn.getText());
			if(!sDone){
				invalidMessage(summaryIn, label5, "Summary");
			} else {
				String newLabel5 = "Summary set as: " + e.event.getSummary();
				validMessage(label5, newLabel5);
			}
		}
		if(ae.getSource() == this.dtStartIn){
			dtsDone = e.eDTStart(dtStartIn.getText());
			if(!dtsDone){
				invalidMessage(dtStartIn, label6, "Start Time");
			} else {
				String newLabel6 = "Start Time set as: " + e.event.getDTStart();
				validMessage(label6, newLabel6);
			}
		}		
		if(ae.getSource() == this.dtEndIn){
			dteDone = e.eDTEnd(dtEndIn.getText());
			if(!dteDone){
				invalidMessage(dtEndIn, label7, "End Time");
			} else {
				String newLabel7 = "End Time set as: " + e.event.getDTEnd();
				validMessage(label7, newLabel7);
			}
		}
		if(ae.getSource() == this.timeZoneIn){
			tzDone = e.eTimeZone(timeZoneIn.getText());
			if(!tzDone){
				invalidMessage(timeZoneIn, label8, "Time Zone");
			} else {
				String newLabel8 = "Time Zone set as: " + e.event.getTimeZone();
				validMessage(label8, newLabel8);
			}
		}
		if(ae.getSource() == this.export){
			exportPressed();
		}
		
	}
	
	public void invalidMessage(JTextField tf, JLabel l, String title){
		tf.setText("");
		String invalid = "Invalid. Enter info again.";
		l.setText(title + invalid);
	}
	
	public void validMessage(JLabel l, String data){
		l.setText(data);
	}

	public void exportPressed(){
		if(vDone && cDone && gDone && pDone && sDone && dtsDone && dteDone && tzDone){
			try {
				exportICS();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			notifications.setText("Complete all categories before exporting");
		}
	}
   
  public void exportICS() throws FileNotFoundException {
		File eventFile = new File("events.ics");
		try {
			FileWriter writer = new FileWriter(eventFile);
			writer.write("BEGIN:VCALENDAR");
			writer.write("\r\n");
			writer.write("VERSION:" + e.event.getVersion());
			writer.write("\r\n");
			writer.write("PRODID:-//ics314//iCal_Ngauamo_Schenk_Shum");
			writer.write("\r\n");
			writer.write("CALSCALE:GREGORIAN");
			writer.write("\r\n");
			writer.write("METHOD:" + e.event.getClassification());
			writer.write("\r\n");
			writer.write("X-WR-TIMEZONE:" + e.event.getTimeZone());
			writer.write("\r\n");
			writer.write("BEGIN:VTIMEZONE");
			writer.write("\r\n");
			writer.write("TZID:" + e.event.getTimeZone());
			writer.write("\r\n");
			writer.write("END:VTIMEZONE");
			writer.write("\r\n");	
			writer.write("BEGIN:VEVENT");
			writer.write("\r\n");	
			writer.write("DTSTART;TZID=" + e.event.getTimeZone() + ":" + e.event.getDTStart());
			writer.write("\r\n");
			writer.write("DTEND;TZID=" + e.event.getTimeZone() + ":" + e.event.getDTEnd());
			writer.write("\r\n");	
			writer.write("LOCATION:" + e.event.getGeoPosition());
			writer.write("\r\n");
			writer.write("SUMMARY:" + e.event.getSummary());
			writer.write("\r\n");
			writer.write("END:VEVENT");
			writer.write("\r\n");
			writer.write("END:VCALENDAR");

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void CalendarGUI() {	
	}
	
	@Override
	public void init(){
		CalendarGUI f = new CalendarGUI();
		this.setContentPane(top);
		this.setSize(600, 400);
		this.setVisible(true);
		try{
			java.awt.EventQueue.invokeAndWait(new
					Runnable(){
				public void run(){
					CalendarGUI();
				}
			});
		} catch (Exception ex){}
	}
	
}
