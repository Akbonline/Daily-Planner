/*Personal Organizer*/
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
 
class Login extends JDialog {
public Login() {
    setTitle("Log in");
    setSize(250,125);
    setLocation(400,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    getContentPane().setLayout(new GridLayout(3,2));
    getContentPane().add(new JLabel("User name: "));
    
    final JTextField username = new JTextField();
    getContentPane().add(username);
    getContentPane().add(new JLabel("Password: "));
    final JPasswordField password = new JPasswordField(10);
    getContentPane().add(password);
    final JButton okBtn = new JButton("OK");
    getContentPane().add(okBtn);
    final JButton cancelBtn = new JButton("Cancel");
    getContentPane().add(cancelBtn);
    
    okBtn.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		try {
    			InputStream is = this.getClass().getResourceAsStream("/users/userp.txt");
				BufferedReader validate = new BufferedReader(new InputStreamReader(is));
				String sval;
    			while ((sval = validate.readLine()) != null) {
    				StringTokenizer stu = new StringTokenizer(sval);
    				String us1 = stu.nextToken();
    				String us2 = stu.nextToken();
    				if (us1.equals(username.getText()) && 
    				(new String(password.getText()).equals(us2))) {
    					new Diary().setVisible(true);
    					dispose();
    				}
    			}
    		}
    		catch (FileNotFoundException ioe) {
    			JOptionPane.showMessageDialog(null, "Iternal Error, contact callin_24_7@yahoo.com if the error persists", "", JOptionPane.WARNING_MESSAGE);
    		}
    		catch (NoSuchElementException ioe) {}
    		catch (IOException ioe) {
    			JOptionPane.showMessageDialog(null, "Iternal Error, contact callin_24_7@yahoo.com if the error persists", "", JOptionPane.WARNING_MESSAGE);
    		}
    	}
    });
    
    cancelBtn.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent ae) {
    		System.exit(0);
    	}
    });
  }
  public static void main(String[] args) {
  	new Login().setVisible(true);
  }
}
class Diary extends JFrame implements ActionListener {
	private JTextArea note;
	private JTextField name;
 	private JMenuBar menu = new JMenuBar();
 	private JMenu file, edit, font, background, tcolor, settings, help;
 	private JMenuItem nu, copy, paste, save, exit, b8, b10, b12, b14, b16, b18, b20, b24, b30, bblue, bred, bgreen, bpink, cblue, cred, cgreen, cpink, eset, nver, using, about; 
 	private File dir = new File("saved/");
 	private String[] dirs = dir.list();
 	private JButton[] btn = new JButton[dirs.length];
 	
