package mc.podshot.launcher.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AskForPassword extends JPanel implements ActionListener {
	private static JFrame frame;

	public AskForPassword() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 203, 100);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPleaseEnterPassword = new JLabel("Please Enter Password");
		lblPleaseEnterPassword.setBounds(10, 11, 135, 14);
		panel.add(lblPleaseEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 36, 135, 20);
		panel.add(passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(10, 66, 89, 23);
		panel.add(btnSubmit);
	}
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	public String pass;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		pass = passwordField.getPassword().toString();
		frame.dispose();
		NewMainGUI.passWord = pass;
	}

	public static void build() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	private static void createAndShowGUI() {

		frame = new JFrame("Enter Password");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new AskForPassword();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);

	}
}
