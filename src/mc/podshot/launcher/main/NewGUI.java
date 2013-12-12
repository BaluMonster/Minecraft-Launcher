package mc.podshot.launcher.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;

import javax.swing.JFrame;

import java.awt.Cursor;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class NewGUI extends JPanel implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	//private JTextField username;
	//private JTextField password;
	private JPasswordField passwordfield;
	private JTextField textField;
	private JButton startButton;
	private JTextField Username;
	private JPasswordField Password;
	
	public NewGUI() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("63px"),
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(347dlu;min)"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("33px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("76dlu:grow"),}));
		
		JPanel loginPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) loginPanel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		add(loginPanel, "3, 2, 1, 2, left, top");
		
		JLabel lblNewLabel = new JLabel("Username");
		loginPanel.add(lblNewLabel);
		lblNewLabel.setLabelFor(Username);
		
		Username = new JTextField();
		loginPanel.add(Username);
		Username.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		loginPanel.add(lblNewLabel_1);
		
		Password = new JPasswordField();
		lblNewLabel_1.setLabelFor(Password);
		Password.setColumns(20);
		loginPanel.add(Password);
		
		JButton startButton = new JButton("Login");
		loginPanel.add(startButton);
		loginPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Username}));
		
		JPanel panel = new JPanel();
		add(panel, "3, 4");
		panel.setLayout(new MigLayout("", "[46px][46px][][][][][]", "[14px][][][][]"));
		
		if (Store.getLoginStatus().equalsIgnoreCase("green")) {
			JLabel loginLabel = new JLabel("Login Servers are Online");
			panel.add(loginLabel, "cell 6 0,alignx left,aligny top");
		} else {
			JLabel loginLabel = new JLabel("Login Servers are Offline");
			panel.add(loginLabel, "cell 6 0,alignx left,aligny top");
		}
		
		if (Store.getWebsiteStatus().equalsIgnoreCase("green")) {
			JLabel webLabel = new JLabel("The Minercaft Website is Online");
			webLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			panel.add(webLabel, "cell 6 2,alignx left,aligny top");
		} else {
			JLabel webLabel = new JLabel("The Minercaft Website is Offline");
			webLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			panel.add(webLabel, "cell 6 2,alignx left,aligny top");
		}
		
		if (Store.getAuthStatus().equalsIgnoreCase("green")) {
			JLabel sessionLabel = new JLabel("Authentication Servers are Online");
			panel.add(sessionLabel, "cell 6 4");
		} else {
			JLabel sessionLabel = new JLabel("Authentication Servers are Offline");
			panel.add(sessionLabel, "cell 6 4");
		}
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		startButton.setEnabled(false);
		File dir = new File("launcher_files");
		dir.mkdir();
		String user = textField.getText();
		char[] charedpass = passwordfield.getPassword();
		//String pass = String.valueOf(charedpass);
		//String ramallow = InGB.getText();
		//int intram = Integer.parseInt(ramallow);
		//Store.setRam(intram);
		Store.setUser(user);
		Store.setPassword(charedpass);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
	}
	
	private static void createAndShowGUI() {

		JFrame frame = new JFrame("Launcher Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new NewGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);

	}


	public static void build() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
