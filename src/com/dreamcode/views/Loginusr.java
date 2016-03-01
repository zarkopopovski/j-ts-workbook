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

public class Loginusr extends JDialog implements ActionListener{
	
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    public JComboBox jComboBox1;
    public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
    public URL jb1,jb2,jb3;
    public Image ib1,ib2,ib3;
    public File f;
    public FileReader fr;
    public BufferedReader bf;
    public JTSWorkBook jts;
    public int loginid=0;
    public int acclev=0;
    public String grupit;    
	public JLabel labico;
    public Loginusr(JTSWorkBook parent,String s){
    	super(parent,s,true);    	
    	Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 425 ) / 2;
        int yPos = ( dimScreen.height - 375 ) / 2;        
		setBounds(xPos,yPos,425,375);		    	
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);    	
    	jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel(new BorderLayout());
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jb1 = ClassLoader.getSystemResource("img/ok.png"); 
        ib1 = Toolkit.getDefaultToolkit().getImage(jb1);       
        jButton1 = new javax.swing.JButton(new ImageIcon(ib1));
        jButton1.setText("Apply");
        jButton1.addActionListener(this);
        jb2 = ClassLoader.getSystemResource("img/cancel.png"); 
        ib2 = Toolkit.getDefaultToolkit().getImage(jb2);       
        jButton2 = new javax.swing.JButton(new ImageIcon(ib2));
        jButton2.setText("Cancel");
        jButton2.addActionListener(this);
        jb3 = ClassLoader.getSystemResource("img/keyz.png");                           
        ib3 = Toolkit.getDefaultToolkit().getImage(jb3);                   
        labico = new JLabel(new ImageIcon(ib3));
		jts = new JTSWorkBook();
		this.con = parent.con;
        jPanel1.setLayout(new java.awt.GridLayout(1, 1, 5, 5));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Login Informations"));
        
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        jLabel3.setText("Username:");
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel3);
        jPanel3.add(jComboBox1);

        jLabel4.setText("Password:");
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(jLabel4);
        jPanel3.add(jPasswordField1);

        jPanel1.add(jPanel3);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

		jButton1.setText("Apply");
        jPanel2.add(jButton1);

        jButton2.setText("Cancel");
        jPanel2.add(jButton2);     
        add(labico,BorderLayout.NORTH);        
        add(jPanel2, java.awt.BorderLayout.EAST);
        fillUsers();    	
    }
    public void fillUsers(){
    	try{
    		stat = con.createStatement();
    		rs = stat.executeQuery("SELECT * FROM employee");
    		while(rs.next()){
    			jComboBox1.addItem(rs.getString("name"));
    		}
    		    		
    	}catch(Exception ex){    	}
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==jButton1){
    		//if((!jTextField2.getText().equals(null) && !jTextField2.getText().equals(""))&&
    		if((!jComboBox1.getSelectedItem().toString().equals(null) && !jComboBox1.getSelectedItem().toString().equals(""))&&
    		  (!jPasswordField1.getText().equals(null) && !jPasswordField1.getText().equals(""))){	
		       		try{
		       			stat=con.createStatement();
		       			rs=stat.executeQuery("SELECT COUNT(id) AS val FROM employee WHERE name='"+jComboBox1.getSelectedItem().toString()+"' AND pwd='"+jPasswordField1.getText()+"'");
		       			rs.next();
		       			if((Integer.parseInt(rs.getString("val")))>0){
		       				rs=stat.executeQuery("SELECT * FROM employee WHERE name='"+jComboBox1.getSelectedItem().toString()+"' AND pwd='"+jPasswordField1.getText()+"'");
		       				rs.next();
		       				loginid=Integer.valueOf(rs.getString("id"));
		       				acclev=rs.getInt("acctype");
		       				grupit = rs.getString("grpno");
		       				//JOptionPane.showMessageDialog(jts,"Login is successful, press OK to continue.","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);    		       				
		       				setVisible(false); 			
		       			}else{
		       				if(JOptionPane.showConfirmDialog(jts,"Login failed, try again  ?","jTSWorkBook",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION) System.exit(0);
		       			}
		       		}catch(Exception ex){System.out.println("Error: "+ex.getMessage());}
    		}else{
    			JOptionPane.showMessageDialog(jts,"Error: Please fill all fields","jTSWorkBook",JOptionPane.ERROR_MESSAGE);     			
    		}
    	}else if(ae.getSource()==jButton2){
    		System.exit(0);
    	}
    }
	
	
}