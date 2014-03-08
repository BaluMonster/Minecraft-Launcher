package mc.podshot.launcher.main.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFiles {
	public static List<String> list = new ArrayList<>();
	
	
	public static List<String> listFiles(String ipath) {

		// Directory path here
		String path = ipath; 

		String files;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles(); 

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".json") || files.endsWith(".JSON")) {
					files = files.substring(0, files.lastIndexOf('.'));
					System.out.println(files);
					list.add(files);
				}
			}
		}
		return list;
	}


}
