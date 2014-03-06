package mc.podshot.launcher.gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mc.podshot.launcher.main.LaunchMC;
import mc.podshot.launcher.main.Startup;
import mc.podshot.launcher.main.backround.LaunchStore;
import mc.podshot.launcher.main.backround.MCStore;
import net.miginfocom.swing.MigLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MainGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	//private JTextField username;
	//private JTextField password;
	private JButton startButton;
	private JTextField Username;
	private JPasswordField Password;
	private JButton Settings;

	public MainGUI() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("63px"),
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("max(347dlu;min)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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

		startButton = new JButton("Login");
		loginPanel.add(startButton);
		startButton.setActionCommand("launch");
		startButton.addActionListener(this);
		loginPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Username}));

		Settings = new JButton("Settings");
		Settings.setToolTipText("Open Settings Window");
		Settings.setActionCommand("settings");
		Settings.addActionListener(this);
		add(Settings, "5, 2");

		JPanel panel = new JPanel();
		add(panel, "3, 4");
		panel.setLayout(new MigLayout("", "[46px][46px][][][][][]", "[14px][][][][][]"));

		//JLabel lblNewLabel_3 = new JLabel("New label");
		//panel.add(lblNewLabel_3, "cell 6 5");

		//JLabel loginLabel = new JLabel("Login Servers are Online");
		//panel.add(loginLabel, "cell 6 0,alignx left,aligny top");




		if (LaunchStore.getLoginStatus().equalsIgnoreCase("green")) {
			JLabel loginLabel = new JLabel("Login Server is Online");
			panel.add(loginLabel, "cell 6 0,alignx left,aligny top");
		} else {
			JLabel loginLabel = new JLabel("Login Server is Offline");
			panel.add(loginLabel, "cell 6 0,alignx left,aligny top");
		}

		if (LaunchStore.getWebsiteStatus().equalsIgnoreCase("green")) {
			JLabel webLabel = new JLabel("Minercaft.net is Online");
			webLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			panel.add(webLabel, "cell 6 1,alignx left,aligny top");
		} else {
			JLabel webLabel = new JLabel("Minercaft.net is Offline");
			webLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			panel.add(webLabel, "cell 6 1,alignx left,aligny top");
		}

		if (LaunchStore.getSessionStatus().equalsIgnoreCase("green")) {
			JLabel lblNewLabel_2 = new JLabel("Session Server is Online");
			panel.add(lblNewLabel_2, "cell 6 2");
		} else {
			JLabel lblNewLabel_2 = new JLabel("Session Server is Offline");
			panel.add(lblNewLabel_2, "cell 6 2");
		}

		if (LaunchStore.getAuthStatus().equalsIgnoreCase("green")) {
			JLabel sessionLabel = new JLabel("Authentication Server is Online");
			panel.add(sessionLabel, "cell 6 3");
		} else {
			JLabel sessionLabel = new JLabel("Authentication Server is Offline");
			panel.add(sessionLabel, "cell 6 3");
		}

		if (LaunchStore.getAccountStatus().equalsIgnoreCase("green")) {
			JLabel lblNewLabel_3 = new JLabel("Account Server is Online");
			panel.add(lblNewLabel_3, "cell 6 4");
		} else {
			JLabel lblNewLabel_3 = new JLabel("Account Server is Offline");
			panel.add(lblNewLabel_3, "cell 6 4");
		}

		if (LaunchStore.getAccountStatus().equalsIgnoreCase("green")) {
			JLabel lblNewLabel_3 = new JLabel("Skin Server is Online");
			panel.add(lblNewLabel_3, "cell 6 5");
		} else {
			JLabel lblNewLabel_3 = new JLabel("Skin Server is Offline");
			panel.add(lblNewLabel_3, "cell 6 5");
		}



	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if ("launch".equals(arg0.getActionCommand())) {
			startButton.setEnabled(false);
			File dir = new File("launcher_files");
			dir.mkdir();
			String user = Username.getText().toString();
			char[] charedpass = Password.getPassword();
			if (LaunchStore.getDebug() == true) {
				System.out.println("Username: " + user);
				System.out.println("Chared Password: " + charedpass.toString());
			}
			LaunchStore.setUser(user);
			LaunchStore.setPassword(charedpass);
			//MCStore.setRam(1);
			try {
				LaunchStore.getLauncher().play(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		} else if ("settings".equals(arg0.getActionCommand())) {
			SettingGUI.build();
			//System.exit(0);
		}

	}

	private static void createAndShowGUI() {

		JFrame frame = new JFrame("Launcher Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new MainGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);

	}

	public static void done() {
		System.exit(0);
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
