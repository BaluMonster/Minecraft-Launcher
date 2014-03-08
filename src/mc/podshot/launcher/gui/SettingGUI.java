package mc.podshot.launcher.gui;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;

import mc.podshot.launcher.main.backround.GUIStore;
import mc.podshot.launcher.main.backround.LaunchStore;
import mc.podshot.launcher.main.backround.MCStore;

import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;

public class SettingGUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private JTextField mcDiretory;
	private JPanel panel;
	private JButton btnClose;
	private JLabel lblNewLabel;
	private JSpinner spinner;
	private JSpinner profileSpinner;

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
		
		JLabel lblRamAmount = new JLabel("Ram Amount");
		lblRamAmount.setBounds(80, 99, 81, 14);
		panel.add(lblRamAmount);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"512 MB", "1 GB", "1.5 GB", "2 GB", "2.5 GB", "3 GB"}));
		spinner.setBounds(171, 97, 71, 20);
		panel.add(spinner);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(80, 148, 46, 14);
		panel.add(lblProfile);
		
		profileSpinner = new JSpinner();
		List<String> list = GUIStore.getProfiles();
		String[] profiles = new String[ list.size() ];
		list.toArray(profiles);
		profileSpinner.setModel(new SpinnerListModel(profiles));
		profileSpinner.setBounds(131, 145, 111, 20);
		panel.add(profileSpinner);
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
		String ram = (String) spinner.getValue();
		System.out.println(ram);
		if (ram.equals("512 MB")) {
			MCStore.setRam(512);
		} else if (ram.equals("1 GB")) {
			MCStore.setRam(1024);
		} else if (ram.equals("1.5 GB")) {
			MCStore.setRam(1536);
		} else if (ram.equals("2 GB")) {
			MCStore.setRam(2048);
		} else if (ram.equals("2.5 GB")) {
			MCStore.setRam(2560);
		} else if (ram.equals("3 GB")) {
			MCStore.setRam(3072);
		}
		System.out.println(LaunchStore.getMCDir());
		frame.dispose();
	}
}
