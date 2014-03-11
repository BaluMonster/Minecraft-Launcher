package mc.podshot.launcher.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class AboutGUI extends JPanel implements ActionListener {
	public AboutGUI() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 263);
		add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setEditable(false);
		txtpnInfo.setText("=====================\r\nAbout Pod-Launcher\r\n=====================");
		txtpnInfo.setBounds(10, 11, 430, 230);
		panel.add(txtpnInfo);
	}
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static void build() {
		// TODO Auto-generated method stub
		
	}
}
