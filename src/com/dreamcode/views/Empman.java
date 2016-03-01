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

public class Empman extends JDialog implements ActionListener{
	
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;    
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;    
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;    
    private javax.swing.JPanel jPanel8;  
    private javax.swing.JPanel jPanel9; 
	private javax.swing.JPanel jPanel10;     	 
	private javax.swing.JPanel jPanel11;
	private javax.swing.JPanel jPanel12;
    private javax.swing.JLabel jLabel7;       
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTabbedPane jTabbedPane1;    
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jPasswordField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2; 
    private JComboBox jComboBox1;   
    private JComboBox jComboBox2;
    private JTSWorkBook jts;
	String name,pass,email,position,group,acctype,nick;
	int aid;
	public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;	
	public URL jb1,jb2,jb3,jb4;
	public Image ib1,ib2,ib3,ib4;
	public Empman(JTSWorkBook parent,String s,int state,int az){
		super(parent,s,true);
		Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 500 ) / 2;
        int yPos = ( dimScreen.height - 275 ) / 2;        
		setBounds(xPos,yPos,500,275);		
		setResizable(false);		
	
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setPreferredSize(new java.awt.Dimension(280, 20));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 20));
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setPreferredSize(new java.awt.Dimension(280, 20));
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField2.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();        
        jPanel9 = new javax.swing.JPanel(new GridLayout(1,2,5,0));
        jPanel10 = new javax.swing.JPanel(new GridLayout(5,1,0,1));        
        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 300));
        jPanel11 = new javax.swing.JPanel(new BorderLayout());
        jPanel12 = new javax.swing.JPanel(new BorderLayout());
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();     
        jTextField6 = new javax.swing.JTextField();   
        jPanel2 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jb1 = ClassLoader.getSystemResource("img/ok.png"); 
		ib1 = Toolkit.getDefaultToolkit().getImage(jb1);       
        jButton1 = new javax.swing.JButton(new ImageIcon(ib1));
        jButton1.setText("OK");
        jButton1.addActionListener(this);
        jb2 = ClassLoader.getSystemResource("img/cancel.png");   
        ib2 = Toolkit.getDefaultToolkit().getImage(jb2);       
        jButton2 = new javax.swing.JButton(new ImageIcon(ib2));
        jButton2.setText("Close");
        jButton2.addActionListener(this);
        jb3 = ClassLoader.getSystemResource("img/usrnew.png");   
        ib3 = Toolkit.getDefaultToolkit().getImage(jb3);       
        jButton3 = new javax.swing.JButton(new ImageIcon(ib3));
        jButton3.setText("Save");
        jButton3.addActionListener(this);
        jb4 = ClassLoader.getSystemResource("img/usrupdate.png");
        ib4 = Toolkit.getDefaultToolkit().getImage(jb4);       
        jButton4 = new javax.swing.JButton(new ImageIcon(ib4));
        jButton4.setText("Upd");
        jButton4.addActionListener(this);       
        jComboBox1 = new JComboBox();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "","All","Progesa & eProgesa", "eRiskLine", "TraceLine", "QMS & QA" }));	
        jComboBox2 = new JComboBox();
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "","Administrator", "Super User", "User" }));	
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        //jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));
        jPanel3.setLayout(new java.awt.BorderLayout());
		this.con=parent.con;
		jts = new JTSWorkBook();
			
        jLabel1.setText(" Name");
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel11.add(jLabel1,BorderLayout.WEST);

        jLabel2.setText(" Password");
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel11.add(jLabel2,BorderLayout.EAST);
        jPanel12.add(jTextField1,BorderLayout.WEST);
        jPanel12.add(jPasswordField2,BorderLayout.EAST);
		jPanel3.add(jPanel11,BorderLayout.NORTH);
		jPanel3.add(jPanel12,BorderLayout.CENTER);
        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Contact"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Nick");
        jPanel8.add(jLabel8);
        jPanel8.add(jTextField6);
        
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Email");
        jPanel8.add(jLabel6);
        jPanel8.add(jTextField5);
        
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Position");
        jPanel8.add(jLabel4);

        jTextField3.setPreferredSize(new java.awt.Dimension(30, 20));
        jPanel8.add(jTextField3);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Group");
        jPanel8.add(jLabel5);
        jPanel8.add(jComboBox1);
        
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Access Level");
        
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Admin");
        jPanel9.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Employee");
        jPanel9.add(jRadioButton2);
		
		jPanel8.add(jLabel7);
        jPanel8.add(jComboBox2);        
        
        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);
        
        jTabbedPane1.addTab("General Informations", jPanel4);

        jPanel5.add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        if(state==1){
        	this.aid = 0;        
        	//jButton3.setEnabled(true);
        	//jButton4.setEnabled(false);        	
        }else if(state==2){
        	//jButton3.setEnabled(false);
        	//jButton4.setEnabled(true);
        	this.aid = az;        
        }
		jPanel10.add(jButton3);
		//jPanel10.add(jButton4);
        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);
		jPanel1.add(jPanel10,BorderLayout.EAST);
		
        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout(1, 6, 5, 5));
                
        jPanel2.add(new JLabel());
        jPanel2.add(new JLabel());
        jPanel2.add(jButton1);        
        jPanel2.add(jButton2);
		if(state==2){
			reQuery(az);
		}
	}
	public void reQuery(int id){		
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT * FROM employee WHERE id="+id);
			rs.next();
			jTextField1.setText(rs.getString("name"));				
			jTextField6.setText(rs.getString("nick"));
			jPasswordField2.setText(rs.getString("pwd"));
			jTextField3.setText(rs.getString("position"));				
			jTextField5.setText(rs.getString("email"));				
		}catch(Exception ex){	}
	}	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton1){
			
						
			
		}else if(ae.getSource()==jButton2){			
			setVisible(false);
		}else if(ae.getSource()==jButton3){	
			if(aid==0){					
				if(jComboBox1.getSelectedIndex()>0 && jComboBox2.getSelectedIndex()>0){				
						if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){
							name = "unknown";
						}else{
							name = jTextField1.getText();
						}	
						if(jPasswordField2.getText().equals(null)||jPasswordField2.getText().equals("")){
							pass = "unknown";
						}else{
							pass = jPasswordField2.getText();
						} 
						if(jTextField3.getText().equals(null)||jTextField3.getText().equals("")){
							position = "unknown";
						}else{
							position = jTextField3.getText();
						} 
						if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
							email = "unknown";
						}else{
							email = jTextField5.getText();
						}
						if(jTextField6.getText().equals(null)||jTextField6.getText().equals("")){
							nick = "unknown";
						}else{
							nick = jTextField6.getText();
						}
						group = jComboBox1.getSelectedItem().toString();
								
						acctype = String.valueOf(jComboBox2.getSelectedIndex());
						try{
							stat = con.createStatement();
							stat.execute("INSERT INTO employee(name,nick,pwd,email,position,grpno,acctype) VALUES('"+name+"','"+nick+"','"+pass+"','"+email+"','"+position+"','"+group+"','"+acctype+"')");
							jTextField1.setText("");
							jPasswordField2.setText("");
							jTextField3.setText("");
							jTextField5.setText("");
							jTextField6.setText("");
							JOptionPane.showMessageDialog(jts,"New Employeer is Registered","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
						}catch(Exception ex){
							System.out.println("Error: "+ex.getMessage());
						}
					}else{
						JOptionPane.showMessageDialog(jts,"Choose valid Group (Other then None) and valid Access Level (Other then None)","jTSWorkBook",JOptionPane.ERROR_MESSAGE);				
					}
			}else{				
				String qdata = "UPDATE employee SET ";
				if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){
					
				}else{				
					name = jTextField1.getText();
					qdata = qdata + "name='"+name+"',";
				}
				if(jTextField6.getText().equals(null)||jTextField6.getText().equals("")){
					
				}else{				
					nick = jTextField6.getText();
					qdata = qdata + "nick='"+nick+"',";
				}	
				if(jPasswordField2.getText().equals(null)||jPasswordField2.getText().equals("")){
					
				}else{
					pass = jPasswordField2.getText();
					qdata = qdata + "pwd='"+pass+"',";
				} 
				if(jTextField3.getText().equals(null)||jTextField3.getText().equals("")){
					
				}else{
					position = jTextField3.getText();
					qdata = qdata + "position='"+position+"',";
				} 
				if(jComboBox1.getSelectedIndex()>0||jComboBox2.getSelectedIndex()>0){				
					if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
						
					}else{
						email = jTextField5.getText();
						qdata = qdata + "email='"+email+"',";
					}
				}else{
					if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
						
					}else{
						email = jTextField5.getText();
						qdata = qdata + "email='"+email+"' ";
					}
					
				}				
				if(jComboBox1.getSelectedIndex()>0&&jComboBox2.getSelectedIndex()>0){
					group = jComboBox1.getSelectedItem().toString();
					qdata = qdata + "grpno='"+group+"',";	
				}else if(jComboBox1.getSelectedIndex()>0&&jComboBox2.getSelectedIndex()==0){
					group = jComboBox1.getSelectedItem().toString();
					qdata = qdata + "grpno='"+group+"' ";	
				}
				if(jComboBox2.getSelectedIndex()>0){
					acctype = String.valueOf(jComboBox2.getSelectedIndex());
					qdata = qdata + "acctype='"+acctype+"'";
				}													
				 qdata = qdata + " WHERE id="+String.valueOf(aid);	
				//System.out.println(qdata);	
				try{
					stat = con.createStatement();
					stat.execute(qdata);
					jTextField1.setText("");
					jPasswordField2.setText("");
					jTextField3.setText("");
					jTextField5.setText("");
					jTextField6.setText("");
					jButton3.setEnabled(true);
	        		jButton4.setEnabled(false);  
					JOptionPane.showMessageDialog(jts,"Choosen Employeer is Modified","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);	
					setVisible(false);			
				}catch(Exception ex){
					System.out.println("Error: "+ex.getMessage());
				}	
			}				
		}else if(ae.getSource()==jButton4){
			
			}			
				
		}						
		
	}