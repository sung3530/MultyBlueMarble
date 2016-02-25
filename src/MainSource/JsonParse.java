package MainSource;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import MainSource.Citys.City;
import MainSource.Citys.CityCheck;

public class JsonParse {

	private JSONObject json_Data=new JSONObject();
	private JSONParser parser = new JSONParser();
	private String code;
	private dice dice=new dice();
	private int diceTemp;
	
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
		case "client" : // user 이름 받아서 이름 저장.
			client.setName((String)json_Data.get("body"));
			String[] list=ClientManager.getInstance().setNameList();
			ClientManager.getInstance().send_ToAll("nameList", list);
			System.out.println((String)json_Data.get("body"));
			break;
		case "dice":
			diceTemp=dice.Rolling();
			client.send_Json_Message("roll", diceTemp);
			client.move(diceTemp);
			citysCheck(client);
			break;
			
		case "city" :
			if((boolean)json_Data.get("body")){
				if(client.buyCity( CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].getPrice())){
					 CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].setMaster(client);
					 client.send_Json_Message("building", 3,0);
				}
			}
			break;
		case "fee" :
			if((boolean)json_Data.get("body")){
				if(!client.sendFee(CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].getFee())){
				 client.send_Json_Message("end", true);
				 ClientManager.getInstance().endClient(client);
				}
			}
			ClientManager.getInstance().turnStart();	
			break;
		case "building" :
			if(client.buyBuilding((int)json_Data.get("bodyOwn"), (int)json_Data.get("bodyTwo"))){
				CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].setBuilding((int)json_Data.get("bodyOwn"));
				CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].setHotel( (int)json_Data.get("bodyTwo"));
			}
			else{
				client.send_Json_Message("money", false);
			}
			ClientManager.getInstance().turnStart();
			break;
		case "spaceTravel" :
				if(CityCheck.getInstance().checkName((int)json_Data.get("bodyOwn"), (String)json_Data.get("bodyTwo"))){
					client.selecMove((int)json_Data.get("bodyOwn"));
					citysCheck(client);
				}
			ClientManager.getInstance().turnStart();
			break;
		default:
			break;
		}
		
	}
	
	private void citysCheck(Client client){
		if(CityCheck.getInstance().checkIsland(client.getPosition())){//무인도 도착시
			client.send_Json_Message("island", true );
			client.setIsland();
		}
		else if(CityCheck.getInstance().checkSpaceTravel(client.getPosition())){//우주여행시
			client.send_Json_Message("spaceTravel", true);
		}
		else if(CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].getMaster()!=client)//city가 내것이 아닐경우 주인없으면 true 딴사람꺼면 false
			client.send_Json_Message("city",  CityCheck.getInstance().checkCity(client.getPosition()),  CityCheck.getInstance().fee_price(client.getPosition(),client));
		else if(CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].getMaster()==client){//city가 내것일 경우.
			client.send_Json_Message("building", 3-CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].getBuilding(),CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].getBuilding()-CityCheck.getInstance().getCityList().getCityList()[client.getPosition()].getHotel());
		}
	}
}
