package mc.podshot.launcher.main;

import mc.podshot.launcher.gui.MainGUI;
import mc.podshot.launcher.launch.GameLauncher;
import mc.podshot.launcher.launch.Launch;
import mc.podshot.launcher.main.backround.LaunchStore;

public class Startup {
	
	private static Launch instance;

	public static void main(String[] args) {
		boolean debug = true;
		String version = "DEV";
		if (debug == true) {
			System.out.println("Podshot Launcher Version: " + version);
		}
		// Execution Class, everything that need to be ran before the GUI is initalized
		@SuppressWarnings("unused")
		LaunchStore storing = new LaunchStore();
		LaunchStore.setDebug(debug);
		try {
			CheckServers.checkServers();
			if (debug == true) {
				System.out.println("Checking Servers");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (debug == true) {
			System.out.println("Building GUI");
		}
		GameLauncher launcher = new GameLauncher();
		launcher.downloadVersions();
		instance = new Launch(launcher);
		LaunchStore.setLaunch(launcher);
		MainGUI.build();
	}

}
