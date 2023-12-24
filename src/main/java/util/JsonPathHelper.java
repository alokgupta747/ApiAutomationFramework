package util;

import com.jayway.jsonpath.JsonPath;
import httpclient.GetRequest;

import java.util.logging.Logger;

public class JsonPathHelper {
	private final Logger logger = Logger.getLogger(GetRequest .class.getName());
	protected JsonPathHelper() {
		
	}
	
	public String setJsonPathProperty(String payload, String jsonPath, Object newValue) {
		return JsonPath.parse(payload).set(jsonPath, newValue).jsonString();
	}
	
	public String updateJsonPathProperty(String payload, String jsonPath, String key, String value) {
		return JsonPath.parse(payload).put(jsonPath, key, value).jsonString();
	}
	
	public String deleteJsonPathProperty(String payload, String jsonPath) {
		return JsonPath.parse(payload).delete(jsonPath).jsonString();
	}
	
	public String addJsonPathProperty(String payload, String jsonPath, Object newValue) {
		return JsonPath.parse(payload).add(jsonPath, newValue).jsonString();
	}
	
	private Object convertToObject(String payload, String classNameWithFullPackage) {
		return JsonPath.parse(payload).read("$",createInstanceOfClass(classNameWithFullPackage).getClass());
	}
	
	public Object readProperty(String payload, String jsonPath) {
		return JsonPath.parse(payload).read(jsonPath);
	}
	
	@SuppressWarnings("rawtypes")
	private Object createInstanceOfClass(String className) {
		logger.info("Class Name: "+className);
		Class classTemp = null;
		try {
			classTemp = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			//MainLogger.getLogger().error(e1.getMessage());
			e1.printStackTrace();
		}
		Object obj = null;
		try {
			obj = classTemp.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			//MainLogger.getLogger().error(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

}
