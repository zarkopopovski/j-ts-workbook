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

public class JTSWBConfig extends JDialog implements ActionListener{
	
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
    public URL jb1,jb2;
    public Image ib1,ib2;
    public File f;
    public FileReader fr;
    public BufferedReader bf;
    public JTSWorkBook jts;
    public JTSWBConfig(JTSWorkBook parent,String s){
    	super(parent,s,true);    	
    	Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 375 ) / 2;
        int yPos = ( dimScreen.height - 115 ) / 2;        
		setBounds(xPos,yPos,375,115);		    	
		setResizable(false);
    	jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
		jts = new JTSWorkBook();
        jPanel1.setLayout(new java.awt.GridLayout(1, 1, 5, 5));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Basic Configuration"));
        
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        jLabel3.setText("Server IP Address");
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField2);

        jLabel4.setText("Server Port");
        jPanel3.add(jLabel4);
        jPanel3.add(jTextField3);

        jPanel1.add(jPanel3);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        jButton1.setText("Apply");
        jPanel2.add(jButton1);

        jButton2.setText("Cancel");
        jPanel2.add(jButton2);

        add(jPanel2, java.awt.BorderLayout.EAST);
        
    	
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==jButton1){
    		if((!jTextField2.getText().equals(null) && !jTextField2.getText().equals(""))&&
    		  (!jTextField3.getText().equals(null) && !jTextField3.getText().equals(""))){		    		
		    		try{
		    			f = new File("conf.jvm");
						if(f.exists()){							
							JOptionPane.showMessageDialog(jts,"Error: Config file already exists, to change configuration\n"+
							"first delete config file and then try again to reconfigure.","jTSWorkBook",JOptionPane.ERROR_MESSAGE); 
						}else{
							PrintWriter out = new PrintWriter(new FileWriter("conf.jvm"));														
							out.println("ipad:"+jTextField2.getText().trim());
							out.println("port:"+jTextField3.getText().trim());																												
							out.close();
							JOptionPane.showMessageDialog(jts,"Configuration done","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE); 
							if(JOptionPane.showConfirmDialog(jts,"jTSWorkBook should be restarted, press Yes for close jTSWorkBook  ?","jTSWorkBook",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) System.exit(0);
							
							jTextField2.setText("");
							jTextField3.setText("");
							
						}						
						    			
		    		}catch(Exception ex){
		    			//JOptionPane.showMessageDialog(jts,"Error: ","jTSWorkBook",JOptionPane.ERROR_MESSAGE); 
		    		} 		    	
    		}else{
    			JOptionPane.showMessageDialog(jts,"Error: Please fill all fields","jTSWorkBook",JOptionPane.ERROR_MESSAGE); 
    		}
    	}else if(ae.getSource()==jButton2){
    		setVisible(false);
    	}
    }
	
	
}