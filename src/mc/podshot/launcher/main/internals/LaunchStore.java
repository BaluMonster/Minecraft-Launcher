package mc.podshot.launcher.main.internals;

import mc.podshot.launcher.launch.GameLauncher;

public class LaunchStore {
	// Class for quickly storing and getting information that allows for the information to be used by other
	// Parts of the launcher without calling a function from the main class
	private static String username;
	private static char[] password;
	private static String website;
	private static String login;
	private static String session;
	private static String accounts;
	private static String auth;
	private static String skins;
	private static boolean debug;
	private static String dir;
	private static GameLauncher launcher;
	
	public static void setUser(String user) {
		username = user;
	}
	
	public static void setPassword(char[] pass) {
		password = pass;
	}
	
	public static String decodePass() {
		String uncharedpass = String.valueOf(password);
		return uncharedpass;
	}
	
	public static String getUsername() {
		return username;
	}

	public static void setWebsiteStatus(String web) {
		website = web;
	}

	public static void setLoginStatus(String log) {
		login = log;
	}

	public static void setSessionStatus(String ses) {
		session = ses;
	}

	public static void setAccountStatus(String acc) {
		accounts = acc;
	}

	public static void setAuthStatus(String ath) {
		auth = ath;
	}

	public static void setSkinStatus(String skin) {
		skins = skin;
	}
	
	public static void setDebug(boolean deb) {
		debug = deb;
		
	}
	
	public static String getWebsiteStatus() {
		return website;
	}
	
	public static String getLoginStatus() {
		return login;
	}
	
	public static String getSessionStatus() {
		return session;
	}
	
	public static String getAccountStatus() {
		return accounts;
	}
	
	public static String getAuthStatus() {
		return auth;
	}
	
	public static String getSkinStatus() {
		return skins;
	}
	
	public static boolean getDebug() {
		return debug;
	}

	public static void setMCDir(String mcDir) {
		dir = mcDir;
		
	}
	
	public static String getMCDir() {
		return dir;
	}
	
	public static void setLaunch(GameLauncher laun) {
		launcher = laun;
	}
	
	public static GameLauncher getLauncher() {
		return launcher;
	}

}
