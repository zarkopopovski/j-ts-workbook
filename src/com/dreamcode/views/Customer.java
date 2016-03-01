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

public class Customer extends JDialog implements ActionListener{
	
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField jTextField8; 
    private DefaultTableModel tableModel1; 
	private javax.swing.JTable jTable1;  
	public Statement stat;
	public ResultSet rs;	  	    
	public Connection con;
	public String ido,code,name,contact,tel,email,desc,city,region,fax;
	public JTSWorkBook jts;
	public URL jb1,jb2,jb3,jb4,jb5,jb6;
    public Image ib1,ib2,ib3,ib4,ib5,ib6;
	public Customer(JTSWorkBook parent,String s){
		super(parent,s,true);
		Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 650 ) / 2;
        int yPos = ( dimScreen.height - 650 ) / 2;        
		setBounds(xPos,yPos,650,650);		
		setResizable(false);		
		
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        //jTextField1.setPreferredSize(new java.awt.Dimension(80, 20));
        jTextField2 = new javax.swing.JTextField();
        //jTextField2.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();        
        jPanel9 = new javax.swing.JPanel(new BorderLayout());        
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registered Clients"));
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();        
        jTextField7 = new javax.swing.JTextField();        
        jTextField8 = new javax.swing.JTextField();        
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel(new GridLayout(10,1,5,5));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 625));
        jLabel3 = new javax.swing.JLabel();        
        jLabel7 = new javax.swing.JLabel("City ");   
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);             
        jLabel8 = new javax.swing.JLabel("Region ");        
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9 = new javax.swing.JLabel("Fax ");        
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
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
        //jButton3.setPreferredSize(new Dimension(40,20));      
        jButton3.addActionListener(this);
        jb4 = ClassLoader.getSystemResource("img/usrupdate.png");   
        ib4 = Toolkit.getDefaultToolkit().getImage(jb4);                  
        jButton4 = new javax.swing.JButton(new ImageIcon(ib4));
        jButton4.setText("Upd");
        jButton4.addActionListener(this);
        jButton4.setEnabled(false);
        jb5 = ClassLoader.getSystemResource("img/stop.png");   
        ib5 = Toolkit.getDefaultToolkit().getImage(jb5);                  
        jButton5 = new javax.swing.JButton(new ImageIcon(ib5));
        jButton5.setText("Del");
        jButton5.addActionListener(this);
        jButton5.setEnabled(false);
        jb6 = ClassLoader.getSystemResource("img/clear.png");  
        ib6 = Toolkit.getDefaultToolkit().getImage(jb6);                  
        jButton6 = new javax.swing.JButton(new ImageIcon(ib6));
        jButton6.setText("Clr");
        jButton6.addActionListener(this);                
        this.con=parent.con;
        tableModel1 = new DefaultTableModel();
        jTable1 = new javax.swing.JTable(tableModel1){
			public boolean isCellEditable(int rowIndex, int vColIndex) {
 				return false; 
			} 
		};
		jTable1.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				Object id;
				String clid;
				Object name;
				String cname;
				Object contact;
				String ccontact;
				Object ocity;
				String ccity;
				Object oregion;
				String rregion;
				Object tel;
				String ctel;
				Object ofax;
				String cfax;
				int drow; 
				if(me.getClickCount()!=2) return;
					drow = jTable1.rowAtPoint(me.getPoint());
					id = jTable1.getValueAt(drow, 0); 				  
					clid = (String)id;
					ido = clid;				  	
					try{
						stat = con.createStatement();
						rs=stat.executeQuery("SELECT * FROM client WHERE id="+clid);
						rs.next();
						jTextField1.setText(rs.getString("code"));
						jTextField2.setText(rs.getString("name"));
						jTextField3.setText(rs.getString("contact"));
						jTextField4.setText(rs.getString("tel"));
						jTextField5.setText(rs.getString("email"));
						jTextField6.setText(rs.getString("city"));
						jTextField7.setText(rs.getString("region"));
						jTextField8.setText(rs.getString("fax"));
						jTextArea1.setText(rs.getString("description"));
						jButton4.setEnabled(true);	
						jButton5.setEnabled(true);
					}catch(Exception ex){
						
					}					
				}
			});
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.add(jButton3);
        jPanel10.add(jButton4);
        jPanel10.add(jButton5);
        jPanel10.add(jButton6);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        jLabel1.setText(" Nick");
        jPanel3.add(jLabel1);

        jLabel2.setText(" Name");
        jPanel3.add(jLabel2);
        jPanel3.add(jTextField1);
        jPanel3.add(jTextField2);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2));
        jPanel4.setLayout(new java.awt.GridLayout(3,1,5,5));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Contact"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel8.setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contact");
        jPanel8.add(jLabel4);

        jTextField3.setPreferredSize(new java.awt.Dimension(30, 20));
        jPanel8.add(jTextField3);        
        
        jPanel8.add(jLabel7);
        jPanel8.add(jTextField6);
        
        jPanel8.add(jLabel8);
        jPanel8.add(jTextField7);
        
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telephone");
        jPanel8.add(jLabel5);
        jPanel8.add(jTextField4);
        
        jPanel8.add(jLabel9);
        jPanel8.add(jTextField8);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Email");
        jPanel8.add(jLabel6);
        jPanel8.add(jTextField5);
        
        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Comment"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Description");
       
        jPanel7.add(new JScrollPane(jTextArea1), java.awt.BorderLayout.CENTER);
        
        jPanel4.add(jPanel7);
		jPanel9.add(new JScrollPane(jTable1));
		jPanel4.add(jPanel9);
        jTabbedPane1.addTab("General Informations", jPanel4);

        jPanel5.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout(1, 7, 5, 5));
                
        jPanel2.add(new JLabel());
        jPanel2.add(new JLabel());
        jPanel2.add(new JLabel());        
        jPanel2.add(jButton1);        
        jPanel2.add(jButton2);

        add(jPanel10,BorderLayout.EAST);	
        
        //DBconnect(parent.podatok[2]);
        tableHeader1();        
        retrieveCustomer();
	}
	public void tableHeader1(){
		tableModel1.addColumn("Id");				
		tableModel1.addColumn("Nick");		
		tableModel1.addColumn("Name");
		
		TableColumn column0=jTable1.getColumnModel().getColumn(0);
		column0.setMinWidth(5);
		column0.setMaxWidth(50);
		column0.setPreferredWidth(30);		
		TableColumn column3=jTable1.getColumnModel().getColumn(1);
		column3.setMinWidth(50);
		column3.setMaxWidth(150);
		column3.setPreferredWidth(75);				
	}
	public void retrieveCustomer(){
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
			rs = stat.executeQuery("SELECT id,code,name FROM client ORDER BY code ASC");
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
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton1){			
			
		}else if(ae.getSource()==jButton2){			
			setVisible(false);
		}else if(ae.getSource()==jButton3){	
			if(jTextField1.getText().equals(null)||jTextField1.getText().equals("")){
				code = "unknown";
			}else{
				code = jTextField1.getText();
			}	
			if(jTextField2.getText().equals(null)||jTextField2.getText().equals("")){
				name = "unknown";
			}else{
				name = jTextField2.getText();
			} 
			if(jTextField3.getText().equals(null)||jTextField3.getText().equals("")){
				contact = "unknown";
			}else{
				contact = jTextField3.getText();
			} 
			if(jTextField4.getText().equals(null)||jTextField4.getText().equals("")){
				tel = "unknown";
			}else{
				tel = jTextField4.getText();
			} 
			if(jTextField5.getText().equals(null)||jTextField5.getText().equals("")){
				email = "unknown";
			}else{
				email = jTextField5.getText();
			}
			if(jTextField6.getText().equals(null)||jTextField6.getText().equals("")){
				city = "unknown";
			}else{
				city = jTextField6.getText();
			} 
			if(jTextField7.getText().equals(null)||jTextField7.getText().equals("")){
				region = "unknown";
			}else{
				region = jTextField7.getText();
			}
			if(jTextField8.getText().equals(null)||jTextField8.getText().equals("")){
				fax = "unknown";
			}else{
				fax = jTextField8.getText();
			}   
			if(jTextArea1.getText().equals(null)||jTextArea1.getText().equals("")){
				desc = "unknown";
			}else{
				desc = jTextArea1.getText();
			}											
			try{
				stat = con.createStatement();
				stat.execute("INSERT INTO client(name,code,contact,city,region,tel,fax,email,description,cdate) VALUES('"+name+"','"+code+"','"+contact+"','"+city+"','"+region+"','"+tel+"','"+fax+"','"+email+"','"+desc+"',NOW())");
			}catch(Exception ex){
				System.out.println("Error: "+ex.getMessage());
			}
			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			jTextField5.setText("");
			jTextField6.setText("");
			jTextField7.setText("");
			jTextField8.setText("");
			jTextArea1.setText("");
			retrieveCustomer();
		}else if(ae.getSource()==jButton4){			
			try{
				stat = con.createStatement();
				stat.execute("UPDATE client SET name='"+jTextField2.getText()+"',code='"+jTextField1.getText()+"',contact='"+jTextField3.getText()+"',city='"+jTextField6.getText()+"',region='"+jTextField7.getText()+"',tel='"+jTextField4.getText()+"',fax='"+jTextField8.getText()+"',email='"+jTextField5.getText()+"',description='"+jTextArea1.getText()+"' WHERE id="+ido);
			}catch(Exception ex){
				System.out.println("Error: "+ex.getMessage());
			}
			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			jTextField5.setText("");
			jTextField6.setText("");
			jTextField7.setText("");
			jTextField8.setText("");
			jTextArea1.setText("");
			jButton4.setEnabled(false);	
			jButton5.setEnabled(false);
			retrieveCustomer();
			ido="";
		}else if(ae.getSource()==jButton5){			
			try{
				stat = con.createStatement();
				stat.execute("DELETE FROM client WHERE id="+ido);
			}catch(Exception ex){
				System.out.println("Error: "+ex.getMessage());
			}
			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			jTextField5.setText("");
			jTextField6.setText("");
			jTextField7.setText("");
			jTextField8.setText("");
			jTextArea1.setText("");
			jButton4.setEnabled(false);	
			jButton5.setEnabled(false);
			retrieveCustomer();
			ido="";			
		}else if(ae.getSource()==jButton6){			
			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			jTextField5.setText("");
			jTextField6.setText("");
			jTextField7.setText("");
			jTextField8.setText("");
			jTextArea1.setText("");
			jButton4.setEnabled(false);	
			jButton5.setEnabled(false);
			retrieveCustomer();
			ido="";
		}			
		
	}	
	
	
}