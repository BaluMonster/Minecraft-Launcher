package mc.podshot.launcher.main.internals;

public class ConfigStore {
	
	private static String lastProfile;

	public static void setLastProfile(String pro) {
		lastProfile = pro;
	}

	public static String getLastProfile() {
		return lastProfile;
	}
}
