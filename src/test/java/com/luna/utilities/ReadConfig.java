package com.luna.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = "C:\\Users\\ha890\\eclipse-workspaceNew2\\SeleniumFramework\\Configuration\\config.properties";

	public ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("Url not specified in Config file..");
		}
	}
	
	public String getBrowser() {
		String value = properties.getProperty("browser");
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException("browser not specified in Config file..");
		}
	}
	
	public String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
		
	}

	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}
}
