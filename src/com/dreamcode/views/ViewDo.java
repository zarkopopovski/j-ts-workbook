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

public class ViewDo extends JDialog{
	
	private javax.swing.JButton jButton1;    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField10;
    public JTSWorkBook jts;
    public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
    public URL jb2;
    public Image ib2;
    public ViewDo(JTSWorkBook parent,String s,int id){
    	super(parent,s,true);    	
    	Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 525 ) / 2;
        int yPos = ( dimScreen.height - 500 ) / 2;        
		setBounds(xPos,yPos,525,500);		    	
		setResizable(false);
		    	
    	jPanel1 = new javax.swing.JPanel();
    	jb2 = ClassLoader.getSystemResource("img/cancel.png");                  
		ib2 = Toolkit.getDefaultToolkit().getImage(jb2);       
        jButton1 = new javax.swing.JButton(new ImageIcon(ib2));                
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel(new BorderLayout());
        jPanel7 = new javax.swing.JPanel(new BorderLayout());
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setEditable(false);
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField2.setEditable(false);
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField3.setEditable(false);
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel("Name/Requested No");
        jLabel8 = new javax.swing.JLabel("Client Reference No");
        jLabel9 = new javax.swing.JLabel("Environment");
        jLabel10 = new javax.swing.JLabel("Task ID");
        jTextField4 = new javax.swing.JTextField();
        jTextField4.setEditable(false);
        jTextField5 = new javax.swing.JTextField();
        jTextField5.setEditable(false);
        jTextField6 = new javax.swing.JTextField();
        jTextField6.setEditable(false);
        jTextField7 = new javax.swing.JTextField();
        jTextField7.setEditable(false);
        jTextField8 = new javax.swing.JTextField();
        jTextField8.setEditable(false);
        jTextField9 = new javax.swing.JTextField();
        jTextField9.setEditable(false);
        jTextField10 = new javax.swing.JTextField();
        jTextField10.setEditable(false);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
		jTextArea1.setEditable(false);
		jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
		jTextArea2.setEditable(false);                               
        jPanel1.setLayout(new java.awt.GridLayout(6, 1, 3, 3));

        jPanel1.setBorder(new javax.swing.border.EtchedBorder());
        jButton1.setText("Close");
        jButton1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		setVisible(false);
        	}
        });        
        jPanel1.add(jButton1);
        this.con=parent.con;
        jPanel2.setBorder(new javax.swing.border.EtchedBorder());
        add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel4.setLayout(new java.awt.GridLayout(10,2,5,5));

        jPanel3.setBorder(new javax.swing.border.EtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail Info"));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Description"));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Comment"));
        jPanel4.add(jLabel10);
        jPanel4.add(jTextField10);
        jLabel1.setText("Task Name: ");
        jPanel4.add(jLabel1);
       
        jPanel4.add(jTextField1);
        
        jPanel4.add(jLabel7);
        jPanel4.add(jTextField7);
        jPanel4.add(jLabel8);
        jPanel4.add(jTextField8);
        jPanel4.add(jLabel9);
        jPanel4.add(jTextField9);

        jLabel2.setText("Priority: ");
        jPanel4.add(jLabel2);

        jPanel4.add(jTextField2);

        jLabel3.setText("Status: ");
        jPanel4.add(jLabel3);

        jPanel4.add(jTextField3);

        jLabel4.setText("Date Start: ");
        jPanel4.add(jLabel4);

        jPanel4.add(jTextField4);
        
        jLabel5.setText("Date End Est: ");
        jPanel4.add(jLabel5);

        jPanel4.add(jTextField5);
        
        jLabel6.setText("Date End Ac: ");
        jPanel4.add(jLabel6);

        jPanel4.add(jTextField6);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(jTextArea1);
        jScrollPane2.setViewportView(jTextArea2);
		jPanel6.add(jScrollPane1,BorderLayout.CENTER);
		jPanel7.add(jScrollPane2,BorderLayout.CENTER);
		jPanel5.add(jPanel6);
		jPanel5.add(jPanel7);
        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);        

        add(jPanel3, java.awt.BorderLayout.CENTER);
   	    reQuery(id);	
    	
    }
	public void reQuery(int id){		
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT * FROM tasks WHERE id="+id);
			rs.next();
			jTextField1.setText(rs.getString("taskname"));				
			jTextField2.setText(rs.getString("priority"));				
			jTextField3.setText(rs.getString("status"));
			jTextField4.setText(rs.getString("date_rcv"));
			jTextField5.setText(rs.getString("date_end_est"));
			jTextField6.setText(rs.getString("date_end_ac"));
			jTextField7.setText(rs.getString("namereq"));
			jTextField8.setText(rs.getString("clreff"));
			jTextField9.setText(rs.getString("environment"));
			jTextField10.setText(rs.getString("id"));
			jTextArea1.setText(rs.getString("description"));
			jTextArea2.setText(rs.getString("comment"));
		}catch(Exception ex){	}
	}	
	
	
}