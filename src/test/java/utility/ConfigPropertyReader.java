package utility;

import httpclient.GetRequest;

import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc

/**
 * This is the utility class for data read write.
 *
 * @author QAIT
 */
public class ConfigPropertyReader {

	/** The Constant defaultConfigFile. */
	private static final String defaultConfigFile = System.getProperty("user.dir") + File.separator
			+ "config.properties";
	
	/** The config settings. */
	private HashMap<String, String> configSettings;
	private Logger logger;

	/**
	 * construtor of this class.
	 */
	public ConfigPropertyReader() {
		configSettings = new HashMap<String, String>();
		configSettings = getSessionConfig();
		logger = Logger.getLogger(GetRequest.class.getName());
	}

	/**
	 * Gets the config settings.
	 *
	 * @return the config settings
	 */
	public HashMap<String, String> getConfigSettings() {
		return configSettings;
	}

	/**
	 * Gets the session config.
	 *
	 * @return the session config
	 */
	public HashMap<String, String> getSessionConfig() {
		configSettings = readAllPropertyVlauesFromConfigFile();
		Properties prop = System.getProperties();
		for (Object ob : configSettings.keySet()) {
			if (prop.keySet().contains(ob)) {
				configSettings.replace(ob.toString(), prop.get(ob).toString());
			}
		}
		return configSettings;
	}

	/**
	 * Read all property vlaues from config file.
	 *
	 * @return the hash map
	 */
	public static HashMap<String, String> readAllPropertyVlauesFromConfigFile() {
		HashMap<String, String> mymap = new HashMap<String, String>();
		Properties prop;
		try {
			prop = loadProperties(defaultConfigFile);
			for (final Entry<Object, Object> entry : prop.entrySet()) {
				mymap.put((String) entry.getKey(), (String) entry.getValue());
			}
			return mymap;
		} finally {
			// prop.c
		}
	}
	
	public static String getProperty(final String propFile, final String property) {
		try {
			Properties propERTY = loadProperties(propFile);
			return propERTY.getProperty(property);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static Properties loadProperties(String fileName){
		Properties properties = new Properties();
		try (FileInputStream input = new FileInputStream(fileName)) {
			// Load properties from the input stream
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error loading properties from file: " + fileName);
		}
		return properties;
	}
}
