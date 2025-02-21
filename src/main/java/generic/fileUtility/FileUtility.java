package generic.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

import generic.fileUtility.IPathConstants;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IPathConstants.filePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}
}
