package MainSource;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerManager {
	private ServerGui ServerGui;
	private ServerSocket serverSocket;
	private UserReciever UserReciever=new UserReciever(this);
	private int port;
	

	public ServerManager(ServerGui ServerGui){
		this.ServerGui=ServerGui;
		
	}

	public void setPort(int port){
		this.port=port;
	}
	public ServerGui getServerGui(){
		return ServerGui;
	}
	
	public void serverStart(){
		try {
			serverSocket=new ServerSocket(port);
			if(serverSocket!=null){
				ServerGui.getButton()[0].setText("서버 실행중\n");
				ServerGui.getButton()[0].setEnabled(false);
				UserReciever.setServerSocket(serverSocket);
				UserReciever.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ServerGui.getTextArea().append("소켓이 이미 사용중입니다...\n");
		}
	}
	
	public void serverStop(){
		try {
			serverSocket.close();
			ServerGui.getButton()[0].setText("Connection");
			ServerGui.getButton()[0].setEnabled(true);
			ServerGui.getTextArea().append("서버 종료\n");
		
		
		} catch (IOException e) {
		// TODO Auto-generated catch block
			ServerGui.getTextArea().append("서버 중지 실패\n");
			}
	}
}