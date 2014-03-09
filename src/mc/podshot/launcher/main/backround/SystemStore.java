package mc.podshot.launcher.main.backround;

public class SystemStore {

	private static String name;

	public static String getUserName() {
		return name;
	}
	
	public static void setUserName(String user) {
		name = user;
	}

}
