package mc.podshot.launcher.main;

public class Store {
	private int ram;
	private String username;
	private char[] password;
	
	public void setRam(int ramallowcation) {
		this.ram = ramallowcation;
	}
	
	public void setUser(String user) {
		this.username = user;
	}
	
	public void setPassword(char[] pass) {
		this.password = pass;
	}
	
	public String decodePass() {
		String uncharedpass = String.valueOf(password);
		return uncharedpass;
	}
	
	public int getRam() {
		return ram;
	}
	
	public String getUsername() {
		return username;
	}

}
