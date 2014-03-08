package mc.podshot.launcher.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import mc.podshot.launcher.files.UnZipper;
import mc.podshot.launcher.main.backround.GUIStore;
import mc.podshot.launcher.main.backround.LaunchStore;

public class NewMainGUI extends JPanel implements ActionListener {
	private JLabel loginLabel;
	private JLabel authLabel;
	private JLabel sessionLabel;
	private JLabel webLabel;
	private JLabel skinLabel;
	private JButton btnzipworld;


	public NewMainGUI() {
		setLayout(null);
		
		JPanel LoginPanel = new JPanel();
		LoginPanel.setBounds(0, 0, 521, 323);
		add(LoginPanel);
		LoginPanel.setLayout(null);
		
		UserField = new JTextField();
		UserField.setBounds(79, 11, 150, 20);
		LoginPanel.add(UserField);
		UserField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(22, 14, 60, 14);
		LoginPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(239, 14, 64, 14);
		LoginPanel.add(lblPassword);
		
		PassField = new JPasswordField();
		PassField.setBounds(313, 11, 150, 20);
		LoginPanel.add(PassField);
		PassField.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(22, 61, 89, 23);
		btnLogin.setActionCommand("launch");
		btnLogin.addActionListener(this);
		LoginPanel.add(btnLogin);
		
		btnSettings = new JButton("Settings");
		btnSettings.setBounds(121, 61, 89, 23);
		LoginPanel.add(btnSettings);
		btnSettings.setActionCommand("settings");
		btnSettings.addActionListener(this);
		
		btnzipworld = new JButton("UnZip World");
		btnzipworld.setBounds(220, 61, 105, 23);
		btnzipworld.setActionCommand("world");
		btnzipworld.addActionListener(this);
		LoginPanel.add(btnzipworld);
		
		JPanel infopanel = new JPanel();
		infopanel.setBounds(10, 124, 347, 177);
		LoginPanel.add(infopanel);
		infopanel.setLayout(null);
		
		if (LaunchStore.getLoginStatus().equalsIgnoreCase("green")) {
			loginLabel = new JLabel("Login Server is Online");
			loginLabel.setBounds(10, 10, 127, 14);
		} else {
			loginLabel = new JLabel("Login Server is Offline");
			loginLabel.setBounds(10, 10, 127, 14);
		}
		infopanel.add(loginLabel);
		
		if (LaunchStore.getAccountStatus().equalsIgnoreCase("green")) {
			accountLabel = new JLabel("Account Server is Online");
			accountLabel.setBounds(10, 30, 150, 14);
		} else {
			accountLabel = new JLabel("Account Server is Offline");
			accountLabel.setBounds(10, 30, 150, 14);
		}
		infopanel.add(accountLabel);
		
		if (LaunchStore.getAuthStatus().equalsIgnoreCase("green")) {
			authLabel = new JLabel("Authentication Server is Online");
			authLabel.setBounds(10, 50, 189, 14);
		} else {
			authLabel = new JLabel("Authentication Server is Offline");
			authLabel.setBounds(10, 50, 189, 14);
		}
		infopanel.add(authLabel);
		
		if (LaunchStore.getSessionStatus().equalsIgnoreCase("green")) {
			sessionLabel = new JLabel("Session Server is Online");
			sessionLabel.setBounds(10, 70, 150, 14);
		} else {
			sessionLabel = new JLabel("Session Server is Offline");
			sessionLabel.setBounds(10, 70, 150, 14);
		}
		infopanel.add(sessionLabel);
		
		if (LaunchStore.getWebsiteStatus().equalsIgnoreCase("green")) {
			webLabel = new JLabel("Minecraft.net is Online");
			webLabel.setBounds(10, 90, 150, 14);
		} else {
			webLabel = new JLabel("Minecraft.net is Offline");
			webLabel.setBounds(10, 90, 150, 14);
		}
		infopanel.add(webLabel);
		
		if (LaunchStore.getSkinStatus().equalsIgnoreCase("green")) {
			skinLabel = new JLabel("Skin Server is Online");
			skinLabel.setBounds(10, 110, 150, 14);
		} else {
			skinLabel = new JLabel("Skin Server is Offline");
			skinLabel.setBounds(10, 90, 150, 14);
		}
		infopanel.add(skinLabel);
	}
	private static final long serialVersionUID = 1L;
	private JTextField UserField;
	private JPasswordField PassField;
	private JButton btnLogin;
	private JButton btnSettings;
	private JLabel accountLabel;
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if ("launch".equals(arg0.getActionCommand())) {
			btnLogin.setEnabled(false);
			File dir = new File("launcher_files");
			dir.mkdir();
			String user = UserField.getText().toString();
			char[] charedpass = PassField.getPassword();
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
		} else if ("world".equals(arg0.getActionCommand())) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ZIP Archives", "zip");
			chooser.setFileFilter(filter);
			int returnVal  = chooser.showOpenDialog(this.getParent());
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +chooser.getSelectedFile());
			       GUIStore.setZipFile(chooser.getSelectedFile());
			       UnZipper.doZip();
			       GUIStore.setZipFile(null);
			}

		}
		
	}
	
	private static void createAndShowGUI() {

		JFrame frame = new JFrame("Launcher Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new NewMainGUI();
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
