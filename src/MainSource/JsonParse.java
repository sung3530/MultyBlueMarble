package MainSource;

import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParse {

	private JSONObject json_Data=new JSONObject();
	private JSONParser parser = new JSONParser();
	
	public void json_parsing(String message,Client client){
	
			try {
				json_Data=new JSONObject();
				json_Data=(JSONObject) parser.parse(message);
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}
	public void code_Check(){
		
		
	}
}
