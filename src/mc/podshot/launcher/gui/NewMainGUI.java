package mc.podshot.launcher.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import mc.podshot.launcher.files.JSONUtils;
import mc.podshot.launcher.main.internals.ConfigStore;
import mc.podshot.launcher.main.internals.GUIStore;
import mc.podshot.launcher.main.internals.LaunchStore;

public class NewMainGUI extends JPanel implements ActionListener {
	// Main GUI Class
	public static JFrame frame;
	private JLabel loginLabel;
	private JLabel authLabel;
	private JLabel sessionLabel;
	private JLabel webLabel;
	private JLabel skinLabel;
	@SuppressWarnings("unused")
	private JButton btnzipworld;
	private JSpinner profileSpinner;
	private JButton btnCreateProfile;
	private JButton btnAbout;
	public static String passWord;


	public NewMainGUI() {
		// Sets up GUI, Uses Absolute Layout
		setLayout(null);

		JPanel LoginPanel = new JPanel();
		LoginPanel.setBounds(0, 0, 596, 323);
		add(LoginPanel);
		LoginPanel.setLayout(null);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(174, 22, 89, 23);
		btnLogin.setActionCommand("launch");
		btnLogin.addActionListener(this);
		LoginPanel.add(btnLogin);

		btnSettings = new JButton("Settings");
		btnSettings.setBounds(273, 22, 89, 23);
		LoginPanel.add(btnSettings);
		btnSettings.setActionCommand("settings");
		btnSettings.addActionListener(this);

		/**
		btnzipworld = new JButton("UnZip World");
		btnzipworld.setBounds(22, 58, 105, 23);
		btnzipworld.setActionCommand("world");
		btnzipworld.addActionListener(this);
		LoginPanel.add(btnzipworld);
		**/

		JPanel infopanel = new JPanel();
		infopanel.setBounds(10, 124, 347, 177);
		LoginPanel.add(infopanel);
		infopanel.setLayout(null);

		profileSpinner = new JSpinner();
		List<String> list = GUIStore.getProfiles();
		String[] profiles = new String[ list.size() ];
		list.toArray(profiles);
		profileSpinner.setModel(new SpinnerListModel(profiles));
		profileSpinner.setBounds(53, 23, 111, 20);
		LoginPanel.add(profileSpinner);

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

		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(10, 26, 46, 14);
		LoginPanel.add(lblProfile);

		btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.setBounds(137, 58, 126, 23);
		btnCreateProfile.setActionCommand("create");
		btnCreateProfile.addActionListener(this);
		LoginPanel.add(btnCreateProfile);
		
		btnAbout = new JButton("About");
		btnAbout.setBounds(20, 58, 89, 23);
		btnAbout.setActionCommand("about");
		btnAbout.addActionListener(this);
		LoginPanel.add(btnAbout);
		
	}
	private static final long serialVersionUID = 1L;
	private JButton btnLogin;
	private JButton btnSettings;
	private JLabel accountLabel;


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if ("launch".equals(arg0.getActionCommand())) {
			btnLogin.setEnabled(false);
			File dir = new File("launcher_files");
			dir.mkdir();
			String profile2use = (String) profileSpinner.getValue();
			String username = JSONUtils.readJSON("profiles/" + profile2use + ".json", "Username");
			System.out.println("Using profile: " + profile2use);
			//String user = UserField.getText().toString();
			//char[] charedpass = PassField.getPassword();
			//if (LaunchStore.getDebug() == true) {
			//System.out.println("Username: " + user);
			//System.out.println("Chared Password: " + charedpass.toString());
			//}
			//LaunchStore.setUser(user);
			//LaunchStore.setPassword(charedpass);
			//MCStore.setRam(1);
			
			if (JSONUtils.readJSON("profiles/" + profile2use + ".json", "Remember Password").equals("false")) {
				AskForPassword.build();
			}
			
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
			System.out.println("Can't Unzip World Files Yet!");
		} else if ("create".equals(arg0.getActionCommand())) {
			CreateNewProfileGUI.build();
		} else if ("about".equals(arg0.getActionCommand())) {
			AboutGUI.build();
		}

	}

	private static void createAndShowGUI() {

		frame = new JFrame("Launcher Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new NewMainGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setLocationRelativeTo(null);
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
