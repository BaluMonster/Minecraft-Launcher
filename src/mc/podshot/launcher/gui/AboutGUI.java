package mc.podshot.launcher.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class AboutGUI extends JPanel implements ActionListener {
	private static JFrame frame;

	public AboutGUI() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 289);
		add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setEditable(false);
		txtpnInfo.setText("====================================\r\n\tAbout Pod-Launcher\r\n====================================\r\n\tPod-Launcher is a light-weight,\r\n\tcustomizable, java application \r\n\tfor launching Minecraft.\r\n\r\n====================================\r\n\tButtons\r\n====================================");
		txtpnInfo.setBounds(10, 11, 430, 267);
		panel.add(txtpnInfo);
	}
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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

		frame = new JFrame("Launcher About");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JComponent newContentPane = new AboutGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.setPreferredSize(new Dimension(300, 300));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);

	}
}
