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

public class ViewDoProj extends JDialog{
	
	private javax.swing.JButton jButton1;    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;    
    private javax.swing.JTextArea jTextArea1;    
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    public JTSWorkBook jts;
    public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
    public URL jb2;
    public Image ib2;
    public ViewDoProj(JTSWorkBook parent,String s,int id){
    	super(parent,s,true);    	
    	Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 475 ) / 2;
        int yPos = ( dimScreen.height - 400 ) / 2;        
		setBounds(xPos,yPos,475,400);		    	
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
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField4.setEditable(false);
        jTextField5 = new javax.swing.JTextField();
        jTextField5.setEditable(false);
        jTextField6 = new javax.swing.JTextField();
        jTextField6.setEditable(false);
        jTextField7 = new javax.swing.JTextField();
        jTextField7.setEditable(false);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
		jTextArea1.setEditable(false);		                              
        jPanel1.setLayout(new java.awt.GridLayout(6, 1, 3, 3));
		this.con=parent.con;
        jPanel1.setBorder(new javax.swing.border.EtchedBorder());
        jButton1.setText("Close");
        jButton1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		setVisible(false);
        	}
        });        
        jPanel1.add(jButton1);
        jPanel2.setBorder(new javax.swing.border.EtchedBorder());
        add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel4.setLayout(new java.awt.GridLayout(7,2,5,5));

        jPanel3.setBorder(new javax.swing.border.EtchedBorder());
        jPanel5.setLayout(new java.awt.GridLayout(1, 1, 5, 5));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail Info"));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Description"));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Comment"));
        jLabel1.setText("Project Name: ");
        jPanel4.add(jLabel1);
       
        jPanel4.add(jTextField1);

        jLabel2.setText("Product Version: ");
        jPanel4.add(jLabel2);

        jPanel4.add(jTextField2);
        
        jLabel7.setText("Client: ");
        jPanel4.add(jLabel7);

        jPanel4.add(jTextField7);

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
		jPanel6.add(jScrollPane1,BorderLayout.CENTER);		
		jPanel5.add(jPanel6);		
        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);        

        add(jPanel3, java.awt.BorderLayout.CENTER);
   	    reQuery(id);	
    	
    }
	public void reQuery(int id){		
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT p.id,p.product,c.name,CONCAT(pr.product,' ',pr.version) AS pver,p.date_start,p.status,p.comment FROM project p,client c,products pr WHERE p.clid=c.id AND p.prodid=pr.id AND p.id="+id);									
			rs.next();
			jTextField1.setText(rs.getString("product"));				
			jTextField2.setText(rs.getString("pver"));				
			jTextField7.setText(rs.getString("name"));
			jTextField3.setText(rs.getString("status"));
			jTextField4.setText(rs.getString("date_start"));			
			jTextArea1.setText(rs.getString("comment"));
		}catch(Exception ex){System.out.println(ex.getMessage());	}
	}	
	
	
}