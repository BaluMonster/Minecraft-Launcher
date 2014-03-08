package mc.podshot.launcher.main.backround;

import java.io.File;
import java.util.List;

public class GUIStore {
	
	private static File zip;
	private static List<String> profiles;

	public static void setZipFile(File file) {
		zip = file;
	}
	
	public static File getZipFile() {
		return zip;
	}

	public static List<String> getProfiles() {
		return profiles;
	}
	
	public static void setProfiles(List<String> pros) {
		profiles = pros;
	}

}
