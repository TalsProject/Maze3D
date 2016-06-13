package utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileUtil {
	public static void writeGZipCompressToFile(Serializable obj, String fileFullPath) {
		try (FileOutputStream fos = new FileOutputStream(fileFullPath);
				GZIPOutputStream gos = new GZIPOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(gos)) {
			oos.writeObject(obj);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> T readGZipCompressFromFile(String fileFullPath) {
	    try (FileInputStream fin = new FileInputStream(fileFullPath);
	 		   GZIPInputStream gis = new GZIPInputStream(fin);
	 		   ObjectInputStream ois = new ObjectInputStream(gis)) {
	    	
	    	return (T) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
	    return null;
	}
	
	public static ByteArrayOutputStream objectToByteArrayOutputStream(Serializable obj) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(obj);
			return baos;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
