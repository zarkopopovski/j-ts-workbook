package com.dreamcode.views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

import com.dreamcode.timesheetworkbook.JTSWorkBook;
import com.dreamcode.utils.DateChooser;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.net.*;

public class Actmen extends JDialog implements ActionListener{
	
	private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;    
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;    
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;    
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    public String ido,name,dates,datest,datesc,comment,desc,proid,prio,acctype,taid;
	public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
	public JTSWorkBook jts;
	DateChooser dc;
	StringTokenizer stoken;	
	String daj,mant,jiar;
	int id;	
	public URL jb1,jb2,jb3,jb4;
	public Image ib1,ib2,ib3,ib4;
	public String tsid="";
	public Actmen(JTSWorkBook parent,String s,int f,int id,String tsid){
		super(parent,s,true);
		Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 550 ) / 2;
        int yPos = ( dimScreen.height - 225 ) / 2;        
		setBounds(xPos,yPos,550,225);		
		setResizable(false);		
		jts = new JTSWorkBook();		
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox1.addActionListener(this);
        jComboBox2 = new javax.swing.JComboBox();        
        jComboBox3 = new javax.swing.JComboBox();   
        jComboBox4 = new javax.swing.JComboBox();        
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "","In Process", "Waiting", "Closed"}));     
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "","Analyse", "Design", "Development", "Testing", "Installation", "Update", "Verification", "Consultation", "Coordination","Other"}));     
        jLabel5 = new javax.swing.JLabel();        
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField5.setEditable(false);
        jTextField6 = new javax.swing.JTextField();
        jTextField6.setEditable(false);
        jButton5 = new javax.swing.JButton();
        jButton5.addActionListener(this);
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(this);
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField3.setEditable(false);
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(this);
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();        
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 80));
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setPreferredSize(new java.awt.Dimension(90, 550));
        jb3 = ClassLoader.getSystemResource("img/usrnew.png"); 
		ib3 = Toolkit.getDefaultToolkit().getImage(jb3);       
        jButton1 = new javax.swing.JButton(new ImageIcon(ib3));
        jButton1.addActionListener(this);
        jb4 = ClassLoader.getSystemResource("img/usrupdate.png");   
		ib4 = Toolkit.getDefaultToolkit().getImage(jb4);       
        jButton2 = new javax.swing.JButton(new ImageIcon(ib4));
         if(f==1){
        	this.id=0; 
        	this.tsid=tsid;     	
        	//jButton2.setEnabled(false);
        }else if(f==2){
        	//jButton2.setEnabled(true);
        	//jButton1.setEnabled(false);  
        	this.id=id;      	
        	this.tsid=tsid;
        }
        jButton2.addActionListener(this);
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jb1 = ClassLoader.getSystemResource("img/ok.png");   
		ib1 = Toolkit.getDefaultToolkit().getImage(jb1);       
        jButton6 = new javax.swing.JButton(new ImageIcon(ib1));
        jButton6.addActionListener(this);
        jb2 = ClassLoader.getSystemResource("img/cancel.png");   
		ib2 = Toolkit.getDefaultToolkit().getImage(jb2);       
        jButton7 = new javax.swing.JButton(new ImageIcon(ib2));
        jButton7.addActionListener(this);        
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());
		this.con=parent.con;
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Activity");
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel10.add(jTextField1, java.awt.BorderLayout.SOUTH);
        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2));
        //jPanel4.setLayout(new java.awt.GridLayout(2, 1, 5, 5));
        jPanel4.setLayout(new BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Activity"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.setLayout(new java.awt.GridLayout(4, 2, 5, 5));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Project Name");        

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Task Name");
        		
		jPanel8.add(jLabel1);
		if(f==2){
			jPanel8.add(jTextField6);
		}else{
			jPanel8.add(jComboBox5);
		}		
		jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Priority");
		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empty","Normal", "Urgent", "Critical", "Priority 4" }));		
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Date Start");
        jPanel8.add(jLabel6);

        jPanel12.setLayout(new java.awt.BorderLayout());
        jPanel12.add(jTextField5, java.awt.BorderLayout.CENTER);

        jButton5.setText("...");
        jPanel12.add(jButton5, java.awt.BorderLayout.EAST);

        jPanel8.add(jPanel12);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Date End Est");
        jPanel9.setLayout(new java.awt.BorderLayout());
        jPanel9.add(jTextField2, java.awt.BorderLayout.CENTER);

        jButton3.setText("...");
        jPanel9.add(jButton3, java.awt.BorderLayout.EAST);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Date End");//date edn ach
        jPanel8.add(jLabel2);

        jPanel11.setLayout(new java.awt.BorderLayout());
        jPanel11.add(jTextField3, java.awt.BorderLayout.CENTER);

        jButton4.setText("...");
        jPanel11.add(jButton4, java.awt.BorderLayout.EAST);

        jPanel8.add(jPanel11);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Status");
        jPanel8.add(jLabel10);

        jPanel14.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Active");
        jPanel14.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Passive");
        jPanel14.add(jRadioButton2);

        jPanel8.add(jComboBox4);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6,BorderLayout.CENTER);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Details Description"));
        jPanel7.setLayout(new java.awt.BorderLayout());
        
        jScrollPane1.setViewportView(jTextArea1);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 10));
        
        jTabbedPane1.addTab("Activity Informations", jPanel4);

        jPanel5.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 300));
        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jButton1.setText("Save");
        jPanel2.add(jButton1);

        jButton2.setText("Upd");
        
        add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setLayout(new java.awt.GridLayout(1, 6));
        jPanel13.add(jLabel8);
        jPanel13.add(jLabel9);

        jButton6.setText("OK");
        jPanel13.add(jButton6);

        jButton7.setText("Close");
        jPanel13.add(jButton7);
		rePro();
		if(f==2){
			reQuery(id);	
		}

	}	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton1){
			JTSWorkBook jtsw = new JTSWorkBook();
				if(id==0){				
				
					if(jComboBox5.getSelectedItem().toString().equals("")){
						name="unknown";
					}else{
						name=jComboBox5.getSelectedItem().toString();
					}	
					if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
						dates = "0000-00-00";
					}else{
						dates = jTextField5.getText();							
					} 
					if(jTextField2.getText().equals(null)||jTextField2.getText().equals("")){
						datest = "0000-00-00";
					}else{
						datest = jTextField2.getText();										
					} 			
					if(jTextField3.getText().equals(null)||jTextField3.getText().equals("")){
						datesc = "0000-00-00";
					}else{
						datesc = jTextField3.getText();										
					} 
					if(jTextArea1.getText().equals(null)||jTextArea1.getText().equals("")){
						desc = "unknown";
					}else{
						desc = jTextArea1.getText();
					}			
					String [] temp = new String[2];			
					temp=jComboBox2.getSelectedItem().toString().split("_");
					taid=temp[0];
					prio=jComboBox3.getSelectedItem().toString(); 
					
					if(jComboBox4.getSelectedItem().toString().equals("")){
						acctype="unknown";
					}else{
						acctype=jComboBox4.getSelectedItem().toString();
					}	
						
					try{
						stat = con.createStatement();
						//stat.execute("INSERT INTO activity(actname,tsid,description,priority,date_start,status) VALUES('"+name+"',"+taid+",'"+desc+"','"+prio+"','"+dates+"','"+datest+"','"+datesc+"','"+acctype+"','"+comment+"')");
						stat.execute("INSERT INTO activity(actname,tsid,date_start,date_end,status) VALUES('"+name+"',"+tsid+",'"+dates+"','"+datesc+"','"+acctype+"')");
						//JOptionPane.showMessageDialog(jts,"New Activity is Registered","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
						if(JOptionPane.showConfirmDialog(jts,"New Activity is Registered.\nDo you want to register another activity under choosen task ?","jTSWorkBook",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION)
							setVisible(false);										
					}catch(Exception ex){
						System.out.println("Error: "+ex.getMessage());
					}
					jTextField2.setText("");
					jTextField3.setText("");			
					jTextField5.setText("");					
					/*
					newemp nemp = new newemp(jtsw,"New Employee",1,"0");
					nemp.show();
					*/					
				}else{
					String qdata = "UPDATE activity SET ";
					if(jComboBox5.getSelectedItem().toString().equals("")){						
					}else{
						name=jComboBox5.getSelectedItem().toString();
						qdata = qdata + "actname='"+name+"', ";
					}	
					
					if(jTextField3.getText().equals(null)||jTextField3.getText().equals("")){
						
					}else{
						datest = jTextField3.getText();										
						qdata = qdata + "date_end='"+datest+"' ,";
					} 	
					if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
						
					}else{
						datesc = jTextField5.getText();									
						qdata = qdata + "date_start='"+dates+"' ,";
					}					
					
					if(jComboBox4.getSelectedItem().toString().equals("")){
						
					}else{
						acctype=jComboBox4.getSelectedItem().toString();
						qdata = qdata + "status='"+acctype+"', ";
					}				
					qdata = qdata + "tsid="+tsid+" WHERE id="+String.valueOf(id);
					try{
						stat = con.createStatement();
						stat.execute(qdata);
						JOptionPane.showMessageDialog(jts,"Choosen Activity is Modified","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					}catch(Exception ex){}
					jTextField1.setText("");
					jTextField2.setText("");
					jTextField3.setText("");
					jTextField5.setText("");				
					/*
					newemp nemp = new newemp(jtsw,"Update Existing Employee",2,"0");
					nemp.show(); 
					*/											
				}	
		}else if(ae.getSource()==jButton2){						

		}else if(ae.getSource()==jButton3){
			dc = new DateChooser();
			dc.show();	
			//jTextField2.setText("" + dc.getCalendar().getTime());
			stoken = new StringTokenizer(dc.getCalendar().getTime().toString());
			stoken.nextToken();
			mant = stoken.nextToken();
			daj = stoken.nextToken();
			stoken.nextToken();
			stoken.nextToken();
			jiar = stoken.nextToken();
			mant = jts.dateForm(mant);
			datest=jiar+"-"+mant+"-"+daj;	
			jTextField2.setText(datest);
		}else if(ae.getSource()==jButton4){
			dc = new DateChooser();
			dc.show();	
			//jTextField3.setText("" + dc.getCalendar().getTime());
			stoken = new StringTokenizer(dc.getCalendar().getTime().toString());
			stoken.nextToken();
			mant = stoken.nextToken();
			daj = stoken.nextToken();
			stoken.nextToken();
			stoken.nextToken();
			jiar = stoken.nextToken();
			mant = jts.dateForm(mant);
			datesc=jiar+"-"+mant+"-"+daj;	
			jTextField3.setText(datesc);
		}else if(ae.getSource()==jButton5){
			dc = new DateChooser();
			dc.show();	
			//jTextField5.setText("" + dc.getCalendar().getTime());
			stoken = new StringTokenizer(dc.getCalendar().getTime().toString());
			stoken.nextToken();
			mant = stoken.nextToken();
			daj = stoken.nextToken();
			stoken.nextToken();
			stoken.nextToken();
			jiar = stoken.nextToken();
			mant = jts.dateForm(mant);
			dates=jiar+"-"+mant+"-"+daj;		
			jTextField5.setText(dates);
		}else if(ae.getSource()==jButton6){
			
		}else if(ae.getSource()==jButton7){
			setVisible(false);
		}else if(ae.getSource()==jComboBox1){
			reTask(jComboBox1.getSelectedItem().toString());			
		}
		
	}
	public void reQuery(int id){		
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT * FROM activity WHERE id="+id);
			rs.next();
			//jTextField1.setText(rs.getString("actname"));
			jTextField3.setText(rs.getString("date_end"));
			jTextField5.setText(rs.getString("date_start"));
			jTextField6.setText(rs.getString("actname"));
			jTextArea1.setText(rs.getString("description"));
		}catch(Exception ex){	}
	}
	public void rePro(){		
		jComboBox1.removeAllItems();
		jComboBox1.addItem("Empty");
		jComboBox1.addItem("All");
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT id,product FROM project");
			while (rs.next()){				
				jComboBox1.addItem(String.valueOf(rs.getInt("id"))+"_"+rs.getString("product"));
			}
		}catch(Exception ex){	}
	}
	public void reTask(String prid){		
		jComboBox2.removeAllItems();
		jComboBox2.addItem("Empty");
		jComboBox2.addItem("All");
		String [] temp = new String[2];
		try{			
			stat=con.createStatement();									
			if(prid.substring(0,3).equals("All")){
				rs = stat.executeQuery("SELECT id,taskname FROM tasks");
			}else{				
				temp=prid.split("_");
				rs = stat.executeQuery("SELECT id,taskname FROM tasks WHERE prid="+temp[0]);
			}
			while (rs.next()){				
				jComboBox2.addItem(String.valueOf(rs.getInt("id"))+"_"+rs.getString("taskname"));
			}
		}catch(Exception ex){	}
	}
	public void reAct(String prid){		
		jComboBox3.removeAllItems();
		jComboBox3.addItem("All");
		String [] temp = new String[2];
		try{			
			stat=con.createStatement();									
			if(prid.substring(0,3).equals("All")){
				rs = stat.executeQuery("SELECT id,actname FROM activity");
			}else{				
				temp=prid.split("_");
				rs = stat.executeQuery("SELECT id,actname FROM activity WHERE prid="+temp[0]);
			}
			while (rs.next()){				
				jComboBox2.addItem(String.valueOf(rs.getInt("id"))+"_"+rs.getString("taskname"));
			}
		}catch(Exception ex){	}
	}
	
}