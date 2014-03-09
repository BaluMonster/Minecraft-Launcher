package mc.podshot.launcher.files;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class WriteConfig {

	public static void writeConfig() {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("config/config.properties", "UTF-8");
			writer.println("Last-Profile=null");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
