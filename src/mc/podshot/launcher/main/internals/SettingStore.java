package mc.podshot.launcher.main.internals;

public class SettingStore {
	private static String profile;

	public static void setProfile(String pro) {
		profile = pro;
	}
	
	public static String getProfile() {
		return profile;
	}
	

}
