package com.dreamcode.views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

import com.dreamcode.timesheetworkbook.JTSWorkBook;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.net.*;

public class Projector extends JDialog implements ActionListener{
	
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton10;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;    
    private javax.swing.JPanel jPanel7; 
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private DefaultTableModel tableModel1;
    private DefaultTableModel tableModel2;
	public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
	public JTSWorkBook jts;
	String ido;
	public URL jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	public Image ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10;

	public Projector(JTSWorkBook parent,String s){
		super(parent,s,true);
		Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 675 ) / 2;
        int yPos = ( dimScreen.height - 525 ) / 2;        
		setBounds(xPos,yPos,675,525);		
		setResizable(false);		
				
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();          
        jToolBar1 = new javax.swing.JToolBar();
        jb1 = ClassLoader.getSystemResource("img/nermp.png");   		
		ib1 = Toolkit.getDefaultToolkit().getImage(jb1);      
        jButton1 = new javax.swing.JButton(new ImageIcon(ib1));
        jButton1.setToolTipText("New Project");
        jButton1.addActionListener(this);
        jb2 = ClassLoader.getSystemResource("img/erdemp.png");  
		ib2 = Toolkit.getDefaultToolkit().getImage(jb2);       
        jButton2 = new javax.swing.JButton(new ImageIcon(ib2));
        jButton2.setToolTipText("Update Project");
        jButton2.addActionListener(this);
        jb3 = ClassLoader.getSystemResource("img/erermp.png");  
		ib3 = Toolkit.getDefaultToolkit().getImage(jb3);       
        jButton3 = new javax.swing.JButton(new ImageIcon(ib3));
        jButton3.setToolTipText("Delete Project");
        jButton3.addActionListener(this);        
        jb4 = ClassLoader.getSystemResource("img/rfilt.png");   
		ib4 = Toolkit.getDefaultToolkit().getImage(jb4);       
        jButton4 = new javax.swing.JButton(new ImageIcon(ib4));
        jButton4.setToolTipText("Filter Projects");
        jButton4.addActionListener(this);
        jPanel4 = new javax.swing.JPanel();        
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea1.setEditable(false);
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();                        
        jPanel7 = new javax.swing.JPanel(new GridLayout(1,4,5,5));                
        jPanel8 = new javax.swing.JPanel(new BorderLayout()); 
        //jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar2 = new javax.swing.JToolBar();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox1.addActionListener(this);
        jb5 = ClassLoader.getSystemResource("img/nermp.png");  
        ib5 = Toolkit.getDefaultToolkit().getImage(jb5);       
        jButton5 = new javax.swing.JButton(new ImageIcon(ib5));
        jButton5.setToolTipText("New Task");
        jButton5.addActionListener(this);
        jb6 = ClassLoader.getSystemResource("img/erdemp.png"); 
        ib6 = Toolkit.getDefaultToolkit().getImage(jb6);       
        jButton6 = new javax.swing.JButton(new ImageIcon(ib6));
        jButton6.setToolTipText("Update Task");
        jButton6.addActionListener(this);    
        jb7 = ClassLoader.getSystemResource("img/erermp.png"); 
        ib7 = Toolkit.getDefaultToolkit().getImage(jb7);       
        jButton7 = new javax.swing.JButton(new ImageIcon(ib7));
        jButton7.setToolTipText("Delete Task");
        jButton7.addActionListener(this);
        jb8 = ClassLoader.getSystemResource("img/rfilt.png");  
        ib8 = Toolkit.getDefaultToolkit().getImage(jb8);       
        jButton8 = new javax.swing.JButton(new ImageIcon(ib8));
        jButton8.setToolTipText("Filter Tasks");
        jButton8.addActionListener(this);
        jb9 = ClassLoader.getSystemResource("img/idea.png");  
        ib9 = Toolkit.getDefaultToolkit().getImage(jb9);       
        jButton9 = new javax.swing.JButton(new ImageIcon(ib9));
        jButton9.setToolTipText("Task Details");
        jButton9.addActionListener(this);
        jb10 = ClassLoader.getSystemResource("img/idea.png"); 
        ib10 = Toolkit.getDefaultToolkit().getImage(jb10);       
        jButton10 = new javax.swing.JButton(new ImageIcon(ib10));
        jButton10.setToolTipText("Project Details");
        jButton10.addActionListener(this);
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tableModel1 = new DefaultTableModel();
        tableModel2 = new DefaultTableModel();
		jTable1 = new javax.swing.JTable(tableModel1){
        	public boolean isCellEditable(int rowIndex, int vColIndex) {
 				return false; 
			} 
        };
        	jTable1.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				Object pid;
				String plid;				
				int drow; 
				if(me.getClickCount()!=2) return;
					drow = jTable1.rowAtPoint(me.getPoint());
					pid = jTable1.getValueAt(drow, 0); 				  
					plid = (String)pid;
					ido = plid;				  	
					try{
						stat = con.createStatement();
						rs=stat.executeQuery("SELECT comment FROM project WHERE id="+plid);
						rs.next();						
						jTextArea1.setText(rs.getString("comment"));						
					}catch(Exception ex){
						
					}					
				}
			});
        jTable2 = new javax.swing.JTable(tableModel2){
        	public boolean isCellEditable(int rowIndex, int vColIndex) {
 				return false; 
			} 
        };
        jPanel1.setLayout(new java.awt.BorderLayout());
		this.con=parent.con;
        jSplitPane1.setDividerLocation(350);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel3.setLayout(new java.awt.BorderLayout());
               
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "List of Projects"));
        jPanel8.add(new JScrollPane(jTable1), java.awt.BorderLayout.CENTER);
        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        jToolBar1.setRollover(true);
        
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);
        
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);
        
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        //jToolBar1.add(jButton10);
        
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jToolBar1, java.awt.BorderLayout.NORTH);

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        
        jPanel4.add(new JScrollPane(jTextArea1), java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel4);

        jPanel1.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Projects", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());
               
        jLabel2.setText("Project Name: ");
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel7.add(new JLabel());
        jPanel7.add(new JLabel());
        jPanel7.add(jLabel2);
        jPanel7.add(jComboBox1);
        jPanel6.add(jPanel7,BorderLayout.NORTH);
        jPanel6.add(new JScrollPane(jTable2), java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        jToolBar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar2.setRollover(true);
        
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton5);
        
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton6);
        
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        //jToolBar2.add(jButton9);
        
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton7);
        
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jToolBar2, java.awt.BorderLayout.NORTH);
        add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Currently 0 Projects");
        jPanel5.add(jLabel1, java.awt.BorderLayout.CENTER);

        add(jPanel5, java.awt.BorderLayout.SOUTH);
        tableHeader1();
        reProj();
	}
	public void tableHeader1(){		
		tableModel1.addColumn("Id");		
		tableModel1.addColumn("Project Name");		
		tableModel1.addColumn("Client");
		tableModel1.addColumn("Status");
		
		TableColumn column0=jTable1.getColumnModel().getColumn(0);
		column0.setMinWidth(5);
		column0.setMaxWidth(50);
		column0.setPreferredWidth(30);		
		TableColumn column2=jTable1.getColumnModel().getColumn(2);
		column2.setMinWidth(50);
		column2.setMaxWidth(200);
		column2.setPreferredWidth(150);	
		TableColumn column3=jTable1.getColumnModel().getColumn(3);
		column3.setMinWidth(50);
		column3.setMaxWidth(150);
		column3.setPreferredWidth(125);	
		
	}
	public void tableHeader2(){		
		tableModel2.addColumn("Id");		
		tableModel2.addColumn("TName");
		tableModel2.addColumn("Priority");
		tableModel2.addColumn("Date Start");		
		tableModel2.addColumn("Status");
		
	}
	public void reProj(){		
		try{	
			int row = tableModel1.getRowCount();			
			while(row > 0)
			{	
				row--;				
				tableModel1.removeRow(row);
			}	
			
			//execute query			
			stat=con.createStatement();									
			//rs = stat.executeQuery("SELECT p.id,p.product,c.name,CONCAT(pr.product,' ',pr.version) AS pver,p.status FROM project p,client c,products pr WHERE p.clid=c.id AND p.prodid=pr.id");									
			if(jts.groupIt.indexOf("&")>0){
				if(jts.groupIt.startsWith("QMS")){
					rs = stat.executeQuery("SELECT DISTINCT p.id,p.product,c.name,p.status FROM project p,client c, products pr WHERE p.clid=c.id AND p.prodid=pr.id AND pr.product IN('QMS','QA') ORDER BY p.product ASC");										
				}else{					
					//rs = stat.executeQuery("SELECT DISTINCT p.id,p.product,c.name,p.status FROM project p,client c, products pr WHERE p.clid=c.id AND p.prodid=pr.id AND pr.product = 'Progesa' OR pr.product = 'eProgesa' ORDER BY p.product ASC");
					rs = stat.executeQuery("SELECT DISTINCT p.id,p.product,c.name,p.status FROM project p,client c, products pr WHERE p.clid=c.id AND p.prodid=pr.id AND pr.product IN('Progesa','eProgesa') ORDER BY p.product ASC");
				}				
			}else if(jts.groupIt.equals("eRiskLine")){				
				rs = stat.executeQuery("SELECT DISTINCT p.id,p.product,c.name,p.status FROM project p,client c, products pr WHERE p.clid=c.id AND p.prodid=pr.id AND pr.product = 'eRiskLine' ORDER BY p.product ASC");									
			}else if(jts.groupIt.equals("TraceLine")){				
				rs = stat.executeQuery("SELECT DISTINCT p.id,p.product,c.name,p.status FROM project p,client c, products pr WHERE p.clid=c.id AND p.prodid=pr.id AND pr.product = 'TraceLine' ORDER BY p.product ASC");									
			}else{
				rs = stat.executeQuery("SELECT DISTINCT p.id,p.product,c.name,p.status FROM project p,client c WHERE p.clid=c.id ORDER BY p.product ASC");									
			}
			
			//rs = stat.executeQuery("SELECT p.id,p.product,c.name,p.status FROM project p,client c WHERE p.clid=c.id");									
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
			System.out.println(e.getMessage());	
			//e.printStackTrace();
		}			
	}
	public void rePro(){
		jComboBox1.removeAllItems();
		jComboBox1.addItem("All");
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT id,product FROM project");
			while (rs.next()){				
				jComboBox1.addItem(String.valueOf(rs.getInt("id"))+"_"+rs.getString("product"));
			}
		}catch(Exception ex){	}
	}
	public void reTasks(String test){
		try{	
			int row = tableModel2.getRowCount();			
			while(row > 0)
			{	
				row--;				
				tableModel2.removeRow(row);
			}	
			
			//execute query			
			stat=con.createStatement();									
			if(test.substring(0,3).equals("All")){
				rs = stat.executeQuery("SELECT id,taskname,priority,date_rcv,status FROM tasks");									
			}else{
				String [] temp = new String[2];
				temp=test.split("_");
				rs = stat.executeQuery("SELECT id,taskname,priority,date_rcv,status FROM tasks WHERE prid="+temp[0]);									
			}
			
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
				tableModel2.addRow(data);
			}
		}
		catch(Exception e) {
			//System.out.println(e);	
			//e.printStackTrace();
		}			
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton1){
			jts = new JTSWorkBook();
			Projmen proj = new Projmen(jts,"New Project",1,0);
			proj.show();
			reProj();							
		}else if(ae.getSource()==jButton2){			
			jts = new JTSWorkBook();
			Object pid;
			String plid;
			int drow;
			drow = jTable1.getSelectedRow();													
			if(jTable1.isRowSelected(drow)){
				pid = jTable1.getValueAt(drow, 0);
				plid = (String)pid;	
				Projmen proj = new Projmen(jts,"Update Existing Project",2,Integer.parseInt(plid));
				proj.show();						
				jTextArea1.setText("");
				reProj();
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some project from projects table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}			
		}else if(ae.getSource()==jButton3){
			Object pid;
			String plid;
			int drow;
			drow = jTable1.getSelectedRow();
			if(jTable1.isRowSelected(drow)){
				try{				
					pid = jTable1.getValueAt(drow, 0);
					plid = (String)pid;
					stat=con.createStatement();									
						rs = stat.executeQuery("SELECT COUNT(id) AS tid FROM tasks WHERE prid="+plid);
							rs.next();
							if(rs.getInt("tid")>0){
								JOptionPane.showMessageDialog(jts,"You have registered tasks under this project,you cant delete.","jTSWorkBook",JOptionPane.ERROR_MESSAGE);														
							}else{
								if(JOptionPane.showConfirmDialog(jts,"Are you sure that you want to delete selected project ?",	"jTSWorkBook",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
									stat.execute("DELETE FROM project WHERE id="+plid); 									
									jTextArea1.setText("");
									reProj();
									JOptionPane.showMessageDialog(jts,"Selected Project is Deleted","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
								}
							}										
				}catch(Exception ex){
					//System.out.println(ex);
				}
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some project from projects table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}	
		}else if(ae.getSource()==jButton4){
				
		}else if(ae.getSource()==jButton5){
			JTSWorkBook jtsw = new JTSWorkBook();
			Taskmen tan = new Taskmen(jtsw,"New Task",1,0,0,"");
			tan.show();	
			reTasks("All");									
		}else if(ae.getSource()==jButton6){
			jts = new JTSWorkBook();
			Object pid;
			String plid;
			int drow;
			drow = jTable2.getSelectedRow();													
			if(jTable2.isRowSelected(drow)){
				pid = jTable2.getValueAt(drow, 0);
				plid = (String)pid;	
				Taskmen tan = new Taskmen(jts,"Update Existing Task",2,Integer.parseInt(plid),0,"");
				tan.show();										
				reTasks("All");
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some task from tasks table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}			
				
		}else if(ae.getSource()==jButton7){
			Object pid;
			String plid;
			int drow;
			drow = jTable2.getSelectedRow();
			if(jTable2.isRowSelected(drow)){
				try{				
					pid = jTable2.getValueAt(drow, 0);
					plid = (String)pid;
					stat=con.createStatement();									
					stat.execute("DELETE FROM tasks WHERE id="+plid); 								
					reTasks("All");
					JOptionPane.showMessageDialog(jts,"Selected Task is Deleted","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
				}catch(Exception ex){
				}
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some task from tasks table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}					
		}else if(ae.getSource()==jButton8){
				
		}else if(ae.getSource()==jButton9){			
			jts = new JTSWorkBook();
			Object pid;
			String plid;
			int drow;
			drow = jTable2.getSelectedRow();													
			if(jTable2.isRowSelected(drow)){
				pid = jTable2.getValueAt(drow, 0);
				plid = (String)pid;	
				ViewDo vdo = new ViewDo(jts,"Preview Task",Integer.parseInt(plid));
				vdo.show();														
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some task from tasks table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}		
		}else if(ae.getSource()==jComboBox1){			
			reTasks(jComboBox1.getSelectedItem().toString());
		}else if(ae.getSource()==jButton10){
			jts = new JTSWorkBook();
			Object pid;
			String plid;
			int drow;
			drow = jTable1.getSelectedRow();													
			if(jTable1.isRowSelected(drow)){
				pid = jTable1.getValueAt(drow, 0);
				plid = (String)pid;									
				ViewDoProj vdp = new ViewDoProj(jts,"Preview Project",Integer.parseInt(plid));
				vdp.show();														
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some project from projects table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}		
				
		}						
		
	}
	
}