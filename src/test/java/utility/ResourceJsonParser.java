package utility;

import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * The Class ResourceJsonParser.O
 */
@SuppressWarnings("unchecked")
public class ResourceJsonParser {

	/** The data. */
	private Object data;

	/** The config reader. */
	public ConfigPropertyReader configReader;

	/**
	 * Instantiates a new resource json parser.
	 */
	public ResourceJsonParser() {
		configReader = new ConfigPropertyReader();
		try {
			data = JsonPath.read(new File(
					System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + configReader.getSessionConfig().get("apidatafolder")
					+ File.separator + configReader.getSessionConfig().get("tier") + ".json"),
					"$");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// *****************************************Magneto
	// data********************************************************

	public String getUserURL() {
		return JsonPath.read(data, "$.user.get_user_url");
	}

	public String getMagnetoDomain1URL() {
		return JsonPath.read(data, "$.magneto.domain_url1");
	}


	public Map<String, String> getMagentoClientHeaderCredentials() {
		Map<String, String> authHeaders = (Map<String, String>) JsonPath.read(data, "$.magneto.credentials");
		return authHeaders;
	}

	public Map<String, String> getMemberTaxesClientHeaderCredentials() {
		Map<String, String> authHeaders = (Map<String, String>) JsonPath.read(data, "$.membertaxes.credentials");
		return authHeaders;
	}

	public String getMemberTaxesAuthDomainURL() {
		return JsonPath.read(data, "$.membertaxes.sso.token_url");
	}

	public String getMemberTaxesDomainURL() {
		return JsonPath.read(data, "$.membertaxes.domain_url");
	}

	public  Map<String, String>  getMemberTaxesAuthCredentials() {
		Map<String, String> authHeaders = (Map<String, String>)JsonPath.read(data, "$.membertaxes.sso.credentials");
		return authHeaders;
	}


	public Map<String, String> getMagentoInvalidClientHeaderCredentials() {
		Map<String, String> authHeaders = (Map<String, String>) JsonPath.read(data, "$.magneto.invalidCredentials");
		return authHeaders;
	}

	public Map<String, String> getMagentoNoClientIDCredentials() {
		Map<String, String> authHeaders = (Map<String, String>) JsonPath.read(data, "$.magneto.noClientIdCredentials");
		return authHeaders;
	}

	public String getCustomerId_For_Retrieve_Customer_JsonPayload_Matching() {
		return JsonPath.read(data, "$.magneto.retrieve_cust_by_id.existing_customer");
	}

	public Map<String, String> getMagentoHeaderCredentialsWithoutClientTraceGUID() {
		return JsonPath.read(data, "$.magneto.noClientTraceGUIDCredentials");
	}

	public String getDuplicateEmail() {
		return JsonPath.read(data, "$.magneto.customer.duplicateEmail");
	}

	public String getInvalidEmail() {
		return JsonPath.read(data, "$.magneto.customer.invalidEmail");
	}

	// ****************************************************************************************************

	public String getVertexDomainURL() {
		return JsonPath.read(data, "$.vertex.domain_url");
	}

	public Map<String, String> getVertexClientHeaderCredentials() {
		Map<String, String> authHeaders = (Map<String, String>) JsonPath.read(data, "$.vertex.credentials");
		return authHeaders;
	}

	public Map<String, String> getVertexHeaderCredentialsWithInvalidClientId() {
		Map<String, String> authHeaders = (Map<String, String>) JsonPath.read(data, "$.vertex.credentialsWithInvalidClientId");
		return authHeaders;
	}

	public String getInvalidFormatDate() {
		return JsonPath.read(data, "$.vertex.testData.invalidDate");
	}

	public String getZimbadweCurrencyCodeAlpha() {
		return JsonPath.read(data, "$.vertex.testData.zimbabweCurrencyCodeAlpha");
	}

	public String getZimbadweCurrencyCodeNum() {
		return JsonPath.read(data, "$.vertex.testData.zimbabweCurrencyCodeNum");
	}

	public Map<String, String> getVertexHeaderCredentialsWithoutClientTraceGUID() {
		return JsonPath.read(data, "$.vertex.noClientTraceGUIDCredentials");
	}

	public String getLongStringValue() {
		return JsonPath.read(data, "$.vertex.testData.longStringValue");
	}

	public String getUSATaxRate() {
		return JsonPath.read(data, "$.vertex.testData.USATaxRate");
	}

	public String getIndiaTaxRate() {
		return JsonPath.read(data, "$.vertex.testData.IndiaTaxRate");
	}

	public String getCanadaTaxRate() {
		return JsonPath.read(data, "$.vertex.testData.CanadaTaxRate");
	}

	public Map<String, String> getVertexClientHeaderWithoutClientIdCredentials() {
		return JsonPath.read(data, "$.vertex.noClientTraceIDCredentials");
	}

	public Map<String, String> getNonUSAddressInfo(){
		Map<String, String> nonUsAddress = (Map<String, String>) JsonPath.read(data, "$.vertex.testData.NonUSCountryDetails");
		return nonUsAddress;
	}

	public String get_non_existing_cust_id() {
		return JsonPath.read(data, "$.magneto.customer.invalidCustId");

	}

	public String get_account_not_confirmed_cust_id() {
		return JsonPath.read(data, "$.magneto.customer.accountNotConfirmedCustId");
	}

	public String get_non_existing_address_id() {
		return JsonPath.read(data, "$.magneto.customer.invalidCustId");
	}

	public String getDefaultAddressIdForRetriveAddress() {
		return JsonPath.read(data, "$.magneto.address.defaultAddress");
	}
	
	//
	public Map<Object, Object>  getAllCustomerAttributeCodes() {
		return JsonPath.read(data, "$.magneto.customer_attribute_codes");
	}

}
