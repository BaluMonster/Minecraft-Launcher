package mc.podshot.launcher.main.internals;

import java.io.File;
import java.util.List;

public class GUIStore {
	
	private static List<String> zip;
	private static List<String> profiles;

	public static void setZipFiles(List<String> flist) {
		zip = flist;
	}
	
	public static List<String> getZipFiles() {
		return zip;
	}

	public static List<String> getProfiles() {
		return profiles;
	}
	
	public static void setProfiles(List<String> pros) {
		profiles = pros;
	}

}
