package httpclient;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static io.restassured.filter.log.RequestLoggingFilter.logRequestTo;
import static io.restassured.filter.log.ResponseLoggingFilter.logResponseTo;

// TODO: Auto-generated Javadoc
/**
 * The Class GetRequest.
 */
public class GetRequest {

	/** The logger. */
	private Logger logger;

	/**
	 * Instantiates a new gets the request.
	 */
	public GetRequest() {
		RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().enablePrettyPrinting(false));
		logger = Logger.getLogger(GetRequest.class.getName());
	}

	/**
	 * Gets the request.
	 *
	 * @param url the url
	 * @param authHeaders the auth headers
	 * @param authToken the auth token
	 * @return the request
	 */
	public Response getRequest(String url, Map<String, String> authHeaders, String authToken) {
		final StringWriter writer = new StringWriter();
		Response res = RestAssured.given()
				.header("Authorization", "Bearer " +  authToken).headers(authHeaders).expect().when()
				.get(url).then().extract().response();
		logger.info("**********************************HTTP Request and Response********************************");
		logger.info("******************************************************************");
		String logs = writer.toString();
		logger.info(logs);
//		curlRequest("GetRequestandResponse", logs);
		logger.info("******************************************************************");
		logger.info("******************************************************************");
		return res;
	}

	/**
	 * Gets the request.
	 *
	 * @param url the url
	 * @param authHeaders the auth headers
	 * @param jsonBody the json body
	 * @return the request
	 */
	public Response getRequest(String url, Map<String, String> authHeaders,
			Object jsonBody) {
		final StringWriter writer = new StringWriter();
		Response res = RestAssured.given()
				 .header("Connection", "Close")
				 .contentType("application/json")
				.headers(authHeaders).body(jsonBody).when().get(url).then().extract().response();
		logger.info("**********************************HTTP Request and Response********************************");
		logger.info("******************************************************************");
		String logs = writer.toString();
		logger.info(logs);
//		curlRequest("GetRequestandResponse", logs);
		logger.info("******************************************************************");
		logger.info("******************************************************************");
		return res;
	}

	/**
	 * Gets the request with query param.
	 *
	 * @param url the url
	 * @param authHeaders the auth headers
	 * @param queryParam the query param
	 * @param authToken the auth token
	 * @return the request with query param
	 */
	public Response getRequestWithQueryParam(String url, Map<String, String> authHeaders,
			Map<String, String> queryParam, String authToken) {
		final StringWriter writer = new StringWriter();
		Response res = RestAssured.given()
				.header("Authorization", "Bearer "+ authToken).headers(authHeaders)

				.queryParams(queryParam).when().get(url).then().extract().response();
		logger.info("**********************************HTTP Request and Response********************************");
		logger.info("******************************************************************");
		String logs = writer.toString();
		logger.info(logs);
//		curlRequest("GetRequestandResponse", logs);
		logger.info(logs);
		logger.info("******************************************************************");
		logger.info("******************************************************************");
		return res;
	}

	/**
	 * Gets the request with query params.
	 *
	 * @param url the url
	 * @param authHeaders the auth headers
	 * @param queryParam the query param
	 */
	public Response getRequestWithQueryParams(String url, Map<String, String> authHeaders,Map<String,String> queryParam) {
		final StringWriter writer = new StringWriter();
		Response res = RestAssured.given()
				 .headers(authHeaders)
				.queryParams(queryParam).
				 expect().when().get(url).then().extract().response();
		logger.info("**********************************HTTP Request and Response********************************");
		logger.info("******************************************************************");
		String s = writer.toString();
		logger.info(s);
//		curlRequest("GetRequestandResponse", s);
		logger.info("******************************************************************");
		logger.info("******************************************************************");
		return res;
	}

	/**
	 * Gets the request.
	 *
	 * @param url the url
	 * @param authHeaders the auth headers
	 * @return the request
	 */
	public Response getRequest(String url, Map<String, String> authHeaders) {
		final StringWriter writer = new StringWriter();
		Response res = RestAssured.given()
				.headers(authHeaders).expect().when().get(url).then().extract().response();
		logger.info("**********************************HTTP Request and Response********************************");
		logger.info("******************************************************************");
		String s = writer.toString();
		logger.info(s);
		//System.out.println(writer);
//		curlRequest("GetRequestandResponse", s);
		logger.info("******************************************************************");
		logger.info("******************************************************************");
		return res;
	}

	/**
	 * Gets the request.
	 *
	 * @param url the url
	 * @param params the params
	 * @return the request
	 */
	public Response getRequest(String url, HashMap<String,String> params) {
		final StringWriter writer = new StringWriter();
		Response res = RestAssured.given()
				.params(params).get(url).then().extract().response();
		logger.info("**********************************HTTP Request and Response********************************");
		logger.info("******************************************************************");
		String s = writer.toString();
		logger.info(s);
//		curlRequest("AuthenticationRequest", s);
		logger.info("******************************************************************");
		logger.info("******************************************************************");
		return res;
	}

//	/**
//	 * Curl request.
//	 *
//	 * @param name the name
//	 * @param data the data
//	 * @return the string
//	 */
//	@Attachment(value = "{0}", type = "text/plain")
//	public static String curlRequest(final String name, final String data) {
//	    return data;
//	}
}
