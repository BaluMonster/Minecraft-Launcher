package mc.podshot.launcher.main.deprecated;

import sk.tomsik68.mclauncher.api.common.IObservable;
import sk.tomsik68.mclauncher.api.common.IObserver;
import sk.tomsik68.mclauncher.api.versions.IVersion;
import sk.tomsik68.mclauncher.impl.versions.mcdownload.MCDownloadVersionList;

public class DownloadVersionList {
	
	public void DownloadVersion() {
        MCDownloadVersionList list = new MCDownloadVersionList();
        list.addObserver(new IObserver<IVersion>() {
            @Override
            public void onUpdate(IObservable<IVersion> observable, IVersion changed) {
                System.out.println(changed.getDisplayName());
            }
        });
        try {
            list.startDownload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
