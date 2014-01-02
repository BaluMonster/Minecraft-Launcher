package mc.podshot.launcher.main;

import mc.podshot.launcher.main.backround.Store;

public class MainThread {
	
	public static void main(String[] args) {
		boolean debug = true;
		String version = "Alpha v0.0.5";
		if (debug == true) {
			System.out.println("Podshot Launcher Version: " + version + "\nHas been Initalized");
		}
		// Execution Class, everything that need to be ran before the GUI is initalized
		@SuppressWarnings("unused")
		Store storing = new Store();
		Store.setDebug(debug);
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
		NewGUI.build();
	}

}
