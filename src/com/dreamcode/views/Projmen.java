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

public class Projmen extends JDialog implements ActionListener{
	
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    public String ido,name,dates,datest,datesc,ver,desc,clio,prover,status;
	public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
	public JTSWorkBook jts;
	DateChooser dc;
	StringTokenizer stoken;	
	String daj,mant,jiar;
	int id;	
	public URL jb1,jb2,jb3,jb4;
	public Image ib1,ib2,ib3,ib4;
	public HashMap clientmap;
	public HashMap productmap;
	public Projmen(JTSWorkBook parent,String s,int f,int id){
		super(parent,s,true);
		Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 575 ) / 2;
        int yPos = ( dimScreen.height - 500 ) / 2;        
		setBounds(xPos,yPos,575,500);		
		setResizable(false);		
	
        buttonGroup1 = new javax.swing.ButtonGroup();
        jts = new JTSWorkBook();		
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
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "","In Process", "Waiting", "Closed"}));
        jComboBox3 = new javax.swing.JComboBox();        
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField5.setEditable(false);
        jTextField6 = new javax.swing.JTextField();
        jTextField6.setEditable(false);
        jTextField7 = new javax.swing.JTextField();
        jTextField7.setEditable(false);
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
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 300));
        jb3 = ClassLoader.getSystemResource("img/usrnew.png"); 
		ib3 = Toolkit.getDefaultToolkit().getImage(jb3);       
        jButton1 = new javax.swing.JButton(new ImageIcon(ib3));
        jButton1.addActionListener(this);
        jb4 = ClassLoader.getSystemResource("img/usrupdate.png");   
		ib4 = Toolkit.getDefaultToolkit().getImage(jb4);       
        jButton2 = new javax.swing.JButton(new ImageIcon(ib4));        
        clientmap = new HashMap();
        productmap = new HashMap();
        if(f==1){
        	this.id=0;      	
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

        jLabel1.setText(" Project Name ");
        jPanel10.add(jLabel1, java.awt.BorderLayout.CENTER);

        jTextField1.setPreferredSize(new java.awt.Dimension(425, 20));
        jPanel10.add(jTextField1, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanel10, java.awt.BorderLayout.WEST);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Project"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Product & Version");
        jPanel8.add(jLabel5);
        if(f==2){
        	jPanel8.add(jTextField7);        	
        }else{
        	jPanel8.add(jComboBox3);        
        }
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Client");
        jPanel8.add(jLabel4);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        if(f==2){
        	jPanel8.add(jTextField6);
        }else{
        	jPanel8.add(jComboBox1);
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
        jPanel8.add(jLabel7);

        jPanel9.setLayout(new java.awt.BorderLayout());
        jPanel9.add(jTextField2, java.awt.BorderLayout.CENTER);

        jButton3.setText("...");
        jPanel9.add(jButton3, java.awt.BorderLayout.EAST);

        jPanel8.add(jPanel9);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Date End Ach");
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
        jPanel8.add(jComboBox2);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Description"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jTextArea1);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 10));

        jPanel4.add(jPanel7);

        jTabbedPane1.addTab("Project Informations", jPanel4);

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
		reProduc();
		reCl();
		if(f==2){
			reQuery(id);
			jComboBox1.setEnabled(false);	
			jComboBox3.setEnabled(false);	
		}		
	}
	public void reCl(){
		jComboBox1.removeAllItems();
		jComboBox1.addItem("");
		int i=0;
		try{			
			stat=con.createStatement();									
			rs = stat.executeQuery("SELECT id,name,code FROM client ORDER BY code ASC");
			while (rs.next()){				
				jComboBox1.addItem(rs.getString("code"));
				clientmap.put(new Integer(i),String.valueOf(rs.getInt("id"))+"_"+rs.getString("name"));
				i++;
			}
		}catch(Exception ex){	}
	}
	public void reProduc(){
		jComboBox3.removeAllItems();
		jComboBox3.addItem("");
		int i=0;
		try{			
			stat=con.createStatement();	
			if(jts.groupIt.indexOf("&")>0){
				//rs = stat.executeQuery("SELECT p.id,p.product FROM project p, products pr WHERE p.prodid=pr.id AND pr.product='Progesa' OR pr.product='eProgesa'");
				if(jts.groupIt.startsWith("QMS")){
					rs = stat.executeQuery("SELECT * FROM products WHERE product = 'QMS' OR product = 'QA'");															
				}else{					
					rs = stat.executeQuery("SELECT * FROM products WHERE product='Progesa' OR product='eProgesa'");					
				}
			}else if(jts.groupIt.equals("eRiskLine")){				
				rs = stat.executeQuery("SELECT * FROM products WHERE product='eRiskLine'");
			}else if(jts.groupIt.equals("TraceLine")){
				rs = stat.executeQuery("SELECT * FROM products WHERE product='TraceLine'");				
			}else{
				rs = stat.executeQuery("SELECT * FROM products");
			}	
			while (rs.next()){				
				jComboBox3.addItem(rs.getString("product")+" "+rs.getString("version"));
				productmap.put(new Integer(i),String.valueOf(rs.getInt("id"))+"_"+rs.getString("product")+"_"+rs.getString("version"));
				i++;
			}
		}catch(Exception ex){	}
	}
	public void reQuery(int id){		
		try{			
			stat=con.createStatement();									
			//rs = stat.executeQuery("SELECT * FROM project WHERE id="+id);
			rs = stat.executeQuery("SELECT pr.product,pr.comment,pr.date_start,p.product AS produ ,p.version,cl.code  FROM project pr,products p,client cl WHERE p.id=pr.prodid AND cl.id=pr.clid AND pr.id="+id);			
			rs.next();
			jTextField1.setText(rs.getString("product"));
			jTextField5.setText(rs.getString("date_start"));
			jTextField6.setText(rs.getString("code"));
			jTextField7.setText(rs.getString("produ")+" "+rs.getString("version"));
			jTextArea1.setText(rs.getString("comment"));
		}catch(Exception ex){
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton1){
			int idx1=0,idx3=0;
			String clientaz="",proektaz="";
			if(id==0){			
					idx1 = jComboBox1.getSelectedIndex();			
					if(idx1>0){	
						clientaz = (String)clientmap.get(idx1-1);
					}	
					idx3 = jComboBox3.getSelectedIndex();			
					if(idx3>0){	
						proektaz=(String)productmap.get(idx3-1);
					}		
						
					if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){
						name = "unknown";
					}else{
						name = jTextField1.getText();
					}	
					if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
						dates = "0000-00-00";
					}else{						
						dates=jTextField5.getText();			
					} 
					if(jTextField2.getText().equals(null)||jTextField2.getText().equals("")){
						datest = "0000-00-00";
					}else{						
						datest=jTextField2.getText();			
					} 
					if(jTextField4.getText().equals(null)||jTextField4.getText().equals("")){
						ver = "0";
					}else{
						ver = jTextField4.getText();
					} 
					if(jTextField3.getText().equals(null)||jTextField3.getText().equals("")){
						datesc = "0000-00-00";
					}else{
						datesc = jTextField3.getText();								
					} 
					if(jTextArea1.getText().equals(null)||jTextArea1.getText().equals("")){
						desc = "unknown";
					}else{
						desc = jTextArea1.getText();
					}
					String [] temp = new String[2];
					String [] ptemp = new String[3];
					if(idx1==0){
						clio="0";
					}else{
						temp = clientaz.split("_");
						clio=temp[0];
					}			
					if(jComboBox2.getSelectedItem().toString().equals("")){
						status="unknown";		
					}else{
						status = jComboBox2.getSelectedItem().toString();
					}
					if(idx3==0){
						prover="0";
					}else{
						ptemp=proektaz.split("_");
						prover = ptemp[0];
					}
					try{
						stat = con.createStatement();
						stat.execute("INSERT INTO project(product,prodid,clid,date_start,date_end_est,date_end_ac,status,comment) VALUES('"+name+"',"+prover+","+clio+",'"+dates+"','"+datest+"','"+datesc+"','"+status+"','"+desc+"')");
						//JOptionPane.showMessageDialog(jts,"New Project is Registered","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);
						if(JOptionPane.showConfirmDialog(jts,"New Project is Registered.\nDo you want to register another project ?","jTSWorkBook",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION) setVisible(false);				
					}catch(Exception ex){
						System.out.println("Error: "+ex.getMessage());
					}
					jTextField1.setText("");
					jTextField2.setText("");
					jTextField3.setText("");
					jTextField4.setText("");
					jTextField5.setText("");
					jTextArea1.setText("");
					/*
					newemp nemp = new newemp(jtsw,"New Employee",1,"0");
					nemp.show();
					*/					
			}else{					
					String qdata = "UPDATE project SET ";
					if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){				
					}else{
						name = jTextField1.getText();
						qdata = qdata + "product='"+name+"', ";
					}	
					if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
						
					}else{
						dates = jTextField5.getText();
						qdata = qdata + "date_start='"+dates+"' ,";			
					} 
					if(jTextField2.getText().equals(null)||jTextField2.getText().equals("")){
						
					}else{
						datest = jTextField2.getText();
						qdata = qdata + "date_end_est='"+datest+"' ,";
					} 			
					if(jTextField3.getText().equals(null)||jTextField3.getText().equals("")){
						
					}else{
						datesc = jTextField3.getText();
						qdata = qdata + "date_end_ac='"+datesc+"' ,";
					}					
					if(jTextArea1.getText().equals(null)||jTextArea1.getText().equals("")){
						
					}else{
						desc = jTextArea1.getText();
						qdata = qdata + "comment='"+desc+"'";
					}
					String [] temp = new String[2];
					String [] ptemp = new String[3];
						
					if(jComboBox2.getSelectedItem().toString().equals("")){
					
					}else{
						status = jComboBox2.getSelectedItem().toString();
						qdata = qdata + ",status='"+status+"' ";
					}
					
					qdata = qdata + " WHERE id="+String.valueOf(id);
					try{
						stat = con.createStatement();
						stat.execute(qdata);
						JOptionPane.showMessageDialog(jts,"Choosen Project is Modified","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					
					}catch(Exception ex){System.out.println(ex.getMessage());}
					
					
					
					jTextField1.setText("");
					jTextField2.setText("");
					jTextField3.setText("");
					jTextField4.setText("");
					jTextField5.setText("");
					jTextArea1.setText("");
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