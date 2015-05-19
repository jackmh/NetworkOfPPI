package database;

import java.util.Properties;

public class DBConnectionConfig {
	private static Properties prop = new Properties();
	
	static {
		try{
			prop.load(DBConnectionConfig.class.getResourceAsStream("DBConnectionConfig.properties"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getPropertyByName(String name)
	{
		return prop.getProperty(name);
	}
}
