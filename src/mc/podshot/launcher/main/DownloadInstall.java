package mc.podshot.launcher.main;

import java.io.File;

import sk.tomsik68.mclauncher.api.common.IObservable;
import sk.tomsik68.mclauncher.api.common.IObserver;
import sk.tomsik68.mclauncher.api.common.mc.IMinecraftInstance;
import sk.tomsik68.mclauncher.api.ui.IProgressMonitor;
import sk.tomsik68.mclauncher.api.versions.IVersion;
import sk.tomsik68.mclauncher.impl.common.mc.MinecraftInstance;
import sk.tomsik68.mclauncher.impl.versions.mcdownload.MCDownloadVersionList;

public class DownloadInstall {
	
	public void Install() {
		MCDownloadVersionList list = new MCDownloadVersionList();
		final IMinecraftInstance mc = new MinecraftInstance(new File("podtestmc"));
		list.addObserver(new IObserver<IVersion>() {
			private boolean installed = false;
			
			@Override
			public void onUpdate(IObservable<IVersion> observable, IVersion changed) {
				if (installed)
					return;
				installed = true;
				System.out.println("Installing " + changed.getDisplayName());
				try {
					changed.getInstaller().install(changed, mc, new IProgressMonitor() {
						
						public void setProgress(int progress) {
							//TODO
						}
						
						public void setMax(int len) {
							//TODO
						}
						
						public void incrementProgress(int amount) {
							//TODO
						}
						
						public void finish() {
							//TODO
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			list.startDownload();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
