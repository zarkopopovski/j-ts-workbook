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

public class Timshe extends JDialog implements ActionListener{
	
	private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private DefaultTableModel tableModel1; 
	private javax.swing.JTable jTable1;  
    public String ido,effort,dates,datest,datesc,comment,desc,acid,taid;
	public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
	public JTSWorkBook jts;
	DateChooser dc;
	StringTokenizer stoken;	
	String daj,mant,jiar;
	int id;	
    public URL jb3,jb4;
    public Image ib3,ib4;
    public HashMap prodmap;
    public HashMap taskmap;
    public HashMap actmap;
    public int logid=0;
    String lastKnownDate="";
    boolean reenter=false;
    public Timshe(JTSWorkBook parent,String s,int f, int id){
    	super(parent,s,true);    	
    	Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 650 ) / 2;
        int yPos = ( dimScreen.height - 625 ) / 2;        
		setBounds(xPos,yPos,650,625);		    	
		setResizable(false);
		jts = new JTSWorkBook();
		prodmap = new HashMap();
		taskmap = new HashMap();
		actmap = new HashMap();
		jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox1.addActionListener(this);
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox2.addActionListener(this);
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel("Client");
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8 = new javax.swing.JLabel("Task Description  ");
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setPreferredSize(new java.awt.Dimension(268, 25));
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel(new BorderLayout());
        jPanel5 = new javax.swing.JPanel(new GridLayout(8,1,5,5));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 425));
        jPanel6 = new javax.swing.JPanel(new BorderLayout());        
        jPanel7 = new javax.swing.JPanel(new BorderLayout());        
        jPanel8 = new javax.swing.JPanel(new BorderLayout()); 
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Comment"));
        jPanel9 = new javax.swing.JPanel(new BorderLayout());
        //jPanel9.setPreferredSize(new java.awt.Dimension(525, 100));
        jPanel10 = new javax.swing.JPanel(new GridLayout(1,2,5,5));
        jPanel11 = new javax.swing.JPanel(new BorderLayout());
        jPanel12 = new javax.swing.JPanel(new BorderLayout());
        jPanel12.setPreferredSize(new java.awt.Dimension(525, 100));
        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 1, 4, 1));
        jPanel13 = new javax.swing.JPanel(new BorderLayout());
        jPanel13.setPreferredSize(new java.awt.Dimension(525, 140));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Daily Effort Preview"));
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(this);
        jTextField2 = new javax.swing.JTextField();
        jTextField2.setEditable(false);        
        jTextField3 = new javax.swing.JTextField();
        jTextField3.setEditable(false);
        jTextField4 = new javax.swing.JTextField();
        jTextField4.setEditable(false);
        jTextField5 = new javax.swing.JTextField();
        jTextField5.setEditable(false);
        jTextField6 = new javax.swing.JTextField();
        jTextField6.setEditable(false);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea2 = new javax.swing.JTextArea();
        jTextArea2.setEditable(false);
        jb3 = ClassLoader.getSystemResource("img/usrnew.png"); 
		ib3 = Toolkit.getDefaultToolkit().getImage(jb3);       
		jButton4 = new javax.swing.JButton(new ImageIcon(ib3));
		jButton4.setText("Save");
        jButton4.setToolTipText("Submit Time Sheet");
        jButton4.addActionListener(this);
        jb4 = ClassLoader.getSystemResource("img/usrupdate.png");   
		ib4 = Toolkit.getDefaultToolkit().getImage(jb4);       
		jButton2 = new javax.swing.JButton(new ImageIcon(ib4));
		jButton2.setText("Upd");
        jButton2.setToolTipText("Modify Time Sheet");        
        jButton5 = new javax.swing.JButton("...");        
        jButton5.addActionListener(this);                
        this.logid=parent.loginid;        
        tableModel1 = new DefaultTableModel();
        jTable1 = new javax.swing.JTable(tableModel1){
			public boolean isCellEditable(int rowIndex, int vColIndex) {
 				return false; 
			} 
		};
        if(f==1){        	
        	this.id=0;      	
        	//jButton2.setEnabled(false);
        }else if(f==2){
        	//jButton2.setEnabled(true);
        	//jButton4.setEnabled(false);  
        	this.id=id;      	
        	jComboBox1.setEnabled(false);
        	jComboBox2.setEnabled(false);
        	jComboBox3.setEnabled(false);
        	jButton5.setEnabled(false);
        }
        jButton2.addActionListener(this);
        jButton3 = new javax.swing.JButton(new ImageIcon("img/stop.png"));
        jButton3.setText("Del");
        jButton3.setToolTipText("Delete Time Sheet");
        jButton3.setEnabled(false);       
        jButton3.addActionListener(this);        
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Activity Information"));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 5, 5));
		this.con=parent.con;
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Project");
        jPanel1.add(jLabel1);
		if(f==2){
			jPanel1.add(jTextField4);
		}else{
			jPanel1.add(jComboBox1);
		}
        
		jPanel1.add(jLabel7);
		jPanel1.add(jTextField3);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Task");
        jPanel1.add(jLabel2);
        if(f==2){
        	jPanel1.add(jTextField5);
        }else{
        	jPanel1.add(jComboBox2);
        }
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Activity");
        jPanel10.add(jLabel6);        
        jPanel7.add(jComboBox3,BorderLayout.CENTER);
        jPanel7.add(jButton5,BorderLayout.EAST);
        if(f==2){
        	jPanel10.add(jTextField6);
        }else{
        	jPanel10.add(jPanel7);
        }        
        jPanel12.add(new JScrollPane(jTextArea2),BorderLayout.CENTER);
        jPanel12.add(jLabel8,BorderLayout.WEST);       
        jPanel9.add(jPanel12,BorderLayout.CENTER);
        jPanel9.add(jPanel10,BorderLayout.SOUTH);       
        
        jPanel11.add(jPanel1,BorderLayout.CENTER);
        jPanel11.add(jPanel9,BorderLayout.SOUTH);
        
        jPanel6.add(jPanel11, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Details"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));
        
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Date");
        jPanel3.add(jLabel4);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton1.setText("...");
        jPanel4.add(jButton1, java.awt.BorderLayout.EAST);
        
        jPanel4.add(jTextField2, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);
        
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Effort");
        jPanel3.add(jLabel3);

        jPanel3.add(jTextField1);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(jTextArea1);
        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        
        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);    
        
        jPanel5.add(jButton4);
        
        jPanel6.add(jPanel2, java.awt.BorderLayout.CENTER);
        jPanel13.add(new JScrollPane(jTable1),BorderLayout.CENTER);
        //jPanel6.add(jPanel13, java.awt.BorderLayout.SOUTH);
        add(jPanel6, java.awt.BorderLayout.CENTER);
        add(jPanel5, java.awt.BorderLayout.EAST); 
        add(jPanel13, java.awt.BorderLayout.SOUTH);
        
        if(f==2){
			reQuery(id);	
		}else{
			rePro();
		}
        tableHeader();
    }
    public void tableHeader(){		
		//tableModel1.addColumn("Id");
		tableModel1.addColumn("Project");	
		tableModel1.addColumn("Task");		
		tableModel1.addColumn("Activity");		
		tableModel1.addColumn("Effort");
		/*
		TableColumn column0=jTable1.getColumnModel().getColumn(0);
		column0.setMinWidth(5);
		column0.setMaxWidth(50);
		column0.setPreferredWidth(30);	
		TableColumn column2=jTable1.getColumnModel().getColumn(3);
		column2.setMinWidth(75);
		column2.setMaxWidth(125);
		column2.setPreferredWidth(100);	*/			
		TableColumn column5=jTable1.getColumnModel().getColumn(3);
		column5.setMinWidth(5);
		column5.setMaxWidth(50);
		column5.setPreferredWidth(35);		
	}
	public void reClient(int clid){
		try{
			stat = con.createStatement();
			rs=stat.executeQuery("SELECT c.code FROM client c,project p WHERE c.id = p.clid AND p.id="+clid);
			rs.next();
			jTextField3.setText(rs.getString("code"));		
		}catch(Exception ex){ 
		}
		
	}
	public void reTaskDetails(String tid){
		if(!tid.equals(null)||!tid.equals("")){
			String [] temp = new String[3];
			temp=tid.split("_");
			try{
				stat = con.createStatement();
				rs = stat.executeQuery("SELECT * FROM tasks WHERE id="+temp[0]);
				rs.next();
				jTextArea2.setText(rs.getString("description"));
			}catch(Exception ex){
				System.out.println("Error: "+ex.getMessage());
			}
		}
	}
	public void rePro(){		
		jComboBox1.removeAllItems();
		jComboBox1.addItem("All");
		int i=0;
		try{			
			stat=con.createStatement();									
				if(jts.groupIt.indexOf("&")>0){
					//rs = stat.executeQuery("SELECT p.id,p.product FROM project p, products pr WHERE p.prodid=pr.id AND pr.product='Progesa' OR pr.product='eProgesa'");
					if(jts.groupIt.startsWith("QMS")){
						rs = stat.executeQuery("SELECT DISTINCT p.id,p.product,c.name,p.status FROM project p,client c, products pr WHERE p.clid=c.id AND p.prodid=pr.id AND pr.product IN('QMS','QA') ORDER BY p.product ASC");										
					}else{					
						rs = stat.executeQuery("SELECT DISTINCT p.id,p.product,c.name,p.status FROM project p,client c, products pr WHERE p.clid=c.id AND p.prodid=pr.id AND pr.product IN('Progesa','eProgesa') ORDER BY p.product ASC");
					}
				}else if(jts.groupIt.equals("eRiskLine")){
					rs = stat.executeQuery("SELECT DISTINCT p.id,p.product FROM project p, products pr WHERE p.prodid=pr.id AND pr.product='eRiskLine' ORDER BY p.product ASC");
				}else if(jts.groupIt.equals("TraceLine")){
					rs = stat.executeQuery("SELECT DISTINCT p.id,p.product FROM project p, products pr WHERE p.prodid=pr.id AND pr.product='TraceLine' ORDER BY p.product ASC");
				}else{
					rs = stat.executeQuery("SELECT DISTINCT id,product FROM project ORDER BY product ASC");
				}	
			while (rs.next()){								
				jComboBox1.addItem(rs.getString("product"));
				prodmap.put(new Integer(i),String.valueOf(rs.getInt("id"))+"_"+rs.getString("product"));
				i++;
			}
		}catch(Exception ex){	}
	}
	public void reTask(String prid){		
		jComboBox2.removeAllItems();
		jComboBox2.addItem("All");
		String [] temp = new String[2];
		int i=0;
		try{			
			stat=con.createStatement();									
			if(prid.substring(0,3).equals("All")){
				rs = stat.executeQuery("SELECT id,taskname FROM tasks");
			}else{				
				temp=prid.split("_");
				rs = stat.executeQuery("SELECT id,taskname FROM tasks WHERE prid="+temp[0]);
			}
			while (rs.next()){				
				jComboBox2.addItem(rs.getString("taskname"));
				taskmap.put(new Integer(i),String.valueOf(rs.getInt("id"))+"_"+rs.getString("taskname"));
				i++;
			}
		}catch(Exception ex){	}
	}
	public void reAct(String prid){		
		jComboBox3.removeAllItems();
		jComboBox3.addItem("All");
		int i=0;
		String [] temp = new String[2];
		try{			
			stat=con.createStatement();									
			if(prid.substring(0,3).equals("All")){
				rs = stat.executeQuery("SELECT id,actname FROM activity");
			}else{				
				temp=prid.split("_");
				rs = stat.executeQuery("SELECT id,actname FROM activity WHERE tsid="+temp[0]);
			}
			while (rs.next()){	
				jComboBox3.addItem(rs.getString("actname"));
				actmap.put(new Integer(i),String.valueOf(rs.getInt("id"))+"_"+rs.getString("actname"));
				i++;
			}
		}catch(Exception ex){	}
	}	
	public void reTSheet(String datz){		
		try{	
			int row = tableModel1.getRowCount();			
			while(row > 0)
			{	
				row--;				
				tableModel1.removeRow(row);
			}	
			
			//execute query			
			stat=con.createStatement();									
			//rs = stat.executeQuery("SELECT DISTINCT s.id,t.taskname,a.actname,s.edate,s.effort FROM tasks t,activity a,timesheet s, employee e WHERE t.id=s.tsid AND a.id=s.acid AND s.emid=0 ORDER BY s.id DESC");									
			rs = stat.executeQuery("SELECT DISTINCT p.product,t.taskname,a.actname,s.effort FROM tasks t,activity a,timesheet s, employee e, project p WHERE t.id=s.tsid AND a.id=s.acid AND p.id=t.prid AND s.emid="+jts.loginid+" AND s.edate='"+datz+"' ORDER BY s.edate DESC");									
			//ResultSet rs = stat.executeQuery("SELECT * FROM todotab");
			ResultSetMetaData md = rs.getMetaData();
			int colcount = md.getColumnCount();
			
			Object[] data = new Object[colcount];
			//extracting data		
				
			while (rs.next()){				
				for (int i=1; i<=colcount; i++)
				{
					data[i-1] = rs.getString(i);					
					
				}				
				tableModel1.addRow(data);
			}
		}
		catch(Exception e) {
			//System.out.println(e);	
			//e.printStackTrace();
		}			
	}
	public void reQuery(int id){
		String actid;
		try{			
			stat=con.createStatement();									
			//rs = stat.executeQuery("SELECT ts.effort,ts.comment,ac.actname FROM timesheet ts,activity ac WHERE ac.id=ts.acid AND ts.id="+id);
			rs = stat.executeQuery("SELECT DISTINCT s.id,p.id AS pid,p.product,t.taskname,t.description,a.actname,s.edate,s.effort,s.comment FROM tasks t,activity a,timesheet s, project p WHERE t.id=s.tsid AND a.id=s.acid AND p.id=t.prid AND s.id="+id);
			rs.next();
			jTextField1.setText(rs.getString("effort"));							
			jTextField2.setText(rs.getString("edate"));
			jTextField4.setText(rs.getString("product"));
			jTextField5.setText(rs.getString("taskname"));
			jTextField6.setText(rs.getString("actname"));
			jTextArea1.setText(rs.getString("comment"));
			jTextArea2.setText(rs.getString("description"));
			reClient(Integer.parseInt(rs.getString("pid")));			
		}catch(Exception ex){ System.out.println("Error:"+ex.getMessage()); 	}
	}	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton1){
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
			dates=jiar+"-"+mant+"-"+daj;
			jTextField2.setText(dates);
			reTSheet(dates);
		}else if(ae.getSource()==jButton3){
				
		}else if(ae.getSource()==jComboBox1){		
			String[] temp = new String[3];	
			int idx = jComboBox1.getSelectedIndex();
			if(idx>0){										
					reTask((String)prodmap.get(idx-1));					
					temp=((String)prodmap.get(idx-1)).split("_");
					reClient(Integer.parseInt(temp[0]));										
			}else{
				jTextField3.setText("");
			}
		}else if(ae.getSource()==jButton5){			
			int idx = jComboBox2.getSelectedIndex();
			if(idx>0){								
				reAct((String)taskmap.get(idx-1));	
			}
		}else if(ae.getSource()==jComboBox2){			
			int idx = jComboBox2.getSelectedIndex();
			if(idx>0){								
				reTaskDetails((String)taskmap.get(idx-1));
				reAct((String)taskmap.get(idx-1));	
			}
		}else if(ae.getSource()==jButton4){			
			String [] temp = new String[3];
			String [] temp2 = new String[2];			
			int idx1=0;																					
			int idx2=0;
			int idx3=0;
			if(id==0){							
				idx1=jComboBox1.getSelectedIndex();
				if(idx1==0){
					JOptionPane.showMessageDialog(jts,"Please select some project from project list.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);				
				}else{
					idx2=jComboBox2.getSelectedIndex();						
					if(idx2==0){
						JOptionPane.showMessageDialog(jts,"Please select some task from task list.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);				
					}else{
						temp=((String)taskmap.get(idx2-1)).split("_");
						taid=temp[0];					
						idx3=jComboBox3.getSelectedIndex();			
						if(idx3==0){
							JOptionPane.showMessageDialog(jts,"Please select some activity from activity list.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);				
						}else{										
							temp2=((String)actmap.get(idx3-1)).split("_");
							acid=temp2[0];			
							if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){
								effort = "0";
							}else{
								effort = jTextField1.getText();
							}
							if(jTextField2.getText().equals(null)||jTextField2.getText().equals("")){
								dates = "0000-00-00";
							}else{
								dates = jTextField2.getText();												
							}
							if(jTextArea1.getText().equals(null)||jTextArea1.getText().equals("")){
								comment = "unknown";
							}else{
								comment = jTextArea1.getText();
							}
							try{
								stat=con.createStatement();
								stat.execute("INSERT INTO timesheet(tsid,acid,emid,edate,effort,comment) VALUES("+taid+","+acid+","+logid+",'"+dates+"','"+effort+"','"+comment+"')");
								//JOptionPane.showMessageDialog(jts,"New Time Sheet is Registered","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
								if(JOptionPane.showConfirmDialog(jts,"New Time Sheet is Registered.\nDo you want to register another time sheet effort ?","jTSWorkBook",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION) setVisible(false);				
								jTextField1.setText("");
								lastKnownDate = jTextField2.getText();
								//jTextField2.setText("0000-00-00");				
								jTextArea1.setText("");	
								reenter=true;
								reTSheet(jTextField2.getText());								
							}catch(Exception ex){}
								if(reenter==true){
									jTextField1.setText("");
									jTextArea1.setText("");
								}else{
									jTextField1.setText("");
									jTextField2.setText("");
									jTextArea1.setText("");									
								}
								
						}					
					}
				}				
			}else{
				String tdata = "UPDATE timesheet SET ";
			
			if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){
				
			}else{
				effort = jTextField1.getText();
				tdata = tdata + "effort='"+effort+"',";
			}
			
			if(jTextField2.getText().equals(null)||jTextField2.getText().equals("")){
				
			}else{
					dates = jTextField2.getText();						
					tdata = tdata + "edate='"+dates+"',";			
				}
				
				if(jTextArea1.getText().equals(null)||jTextArea1.getText().equals("")){
					
				}else{
					comment = jTextArea1.getText();
					tdata = tdata + "comment='"+comment+"' WHERE id="+id;
				}			
				try{
					stat=con.createStatement();
					stat.execute(tdata);
					JOptionPane.showMessageDialog(jts,"Choosen Time Sheet is Modified","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
					setVisible(false);
				}catch(Exception ex){} 				
					jTextField1.setText("");
					jTextField2.setText("");				
					jTextArea1.setText("");			
				
				
			}			
		}else if(ae.getSource()==jButton2){			
			
		}		
		
	}
		
	
	
}