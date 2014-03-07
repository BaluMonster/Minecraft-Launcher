package mc.podshot.launcher.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class NewMainGUI extends JPanel implements ActionListener {
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
		lblPassword.setBounds(239, 14, 60, 14);
		LoginPanel.add(lblPassword);
		
		PassField = new JTextField();
		PassField.setBounds(294, 11, 150, 20);
		LoginPanel.add(PassField);
		PassField.setColumns(10);
	}
	private static final long serialVersionUID = 1L;
	private JTextField UserField;
	private JTextField PassField;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
