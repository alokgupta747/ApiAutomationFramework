package basetest;

import httpclient.GetRequest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utility.ConfigPropertyReader;
import utility.PayloadReader;
import utility.ResourceJsonParser;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * The Class BaseTestAnotation.
 */
public class BaseTestAnotation {

	/** The testdata. */
	public ResourceJsonParser testdata;

	/** The softAssert. */
	public SoftAssert softAssert;
	public PayloadReader payloadReader;

	private Logger logger;
	public HashMap<String,String> configSettings = ConfigPropertyReader.readAllPropertyVlauesFromConfigFile();

	/**
	 * To setup data.
	 * Overide in test class
	 */
	public void initialize() {
		testdata = new ResourceJsonParser();
		logger = Logger.getLogger(GetRequest.class.getName());
	}

	protected String getQuery(String queryName) {
		String queryFile_path="src/test/resources/dbqueries/dbQueries.properties";
		System.out.println("Executed query -->"+ConfigPropertyReader.getProperty(queryFile_path, queryName));
		return ConfigPropertyReader.getProperty(queryFile_path, queryName);
	}

	/**
	 * Runs before each test class.
	 */
	@BeforeClass(alwaysRun = true)
	public void startTestClass() {
		initialize();
		logger.info("");
		logger.info(
				"********* Class Started :- " + this.getClass().getName() + "*********************************");
		logger.info("");
	}

	/**
	 * can be used as setup things.
	 */
	public void setUpBaseConditionsAndData() {

	}

	/**
	 * Runs before each @test.
	 * Prints method name as well
	 *
	 * @param name the name
	 */
	@BeforeMethod(alwaysRun = true)
	public void startMethodName(Method name) {
		setUpBaseConditionsAndData();
		softAssert = new SoftAssert();
		logger.info("");
		logger.info("********* Test Started :- " + name.getName() + "*********************************");
		logger.info("");
	}

	/**
	 * It runs after class ends.
	 */
	@SuppressWarnings("static-access")
	@AfterClass(alwaysRun = true)
	public void endTestClass() {
		logger.info("");
		logger
				.info("********* Class Ended :- " + this.getClass().getName() + "*********************************");
		logger.info("");
	}

	/**
	 * This method takes screenshot on being failed.
	 *
	 * @param result **this is to represent test result.**
	 * @param name   **this is to represent method name.**
	 */
	@AfterMethod(alwaysRun = true)
	public void endMethodName(ITestResult result, Method name) {
		logger.info("");
		logger.info("********* Test Ended :- " + name.getName() + "*********************************");
		logger.info("");
	}

	/**
	 * Generalized method for logger.
	 *
	 * @param s the s
	 */
	public void logMessage(String s) {
		logger.info(s);
	}

	/**
	 * this method add properties in allure.
	 */
	@SuppressWarnings("static-access")
	@AfterSuite
	public void generateEnvironmentReport() {

	}
}
