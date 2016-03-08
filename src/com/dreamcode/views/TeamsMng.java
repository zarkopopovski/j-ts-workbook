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

public class TeamsMng extends JDialog implements ActionListener{
	
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private DefaultTableModel tableModel1;
    public JTSWorkBook jts;
    public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
    public URL jb1,jb2,jb3;
    public Image ib1,ib2,ib3;
    String prod,ver,ido;
    public TeamsMng(JTSWorkBook parent,String s){
    	super(parent,s,true);    	
    	Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 500 ) / 2;
        int yPos = ( dimScreen.height - 350 ) / 2;        
		setBounds(xPos,yPos,500,350);		    	
		setResizable(false);
		    	
    	jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableModel1 = new DefaultTableModel();
        jTable1 = new javax.swing.JTable(tableModel1){
        	public boolean isCellEditable(int rowIndex, int vColIndex) {
 				return false; 
			} 
        };
        jTable1.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				Object oid,oproduct;
				String sid,sproduct;				
				int drow; 
				if(me.getClickCount()!=2) return;
					drow = jTable1.rowAtPoint(me.getPoint());
					oid = jTable1.getValueAt(drow, 0); 
					oproduct = jTable1.getValueAt(drow, 1); 										
					sid = (String)oid;
					sproduct = (String)oproduct;
					ido = sid;				  	
					jTextField1.setText(sproduct);
					jButton2.setEnabled(true);					
								
				}
			});
        jPanel2 = new javax.swing.JPanel();
        jb1 = ClassLoader.getSystemResource("img/usrnew.png"); 
		ib1 = Toolkit.getDefaultToolkit().getImage(jb1);       
        jButton1 = new javax.swing.JButton(new ImageIcon(ib1));
        jButton1.addActionListener(this);
        jb2 = ClassLoader.getSystemResource("img/usrupdate.png");   
		ib2 = Toolkit.getDefaultToolkit().getImage(jb2);       
        jButton2 = new javax.swing.JButton(new ImageIcon(ib2));
        jButton2.setEnabled(false);
        jButton2.addActionListener(this);
        jb3 = ClassLoader.getSystemResource("img/stop.png");   
		ib3 = Toolkit.getDefaultToolkit().getImage(jb3);       
        jButton3 = new javax.swing.JButton(new ImageIcon(ib3));        
        jButton3.addActionListener(this);
	
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());
		jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Team Name ");
        jPanel3.add(jLabel1, BorderLayout.WEST);
        jPanel3.add(jTextField1, BorderLayout.CENTER);
        
        this.con = parent.con;

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);
        
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new java.awt.GridLayout(6, 1, 5, 5));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 325));

        jButton1.setText("Save");
        jPanel2.add(jButton1);

        jButton2.setText("Upd");
        jPanel2.add(jButton2);

        jButton3.setText("Del");
        jPanel2.add(jButton3);

        add(jPanel2, java.awt.BorderLayout.EAST);
        tableHeader1();
        retProd();
    	
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==jButton1){
    		if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){
    			prod="unknown";
    		}else{
    			prod = jTextField1.getText();    		
    		}
    		
    		try{
    			stat = con.createStatement();
    			stat.execute("INSERT INTO teams(name) VALUES('"+prod+"')");
    			jTextField1.setText("");
    			retProd();
    		}catch(Exception ex){
    		}
    		
    	}else if(ae.getSource()==jButton2){
    		String qdata = "UPDATE teams SET ";
    		if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){    			
    			
    		}else{
    			prod = jTextField1.getText(); 
    			qdata = qdata + "name='"+prod+"' ";   		
    		}
    		qdata = qdata + "WHERE id="+ido;
    		try{
    			stat = con.createStatement();
    			stat.execute(qdata);
    			jTextField1.setText("");
    			retProd();
    			jButton2.setEnabled(false);
    		}catch(Exception ex){
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
					stat.execute("DELETE FROM teams WHERE id="+plid); 				
					jTextField1.setText("");					
					retProd();
					JOptionPane.showMessageDialog(jts,"Selected Team is Deleted","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
				}catch(Exception ex){					
				}
			}else{
				JOptionPane.showMessageDialog(jts,"Please select some team from teams table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
			}	
    	}
    	
    }
    public void tableHeader1(){		
		tableModel1.addColumn("Id");		
		tableModel1.addColumn("Team Name");		
		
		TableColumn column0=jTable1.getColumnModel().getColumn(0);
		column0.setMinWidth(5);
		column0.setMaxWidth(50);
		column0.setPreferredWidth(30);							
	}
	public void retProd(){
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
			rs = stat.executeQuery("SELECT id,name FROM teams");
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
			System.out.println(e);	
			e.printStackTrace();
		}			
	}
    	
}