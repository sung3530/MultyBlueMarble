package MainSource;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class UserReciever extends Thread{
	private ServerManager ServerManager;
	private ServerSocket serverSocket;
	private Socket socket;
	
	
	public UserReciever(ServerManager ServerManager){
		this. ServerManager=ServerManager;
	}
	
	public void setServerSocket(ServerSocket serverSocket){
		
		this.serverSocket=serverSocket;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(ClientManager.getInstance().count_Client()<4){
			try {
				ServerManager.getServerGui().getTextArea().append("������ �����...\n");
				socket=serverSocket.accept();
				ServerManager.getServerGui().getTextArea().append("����� ����!\n");
				
				ClientManager.getInstance().clientGenerate(socket, ServerManager.getServerGui());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				if(e.getCause()!=null){
					ServerManager.getServerGui().getTextArea().append("���� �߻�.\n");
				}
				else if(e.getCause()==null){
					ServerManager.getServerGui().getTextArea().append("���� ����� ���� ������ ���� ��� ����\n");
					break;
				}
			}
		}
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClientManager.getInstance().send_ToAll("gameStart", true);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClientManager.getInstance().turnStart();
	}
}
