package mc.podshot.launcher.main.backround;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import mc.podshot.launcher.main.Startup;

public class Check4Updates {
	private static String dlURL;
	private static String fileName;
	
	public static boolean checkIfUpdate() throws Exception {
		boolean ret = false;
		URL url = new URL("http://dl.dropboxusercontent.com/s/3napt7qd80cnxu8/update.txt");
		Scanner s = new Scanner(url.openStream());
		String version = s.nextLine().toString();
		if (!version.equals(Startup.version)) {
			ret = true;
			dlURL = s.nextLine().toString();
			fileName = s.nextLine().toString();
		} else {
			System.out.println("No Newer Version");
			System.out.println(version);
		}
		return ret;	
	}
	
	public static void downloadUpdate() throws Exception {
		URL updated = new URL(dlURL);
		ReadableByteChannel rbc = Channels.newChannel(updated.openStream());
		FileOutputStream fos = new FileOutputStream(fileName);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	}
	
	public static void renameUpdate() {
		
	}

}
