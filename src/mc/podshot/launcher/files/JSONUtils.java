package mc.podshot.launcher.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public class JSONUtils {
	//Handles anything related to JSON Files
	
	public static void writeProfileJSON(String username, String password, boolean remember, String version, String profile, String mcdir){
		// Creates a new Profile JSON File
		JSONObject obj = new JSONObject();
		obj.put("Username", username);
		if (remember) {
			obj.put("Remember Password", new Boolean(true));
			obj.put("Password", password);
		} else {
			obj.put("Remember Password", new Boolean(false));
			obj.put("Password", null);
		}
		obj.put("Minecraft Directory", mcdir);
		obj.put("last Version Ran", version);
		System.out.print(obj);
		FileWriter writer;
		try {
			writer = new FileWriter("profiles/Profile-" + profile + ".json");
			writer.write(obj.toJSONString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateJSON(int updatemode, String field, String value, File update) throws IOException {
		// Updates to specified JSON File and field to the new specified value
		Object obj;
		try {
			obj = JSONValue.parse(new FileReader(update));
			JSONObject json = (JSONObject) obj;
			json.put(field, value);
			FileWriter writer = new FileWriter(update);
			writer.write(json.toJSONString());
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String readJSON(String jsonPath, String field) {
		// Reads the specified JSON File
		Object obj;
		String strval = null;
		try {
			obj = JSONValue.parse(new FileReader(jsonPath));
			
			JSONObject json = (JSONObject) obj;
			
			strval = (String) json.get(field);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return strval;
	}
	

}
