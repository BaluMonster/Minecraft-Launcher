package mc.podshot.launcher.main;

import sk.tomsik68.mclauncher.api.login.IProfile;
import sk.tomsik68.mclauncher.api.login.ISession;
import sk.tomsik68.mclauncher.impl.common.Platform;
import sk.tomsik68.mclauncher.impl.login.legacy.LegacyLoginService;
import sk.tomsik68.mclauncher.impl.login.legacy.LegacyProfile;
import sk.tomsik68.mclauncher.impl.login.yggdrasil.YDLoginService;
import sk.tomsik68.mclauncher.impl.login.yggdrasil.YDProfile;


public class login {

	public login() {
		IProfile profile = new LegacyProfile("ben.gothard3@gmail.com", "password");
		LegacyLoginService lls = new LegacyLoginService();
		try {
			ISession session = lls.login(profile);
			System.out.println("Legacy Login: " + session.getSessionID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		YDLoginService yls = new YDLoginService();
		ISession session = null;
		try {
			yls.load(Platform.getCurrentPlatform().getWorkingDirectory());
			session = yls.login(profile);
			System.out.println("YD password login: " + session.getSessionID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			profile = new YDProfile("ben.gothard3@gmail.com", "password", session.getSessionID(), session.getUUID());
			session = yls.login(profile);
			System.out.println("YD session ID Login: " + session.getSessionID());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
