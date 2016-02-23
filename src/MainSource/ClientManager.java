package MainSource;
import java.net.Socket;
import java.util.Vector;

public class ClientManager {

	public static ClientManager clientManager=new ClientManager();
	public static ClientManager getInstance(){
		return clientManager;
	}
	
	private Vector clientList=new Vector();
	
	public Vector getList(){
		return clientList;
	}
	
	public int count_Client(){
		return clientList.size();
	}
	public void clientGenerate(Socket socket,ServerGui Server_GUI){
		Client client=new Client();
		client.client_Network(socket,Server_GUI);
		clientList.add(client);
	}
}
