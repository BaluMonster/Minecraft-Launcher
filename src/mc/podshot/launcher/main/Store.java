package mc.podshot.launcher.main;

public class Store {
	// Class for quickly storing and getting information that allows for the information to be used by other
	// Parts of the launcher without calling a function from the main class
	private static int ram;
	private static String username;
	private static char[] password;
	
	public static void setRam(int ramallowcation) {
		ram = ramallowcation;
	}
	
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
	
	public static int getRam() {
		return ram;
	}
	
	public static String getUsername() {
		return username;
	}

}
