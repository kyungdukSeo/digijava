import java.io.BufferedReader;
import java.io.FileReader;
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
	
	private int counter;
	private int sleepInterval;
	
	
	public UDPClient(NetworkSimulator frame)
	{
		this.frame = frame;
		
		System.out.println("i am udp client");
		
		serverPort = Integer.parseInt(this.frame.getInputPort().getText());
		serverIP = this.frame.getInputIP().getText();	// ip = "127.0.0.1" 문자열 
		
		try {
			this.serverAddress = InetAddress.getByName(serverIP);
			socket = new DatagramSocket(myPort);
			
			socket.setSoTimeout(500);
			socket.setReuseAddress(true);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				udpSender();
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				receive();
			}
		});

		thread1.start();

		if(this.frame.getReceiveClient().isSelected() == true)
		{
			thread2.start();
		}
		
	}
	
	public void udpSender()
	{
		// 보낼 데이터가 있냐?
		// if(this.frame.isUdpClientReadyFlag() == true)
		while(true)
		{
			if(this.frame.isUdpClientMode() == false)
			{
				break;
			}
			
			// 여기에 카운트 / 스립인터벌 넣어줘야 정상작동한다
			counter = Integer.parseInt(this.frame.getCountSpinner().getValue().toString());
			sleepInterval = Integer.parseInt(this.frame.getSleepSpinner().getValue().toString());
						
			if(this.frame.isUdpClientReadyFlag() == true)
			{
				// display 읽어서 전송 or random 전송
				byte[] sendBuffer;
				sendBuffer = this.frame.getDisplay().getText().getBytes();
				
				DatagramPacket sendPacket = null;
				sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
				
				try 
				{
					for(int i=1; i<=counter; i++) 
					{
						if(this.frame.getCheckRandom().isSelected() == true)
						{
							int rand = (int)(Math.random() * 6) + 1;
							
							FileReader in = null;
							BufferedReader br = null;
							
							String fileContents = "";
							String path = "d:/kbstar/" + rand + ".txt";
							
							try {
								in = new FileReader(path);
								br = new BufferedReader(in);
								
								String line = "";
								this.frame.getDisplay().setText("");
								
								while((line = br.readLine()) != null)
								{
									this.frame.getDisplay().append(line + "\n");
									fileContents = fileContents + line + "\n";
								}
						
								System.out.println(fileContents);
							} catch (Exception e2) {
								// TODO: handle exception
							}finally
							{
								try {
									if(in != null)
										in.close();
									if(br != null)
										br.close();
								} catch (Exception e3) {
									// TODO: handle exception
								}
							}
							
							sendBuffer = fileContents.getBytes();
							sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);
							
						}
//						else
//						{
							socket.send(sendPacket);
							
							// table 출력 필요
							// int nextTableNo = this.frame.getTableNo() + 1;		// 변수 선언만 하면됨
							
							table = this.frame.getTable();
							int nextTableNo = this.frame.getTableModel().getRowCount() + 1;
							
							tableModel = (DefaultTableModel) table.getModel();
							Object[] tmp = new Object[] {nextTableNo, "Out", sendPacket.getAddress().getHostAddress(), sendPacket.getPort(), new String(sendBuffer)};
							
							this.frame.setTableModel(tableModel);
							this.frame.getTableModel().addRow(tmp);
							
							this.frame.getTableModel().moveRow(this.frame.getTableModel().getRowCount()-1,
									this.frame.getTableModel().getRowCount()-1,
									0
									);
							
							try {
								Thread.sleep(sleepInterval);
							} catch (Exception e) {
								// TODO: handle exception
							}
							
//						}
						
					}
					
					this.frame.setUdpClientReadyFlag(false);
					// this.frame.setRunning(false);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally
				{
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		try {
			if(socket != null)
				socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("UDP Socket Closed..");
		
	}
	
	
	public void receive()
	{
		while(true)
		{
			if(this.frame.isUdpClientMode() == false)
			{
				break;
			}

			byte[] buffer = new byte[1024];		// 2^n 2의 거듭제곱으로 만든다
			packet = new DatagramPacket(buffer, buffer.length);
			try {
				System.out.println("wait..");
				socket.receive(packet);	
				System.out.println("receive..");
				
				table = this.frame.getTable();
				int nextTableNo = this.frame.getTableModel().getRowCount() + 1;
				
				tableModel = (DefaultTableModel)table.getModel();
				
				// 순서, 아이디, 이름, 나이, 주소
				Object[] tmp = new Object[] { nextTableNo, "In", packet.getAddress().getHostAddress(), packet.getPort(), new String(buffer) };
				
				this.frame.setTableModel(tableModel);
				this.frame.getTableModel().addRow(tmp);
				
				this.frame.getTableModel().moveRow(this.frame.getTableModel().getRowCount()-1,
						this.frame.getTableModel().getRowCount()-1,
						0
						);
									
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			//---------------------udpServer()
		
		
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("sleep : "+e.getMessage());
			}
			
			System.out.println("UDP Receiver..");
			
		}
	}
	
	
}

