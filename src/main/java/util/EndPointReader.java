package util;

import com.jayway.jsonpath.JsonPath;

import java.io.*;

/**
 * The Class EndPointReader.
 */
public class EndPointReader {

	/** The end points. */
	private Object endPoints;

	private String apiVersion;

	/** The domain url. */
	private String domain_url;

	/**
	 * Instantiates a new end point reader.
	 *
	 * @param domain_url
	 * the domain url
	 */
	public EndPointReader(String domain_url) {
		endPoints = JsonPath.read(readFromStream().toString(), "$");
		this.domain_url = domain_url;
	}

	// *******************************************User***********************************

	public String getUserEndpoint() {
		return constructEndpointURL("$.user.get_user");
	}
	

	/**
	 * Read from stream.
	 *
	 * @return the string builder
	 */
	private StringBuilder readFromStream() {
		InputStream in = getClass().getResourceAsStream("endpoints.json");
		if (in == null) {
			System.err.println("Resource not found: endpoints.json");
			return new StringBuilder();  // or handle it in a way that makes sense for your application
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = "";
		StringBuilder responseStrBuilder = new StringBuilder();
		try {
			while ((line = reader.readLine()) != null) {
				responseStrBuilder.append(line);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return responseStrBuilder;
	}

	private String constructEndpointURL(String jsonPath) {
		return (domain_url + JsonPath.read(endPoints, jsonPath)).replace("{api_version}", apiVersion);
	}

}
