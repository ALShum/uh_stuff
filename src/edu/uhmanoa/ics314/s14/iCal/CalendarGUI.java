package edu.uhmanoa.ics314.s14.iCal;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * GUI prompts for and takes in user inout. Input is passed to 
 * events.java where it is processed. calendarGUI then exports 
 * a .ics file of the data
 *
 * @author Katrina Schenk
 */
public class CalendarGUI extends JApplet implements ActionListener{
	Events e = new Events();
	private JPanel top;
	private JPanel first;
	private JTextField versionIn, classificationIn, geoPosIn, priorityIn, 
	summaryIn, dtStartIn, dtEndIn, timeZoneIn;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
	JButton export;
	JCheckBox checkRepeat;   
	JComboBox frequencyDrop; 
	JTextField occurrences;

	boolean vDone = false;
	boolean cDone = false;
	boolean gDone = false;
	boolean pDone = false;
	boolean sDone = false;
	boolean dtsDone = false;
	boolean dteDone = false;
	boolean tzDone = false;
	JLabel notifications;
        boolean includeRepeat = false;  
        String[] frequency = { "YEARLY", "MONTHLY", "WEEKLY",
        		"Every Weekday (Monday to Friday)", "DAILY"}; 

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
		/*
		label1 = new JLabel("Version");
		first.add(label1);
		versionIn = new JTextField(10);
		first.add(versionIn);   
		versionIn.addActionListener(this);
		*/

		//Classification
		label2 = new JLabel("Classification");
		first.add(label2);
		classificationIn = new JTextField(10);
		first.add(classificationIn);
		classificationIn.addActionListener(this);

		//Geographic Position
		label3 = new JLabel("Geographic Position ((+/-)xx.xxxxxx;(+/-)xxx.xxxxxx)");
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

		//Export Button
		export = new JButton("Export");
		export.addActionListener(this);
		export.setEnabled(true);
		first.add(export);             

		//Frequency Drop Box
		String[] frequency = { "Yearly", "Monthly", "Weekly",
				"Every Weekday (Monday to Friday)", "Daily"};
		frequencyDrop = new JComboBox(frequency);
		frequencyDrop.setSelectedIndex(3);
		frequencyDrop.addActionListener(this);
		first.add(frequencyDrop);
		frequencyDrop.setVisible(false);

		//Occurrences text box
		label9 = new JLabel("Ends after _ occurrences ");
		first.add(label9);
		label9.setVisible(false);
		occurrences = new JTextField(5);
		first.add(occurrences);
		occurrences.setVisible(false);
		occurrences.addActionListener(this);

		//Repeat check box
		checkRepeat = new JCheckBox("Repeat");
		first.add(checkRepeat);
		checkRepeat.setMnemonic(KeyEvent.VK_C);
		checkRepeat.addItemListener(new ItemListener() {	
			public void itemStateChanged(ItemEvent e){
				frequencyDrop.setVisible(true);
				label9.setVisible(true);
				occurrences.setVisible(true);
                                includeRepeat = true;
				if(e.getStateChange() == ItemEvent.DESELECTED){
					frequencyDrop.setVisible(false);
					label9.setVisible(false);
					occurrences.setVisible(false);
                                        occurrences.setText("");	 
                    		        includeRepeat = false;
				}
			}
		});


		this.top.add(first, BorderLayout.PAGE_START);
		top.setPreferredSize(new Dimension(600, 400));
		first.setEnabled(true);                 


	}
	public void actionPerformed(ActionEvent ae) {
		/*
		if(ae.getSource() == this.versionIn){
			vDone = e.eVersion(versionIn.getText());
			if(!vDone){
				invalidMessage(versionIn, label1, "Version");   
			} else {
				String newLabel1 = "Version set as: " + e.getVersion();
				validMessage(label1, newLabel1);
			}
		} */
		
		if(ae.getSource() == this.classificationIn){
			cDone = e.eClassification(classificationIn.getText());
			if(!cDone){
				invalidMessage(classificationIn, label2, "Classification");
			} else {
				//removed try here
				String newLabel2 = "Classification set as: " + e.getClassification();
				validMessage(label2, newLabel2);        
			}
		}
		if(ae.getSource() == this.geoPosIn){
			gDone = e.eGeoPosition(geoPosIn.getText());
			if(!gDone){
				invalidMessage(geoPosIn, label3, "Geographic Position");
			} else {
				String newLabel3 = "Geographic Position set as: " + e.getGeoPosition();
				validMessage(label3, newLabel3);
			}                       
		}
		if(ae.getSource() == this.priorityIn){
			pDone = e.ePriority(priorityIn.getText());
			if(!pDone){
				invalidMessage(priorityIn, label4, "Priority");
			} else {
				String newLabel4 = "Priority set as: " + e.getPriority();
				validMessage(label4, newLabel4);
			}
		}
		if(ae.getSource() == this.summaryIn){
			sDone = e.eSummary(summaryIn.getText());
			if(!sDone){
				invalidMessage(summaryIn, label5, "Summary");
			} else {
				String newLabel5 = "Summary set as: " + e.getSummary();
				validMessage(label5, newLabel5);
			}
		}
		if(ae.getSource() == this.dtStartIn){
			dtsDone = e.eDTStart(dtStartIn.getText());
			if(!dtsDone){
				invalidMessage(dtStartIn, label6, "Start Time");
			} else {
				String newLabel6 = "Start Time set as: " + e.getDTStart();
				validMessage(label6, newLabel6);
			}
		}               
		if(ae.getSource() == this.dtEndIn){
			dteDone = e.eDTEnd(dtEndIn.getText());
			if(!dteDone){
				invalidMessage(dtEndIn, label7, "End Time");
			} else {
				String newLabel7 = "End Time set as: " + e.getDTEnd();
				validMessage(label7, newLabel7);
			}
		}
		if(ae.getSource() == this.timeZoneIn){
			tzDone = e.eTimeZone(timeZoneIn.getText());
			if(!tzDone){
				invalidMessage(timeZoneIn, label8, "Time Zone");
			} else {
				String newLabel8 = "Time Zone set as: " + e.getTimeZone();
				validMessage(label8, newLabel8);
			}
		}
		if(ae.getSource() == this.export){
			exportPressed();
		}
      
                if(ae.getSource() == this.occurrences){				 
               		int index = frequencyDrop.getSelectedIndex();
        	        String selected = frequency[index];
        		repDone = e.eRepeating(selected, occurrences.getText());
        		if(!repDone){
        		 invalidMessage(occurrences, label9, "Occurrences");
        		} else {
        		    String newLabel9 = "Ends after " + e.getFCount() + " occurrences";
        		    validMessage(label9, newLabel9);
        		}
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
     if(cDone && gDone && pDone && sDone && dtsDone && dteDone && tzDone){
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
                        if(includeRepeat){									
                           writer.write("RRULE:" + e.getFString());	  
                           writer.write("\r\n");   							
                        }
			writer.write("LOCATION:" + e.getGeoPosition());
			writer.write("\r\n");
			writer.write("SUMMARY:" + e.getSummary());
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
		//CalendarGUI f = new CalendarGUI();
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
