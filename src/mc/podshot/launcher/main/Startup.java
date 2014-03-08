package mc.podshot.launcher.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import mc.podshot.launcher.files.JSONWriter;
import mc.podshot.launcher.files.WriteConfig;
import mc.podshot.launcher.gui.MainGUI;
import mc.podshot.launcher.gui.NewMainGUI;
import mc.podshot.launcher.launch.GameLauncher;
import mc.podshot.launcher.launch.Launch;
import mc.podshot.launcher.main.backround.ConfigStore;
import mc.podshot.launcher.main.backround.GUIStore;
import mc.podshot.launcher.main.backround.LaunchStore;
import mc.podshot.launcher.main.resources.ListFiles;

public class Startup {

	private static Launch instance;

	public static void main(String[] args) {
		boolean debug = true;
		String version = "DEV";
		// File Setup
		File profiledir = new File("profiles");
		profiledir.mkdir();
		File configdir = new File("config");
		configdir.mkdir();
		// End File Setup
		File config = new File("config/config.properties");
		ConfigStore.setLastProfile("DEV");
		if (!config.exists()) {
			WriteConfig.writeConfig();
		}
		if (debug == true) {
			System.out.println("Podshot Launcher Version: " + version);
			JSONWriter.writeProfileJSON("test", "test2", debug, null, version);
			//try {
			//JSONWriter.updateJSON(0, version, version, profiledir);
			//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//}
		}
		// Execution Class, everything that need to be ran before the GUI is initalized
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
		List<String> list = ListFiles.listFiles("profiles/");
		GUIStore.setProfiles(list);
		System.out.println(list);
		
		GameLauncher launcher = new GameLauncher();
		launcher.downloadVersions();
		instance = new Launch(launcher);
		LaunchStore.setLaunch(launcher);
		//MainGUI.build();
		NewMainGUI.build();
		
		
	}

}
