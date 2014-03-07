package mc.podshot.launcher.gui;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;

import mc.podshot.launcher.main.backround.LaunchStore;

public class SettingGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private JTextField mcDiretory;
	private JPanel panel;
	private JButton btnClose;
	private JLabel lblNewLabel;

	public SettingGUI() {
		setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 444, 300);
		add(panel);
		panel.setLayout(null);

		btnClose = new JButton("Save & Close Settings");
		btnClose.setBounds(80, 5, 185, 23);
		btnClose.addActionListener(this);
		panel.add(btnClose);

		lblNewLabel = new JLabel("Minecraft Directory");
		lblNewLabel.setBounds(80, 53, 117, 14);
		panel.add(lblNewLabel);

		mcDiretory = new JTextField();
		mcDiretory.setBounds(207, 50, 172, 20);
		panel.add(mcDiretory);
		mcDiretory.setColumns(10);
	}

	private static void createAndShowGUI() {

		frame = new JFrame("Launcher Settings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new SettingGUI();
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String mcDir = mcDiretory.getText().toString();
		LaunchStore.setMCDir(mcDir);
		System.out.println(LaunchStore.getMCDir());
		frame.dispose();
	}
}
