package mc.podshot.launcher.main;

import java.util.Arrays;
import java.util.List;

import mc.podshot.launcher.main.backround.Store;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import sk.tomsik68.mclauncher.util.HttpUtils;

@SuppressWarnings("unused")
public class CheckServers {
	
	public static void checkServers() throws Exception {
		String status = HttpUtils.httpGet("http://status.mojang.com/check");
		Object json = JSONValue.parse(status);
		JSONArray array = (JSONArray) json;
		JSONObject web = (JSONObject)array.get(0);
		String website = (String) web.get("minecraft.net");
		JSONObject log = (JSONObject)array.get(1);
		String login = (String) log.get("login.minecraft.net");
		JSONObject ses = (JSONObject)array.get(2);
		String session = (String) ses.get("session.minecraft.net");
		JSONObject acc = (JSONObject)array.get(3);
		String accounts = (String) acc.get("account.mojang.com");
		JSONObject ath = (JSONObject)array.get(4);
		String auth = (String) ath.get("auth.mojang.com");
		JSONObject sk = (JSONObject)array.get(5);
		String skins = (String) sk.get("skins.minecraft.net");
		//List<String> statuses = Arrays.asList(website, login, session, accounts, auth, skins);
		//System.out.println(statuses);
		Store.setWebsiteStatus(website);
		Store.setLoginStatus(login);
		Store.setSessionStatus(session);
		Store.setAccountStatus(accounts);
		Store.setAuthStatus(auth);
		Store.setSkinStatus(skins);
	}

}
