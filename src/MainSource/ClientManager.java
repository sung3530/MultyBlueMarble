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
	public Vector getList(){
		return clientList;
	}
	public String[] setNameList(){
		for (int i = 0; i < nameList.length; i++) {
			Client client=(Client)clientList.elementAt(i);
			nameList[i]=client.getName();
		}
		return nameList;
	}
	
	public int count_Client(){
		return clientList.size();
	}
	public void turnStart(int count){
		switch (count) {
		case 0:
			client=(Client)clientList.elementAt(0);
			client.send_Json_Message("order", true);
			break;

		case 1:
			client=(Client)clientList.elementAt(1);
			client.send_Json_Message("order", true);
			break;

		case 2:
			client=(Client)clientList.elementAt(2);
			client.send_Json_Message("order", true);
			break;

		case 3:
			client=(Client)clientList.elementAt(3);
			client.send_Json_Message("order", true);
			break;

		default:
			break;
		}
	}
	public void clientGenerate(Socket socket,ServerGui Server_GUI){
		Client client=new Client();
		client.client_Network(socket,Server_GUI);
		clientList.add(client);
	}
	public void send_ToAll(String code, String body){
		for (int i = 0; i < clientList.size(); i++) {
			Client client=(Client)clientList.elementAt(i);
			client.send_Json_Message(code, body);
		}
	}
	public void send_ToAll(String code, String[] body){
		for (int i = 0; i < clientList.size(); i++) {
			Client client=(Client)clientList.elementAt(i);
			client.send_Json_Message(code, body);
		}
	}
}
