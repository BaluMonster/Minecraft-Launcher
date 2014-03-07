package mc.podshot.launcher.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import net.minidev.json.JSONObject;

public class JSONWriter {
	
	public static void writeProfileJSON(String username, String password, boolean remember, String version, String profile){
		JSONObject obj = new JSONObject();
		obj.put("Username", username);
		if (remember) {
			obj.put("Remember Password", new Boolean(true));
			obj.put("Password", password);
		} else {
			obj.put("Remember Password", new Boolean(false));
			obj.put("Password", null);
		}
		obj.put("last Version Ran", version);
		System.out.print(obj);
		PrintWriter writer;
		try {
			writer = new PrintWriter("profiles/Profile-" + profile + ".json", "UTF-8");
			writer.println(obj);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
