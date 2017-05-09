package Factory;

import Utilities.ConfigReader;

public class DataProviderFactory 
{
	public static ConfigReader getConfig()
	{
		ConfigReader config= new ConfigReader();
		return config;
	}
}
