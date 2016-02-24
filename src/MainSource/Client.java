package MainSource;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;

public class Client {
	
	private boolean state;
	private int money;
	private String name;
	private Vector cityList=new Vector();
	private int location;
	private JSONObject jsonMsg=new JSONObject();
	private Socket client_socket;
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private Message_Reciever Message_Reciever;
	public void move(){
		
		
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void client_Network(Socket client_socket,ServerGui Server_GUI){
		this.client_socket=client_socket;
		try{
			is=client_socket.getInputStream();
			dis=new DataInputStream(is);
			os=client_socket.getOutputStream();
			dos=new DataOutputStream(os);
			this.Message_Reciever=new Message_Reciever(dis,dos,this,client_socket);
			this.Message_Reciever.start();
			}
			catch (IOException e){
				Server_GUI.getTextArea().append("스트림 에러\n");
			}
		}
	public void send_Json_Message(String code, int body){
		jsonMsg.clear();;
		jsonMsg.put("code", code);
		jsonMsg.put("body", body);
		try {
			dos.writeUTF(jsonMsg.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Code:snedMSG, send Error", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void send_Json_Message(String code, boolean body){
		jsonMsg.clear();;
		jsonMsg.put("code", code);
		jsonMsg.put("body", body);
		try {
			dos.writeUTF(jsonMsg.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Code:snedMSG, send Error", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void send_Json_Message(String code, String body){
		jsonMsg.clear();;
		jsonMsg.put("code", code);
		jsonMsg.put("body", body);
		try {
			dos.writeUTF(jsonMsg.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Code:snedMSG, send Error", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void send_Json_Message(String code, String[] body){
		jsonMsg.clear();;
		jsonMsg.put("code", code);
		jsonMsg.put("body", body);
		try {
			dos.writeUTF(jsonMsg.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Code:snedMSG, send Error", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void send_Json_Message(String code, String bodyOwn,String bodyTwo){
		jsonMsg.clear();;
		jsonMsg.put("code", code);
		jsonMsg.put("bodyOwn", bodyOwn);
		jsonMsg.put("bodyTwo", bodyTwo);
		try {
			dos.writeUTF(jsonMsg.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Code:snedMSG, send Error", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
