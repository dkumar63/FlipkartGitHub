package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	Properties pro;
	public ConfigReader()
	{
	 try {
		 File src = new File("C:\\Users\\IBM_ADMIN\\git\\FlipkartGitHub\\Configuration\\config.properties");
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	 	} 
	 catch (FileNotFoundException e) {
		e.printStackTrace();
	 	} 
	 catch (IOException e) {
		e.printStackTrace();
	}
}

public String ChromePath()
{
	return pro.getProperty("ChromeDriverPath");
}
public String FirefoxPath()
{
	return pro.getProperty("FirefoxDriverPath");
}

public String IEPath()
{
	return pro.getProperty("IEDriverPath");
}

public String getUrl()
{
	return pro.getProperty("url");
}

}


