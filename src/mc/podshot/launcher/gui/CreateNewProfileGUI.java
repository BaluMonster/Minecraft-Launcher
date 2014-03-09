package mc.podshot.launcher.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mc.podshot.launcher.main.backround.SystemStore;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class CreateNewProfileGUI extends JPanel implements ActionListener {
	private static JFrame frame;
	private JCheckBox chckbxRememberpassword;

	public CreateNewProfileGUI() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblProfileName = new JLabel("Profile Name");
		lblProfileName.setBounds(24, 27, 76, 14);
		panel.add(lblProfileName);
		
		textFieldProfileName = new JTextField();
		textFieldProfileName.setBounds(110, 24, 86, 20);
		panel.add(textFieldProfileName);
		textFieldProfileName.setColumns(10);
		
		JLabel lblMinecraftDirectory = new JLabel("Minecraft Directory");
		lblMinecraftDirectory.setBounds(24, 64, 115, 14);
		panel.add(lblMinecraftDirectory);
		
		txtC = new JTextField();
		String mcdir = "C:\\Users\\" + SystemStore.getUserName() + "\\AppData\\Roaming\\.minecraft";
		txtC.setText(mcdir);
		txtC.setBounds(162, 61, 251, 20);
		panel.add(txtC);
		txtC.setColumns(10);
		
		chckbxRememberpassword = new JCheckBox("Remember Password");
		chckbxRememberpassword.setBounds(24, 96, 149, 23);
		panel.add(chckbxRememberpassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(24, 148, 64, 14);
		panel.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(93, 145, 161, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 189, 64, 14);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(93, 186, 161, 20);
		panel.add(passwordField);
	}
	private static final long serialVersionUID = 1L;
	private JTextField textFieldProfileName;
	private JTextField txtC;
	private JTextField textField;
	private JPasswordField passwordField;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private static void createAndShowGUI() {

		frame = new JFrame("Launcher Settings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new CreateNewProfileGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.setPreferredSize(new Dimension(500, 400));
	    frame.pack();
	    frame.setLocationRelativeTo(null);
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