 	public Diary() {
 		setSize(new Dimension(500, 500));
 		setTitle("Personal Planner and Organizer");
 		
 		file = new JMenu("File");
 		menu.add(file);
 		
 		nu = new JMenuItem("new");
 		nu.addActionListener(this);
 		file.add(nu);
 		
 		file.add(new JSeparator());
 		
 		copy = new JMenuItem("copy");
 		copy.addActionListener(this);
 		file.add(copy);
 		
 		paste = new JMenuItem("paste");
 		paste.addActionListener(this);
 		file.add(paste);
 		
 		file.add(new JSeparator());
 		
 		save = new JMenuItem("Save");
 		save.addActionListener(this);
 		file.add(save);
 		
 		file.add(new JSeparator());
 		
 		exit = new JMenuItem("exit");
 		exit.addActionListener(this);
 		file.add(exit);
 		
 		edit = new JMenu("Edit");
 		menu.add(edit);
 		
 		font = new JMenu("font");
 		edit.add(font);
 		
 		b8 = new JMenuItem("8");
 		b8.addActionListener(this);
 		font.add(b8);
 		
 		b10 = new JMenuItem("10");
 		b10.addActionListener(this);
 		font.add(b10);
 		
 		b12 = new JMenuItem("12");
 		b12.addActionListener(this);
 		font.add(b12);
 		
 		b14 = new JMenuItem("14");
 		b14.addActionListener(this);
 		font.add(b14);
 		
 		b16 = new JMenuItem("16");
 		b16.addActionListener(this);
 		font.add(b16);
 		
 		b18 = new JMenuItem("18");
 		b18.addActionListener(this);
 		font.add(b18);
 		
 		b20 = new JMenuItem("20");
 		b20.addActionListener(this);
 		font.add(b20);
 		
 		b24 = new JMenuItem("24");
 		b24.addActionListener(this);
 		font.add(b24);
 		
 		b30 = new JMenuItem("30");
 		b30.addActionListener(this);
 		font.add(b30);
 		
 		background = new JMenu("background");
 		edit.add(background);
 		
 		bblue = new JMenuItem("blue");
 		bblue.addActionListener(this);
 		background.add(bblue);
 		
 		bred = new JMenuItem("red");
 		bred.addActionListener(this);
 		background.add(bred);
 		
 		bgreen = new JMenuItem("green");
 		bgreen.addActionListener(this);
 		background.add(bgreen);
 		
 		bpink = new JMenuItem("pink");
 		bpink.addActionListener(this);
 		background.add(bpink);
 		
 		tcolor = new JMenu("text color");
 		edit.add(tcolor);
 		
 		cblue = new JMenuItem("blue");
 		cblue.addActionListener(this);
 		tcolor.add(cblue);
 		
 		cred = new JMenuItem("red");
 		cred.addActionListener(this);
 		tcolor.add(cred);
 		
 		cgreen = new JMenuItem("green");
 		cgreen.addActionListener(this);
 		tcolor.add(cgreen);
 		
 		cpink = new JMenuItem("pink");
 		cpink.addActionListener(this);
 		tcolor.add(cpink);
 		
 		settings = new JMenu("Settings");
 		menu.add(settings);
 		
 		eset = new JMenuItem("Edit Settings");
 		eset.addActionListener(this);
 		settings.add(eset);
 		
 		help = new JMenu("Help");
 		menu.add(help);
 		
 		using = new JMenuItem("Using");
 		using.addActionListener(this);
 		help.add(using);
 		
 		about = new JMenuItem("About");
 		about.addActionListener(this);
 		help.add(about);
 		
 		help.add(new JSeparator());
 		
 		nver = new JMenuItem("new Versions");
 		nver.addActionListener(this);
 		help.add(nver);
 		
 		note = new JTextArea("");
 		
 		JPanel filepane = new JPanel(new GridLayout(25, 1));
 		for(int x = 0; x < btn.length; x++) {
      		btn[x] = new JButton(dirs[x]);
      		filepane.add(btn[x]);
      		final int bnum = x;
      		btn[x].addActionListener(new ActionListener(){
        		public void actionPerformed(ActionEvent ae){
          			String fi = btn[bnum].getLabel();
          			try {
          				BufferedReader filein = new BufferedReader(new FileReader("saved/" + fi));
          				String fin;
          				note.setText("");
          				name.setText(fi);
          				setTitle("Personal Planner and Organizer: " + fi);
          				while ((fin = filein.readLine()) != null) {
          					note.append(fin + "\n");
          				}
          			}
          			catch (FileNotFoundException ioe) {
          				JOptionPane.showMessageDialog(null, "Internal Error : Can not find the file", "", JOptionPane.WARNING_MESSAGE);
          			}
          			catch (IOException ioe) {
          				JOptionPane.showMessageDialog(null, "Internal Error", "", JOptionPane.WARNING_MESSAGE);
          			}
          		}});
    	}
 		
 		name = new JTextField("diary");
 		
 		JPanel npane = new JPanel(new GridLayout(0, 1));
 		npane.add(note);
 		
 		JScrollPane spane = new JScrollPane(npane);
 		
 		JPanel main = new JPanel(new GridLayout(0, 1));
 		getContentPane().add(spane);
 		getContentPane().add(name, BorderLayout.SOUTH);
 		getContentPane().add(filepane, BorderLayout.WEST);
 		
 		setJMenuBar(menu);
 	}
 	public void actionPerformed(ActionEvent e) {
 		if (e.getSource() == nu) {
 			int nuask = JOptionPane.showConfirmDialog(Diary.this, "Are you sure you want to make a new entry?\nThis will erase any unsaved entry's!!");
 			if (nuask == JOptionPane.YES_OPTION) {
 				note.setText("");
 				name.setText("diary");
 				setTitle("Personal Planner and Organizer");
 				note.setBackground(Color.WHITE);
 				note.setForeground(Color.BLACK);
 			}
 		}
 		if (e.getSource() == copy) {
 			note.copy();
 		}
 		if (e.getSource() == paste) {
 			note.paste();
 		}
 		if (e.getSource() == save) {
 			try {
 				String sn = name.getText();
                FileWriter outputStream = new FileWriter("saved/" + sn + ".txt");        				
                setTitle("Personal Planner and Organizer : " + sn);
                outputStream.write(note.getText());
                outputStream.close();
            }
            catch(IOException ioe) {
                 System.out.println("IOException");
            }
 		}
 		if (e.getSource() == exit) {
 			int exitask = JOptionPane.showConfirmDialog(Diary.this, "Are you sure you want to exit? Any unsaved entries will be deleted");
 			if (exitask == JOptionPane.YES_OPTION) {
 				System.exit(0);
 			}
 		}
 		if (e.getSource() == b8) {
 			note.setFont(new Font(note.getFont().getName(),note.getFont().getStyle(),8));
 		}
 		if (e.getSource() == b10) {
 			note.setFont(new Font(note.getFont().getName(),note.getFont().getStyle(),10));
 		}
 		if (e.getSource() == b12) {
 			note.setFont(new Font(note.getFont().getName(),note.getFont().getStyle(),12));
 		}
 		if (e.getSource() == b14) {
 			note.setFont(new Font(note.getFont().getName(),note.getFont().getStyle(),14));
 		}
 		if (e.getSource() == b18) {
 			note.setFont(new Font(note.getFont().getName(),note.getFont().getStyle(),18));
 		}
 		if (e.getSource() == b20) {
 			note.setFont(new Font(note.getFont().getName(),note.getFont().getStyle(),20));
 		}
 		if (e.getSource() == b24) {
 			note.setFont(new Font(note.getFont().getName(),note.getFont().getStyle(),24));
 		}
 		if (e.getSource() == b30) {
 			note.setFont(new Font(note.getFont().getName(),note.getFont().getStyle(),30));
 		}
 		if (e.getSource() == bblue) {
 			note.setBackground(Color.BLUE);
 		}
 		if (e.getSource() == bred) {
 			note.setBackground(Color.RED);
 		}
 		if (e.getSource() == bgreen) {
 			note.setBackground(Color.GREEN);
 		}
 		if (e.getSource() == bpink) {
 			note.setBackground(Color.PINK);
 		}
 		if (e.getSource() == cblue) {
 			note.setForeground(Color.BLUE);
 		}
 		if (e.getSource() == cred) {
 			note.setForeground(Color.RED);
 		}
 		if (e.getSource() == cgreen) {
 			note.setForeground(Color.GREEN);
 		}
 		if (e.getSource() == cpink) {
 			note.setForeground(Color.PINK);
 		}
 		if (e.getSource() == eset) {
 			new UserSettings().setVisible(true);
 		}
 	}
 }
