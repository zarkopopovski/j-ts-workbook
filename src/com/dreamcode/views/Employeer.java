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

public class Employeer extends JDialog implements ActionListener{
	
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;    
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private DefaultTableModel tableModel1;
	public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
	public JTSWorkBook jts;
	public URL jb1,jb2,jb3,jb4;
	public Image ib1,ib2,ib3,ib4;
	public Employeer(JTSWorkBook parent,String s){
		super(parent,s,true);
		Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 575 ) / 2;
        int yPos = ( dimScreen.height - 525 ) / 2;        
		setBounds(xPos,yPos,575,525);		
		setResizable(false);		
	
        jToolBar1 = new javax.swing.JToolBar();
        jb1 = ClassLoader.getSystemResource("img/nermp.png");   
		ib1 = Toolkit.getDefaultToolkit().getImage(jb1);       
        jButton1 = new javax.swing.JButton(new ImageIcon(ib1));
        jb2 = ClassLoader.getSystemResource("img/erdemp.png");  
        ib2 = Toolkit.getDefaultToolkit().getImage(jb2);       
        jButton2 = new javax.swing.JButton(new ImageIcon(ib2));
        jb3 = ClassLoader.getSystemResource("img/erermp.png"); 
        ib3 = Toolkit.getDefaultToolkit().getImage(jb3);       
        jButton3 = new javax.swing.JButton(new ImageIcon(ib3));
        jb4 = ClassLoader.getSystemResource("img/rfilt.png");  
        ib4 = Toolkit.getDefaultToolkit().getImage(jb4);       
        jButton4 = new javax.swing.JButton(new ImageIcon(ib4));
        jPanel1 = new javax.swing.JPanel();        
        tableModel1 = new DefaultTableModel();
        jTable1 = new javax.swing.JTable(tableModel1){
        	public boolean isCellEditable(int rowIndex, int vColIndex) {
 				return false; 
			} 
        };
        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        jToolBar1.setRollover(true);
		this.con=parent.con;	
        jButton1.setToolTipText("New Employee");
        jButton1.addActionListener(this);        
        jToolBar1.add(jButton1);
        jButton2.setToolTipText("Edit Current Employee");  
        jButton2.addActionListener(this);       
        //jButton2.setEnabled(false);	
        jToolBar1.add(jButton2);
        jButton3.setToolTipText("Delete Current Employee");        
        jButton3.addActionListener(this); 	
        //jButton3.setEnabled(false);
        jToolBar1.add(jButton3);        
        jButton4.setToolTipText("Filter By Access Right");        
        jButton4.addActionListener(this); 	
        //jToolBar1.add(jButton4);

        add(jToolBar1, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());
        
        jPanel1.add(new JScrollPane(jTable1), java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
        tableHeader1();
        retEmp();

	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton1){
			JTSWorkBook jtsw = new JTSWorkBook();
			Empman nemp = new Empman(jtsw,"New Employee",1,0);
			nemp.show();
			retEmp();							
		}else if(ae.getSource()==jButton2){			
			JTSWorkBook jtsw = new JTSWorkBook();		
			Object pid;
			String plid;
			int drow;
			drow = jTable1.getSelectedRow();													
			if(jTable1.isRowSelected(drow)){
				pid = jTable1.getValueAt(drow, 0);
				plid = (String)pid;					
				//System.out.println(plid);							
				Empman nemp = new Empman(jtsw,"Update Existing Employee",2,Integer.parseInt(plid));
				nemp.show();				
				retEmp();
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some employeer from employeers table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}		
			
			
			
									
		}else if(ae.getSource()==jButton3){			
			Object pid;
			String plid;
			int drow;
			drow = jTable1.getSelectedRow();													
			if(jTable1.isRowSelected(drow)){
				try{
					drow = jTable1.getSelectedRow();
					pid = jTable1.getValueAt(drow, 0);
					plid = (String)pid;
					stat=con.createStatement();									
					stat.execute("DELETE FROM employee WHERE id="+plid); 
					retEmp();
					JOptionPane.showMessageDialog(jts,"Selected Employeer is Deleted","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
				}catch(Exception ex){
				//System.out.println(ex);
				}
				retEmp();
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some employeer from employeers table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}
			
			
		
		}
		
	}
	public void tableHeader1(){		
		tableModel1.addColumn("Id");
		tableModel1.addColumn("Nick");		
		tableModel1.addColumn("Name");		
		tableModel1.addColumn("Group");
		
		TableColumn column0=jTable1.getColumnModel().getColumn(0);
		column0.setMinWidth(5);
		column0.setMaxWidth(50);
		column0.setPreferredWidth(30);		
		TableColumn column1=jTable1.getColumnModel().getColumn(2);
		column1.setMinWidth(100);
		column1.setMaxWidth(150);
		column1.setPreferredWidth(125);		
		TableColumn column2=jTable1.getColumnModel().getColumn(3);
		column2.setMinWidth(100);
		column2.setMaxWidth(150);
		column2.setPreferredWidth(125);		
	}
	public void retEmp(){
		try
		{	
			int row = tableModel1.getRowCount();			
			while(row > 0)
			{	
				row--;				
				tableModel1.removeRow(row);
			}	
			
			//execute query			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT id,nick,name,grpno FROM employee");
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
	
}