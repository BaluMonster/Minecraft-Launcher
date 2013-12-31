package mc.podshot.launcher.main;

import sk.tomsik68.mclauncher.api.login.IProfile;
import sk.tomsik68.mclauncher.api.login.ISession;
import sk.tomsik68.mclauncher.impl.common.Platform;
import sk.tomsik68.mclauncher.impl.login.yggdrasil.YDLoginService;
import sk.tomsik68.mclauncher.impl.login.yggdrasil.io.YDProfileIO;


public class login {

	public login() {
		
		try {
			YDLoginService yls = new YDLoginService();
			yls.load(Platform.getCurrentPlatform().getWorkingDirectory());
			
			YDProfileIO profileIO = new YDProfileIO(Platform.getCurrentPlatform().getWorkingDirectory());
			IProfile[] profiles = profileIO.read();
			IProfile profile = profiles[0];
			
			@SuppressWarnings("unused")
			ISession session;
			session = yls.login(profile);
			
			profiles[0] = profile;
			profileIO.write(profiles);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
