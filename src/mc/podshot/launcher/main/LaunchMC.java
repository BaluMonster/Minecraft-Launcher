package mc.podshot.launcher.main;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import mc.podshot.launcher.main.backround.Store;

import sk.tomsik68.mclauncher.api.common.ILaunchSettings;
import sk.tomsik68.mclauncher.api.common.IObservable;
import sk.tomsik68.mclauncher.api.common.IObserver;
import sk.tomsik68.mclauncher.api.login.IProfile;
import sk.tomsik68.mclauncher.api.login.ISession;
import sk.tomsik68.mclauncher.api.versions.IVersion;
import sk.tomsik68.mclauncher.impl.common.Platform;
import sk.tomsik68.mclauncher.impl.common.mc.MinecraftInstance;
import sk.tomsik68.mclauncher.impl.login.yggdrasil.YDLoginService;
import sk.tomsik68.mclauncher.impl.login.yggdrasil.io.YDProfileIO;
import sk.tomsik68.mclauncher.impl.versions.mcdownload.MCDownloadVersionList;

public class LaunchMC {

	@SuppressWarnings("unused")
	public static void launch() {
		final String finalram = Store.getRam() + "G";
		final String username = Store.getUsername();
		final String pass = Store.decodePass();

		try {
			//final String pass = String.valueOf(Password);
			final MinecraftInstance mc = new MinecraftInstance(new File("podmc"));
			//final String finalram = ram + "G";
			MCDownloadVersionList versionList = new MCDownloadVersionList();
			versionList.addObserver(new IObserver<IVersion>() {

				@Override
				public void onUpdate(IObservable<IVersion> observable, IVersion changed) {
					if(changed.getUniqueID().equals("r1.7.4")) {
						try {
							changed.getInstaller().install(changed, mc, null);
							YDLoginService service = new YDLoginService();
							service.load(Platform.getCurrentPlatform().getWorkingDirectory());
							YDProfileIO profileIO = new YDProfileIO(Platform.getCurrentPlatform().getWorkingDirectory());
							IProfile[] profiles = profileIO.read();
							ISession session = service.login(profiles[0]);


							Process proc = changed.getLauncher().launch(session, mc, null, changed, new ILaunchSettings() {

								@Override
								public boolean isModifyAppletOptions() {
									return false;
								}

								@Override
								public boolean isErrorStreamRedirected() {
									return true;
								}

								@Override
								public File getJavaLocation() {
									return null;
								}

								@Override
								public List<String> getJavaArguments() {
									return null;
								}

								@Override
								public String getInitHeap() {
									return null;
								}

								@Override
								public String getHeap() {
									return null;
								}

								@Override
								public Map<String, String> getCustomParameters() {
									return null;
								}

								@Override
								public List<String> getCommandPrefix() {
									return null;
								}
							});
							BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
							String line;
							while (isProcessAlive(proc)) {
								line = br.readLine();
								if (line != null && line.length() > 0)
									System.out.println(line);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
			versionList.startDownload();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		protected static boolean isProcessAlive(Process proc) {
			try {
				proc.exitValue();
				return false;
			} catch (Exception e) {
				return true;
			}
		}

	}