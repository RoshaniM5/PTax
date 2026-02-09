package com.mpro.ptax.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {

		private static Properties prop = new Properties();
	
		static {
			try {
					FileInputStream fis = new FileInputStream("C:\\Users\\rmulunde\\eclipse-workspace-VNIT\\PTax\\src\\test\\resources\\config.properties");
					prop.load(fis);
				
				}catch(Exception e) {
					
					throw new RuntimeException("Failed to load config file");
				
				}
		}
		
		public static String get(String key) {
			return prop.getProperty(key);
		}
	
}
