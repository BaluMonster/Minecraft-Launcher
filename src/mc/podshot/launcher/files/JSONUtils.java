package mc.podshot.launcher.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.JSONParser;

public class JSONUtils {
	
	public static void writeProfileJSON(String username, String password, boolean remember, String version, String profile, String mcdir){
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
		// int updatemode, String value
		BufferedReader reader = new BufferedReader(new FileReader(update));
		@SuppressWarnings("unused")
		String json = null;
		try {
			json = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String readJSON(String jsonPath, String field) {
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
