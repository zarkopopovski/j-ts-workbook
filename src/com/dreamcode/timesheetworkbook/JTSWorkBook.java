package com.dreamcode.timesheetworkbook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

import com.dreamcode.utils.DateChooser;
import com.dreamcode.views.*;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.net.*;

public class JTSWorkBook extends JFrame implements ActionListener{
	private JButton jButton1;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;    
    private JButton jButton15;   
    private JButton jButton16;
    private JButton jButton17;
    private JButton jButton18;
    private JButton jButton19;
    private JButton jButton20;
    private JButton jButton21;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuBar jMenuBar1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;            
    private JPanel jPanel5;            
    private JPanel jPanel6;            
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JTabbedPane jTabbedPane1;
    private JTable jTable1;
    private JTable jTable2;
    private JToolBar jToolBar1;
    private JToolBar jToolBar2;
    private JToolBar jToolBar3;
    private DefaultTableModel tableModel1;
    private DefaultTableModel tableModel2;
    public JTextField sfield;
    public JTextField efield;
    private JLabel laba;
    public Connection con;
    public ResultSet rs;
    public Statement stat;
    public URL jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11,jb12,jb13,jb14,jb15,jb16,jb17,jb20,jb21;
    public Image ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16,ib17,ib20,ib21;
    public int uid; 
    public File f;
    public FileReader fr;
    public BufferedReader bf; 
    String user,pass,ip,port; 
    String [] temp;
    String [] podatok;
    public DateChooser dc;
    public StringTokenizer stoken;
	public String fdata,tdata,daj,mant,jiar;
	public static int loginid=0;
	public static int acclevel=0;
	public static String groupIt;
	public static boolean connected=false;
	public static boolean confexist=false;
	public JTSWorkBook(){
		setTitle("jTSWorkBook");
		Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ( dimScreen.width - 800 ) / 2;
        int yPos = ( dimScreen.height - 600 ) / 2;        
		setBounds(xPos,yPos,800,600);				
		jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();        
        tableModel1 = new DefaultTableModel();
        jTable1 = new javax.swing.JTable(tableModel1){
        	public boolean isCellEditable(int rowIndex, int vColIndex) {
 				return false; 
			} 
        };       
        jToolBar2 = new javax.swing.JToolBar();
        jb6 = ClassLoader.getSystemResource("img/nemp.png");           
        ib6 = Toolkit.getDefaultToolkit().getImage(jb6);                   
        jButton6 = new javax.swing.JButton(new ImageIcon(ib6));
        jButton6.setFocusable(false);
        jButton6.addActionListener(this);
        jb7 = ClassLoader.getSystemResource("img/edemp.png");
        ib7 = Toolkit.getDefaultToolkit().getImage(jb7);                   
        jButton7 = new javax.swing.JButton(new ImageIcon(ib7));
        jButton7.setFocusable(false);
        jButton7.addActionListener(this);
        jb8 = ClassLoader.getSystemResource("img/eremp.png");
        ib8 = Toolkit.getDefaultToolkit().getImage(jb8);                   
        jButton8 = new javax.swing.JButton(new ImageIcon(ib8));
        jButton8.setFocusable(false);
        jButton8.addActionListener(this);
        jb9 = ClassLoader.getSystemResource("img/find.png");
        ib9 = Toolkit.getDefaultToolkit().getImage(jb9);          
        jButton9 = new javax.swing.JButton(new ImageIcon(ib9));         
        jButton9.setFocusable(false);
        jButton9.addActionListener(this);
        jPanel4 = new javax.swing.JPanel();                
        jTable2 = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        jb10 = ClassLoader.getSystemResource("img/nemp.png");
        ib10 = Toolkit.getDefaultToolkit().getImage(jb10);          
        jButton10 = new javax.swing.JButton(new ImageIcon(ib10));        
        jButton10.addActionListener(this);
        jb11 = ClassLoader.getSystemResource("img/edemp.png");
        ib11 = Toolkit.getDefaultToolkit().getImage(jb11);          
        jButton11 = new javax.swing.JButton(new ImageIcon(ib11));
        jButton11.addActionListener(this);
        jb12 = ClassLoader.getSystemResource("img/eremp.png");
        ib12 = Toolkit.getDefaultToolkit().getImage(jb12);          
        jButton12 = new javax.swing.JButton(new ImageIcon(ib12));        
        jButton12.addActionListener(this);
        jb13 = ClassLoader.getSystemResource("img/find.png"); 
        ib13 = Toolkit.getDefaultToolkit().getImage(jb13); 
        jButton13 = new javax.swing.JButton(new ImageIcon(ib13));                 
        jButton13.addActionListener(this);
        jb14 = ClassLoader.getSystemResource("img/exit.png"); 
        ib14 = Toolkit.getDefaultToolkit().getImage(jb14); 
        jButton14 = new javax.swing.JButton(new ImageIcon(ib14));
        jButton14.setToolTipText("Exit jTSWorkBook");        
        jButton14.addActionListener(this);  
        jb15 = ClassLoader.getSystemResource("img/smlogo.png");
        ib15 = Toolkit.getDefaultToolkit().getImage(jb15); 
        jButton15 = new javax.swing.JButton(new ImageIcon(ib15));
        jButton15.setToolTipText("jTSWorkBook Time Sheet");        
        jButton15.addActionListener(this); 
        jb16 = ClassLoader.getSystemResource("img/conf.png");  
        ib16 = Toolkit.getDefaultToolkit().getImage(jb16); 
        jButton16 = new javax.swing.JButton(new ImageIcon(ib16));
        jButton16.setToolTipText("jTSWorkBook Configuration");        
        jButton16.addActionListener(this);
        jb17 = ClassLoader.getSystemResource("img/produ.png"); 
        ib17 = Toolkit.getDefaultToolkit().getImage(jb17); 
        jButton17 = new javax.swing.JButton(new ImageIcon(ib17));
        jButton17.setToolTipText("Products Manager");        
        jButton17.addActionListener(this);     
        jButton18 = new javax.swing.JButton("..."); 
        jButton18.addActionListener(this);                             
        jButton19 = new javax.swing.JButton("...");                
        jButton19.addActionListener(this);
        jb20 = ClassLoader.getSystemResource("img/show.png"); 
        ib20 = Toolkit.getDefaultToolkit().getImage(jb20);      
        jButton20 = new javax.swing.JButton(new ImageIcon(ib20));
        jButton20.setText("Search");        
        jButton20.addActionListener(this);
        jToolBar1 = new javax.swing.JToolBar();
        jb1 = ClassLoader.getSystemResource("img/custer.png");
        ib1 = Toolkit.getDefaultToolkit().getImage(jb1);
        jButton1 = new javax.swing.JButton(new ImageIcon(ib1));
        jButton1.setToolTipText("Clients Informations");        
        jButton1.addActionListener(this);
        jb2 = ClassLoader.getSystemResource("img/proj.png");
        ib2 = Toolkit.getDefaultToolkit().getImage(jb2);
        jButton2 = new javax.swing.JButton(new ImageIcon(ib2));        
        jButton2.setToolTipText("Projects Informations");        
        jButton2.addActionListener(this);
        jb3 = ClassLoader.getSystemResource("img/activ.png");
        ib3 = Toolkit.getDefaultToolkit().getImage(jb3);        
        jButton3 = new javax.swing.JButton(new ImageIcon(ib3));        
        jButton3.setToolTipText("Tasks and Activities Informations");        
        jButton3.addActionListener(this);                
        jb4 = ClassLoader.getSystemResource("img/emp.png");  
        ib4 = Toolkit.getDefaultToolkit().getImage(jb4);        
        jButton4 = new javax.swing.JButton(new ImageIcon(ib4));        
        jButton4.setToolTipText("Employees Informations");                  
        jButton4.addActionListener(this);        
        jb5 = ClassLoader.getSystemResource("img/gremp.png");
        ib5 = Toolkit.getDefaultToolkit().getImage(jb5);        
        jButton5 = new javax.swing.JButton(new ImageIcon(ib5));        
        jButton5.setToolTipText("Groups");                 
        jButton5.addActionListener(this);  
        
        jb21 = ClassLoader.getSystemResource("img/gremp.png");
        ib21 = Toolkit.getDefaultToolkit().getImage(jb21);        
        jButton21 = new javax.swing.JButton(new ImageIcon(ib21));        
        jButton21.setToolTipText("Teams Informations");                 
        jButton21.addActionListener(this);  
        
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel(new BorderLayout());
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 1, 1));
        jPanel6 = new javax.swing.JPanel(new BorderLayout());
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
        jPanel7 = new javax.swing.JPanel(new GridLayout(2,2,5,5));
        jPanel8 = new javax.swing.JPanel(new BorderLayout());
        jPanel9 = new javax.swing.JPanel(new BorderLayout());
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new JMenuItem("Test1");
        jMenuItem1.setToolTipText("Projects Informations"); 
        jMenuItem1.setMnemonic('e');
		jMenuItem1.addActionListener(this);
        jMenuItem2 = new JMenuItem("Test2");
        jMenuItem3 = new JMenuItem("Test3");
        jMenuItem4 = new JMenuItem("Test4");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem3);
        jMenu2.add(jMenuItem4);        
        tableModel2 = new DefaultTableModel();
        laba = new JLabel(" Maleeee");
  		sfield = new JTextField();
  		sfield.setEditable(false);
  		efield = new JTextField();
  		efield.setEditable(false);
  		                 
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(tableModel1);
        
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("From Date ");
        jPanel7.add(jLabel2);
        
        jPanel8.add(sfield, java.awt.BorderLayout.CENTER);

        jPanel8.add(jButton18, java.awt.BorderLayout.EAST);

        jPanel7.add(jPanel8);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("To Date ");
        jPanel7.add(jLabel3);
        
        jPanel9.add(efield, java.awt.BorderLayout.CENTER);
        
        jPanel9.add(jButton19, java.awt.BorderLayout.EAST);

        jPanel7.add(jPanel9);

        jPanel6.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel6.add(jButton20, java.awt.BorderLayout.EAST);
                
        jPanel5.add(jPanel6, java.awt.BorderLayout.NORTH);        
        
        jPanel5.add(new JScrollPane(jTable1), java.awt.BorderLayout.CENTER);        

        jToolBar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar2.setRollover(true);

        jToolBar2.add(jButton7);

        jToolBar2.add(jButton8);

        jPanel3.add(jToolBar2, java.awt.BorderLayout.NORTH);
        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);        

        jTabbedPane1.addTab("Effort Preview", jPanel3);
        
        jPanel4.setLayout(new java.awt.BorderLayout());

        jTable2.setModel(tableModel1);                

        jPanel4.add(new JScrollPane(jTable2), java.awt.BorderLayout.CENTER);

        jToolBar3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar3.setRollover(true);
        
        jToolBar3.add(jButton10);

        jToolBar3.add(jButton11);

        jToolBar3.add(jButton12);

        jToolBar3.add(jButton13);

        jPanel4.add(jToolBar3, java.awt.BorderLayout.PAGE_START);
        
        jPanel2.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setRollover(true);        
        
        jToolBar1.add(jButton1);
        
        jToolBar1.add(jButton21);
        
        jToolBar1.add(jButton17);
                
        jToolBar1.add(jButton2);
        
        jToolBar1.add(jButton3);        
              
        jToolBar1.add(jButton4);
                
        jToolBar1.add(jButton15);
        jToolBar1.add(jButton16);
        jToolBar1.add(new JSeparator(SwingConstants.VERTICAL));
        jToolBar1.add(jButton14);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Copyright by Zarko Popovski");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);
		add(jPanel1,BorderLayout.SOUTH);
        add(jToolBar1,BorderLayout.NORTH);
        
        jMenu1.setText("File");
        jMenu1.setMnemonic('f');
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setMnemonic('d');
        jMenuBar1.add(jMenu2);;
        tableHeader1();        
        try{
        	f = new File("conf.jvm");        	
        	temp = new String[2];
        	podatok = new String[4];
        	int i=0;      		
        	if(f.exists()){
        		confexist = true;
        	    fr = new FileReader(f);
        		bf = new BufferedReader(fr);
        		String line = bf.readLine();          		
        		while(line!=null){
        			temp = line.split(":");        			
        			podatok[i]=temp[1].trim();
        			i++;
        			line = bf.readLine();
        			//temp = null;
        		}        		
        		DBconnect(podatok[0]);
        		//reTSheet();   	        	
        	}else{
        		jButton1.setEnabled(false);
        		jButton2.setEnabled(false);
        		jButton3.setEnabled(false);
        		jButton4.setEnabled(false);
        		jButton5.setEnabled(false);
        		jButton6.setEnabled(false);
        		jButton7.setEnabled(false);
        		jButton8.setEnabled(false);
        		jButton9.setEnabled(false);
        		jButton10.setEnabled(false);
        		jButton11.setEnabled(false);
        		jButton12.setEnabled(false);
        		jButton13.setEnabled(false);
        		jButton15.setEnabled(false);
        		jButton17.setEnabled(false);
        	}
        	
        	
        }catch(Exception ex){ }
               
        //DBconnect();        
        //reTSheet();        
	}	
	public void tableHeader1(){		
		tableModel1.addColumn("Id");
		tableModel1.addColumn("Project");	
		tableModel1.addColumn("Task");		
		tableModel1.addColumn("Activity");
		tableModel1.addColumn("Date");
		tableModel1.addColumn("Effort");
		
		TableColumn column0=jTable1.getColumnModel().getColumn(0);
		column0.setMinWidth(5);
		column0.setMaxWidth(50);
		column0.setPreferredWidth(30);	
		TableColumn column2=jTable1.getColumnModel().getColumn(3);
		column2.setMinWidth(75);
		column2.setMaxWidth(125);
		column2.setPreferredWidth(100);	
		TableColumn column4=jTable1.getColumnModel().getColumn(4);
		column4.setMinWidth(50);
		column4.setMaxWidth(100);
		column4.setPreferredWidth(75);		
		TableColumn column5=jTable1.getColumnModel().getColumn(5);
		column5.setMinWidth(5);
		column5.setMaxWidth(50);
		column5.setPreferredWidth(45);		
	}
	public void tableHeader2(){		
		tableModel2.addColumn("Test");		
		tableModel2.addColumn("Test");
		tableModel2.addColumn("Test");
	}	

	private void DBconnect(String ip){
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			//con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jtswb","root","");			
			con = DriverManager.getConnection("jdbc:mysql://"+ip+"/jtswb","root","");			
			stat = con.createStatement();
			connected=true;
		}catch (ClassNotFoundException e){
       		//System.out.println("ERROR: "+e.getMessage());         
       		JOptionPane.showMessageDialog(JTSWorkBook.this,"Error: no connection","jTSWorkBook",JOptionPane.ERROR_MESSAGE);
       		jButton1.setEnabled(false);
        	jButton2.setEnabled(false);
        	jButton3.setEnabled(false);
        	jButton4.setEnabled(false);
        	jButton5.setEnabled(false);
        	jButton6.setEnabled(false);
        	jButton7.setEnabled(false);
        	jButton8.setEnabled(false);
        	jButton9.setEnabled(false);
        	jButton10.setEnabled(false);
        	jButton11.setEnabled(false);
        	jButton12.setEnabled(false);
        	jButton13.setEnabled(false);
        	jButton15.setEnabled(false);
        	jButton17.setEnabled(false);
     }catch(SQLException ex){
         //System.out.println("ERROR: "+ex.getMessage());
         	JOptionPane.showMessageDialog(JTSWorkBook.this,"Error: no connection","jTSWorkBook",JOptionPane.ERROR_MESSAGE);
         	jButton1.setEnabled(false);
        	jButton2.setEnabled(false);
        	jButton3.setEnabled(false);
        	jButton4.setEnabled(false);
        	jButton5.setEnabled(false);
        	jButton6.setEnabled(false);
        	jButton7.setEnabled(false);
        	jButton8.setEnabled(false);
        	jButton9.setEnabled(false);
        	jButton10.setEnabled(false);
        	jButton11.setEnabled(false);
        	jButton12.setEnabled(false);
        	jButton13.setEnabled(false);
        	jButton15.setEnabled(false);
        	jButton17.setEnabled(false);
      }
	}
	public String dateForm(String month){
		String nume="";		
		if(month.equals("Jan")){
			nume="01";
		}else if(month.equals("Feb")){
			nume="02";
		}else if(month.equals("Mar")){
			nume="03";
		}else if(month.equals("Apr")){
			nume="04";
		}else if(month.equals("May")){
			nume="05";
		}else if(month.equals("Jun")){
			nume="06";
		}else if(month.equals("Jul")){
			nume="07";
		}else if(month.equals("Aug")){
			nume="08";
		}else if(month.equals("Sep")){
			nume="09";
		}else if(month.equals("Oct")){
			nume="10";
		}else if(month.equals("Nov")){
			nume="11";
		}else if(month.equals("Dec")){
			nume="12";
		}		
		return nume;
	}
	public void testAndHide(int val){
		 if(val==2){
        	jButton1.setEnabled(false);    		
    		jButton4.setEnabled(false);    		
    		jButton17.setEnabled(false);
        }else if(val==3){
        	jButton1.setEnabled(false);
        	jButton2.setEnabled(false);    		    		
    		jButton4.setEnabled(false);    		
    		jButton17.setEnabled(false);
        }              
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==jButton14){
			if(JOptionPane.showConfirmDialog(
				JTSWorkBook.this,"Do you want to quit this application ?",
				"jTSWorkBook",JOptionPane.YES_NO_OPTION)
				==JOptionPane.YES_OPTION)
				System.exit(0);
		}else if(ae.getSource()==jButton1){
				Customer cus = new Customer(JTSWorkBook.this,"Clients Manager");
				cus.show();	
				//System.out.println("Muhaha");
			
		}else if(ae.getSource()==jButton2){
				Projector prj = new Projector(JTSWorkBook.this,"Projects Manager");
				prj.show();		
			
		}else if(ae.getSource()==jButton21){
			TeamsMng teamsMng = new TeamsMng(JTSWorkBook.this, "Teams Manager");
			teamsMng.show();		
		}else if(ae.getSource()==jButton3){
				Reprojector rect = new Reprojector(JTSWorkBook.this,"Tasks and Activities Manager");
				rect.show();		
			
		}else if(ae.getSource()==jButton4){
				Employeer emr = new Employeer(JTSWorkBook.this,"Employers Manager");
				emr.show();		
			
		}else if(ae.getSource()==jButton15){
				Timshe tshe = new Timshe(JTSWorkBook.this,"Time Sheet Manager",1,0);
				tshe.show();		
				reTSheet();
			
		}else if(ae.getSource()==jButton16){
				JTSWBConfig jtsconf = new JTSWBConfig(JTSWorkBook.this,"jTSWorkBook Configuration");
				jtsconf.show();
		}else if(ae.getSource()==jButton6){
				Timshe tshe = new Timshe(JTSWorkBook.this,"New Daily Time Sheet",1,0);
				tshe.show();		
				reTSheet();
		}else if(ae.getSource()==jButton7){				
				Object pid;
				String plid;
				int drow;
				drow = jTable1.getSelectedRow();													
				if(jTable1.isRowSelected(drow)){
					pid = jTable1.getValueAt(drow, 0);
					plid = (String)pid;					
					//System.out.println(plid);			
					Timshe tshe = new Timshe(JTSWorkBook.this,"Update Time Sheet",2,Integer.parseInt(plid));
					tshe.show();										
					reTSheet();
				}else{
					JOptionPane.showMessageDialog(JTSWorkBook.this,"Please select some task from tasks table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
				}								
		}else if(ae.getSource()==jButton8){
				Object pid;
				String plid;
				int drow;
				drow = jTable1.getSelectedRow();
				if(jTable1.isRowSelected(drow)){
					try{				
						pid = jTable1.getValueAt(drow, 0);
						plid = (String)pid;
						if(JOptionPane.showConfirmDialog(JTSWorkBook.this,"Are you sure that you want to delete selected time sheet effort ?",	"jTSWorkBook",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
							stat=con.createStatement();									
							stat.execute("DELETE FROM timesheet WHERE id="+plid); 
							//System.out.println(plid);					
							reTSheet();
							JOptionPane.showMessageDialog(JTSWorkBook.this,"Selected Record is Deleted","jTSWorkBook",JOptionPane.INFORMATION_MESSAGE);				
						}
					}catch(Exception ex){
						//System.out.println(ex);
					}
				}else{
					JOptionPane.showMessageDialog(JTSWorkBook.this,"Please select some time sheet record from time sheet table.","jTSWorkBook",JOptionPane.WARNING_MESSAGE);								
				}	
		}else if(ae.getSource()==jButton9){
				//srcTS sts = new srcTS(jTSWorkBook.this,"TimeSheet Searcher");
				//sts.show();		
			
		}else if(ae.getSource()==jButton17){
				Producto proc = new Producto(JTSWorkBook.this,"Products Manager");
				proc.show();		
			
		}else if(ae.getSource()==jButton18){
    		dc = new DateChooser();
			dc.show();	
			//sfield.setText("" + dc.getCalendar().getTime());		
			stoken = new StringTokenizer(dc.getCalendar().getTime().toString());
			stoken.nextToken();
			mant = stoken.nextToken();
			daj = stoken.nextToken();
			stoken.nextToken();
			stoken.nextToken();
			jiar = stoken.nextToken();			
			mant = dateForm(mant);			
			fdata=jiar+"-"+mant+"-"+daj;
			sfield.setText(fdata);
    	}else if(ae.getSource()==jButton19){
    		dc = new DateChooser();
			dc.show();	
			//efield.setText("" + dc.getCalendar().getTime());
			stoken = new StringTokenizer(dc.getCalendar().getTime().toString());
			stoken.nextToken();
			mant = stoken.nextToken();
			daj = stoken.nextToken();
			stoken.nextToken();
			stoken.nextToken();
			jiar = stoken.nextToken();
			mant = dateForm(mant);
			tdata=jiar+"-"+mant+"-"+daj;
			efield.setText(tdata);
    	}else if(ae.getSource()==jButton20){
    		if(sfield.getText().equals(null)||efield.getText().equals("")){
    			
			}else{				
				reSearch(0,sfield.getText(),"0");
			}
    		if(efield.getText().equals(null)||efield.getText().equals("")){
    			
			}else{				
				reSearch(0,efield.getText(),"0");
			}
			if(sfield.getText().equals(null)||sfield.getText().equals("")&&efield.getText().equals(null)||efield.getText().equals("")){
				
			}else{				
				reSearch(1,sfield.getText(),efield.getText());
			}
    		
    	}
		
		
	}
	public void reSearch(int opt,String fdat,String tdat){
		try{	
			int row = tableModel1.getRowCount();			
			while(row > 0)
			{	
				row--;				
				tableModel1.removeRow(row);
			}	
			
			//execute query			
			stat=con.createStatement();	
			switch(opt){
				case 0:
					rs = stat.executeQuery("SELECT DISTINCT s.id,p.product,t.taskname,a.actname,s.edate,s.effort FROM tasks t,activity a,timesheet s, employee e, project p WHERE t.id=s.tsid AND a.id=s.acid AND p.id=t.prid AND s.edate = '"+fdat+"' AND s.emid="+loginid+" ORDER BY s.edate DESC");									
					break;
				case 1:
					rs = stat.executeQuery("SELECT DISTINCT s.id,p.product,t.taskname,a.actname,s.edate,s.effort FROM tasks t,activity a,timesheet s, employee e, project p WHERE t.id=s.tsid AND a.id=s.acid AND p.id=t.prid AND s.edate BETWEEN '"+fdat+"' AND '"+tdat+"' AND s.emid="+loginid+" ORDER BY s.edate DESC");
					break;				
				default: break;	
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
				tableModel1.addRow(data);
			}
		}
		catch(Exception e) {
			//System.out.println(e);	
			//e.printStackTrace();
		}			
	}
	public void reTSheet(){		
		try{	
			int row = tableModel1.getRowCount();			
			while(row > 0)
			{	
				row--;				
				tableModel1.removeRow(row);
			}	
			
			//execute query			
			stat=con.createStatement();									
			//rs = stat.executeQuery("SELECT DISTINCT s.id,t.taskname,a.actname,s.edate,s.effort FROM tasks t,activity a,timesheet s, employee e WHERE t.id=s.tsid AND a.id=s.acid AND s.emid=0 ORDER BY s.id DESC");									
			rs = stat.executeQuery("SELECT DISTINCT s.id,p.product,t.taskname,a.actname,s.edate,s.effort FROM tasks t,activity a,timesheet s, employee e, project p WHERE t.id=s.tsid AND a.id=s.acid AND p.id=t.prid AND s.emid="+loginid+" ORDER BY s.edate DESC");									
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

	
	
	public static void main(String[] args){		
		JTSWorkBook jts = new JTSWorkBook();		
		jts.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					System.exit(0);
				}
			} 
						
		);		
		URL jb17 = ClassLoader.getSystemResource("img/smlogo.png"); 
		Image ib17 = Toolkit.getDefaultToolkit().getImage(jb17);     
		//jts.setIconImage(new ImageIcon("img/smlogo.png").getImage());
		jts.setIconImage(new ImageIcon(ib17).getImage());
		/*		
		try {      		
      		UIManager.setLookAndFeel("com.incors.plaf.kunststoff.KunststoffLookAndFeel");      		
      		
   		} catch (Exception e) {}	
   		*/		
		if(connected==true  && confexist==true){
        	Loginusr logas = new Loginusr(jts,"jTSWorkBook Login Panel");
			logas.show();
			loginid=logas.loginid;
			acclevel=logas.acclev;			
			groupIt=logas.grupit;
			jts.show();
			jts.testAndHide(acclevel);
			jts.reTSheet(); 						
			//System.out.println(String.valueOf(loginid));    
        }
        if(confexist==false){
        	jts.show();
        }   			   			
	}	
}
