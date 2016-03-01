package com.dreamcode.utils;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;
import java.util.Calendar;
/**
 * dialog to allow user to select a date and return
 * a java.util.Date object
 * Creation date: (2/5/00 10:57:04 AM)
 * @author: Gervase Gallant, ggallant@bigfoot.com
 */
public class DateChooser extends JDialog implements ActionListener {
	//TODO: submit to resource bundle for internationalization
	private String[] months = {"Jan","Feb", "Mar","Apr", "May","June","July","Aug","Sept","Oct","Nov","Dec"};
	private JButton[] days = null;
	private JLabel monthLabel = null;
	private Calendar calendar = null;
	private JPanel mainPanel = null;
	
/**
 * DateChooser constructor comment.
 */
public DateChooser() {
	super();
	this.setModal(true);
	
	initialize();
}
/**
 * deal with all the buttons that may be pressed
 * Creation date: (2/5/00 11:36:11 AM)
 * @param e java.awt.event.ActionEvent
 */
public void actionPerformed(ActionEvent e) {
	String text;
	if (e.getActionCommand().equals("D")){
		//return a date
		text = ((JButton) e.getSource()).getText();
		if (text.length() > 0){
			this.returnDate(text);
		} else {
			Toolkit.getDefaultToolkit().beep();
		}	
	} else {
		this.roll(e.getActionCommand());
	
	}
	
}
/**
 * repaint the window with the supplied calendar date
 * Creation date: (2/5/00 11:04:03 AM)
 * @param d java.util.Date
 */
private void caption() {
	Calendar cal = this.getCalendar();
	int startPos;
	int currentMonth = cal.get(Calendar.MONTH);
	//for painting ease, quick display
	mainPanel.setVisible(false);
	Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
    int xPos = ( dimScreen.width - 175 ) / 2;
    int yPos = ( dimScreen.height - 175 ) / 2;        
	setBounds(xPos,yPos,175,175);
	//set month	
	monthLabel.setText(months[cal.get(Calendar.MONTH)] + " " + cal.get(Calendar.YEAR));

	//set to first day
	cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);

	//now work the day labels
	startPos = cal.get(Calendar.DAY_OF_WEEK);
	

	for (int i = startPos - 1; i < days.length; i++) {
		days[i].setText(String.valueOf(cal.get(Calendar.DATE)));
		cal.roll(Calendar.DATE, true);
		if (cal.get(Calendar.DATE) == 1) {
			//clear remaining labels going forward
			for (int j = i + 1; j < days.length; j++) {
				days[j].setText("");
			}
			break;
		}
	}

	//work first week
	for (int h = 0; h < startPos - 1; h++) {
		if (cal.get(Calendar.DATE) > 25 ) {
			days[h].setText(String.valueOf(cal.get(Calendar.DATE)));
			cal.roll(Calendar.DATE, true);
		} else {
			days[h].setText("");
		}
	}

	this.setCalendar(cal);
	mainPanel.setVisible(true);
}
/**
 * Insert the method's description here.
 * Creation date: (2/5/00 1:12:24 PM)
 * @return java.util.Calendar
 */
public java.util.Calendar getCalendar() {
	if (this.calendar == null){

		calendar = Calendar.getInstance();
	}
	
	return calendar;
}
/**
 * set up the layout and look of the dialog
 * but don't do any data yet.
 * Creation date: (2/5/00 11:02:37 AM)
 */
private void initialize() {
	JButton jb;
	/* layout:
	North panel: month + year display
	Center Panel: buttons for the days, 5 by 7 grid
	South Panel: navigation buttons */
	mainPanel = new JPanel();
	JPanel northPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();

	//widgets
	//NORTH
	monthLabel = new JLabel(months[9] + " 1953");
	northPanel.setLayout(new FlowLayout());
	northPanel.add(monthLabel);


	//CENTER
	centerPanel.setLayout(new GridLayout(5,7));
	days = new JButton[35];
	for (int i = 0; i <35; i++){
		jb = new JButton(String.valueOf(i));
		jb.setSize(25,25);
		jb.setBorder(new EmptyBorder(1,1,1,1));
		jb.setFocusPainted(false);
		jb.setActionCommand("D");
		jb.addActionListener(this);
		days[i] = jb;
		centerPanel.add(jb);	
	}
	
	//SOUTH
	southPanel.setLayout(new FlowLayout());
	southPanel.add(this.makeButton("<<"));
	southPanel.add(this.makeButton("<"));
	southPanel.add(this.makeButton(">"));
	southPanel.add(this.makeButton(">>"));


	mainPanel.setLayout(new BorderLayout());
	mainPanel.add(northPanel, "North");
	mainPanel.add(centerPanel,"Center");
	mainPanel.add(southPanel, "South");

	this.getContentPane().add(mainPanel);
	this.setSize(150,150);
	
	
	caption();
	
	
	
	
}
/**
 * for testing only.
 * Creation date: (2/5/00 11:19:35 AM)
 * @param args java.lang.String[]
 */
/*public static void main(String[] args) {

	try{
		
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e){}
	
	final DateChooser dc = new DateChooser();
	JFrame jf = new JFrame();
	jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	JPanel jp = new JPanel();
	final JTextField jff = new JTextField("The date field will hold the result.");
	JButton jb = new JButton("...");
	
	jb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			dc.show();
			jff.setText("" + dc.getCalendar().getTime());	
		}	
		
	});
	jp.add(jff);
	jp.add(jb);
	jf.getContentPane().add(jp);
	jf.setSize(300,300);
	
	jf.show();


	//set up location of the dialog
	dc.setLocationRelativeTo(jb);
	
	
	
	
	
	
	
	}*/
/**
 * return a button to the control Panel
 * Creation date: (2/5/00 10:57:59 AM)
 * @return java.lang.String
 */
private JButton makeButton(String caption) {
	JButton jb = new JButton(caption);
	jb.setSize(25,25);
	jb.setBorder(new EmptyBorder(1,4,1,4));
	jb.setFocusPainted(false);
	jb.setActionCommand(caption);
	jb.addActionListener(this);
	return jb;	
}
/**
 * roll the calendar to the day
 * then hide the dialog
 * Creation date: (2/5/00 11:40:31 AM)
 * @param day java.lang.String
 */
private void returnDate(String day) {

	this.getCalendar().set(this.getCalendar().get(Calendar.YEAR),this.getCalendar().get(Calendar.MONTH),Integer.parseInt(day));

	this.setVisible(false);
	
}
/**
 * which way to roll the calendar
 * Creation date: (2/5/00 11:46:42 AM)
 * @param direction java.lang.String
 */
private void roll(String direction) {
	int field;
	if (direction.equals(">>")) calendar.roll(Calendar.YEAR,true);
	if (direction.equals(">")) calendar.roll(Calendar.MONTH,true);
	if (direction.equals("<<")) calendar.roll(Calendar.YEAR,false);
	if (direction.equals("<")) calendar.roll(Calendar.MONTH,false);
	caption();
}
/**
 * Insert the method's description here.
 * Creation date: (2/5/00 1:12:24 PM)
 * @param newCalendar java.util.Calendar
 */
public void setCalendar(java.util.Calendar newCalendar) {
	calendar = newCalendar;
	
}
}
