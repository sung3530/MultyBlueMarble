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
				ServerManager.getServerGui().getTextArea().append("접속자 대기중...\n");
				socket=serverSocket.accept();
				ServerManager.getServerGui().getTextArea().append("사용잡 접속!\n");
				
				ClientManager.getInstance().clientGenerate(socket, ServerManager.getServerGui());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				if(e.getCause()!=null){
					ServerManager.getServerGui().getTextArea().append("에러 발생.\n");
				}
				else if(e.getCause()==null){
					ServerManager.getServerGui().getTextArea().append("서버 종료로 인한 접속자 접속 대기 종료\n");
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
