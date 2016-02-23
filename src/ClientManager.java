import java.net.Socket;
import java.util.Vector;

public class ClientManager {

	public static ClientManager clientManager=new ClientManager();
	public static ClientManager getInstance(){
		return clientManager;
	}
	
	private Vector clientList=new Vector();
	
	public void clientGenerate(Socket socket,ServerGui Server_GUI){
		Client client=new Client();
		//Client.user_Network(socket,Server_GUI);
		clientList.add(client);
	}
}
