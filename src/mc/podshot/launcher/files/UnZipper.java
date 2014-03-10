package mc.podshot.launcher.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import mc.podshot.launcher.main.backround.GUIStore;
import mc.podshot.launcher.main.backround.LaunchStore;

public class UnZipper {
	List<String> filelist;
	//private static final File INPUTZIPFILE = GUIStore.getZipFile();
	//private static final String destfolder = LaunchStore.getMCDir() + "/saves";
	//private static final String destfolder = "C:/Users/Jonathan/Videos/Dest/";
	
	public static void doZip(File file, String dest) {
		UnZipper unZip = new UnZipper();
    	unZip.unZipIt(file,dest);

	}
	
	public void unZipIt(File inputzipfile2, String outputFolder){
		 
	     byte[] buffer = new byte[1024];
	 
	     try{
	 
	    	//create output directory is not exists
	    	File folder = new File(outputFolder);
	    	if(!folder.exists()){
	    		folder.mkdir();
	    	}
	 
	    	//get the zip file content
	    	ZipInputStream zis = new ZipInputStream(new FileInputStream(inputzipfile2));
	    	//get the zipped file list entry
	    	ZipEntry ze = zis.getNextEntry();
	 
	    	while(ze!=null){
	 
	    	   String fileName = ze.getName();
	           File newFile = new File(outputFolder + File.separator + fileName);
	 
	           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
	 
	            //create all non exists folders
	            //else you will hit FileNotFoundException for compressed folder
	            new File(newFile.getParent()).mkdirs();
	 
	            FileOutputStream fos = new FileOutputStream(newFile);             
	 
	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }
	 
	            fos.close();   
	            ze = zis.getNextEntry();
	    	}
	 
	        zis.closeEntry();
	    	zis.close();
	 
	    	System.out.println("Done");
	 
	    }catch(IOException ex){
	       ex.printStackTrace(); 
	    }
	   }    


}
