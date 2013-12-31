package mc.podshot.launcher.main;

import mc.podshot.launcher.main.backround.Store;

public class MainThread {
	
	public static void main(String[] args) {
		// Execution Class, everything that need to be ran before the GUI is initalized
		@SuppressWarnings("unused")
		Store storing = new Store();
		try {
			CheckServers.checkServers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		NewGUI.build();
	}

}
