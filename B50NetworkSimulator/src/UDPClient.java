import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UDPClient 
{

	private NetworkSimulator	frame;
	private DatagramSocket 		socket;
	private DatagramPacket 		packet;
	private InetAddress 		serverAddress;
	private String 				serverIP;
	
	private int myPort = 10001;
	private int serverPort;
	
	private JTable table;
	private Vector<String> userColumn = new Vector<String>();
	private Vector<String> userRow;
	private DefaultTableModel tableModel;
	
	
	public UDPClient(NetworkSimulator frame)
	{
		this.frame = frame;
		
		serverPort = Integer.parseInt(this.frame.getInputPort().getText());
		serverIP = this.frame.getInputIP().getText();	// ip = "127.0.0.1" 문자열 
		

		try {
			this.serverAddress = InetAddress.getByName(serverIP);
			socket = new DatagramSocket(myPort);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		// 보낼 데이터가 있냐?
		if(this.frame.isUdpClientReadyFlag() == true)
		{
			// display 읽어서 전송
			byte[] sendBuffer;
			
			sendBuffer = this.frame.getDisplay().getText().getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
			try {
				socket.send(sendPacket);
				
				// table 출력 필요
				int nextTableNo = this.frame.getTableNo() + 1;
				// 
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
		
	}
	
}

