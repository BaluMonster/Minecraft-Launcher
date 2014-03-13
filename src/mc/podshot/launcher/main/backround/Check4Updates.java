package mc.podshot.launcher.main.backround;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Properties;
import java.util.Scanner;

import mc.podshot.launcher.main.Startup;

public class Check4Updates {
	private static String dlURL;
	private static String fileName;
	private static Properties configFile = new Properties();

	public static boolean checkIfUpdate() throws Exception {
		// Looks at update file and cross checks it with the internal version number
		// If it does not match, get the download url and new version name
		boolean ret = false;
		URL url = new URL("http://dl.dropboxusercontent.com/s/3napt7qd80cnxu8/update.txt");
		configFile.load(url.openStream());
		String version = configFile.getProperty("new-version");
		dlURL = configFile.getProperty("file-url");
		fileName = configFile.getProperty("file-name");
		//downloadUpdate();
		if (!version.equals(Startup.version)) {
			ret = true;
		} else {
			if (Startup.debug) {
				System.out.println("No Newer Version");
				System.out.println(version);
				System.out.println(dlURL);
				System.out.println(fileName);
			}
		}
		return ret;	
	}

	public static void downloadUpdate() throws Exception {
		// Downloads the updated file to the "updates" folder
		File upDir = new File("updates");
		upDir.mkdir();
		URL updated = new URL(dlURL);
		ReadableByteChannel rbc = Channels.newChannel(updated.openStream());
		FileOutputStream fos = new FileOutputStream("updates/" + fileName);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	}
}
