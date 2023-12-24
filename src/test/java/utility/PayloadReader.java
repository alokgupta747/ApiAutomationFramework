package utility;

import httpclient.GetRequest;

import java.io.*;
import java.util.logging.Logger;

// TODO: Auto-generated Javadoc

/**
 * The Class PayloadReader.
 */
public class PayloadReader {

	/** The config reader. */
	private ConfigPropertyReader configReader;
	private final Logger logger = Logger.getLogger(GetRequest .class.getName());;

	/**
	 * Instantiates a new payload reader.
	 */
	public PayloadReader() {
		configReader = new ConfigPropertyReader();
	}

	/**
	 * Gets the payload from file.
	 *
	 * @param fileName the file name
	 * @return the payload from file
	 */
	public String getPayloadFromFile(String fileName) {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "payloads" + File.separator
				+ configReader.getConfigSettings().get("tier") + File.separator + fileName;
		logger.info("Payload file is "+filePath);
		BufferedReader reader;
		StringBuilder responseStrBuilder = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = "";
			responseStrBuilder = new StringBuilder();
			while ((line = reader.readLine()) != null) {

				responseStrBuilder.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseStrBuilder.toString();
	}
	
	public String getPayloadFromFile(File fileName) {
		BufferedReader reader;
		StringBuilder responseStrBuilder = null;
		try {
			reader = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
			String line = "";
			responseStrBuilder = new StringBuilder();
			while ((line = reader.readLine()) != null) {

				responseStrBuilder.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseStrBuilder.toString();
	}
}
