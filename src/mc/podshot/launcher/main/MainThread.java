package mc.podshot.launcher.main;

public class MainThread {
	
	public static void main(String[] args) {
		// Execution Class, everything that need to be ran before the GUI is initalized
		try {
			CheckServers.checkServers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		NewGUI.build();
	}

}
