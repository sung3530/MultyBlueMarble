package MainSource;

import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParse {

	private JSONObject json_Data=new JSONObject();
	private JSONParser parser = new JSONParser();
	private String code;
	private dice dice=new dice();
	
	public void json_parsing(String message,Client client){
	
			try {
				json_Data=new JSONObject();
				json_Data=(JSONObject) parser.parse(message);
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			code_Check(client);
	}
	private void code_Check(Client client){
		
	
		switch ((String)json_Data.get("code")) {
		case "client" :
			client.setName((String)json_Data.get("body"));
			String[] list=ClientManager.getInstance().setNameList();
			ClientManager.getInstance().send_ToAll("nameList", list);
			break;
		case "dice":
			client.send_Json_Message("roll", dice.Rolling());
			break;
			
		case "city" :
			
			break;
			
		case "building" :
			
			break;
			
		default:
			break;
		}
		
	}
}
