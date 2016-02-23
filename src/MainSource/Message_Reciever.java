package MainSource;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Message_Reciever extends Thread{
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket client_Socket;
	private Client client;
	private JsonParse Json_Parse=new JsonParse();
	
	public Message_Reciever(DataInputStream dis, DataOutputStream dos,Client client ,Socket client_Socket){
		this.dis=dis;
		this.dos=dos;
		this.client_Socket=client_Socket;
		this.client=client;
	}

	public void run(){
		while(true){
			try {
				String message = dis.readUTF();//송신올떄까지 무한정 대기
				Json_Parse.json_parsing(message,client);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				try {
					dos.close();
					dis.close();
					client_Socket.close();
					ClientManager.getInstance().getList().removeElement(client);
					//Server_GUI.getTextArea().append("사용자 접속 끊어짐 자원 반납\n");
					break;
				
				} catch (Exception ee) {
					if(ee.getCause()==null){
						//Server_GUI.getTextArea().append("close Error");
						break;
					}
				}// catch문 끝
			}
		}
	}
}
