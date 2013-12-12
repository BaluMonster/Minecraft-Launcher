package mc.podshot.launcher.main;

public class MainThread {
	
	public static void main(String[] args) {
		try {
			CheckServers.checkServers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		NewGUI.build();
	}

}
