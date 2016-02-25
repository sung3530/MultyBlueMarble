package MainSource;
import java.net.Socket;
import java.util.Vector;

public class ClientManager {

	public static ClientManager clientManager=new ClientManager();
	public static ClientManager getInstance(){
		return clientManager;
	}
	
	private Vector clientList=new Vector();
	private String[] nameList=new String[4];
	private Client client;
	private int turn=0;
	
	public Vector getList(){
		return clientList;
	}
	public String[] setNameList(){
		for (int i = 0; i < clientList.size(); i++) {
			client=(Client)clientList.elementAt(i);
			nameList[i]=client.getName();
		}
		return nameList;
	}
	
	public int count_Client(){
		return clientList.size();
	}
	public void doubleTurn(){
		turn--;
	}
	public void turnStart(){
		
		client=(Client)clientList.elementAt(turn%4);
		if(client.getIsland())
			client.send_Json_Message("turn", true);
		turn++;
		
	}
	public void clientGenerate(Socket socket,ServerGui Server_GUI){
		client=new Client();
		client.client_Network(socket,Server_GUI);
		clientList.add(client);
	}
	public void send_ToAll(String code, String body){
		for (int i = 0; i < clientList.size(); i++) {
			Client client=(Client)clientList.elementAt(i);
			client.send_Json_Message(code, body);
		}
	}
	public void send_ToAll(String code){
		for (int i = 0; i < clientList.size(); i++) {
			client=(Client)clientList.elementAt(i);
			nameList[i]=client.getName();
		}
		for (int i = 0; i < clientList.size(); i++) {
			client=(Client)clientList.elementAt(i);
			client.send_Json_Message("nameList", nameList[0], nameList[1], nameList[2], nameList[3]);
		}
	}
	public void send_ToAll(String code, boolean body){
		for (int i = 0; i < clientList.size(); i++) {
			client=(Client)clientList.elementAt(i);
			client.send_Json_Message(code, body);
		}
	}
	public void endClient(Client client){
		clientList.remove(client);
	}
}
