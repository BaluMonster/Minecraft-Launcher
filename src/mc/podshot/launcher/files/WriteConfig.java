package mc.podshot.launcher.files;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import mc.podshot.launcher.main.backround.ConfigStore;
import net.minidev.json.JSONObject;


public class WriteConfig {

	public static void writeConfig() {
		JSONObject config = new JSONObject();
		config.put("Last Profile Used", ConfigStore.getLastProfile());
		
		
		
		
		PrintWriter writer;
		try {
			writer = new PrintWriter("config/config.json", "UTF-8");
			writer.println(config);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
