import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Client {
	
	private int money;
	private String name;
	private Vector cityList=new Vector();
	private int location;
	private Socket User_socket;
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	public void move(){
		
		
	}
	public void client_Network(Socket User_socket,ServerGui Server_GUI){
		this.User_socket=User_socket;
		try{
			is=User_socket.getInputStream();
			dis=new DataInputStream(is);
			os=User_socket.getOutputStream();
			dos=new DataOutputStream(os);
			//this.Message_Reciever=new Message_Reciever(dis,dos,this,User_socket,Server_GUI);
			//this.Message_Reciever.start();
			}
			catch (IOException e){
				Server_GUI.getTextArea().append("스트림 에러\n");
			}
		}
	
}