class UserSettings extends JFrame implements ActionListener {
  private JMenuBar menu = new JMenuBar();
  private JMenu Settings;
  private JMenuItem exit, newuser;
  private JButton sset;
  String[] columnNames = {"users","passwords"};
  Vector dat = new Vector();
  private JTable usertable;
 
  public UserSettings() {
    setSize(new Dimension(350, 350));
    setTitle("User Setings");
    
    Settings = new JMenu("Settings");
    menu.add(Settings);
    
    newuser = new JMenuItem("new user");
    newuser.addActionListener(this);
    Settings.add(newuser);
    
    exit = new JMenuItem("Exit");
    exit.addActionListener(this);
    Settings.add(exit);
    
    sset = new JButton("Save settings");
    sset.addActionListener(this);
    try {
      BufferedReader userin = new BufferedReader(new FileReader("users/userp.txt"));
      String su;
      while ((su = userin.readLine()) != null) {
        String[] uspa = su.split(" ");
        dat.add(uspa);
      }
    }
    catch (FileNotFoundException ioe) {
      JOptionPane.showMessageDialog(null, "Internal Error, contact akshatbajpai.biz@gmail.com if the error persists", "", JOptionPane.WARNING_MESSAGE);
    }
    catch (ClassCastException ioe){}
    catch (NullPointerException ioe) {}
    catch (IOException ioe) {
      JOptionPane.showMessageDialog(null, "Internal Error, contact akshatbajpai.biz@gmail.com if the error persists", "", JOptionPane.WARNING_MESSAGE);
    }
    String[][] data = new String[dat.size()][];
    for(int x = 0; x < dat.size(); x++) {
      data[x] = (String[])dat.get(x);
    }
    usertable = new JTable();
    usertable.setModel(new DefaultTableModel( data, columnNames ));
    JScrollPane scrollpane = new JScrollPane(usertable);
    usertable.setPreferredScrollableViewportSize(new Dimension(50, 500));
    
    JPanel pane = new JPanel(new GridLayout(0, 1));
    getContentPane().add(scrollpane);
    getContentPane().add(sset, BorderLayout.SOUTH);
    setJMenuBar(menu);
  }
  public void actionPerformed(ActionEvent e) {
  	if (e.getSource() == newuser) {
  		int cont = usertable.getRowCount();
  		if (cont < 3) {
  			DefaultTableModel usertableModel = (DefaultTableModel)usertable.getModel();
            Object[] rowData = new Object[]{null,null};
            usertableModel.addRow(rowData);
  		}
  		else {
  			JOptionPane.showMessageDialog(null, "You can only have three users", "", JOptionPane.WARNING_MESSAGE);
  		}
  	}
    if (e.getSource() == sset) {
    	int count = usertable.getRowCount();
    	if (count == 1) {
    		Object u1 = usertable.getValueAt(0, 0);
    		String u1s = u1.toString();
    		Object p1 = usertable.getValueAt(0, 1);
    		String p1s = p1.toString();
    		try {
    			BufferedWriter c1 = new BufferedWriter(new FileWriter("users/userp.txt"));
    			String c1s = null;
    			c1.write(u1s + " " + p1s + "\n");
    			c1.close();
    		}
    		catch (IOException ioe) {
    			JOptionPane.showMessageDialog(null, "IO Error saving your changes", "", JOptionPane.WARNING_MESSAGE);
    		}
    	}
    	if (count == 2) {
    		Object tu1 = usertable.getValueAt(0, 0);
    		String tu1s = tu1.toString();
    		Object tp1 = usertable.getValueAt(0, 1);
    		String tp1s = tp1.toString();
    		Object tu2 = usertable.getValueAt(1, 1);
    		String tu2s = tu2.toString();
    		Object tp2 = usertable.getValueAt(1, 2);
    		String tp2s = tp2.toString();
    		try {
    			BufferedWriter c2 = new BufferedWriter(new FileWriter("users/userp.txt"));
    			String c2s = null;
    			c2.write(tu1s + " " + tp1s + "\n" + tu2s + " " + tp2s + "\n");
    			c2.close();
    		}
    		catch (IOException ioe) {
    			JOptionPane.showMessageDialog(null, "IO Error saving your changes", "", JOptionPane.WARNING_MESSAGE);
    		}
    	}
    	if (count == 3) {
    		Object thu1 = usertable.getValueAt(0, 0);
    		String thu1s = thu1.toString();
    		Object thp1 = usertable.getValueAt(0, 1);
    		String thp1s = thp1.toString();
    		Object thu2 = usertable.getValueAt(1, 1);
    		String thu2s = thu2.toString();
    		Object thp2 = usertable.getValueAt(1, 2);
    		String thp2s = thp2.toString();
    		Object thu3 = usertable.getValueAt(2, 2);
    		String thu3s = thu3.toString();
    		Object thp3 = usertable.getValueAt(2, 3);
    		String thp3s = thp3.toString();
    		try {
    			BufferedWriter c3 = new BufferedWriter(new FileWriter("users/userp.txt"));
    			String c3s = null;
    			c3.write(thu1s + " " + thp1s + "\n" + thu2s + " " + thp2s + "\n" + thu3s + " " + thp3s + "\n");
    		}
    		catch (IOException ioe) {
    			JOptionPane.showMessageDialog(null, "IO Error saving your changes", "", JOptionPane.WARNING_MESSAGE);
    		}
    	}
      dispose();
    }
    if (e.getSource() == exit) {
      int exitask = JOptionPane.showConfirmDialog(UserSettings.this, "Are you sure you want to exit? Any unsaved settinging changes will be lost!!");
      if (exitask == JOptionPane.YES_OPTION) {
        dispose();
      }
    }
  }
 }