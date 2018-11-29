package com.neogrid.conference.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class PropertiesReader {
	
	public static Properties getFuncionalProp(String parametro) {
		Properties prop = new Properties();
		
		try {
			InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(parametro);
			prop.load(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
