//Added by RA
package org.iit.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfiguration {

	public Properties loadProperties() throws IOException {
		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir") + "\\config\\config.properties";
		System.out.println(filePath);
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
		return prop;
	}
}
