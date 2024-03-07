package WebAutomation.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataReader {
	
	
	
	
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		// WE CAN USE FILEUTILS TOSELECT THE JSON FILE AND CHANGED TO STRING 
	String jsonContent =	FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "//src//test//java//WebAutomation//Data//PurchasedOrder.json"),StandardCharsets.UTF_8);
	
	// 2ND STEP IS TO CHANGE THE JSON STRING TO HASH MAP - FOR THAT WE NEED  ADDED DEPENDENCY 'JACKSON DATABIND'
	
	ObjectMapper mapper = new ObjectMapper();
List<HashMap<String,String>>data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
 return data;
			
	//TypeReference<List<HashMap<String,String>>>(){} -HERE WE ARE TELLING HOW WE NEED THE SENTEX FOR THE HASHMAP
	
	
	
	
	
	}

	
	
}
