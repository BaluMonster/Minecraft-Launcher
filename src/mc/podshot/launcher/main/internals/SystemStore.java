package mc.podshot.launcher.main.internals;

public class SystemStore {

	private static String name;

	public static String getUserName() {
		return name;
	}
	
	public static void setUserName(String user) {
		name = user;
	}

}
