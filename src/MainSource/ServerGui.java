package MainSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ServerGui extends JFrame implements ActionListener{
	private JPanel mainJpanel=new JPanel();
	private JTextField portTextField=new JTextField();
	private JLabel jl=new JLabel();
	private JButton[] jb=new JButton[2];
	private JTextArea ja=new JTextArea();
	private JScrollPane js=new JScrollPane();
	private ServerManager serverManager;
	

	public ServerGui(){
		super("ServerGui");
		this.serverManager=new ServerManager(this);
		panelReSize();
		textAreaGenerate();
		portTextGenerate();
		buttonGenerate();
		panelGenerate();
		
	}
	
	public JButton[] getButton(){
		return jb;
	}
	public JTextField getTextField(){
		return portTextField;
	}
	public JTextArea getTextArea(){
		return ja;
	}
	
	private void panelReSize(){
		setBounds(100,100,300,400);
		mainJpanel=new JPanel();
		mainJpanel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(mainJpanel);
		mainJpanel.setLayout(null);
	}
	private void textAreaGenerate(){
		ja=new JTextArea();
		ja.setColumns(20);
		ja.setRows(5);
		js.setBounds(12,5,265,255);
		mainJpanel.add(js);
		js.setViewportView(ja);
		ja.setEditable(false);
	}
	private void portTextGenerate(){
		jl=new JLabel("Port : ");
		jl.setBounds(25,265,100,40);
		portTextField=new JTextField();
		portTextField.setBounds(65, 265, 200, 40);
		mainJpanel.add(jl);
		mainJpanel.add(portTextField);
	}
	private void buttonGenerate(){
		jb[0]=new JButton("Connection");
		jb[1]=new JButton("Server_Stop");
		jb[0].setBounds(5,310,130,40);
		jb[1].setBounds(150,310,130,40);
		jb[0].addActionListener(this);
		jb[1].addActionListener(this);
		mainJpanel.add(jb[0]);
		mainJpanel.add(jb[1]);
	}
	private void panelGenerate(){
		setVisible(true);
		portTextField.setText("8000");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb[0])){
			serverManager.setPort(Integer.parseInt(portTextField.getText()));
			serverManager.serverStart();
		}
		
	}
}
