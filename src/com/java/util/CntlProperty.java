package com.java.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class CntlProperty {
	private static String msgPath = "src/resource/message.properties";
	private static Properties p = null;
	public static String msg(String key) {
		String value = "";
		try {
			if(p == null) {
				p = new Properties();
				InputStream is = new FileInputStream(new File (msgPath));
				p.load(is);
			}
			value = (String)p.get(key);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return value;
	}
}
