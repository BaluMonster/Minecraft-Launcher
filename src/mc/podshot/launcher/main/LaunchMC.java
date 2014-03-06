package mc.podshot.launcher.main;

import sk.tomsik68.mclauncher.api.common.mc.IMinecraftInstance;
import sk.tomsik68.mclauncher.api.ui.IProgressMonitor;
import sk.tomsik68.mclauncher.api.versions.IVersion;
import sk.tomsik68.mclauncher.api.versions.IVersionList;

public class LaunchMC {

	public static void play(int i) throws Exception {
		IMinecraftInstance mc = null;
		IVersion version = null;
		IProgressMonitor progressMonitor = null;
		
		version.getInstaller().install(version, mc, progressMonitor);
		
	}

}
