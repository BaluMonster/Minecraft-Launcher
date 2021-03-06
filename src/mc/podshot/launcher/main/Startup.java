package mc.podshot.launcher.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import mc.podshot.launcher.files.JSONUtils;
import mc.podshot.launcher.files.WriteConfig;
import mc.podshot.launcher.gui.NewMainGUI;
import mc.podshot.launcher.launch.GameLauncher;
import mc.podshot.launcher.launch.Launch;
import mc.podshot.launcher.main.backround.Check4Updates;
import mc.podshot.launcher.main.internals.ConfigStore;
import mc.podshot.launcher.main.internals.GUIStore;
import mc.podshot.launcher.main.internals.LaunchStore;
import mc.podshot.launcher.main.internals.SystemStore;
import mc.podshot.launcher.main.resources.ListFiles;

public class Startup {

	@SuppressWarnings("unused")
	private static Launch instance;
	public static String version = "v0.0.1 DEV";
	private static boolean newer;
	public static boolean debug = true;

	public static void main(String[] args) {
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
		} else {
			Properties configFile = new Properties();
			try{
				configFile.load(new FileInputStream("config/config.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			String lastprofile = configFile.getProperty("Last-Profile");
			String doUpdate = configFile.getProperty("Allow-Updates");
			ConfigStore.setLastProfile(lastprofile);
			if (debug) {
				System.out.println(ConfigStore.getLastProfile());
			}

			if (doUpdate.equals("true")) {
				try {
					newer = Check4Updates.checkIfUpdate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				System.out.println(newer);
				/**
				if (newer) {
					File updates = new File("updates");
					updates.mkdir();
					try {
						Check4Updates.downloadUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				 **/
			}
		}

		/**
		File worldDir = new File("World Archives");
		if (!worldDir.exists()) {
			worldDir.mkdir();
		} else {

		}
		 **/
		if (debug == true) {
			System.out.println("Podshot Launcher Version: " + version);
			JSONUtils.writeProfileJSON("test", "test2", true, "1.7.4", "DEV", null);
			try {
				JSONUtils.updateJSON(0, "last Version Ran", "1.7.5", new File("profiles/Profile-Test.json"));
			} catch (IOException e) {
				e.printStackTrace();
			}
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
		List<String> fnlist = ListFiles.listFileNames("profiles/");
		GUIStore.setProfiles(fnlist);
		//System.out.println(fnlist);
		//List<String> flist = ListFiles.listFiles("World Archives");
		//System.out.println(flist);
		//GUIStore.setZipFiles(flist);
		SystemStore.setUserName(System.getProperty("user.name"));
		System.out.println(SystemStore.getUserName());
		GUIStart();

	}

	public static void GUIStart() {
		// Restarts the GUI and Refreshes Profile List
		// Currently used by the CreateProfile class
		List<String> fnlist = ListFiles.listFileNames("profiles/");
		GUIStore.setProfiles(fnlist);
		NewMainGUI.build();

		GameLauncher launcher = new GameLauncher();
		launcher.downloadVersions();
		instance = new Launch(launcher);
		LaunchStore.setLaunch(launcher);
	}
}
