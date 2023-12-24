package services;

import httpclient.GetRequest;
import io.restassured.response.Response;
import util.EndPointReader;

import java.util.Map;

public class UserService{
	
	/**
	 * The Class CustomerService.
	 */
		/** The end point reader. */
		private EndPointReader endPointReader;
		
		/** The authentication headers. */
		private Map<String, String> authenticationHeaders;
		
		/** The end point. */
		String endPoint;

		/** The GET. */
		GetRequest get;
		
		/**
		 * Instantiates a new Ciams Constituent Profile Service
		 *
		 * @param domainUrl the domain url
		 */

	public UserService(String domainUrl) {
		endPointReader = new EndPointReader(domainUrl);
//		this.authenticationHeaders = authenticationHeaders;
		get = new GetRequest();
	}
	
	public Response getUserResponse() {
		endPoint= endPointReader.getUserEndpoint();
		Response response = get.getRequest(endPoint, authenticationHeaders);
		return response;
	}

	public Response getUserResponseWithInvalidURL() {
		String endPoint1= endPointReader.getUserEndpoint()+"test";
		Response response = get.getRequest(endPoint1, authenticationHeaders);
		return response;
	}
}
