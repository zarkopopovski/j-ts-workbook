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

public class Taskmen extends JDialog implements ActionListener{
	
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
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
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;    
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;    
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
	public String ido,name,dates,datest,datesc,comment,desc,proid,prio,acctype,namereq,cliref,envi;
	public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
	public JTSWorkBook jts;
	DateChooser dc;
	StringTokenizer stoken;	
	String daj,mant,jiar;
	int id,nid;	
	public URL jb1,jb2,jb3,jb4;
	public Image ib1,ib2,ib3,ib4;
	public String [] prioTab,enviTab;	
	public Taskmen(JTSWorkBook parent,String s,int f,int id,int nid,String prname){
		super(parent,s,true);
		Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 575 ) / 2;
        int yPos = ( dimScreen.height - 500 ) / 2;        
		setBounds(xPos,yPos,575,500);		
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
        jLabel11 = new javax.swing.JLabel("Requested No");
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12 = new javax.swing.JLabel("Client Reference No");
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13 = new javax.swing.JLabel("Environment");
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14 = new javax.swing.JLabel("Client");
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        prioTab = new String[]{ "", "Normal", "Urgent", "Critical", "Priority 4" };
        enviTab = new String[] { "","Testing", "Production", "Training","Migration","Validation"};
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox1.setEnabled(false);
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "","In Process", "Waiting", "Closed"}));
        jComboBox4 = new javax.swing.JComboBox();
        //jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empty","Testing", "Production", "Training","Migration","Validation"}));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(enviTab));
        jLabel5 = new javax.swing.JLabel();        
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField5.setEditable(false);
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();        
        jTextField8 = new javax.swing.JTextField();        
        jTextField8.setEditable(false);        
        jTextField8.setText(prname);
        jTextField9 = new javax.swing.JTextField();        
        jTextField9.setEditable(false);
        jTextField10 = new javax.swing.JTextField();        
        jTextField10.setEditable(false);    
        jTextField11 = new javax.swing.JTextField();        
        jTextField11.setEditable(false);    
        jButton5 = new javax.swing.JButton();
        jButton5.addActionListener(this);
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField2.setEditable(false);
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(this);
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField3.setEditable(false);
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(this);
        jLabel10 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        //jPanel15 = new javax.swing.JPanel(new GridLayout(2,1,5,5));
        jPanel15 = new javax.swing.JPanel(new BorderLayout());
        jPanel16 = new javax.swing.JPanel(new BorderLayout());
        jPanel17 = new javax.swing.JPanel(new BorderLayout());
        jPanel18 = new javax.swing.JPanel(new GridLayout(2,1,5,5));
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setPreferredSize(new java.awt.Dimension(470, 80));
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea2 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 500));
        jb3 = ClassLoader.getSystemResource("img/usrnew.png"); 
		ib3 = Toolkit.getDefaultToolkit().getImage(jb3);       
        jButton1 = new javax.swing.JButton(new ImageIcon(ib3));
        jButton1.addActionListener(this);
        jb4 = ClassLoader.getSystemResource("img/usrupdate.png");   
		ib4 = Toolkit.getDefaultToolkit().getImage(jb4);       
        jButton2 = new javax.swing.JButton(new ImageIcon(ib4));
        if(f==1){
        	this.id=0;   
        	this.nid=nid;   	
        	//jButton2.setEnabled(false);
        }else if(f==2){
        	//jButton2.setEnabled(true);
        	//jButton1.setEnabled(false);  
        	this.id=id;      	
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
        this.con=parent.con;
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel1.setText(" Task Name ");
        jPanel10.add(jLabel1, java.awt.BorderLayout.CENTER);

        jTextField1.setPreferredSize(new java.awt.Dimension(425, 20));
        jPanel10.add(jTextField1, java.awt.BorderLayout.SOUTH);
        jLabel4.setText(" Project ");
        jPanel17.add(jLabel4, java.awt.BorderLayout.CENTER);
		
		jTextField8.setPreferredSize(new java.awt.Dimension(425, 20));
		jPanel17.add(jTextField8, java.awt.BorderLayout.SOUTH);
		
		jPanel18.add(jPanel17);				
		jPanel18.add(jPanel10);				

        jPanel3.add(jPanel18, java.awt.BorderLayout.WEST);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2));
        //jPanel4.setLayout(new java.awt.GridLayout(2, 1, 5, 5));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Task"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.setLayout(new java.awt.GridLayout(8, 2, 5, 5));

        

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(jLabel14);
        jPanel8.add(jTextField9);
        jPanel8.add(jLabel11);
        jPanel8.add(jTextField6);
        jPanel8.add(jLabel12);
        jPanel8.add(jTextField7);        
        jPanel8.add(jLabel13);
        if(f==2){
        	jPanel8.add(jTextField10);
        }else{
        	jPanel8.add(jComboBox4);
        }
        
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Priority");
        jPanel8.add(jLabel5);
        //jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Empty", "Normal", "Urgent", "Critical", "Priority 4" }));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(prioTab));
        if(f==2){
        	jPanel8.add(jTextField11);
        }else{	
        	jPanel8.add(jComboBox2);
        }
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
        jLabel2.setText("Date End"); //date end ach
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
        jPanel8.add(jComboBox3);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);
        jPanel4.add(jPanel6,BorderLayout.CENTER);
        
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Details Description"));
        jPanel7.setLayout(new java.awt.BorderLayout());
		jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Comment"));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Description");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 10));
        jPanel16.add(new JScrollPane(jTextArea2),BorderLayout.CENTER);
		jPanel15.add(jPanel7);
        jPanel4.add(jPanel15,BorderLayout.SOUTH);
        jTabbedPane1.addTab("Task Informations", jPanel4);

        jPanel5.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout(10, 1, 5, 5));

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
		reClient(nid);
		if(f==2){
			reQuery(id);	
		}

	}
	public void reClient(int clid){
		try{
			stat = con.createStatement();
			rs=stat.executeQuery("SELECT c.code FROM client c,project p WHERE c.id = p.clid AND p.id="+clid);
			rs.next();
			jTextField9.setText(rs.getString("code"));		
		}catch(Exception ex){ 
			
		}
		
	}
	public void rePro(){
		jComboBox1.removeAllItems();
		jComboBox1.addItem("Empty");
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT id,product FROM project");
			while (rs.next()){				
				jComboBox1.addItem(String.valueOf(rs.getInt("id"))+"_"+rs.getString("product"));
			}
		}catch(Exception ex){	}
	}
	public void reQuery(int id){		
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT * FROM tasks WHERE id="+id);
			rs.next();
			jTextField1.setText(rs.getString("taskname"));
			jTextField3.setText(rs.getString("date_end_ac"));
			jTextField5.setText(rs.getString("date_rcv"));			
			jTextField6.setText(rs.getString("namereq"));
			jTextField7.setText(rs.getString("clreff"));			
			jTextField10.setText(rs.getString("environment"));
			jTextField11.setText(rs.getString("priority"));
			jTextArea1.setText(rs.getString("description"));
			jTextArea2.setText(rs.getString("comment"));
		}catch(Exception ex){	}
	}	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton1){
			JTSWorkBook jtsw = new JTSWorkBook();
				if(id==0){									
						if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){
						name = "unknown";
					}else{
						name = jTextField1.getText();
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
					if(jTextField6.getText().equals(null)||jTextField6.getText().equals("")){
						namereq = "unknown";
					}else{
						namereq = jTextField6.getText();
					}	
					if(jTextField7.getText().equals(null)||jTextField7.getText().equals("")){
						cliref = "unknown";
					}else{
						cliref = jTextField7.getText();
					}	
					if(jTextArea1.getText().equals(null)||jTextArea1.getText().equals("")){
						desc = "unknown";
					}else{
						desc = jTextArea1.getText();
					}
					if(jTextArea2.getText().equals(null)||jTextArea2.getText().equals("")){
						comment = "unknown";
					}else{
						comment = jTextArea2.getText();
					}
					String [] temp = new String[2];
					
					proid=String.valueOf(nid);
					if(jComboBox2.getSelectedItem().toString().equals("")){
						prio="unknown";
					}else{
						prio=jComboBox2.getSelectedItem().toString(); 	
					}					
					
					if(jComboBox3.getSelectedItem().toString().equals("")){
						acctype="unknown";
					}else{
						acctype=jComboBox3.getSelectedItem().toString();
					}	
					if(jComboBox4.getSelectedItem().toString().equals("")){
						envi="unknown";
					}else{
						envi=jComboBox4.getSelectedItem().toString();
					}	
					if(proid.equals("0")){
						JOptionPane.showMessageDialog(jts,"Please select some project","jTSWorkBook",JOptionPane.WARNING_MESSAGE);				
					}else{
							try{
								stat = con.createStatement();
								stat.execute("INSERT INTO tasks(prid,taskname,clreff,namereq,environment,description,priority,date_rcv,date_end_ac,status) VALUES("+proid+",'"+name+"','"+cliref+"','"+namereq+"','"+envi+"','"+desc+"','"+prio+"','"+dates+"','"+datesc+"','"+acctype+"')");
								//JOptionPane.showMessageDialog(jts,"New Task is Registered","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);
								if(JOptionPane.showConfirmDialog(jts,"New Task is Registered.\nDo you want to register another task ?","jTSWorkBook",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION) setVisible(false);				
								jTextField1.setText("");
								jTextField2.setText("");
								jTextField3.setText("");			
								jTextField5.setText("");
								jTextField6.setText("");
								jTextField7.setText("");
								jTextArea1.setText("");
								jTextArea2.setText("");									
							}catch(Exception ex){
								System.out.println("Error: "+ex.getMessage());
							}
							jTextField1.setText("");
							jTextField2.setText("");
							jTextField3.setText("");			
							jTextField5.setText("");
							jTextField6.setText("");
							jTextField7.setText("");
							jTextArea1.setText("");
							jTextArea2.setText("");					
					}			
					/*
					newemp nemp = new newemp(jtsw,"New Employee",1,"0");
					nemp.show();
					*/
				}else{
					String qdata = "UPDATE tasks SET ";
					if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){				
					}else{
						name = jTextField1.getText();
						qdata = qdata + "taskname='"+name+"', ";
					}	
					if(jTextField2.getText().equals(null)||jTextField2.getText().equals("")){
						
					}else{
						dates = jTextField2.getText();
						qdata = qdata + "date_end_est='"+dates+"' ,";			
					} 
					if(jTextField3.getText().equals(null)||jTextField3.getText().equals("")){
						
					}else{
						datest = jTextField3.getText();										
						qdata = qdata + "date_end_ac='"+datest+"' ,";
					} 			
					if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
						
					}else{
						datesc = jTextField5.getText();								
						qdata = qdata + "date_rcv='"+datesc+"' ,";
					}			
					if(jTextField7.getText().equals(null)||jTextField7.getText().equals("")){
						
					}else{
						cliref = jTextField7.getText();
						qdata = qdata + "clreff='"+cliref+"' ,";
					}
					if(jTextField6.getText().equals(null)||jTextField6.getText().equals("")){
						
					}else{
						namereq = jTextField6.getText();
						qdata = qdata + "namereq='"+namereq+"' ,";
					}					
					if(jTextArea1.getText().equals(null)||jTextArea1.getText().equals("")){
						
					}else{
						desc = jTextArea1.getText();
						qdata = qdata + "description='"+desc+"' ,";
					}
					if(jComboBox4.getSelectedItem().toString().equals("")){
						
					}else{
						envi=jComboBox4.getSelectedItem().toString();
						qdata = qdata + "environment='"+envi+"' ,";
					}
					if(jTextArea2.getText().equals(null)||jTextArea2.getText().equals("")){
						
					}else{
						comment = jTextArea2.getText();
						qdata = qdata + "comment='"+comment+"' ,";
					}
					String [] temp = new String[2];
					
					if(jComboBox2.getSelectedItem().toString().equals("")){
						
					}else{
						prio=jComboBox2.getSelectedItem().toString(); 	
						qdata = qdata + "priority='"+prio+"',";
					}		
					
					if(jComboBox3.getSelectedItem().toString().equals("")){
						qdata = qdata + "status='unknown' ";
					}else{
						acctype=jComboBox3.getSelectedItem().toString();
						qdata = qdata + "status='"+acctype+"' ";
					}			
					qdata = qdata + " WHERE id="+String.valueOf(id);
					
					try{
						stat = con.createStatement();
						stat.execute(qdata);
						JOptionPane.showMessageDialog(jts,"Choosen Task is Modified","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					}catch(Exception ex){}
								
					jTextField1.setText("");
					jTextField2.setText("");
					jTextField3.setText("");
					jTextField5.setText("");
					jTextField6.setText("");
					jTextField7.setText("");
					jTextArea1.setText("");
					jTextArea2.setText("");
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
		}						
		
	}
	
}