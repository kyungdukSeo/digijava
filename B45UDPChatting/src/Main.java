import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 45 UDP Chatting

class Chatting
{
	private DatagramSocket socket; 	// UDP = User Datagram Protocal
	private DatagramPacket packet;
	private InetAddress address;
	
	private int myPort = 10001;
	private int yourPort = 10002;
	
}
//------------------------위는 버리는코드???-------------------------


class MyFrame extends JFrame implements ActionListener
{
	
	private DatagramSocket socket; 	// UDP = User Datagram Protocal
	private DatagramPacket packet;
	private InetAddress address;
	
	private int myPort = 10002;
	private int yourPort = 10001;		// 10000 	210.181.122.72
	
	
	private 	JPanel 		displayPanel;
		private JTextArea 	display;
		private JScrollPane scroll;

	private 	JPanel 		inputPanel;
		private JTextField 	input;
	
	private 	Font		inputFont;
	private 	Font		displayFont;
	
	

	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		
		// 0. setting Network
		
		try {
			// 210.181.122.72
			address = InetAddress.getByName("127.0.0.1");
			socket = new DatagramSocket(myPort);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		// 1. 나(frame)의 레이아웃 정하기
		this.setLayout(new BorderLayout());
		
		
		// 2. 디스플레이 패널 (center)
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		displayPanel.setBackground(Color.yellow);
		
		// 컴포넌트..
		display = new JTextArea(5,30);
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		displayFont = new Font("dialog", Font.BOLD, 15);
		display.setFont(displayFont);
		
		// 회색(무채색, RGB 동일한 비율) 0에 가까우면 검정, 255에 가까워지면 흰색
		display.setBackground(new Color(230,230,230));
		
		display.setEditable(false);	// 편집 못하게 막기
		
		this.add(displayPanel, BorderLayout.CENTER);
		
		// 3. 인풋 패널 (south)
		inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.setBackground(Color.blue);
		
		// 컴포넌트 
		input = new JTextField(10);						// Event 1
		
		// Event 2 : 이벤트 등록
		input.addActionListener(this);
		
		inputPanel.add(input, BorderLayout.CENTER);
		
		inputFont = new Font("dialog", Font.BOLD, 15);
		input.setFont(inputFont);
		
		this.add(inputPanel, BorderLayout.SOUTH);
		
		// 4. 각 패널을 프레임에 붙이기 

		
		
		this.setVisible(true);
		
	}
	
	public void udpServer()
	{
		// 서버(수신)
		while(true)
		{
			byte[] buffer = new byte[1204];		// 2^n 2의 거듭제곱으로 만든다
			packet = new DatagramPacket(buffer, buffer.length);
			try {
				System.out.println("wait..");
				socket.receive(packet);
				System.out.println("receive..");
				
				display.append("KBStar << " + new String(buffer) + "\n");
				display.setCaretPosition(display.getDocument().getLength());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		// Event 3 : 코드 추가
		if(e.getSource() == input)
		{
			// display 에 input 내용을 append
			
			String sendMsg = input.getText();
			byte[] buffer = sendMsg.getBytes();
			
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length, address, yourPort);
			
			try {
				socket.send(packet);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			display.append("나 >> " + sendMsg + "\n" );
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());			
		
		}
	}
}




public class Main 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		MyFrame frame = new MyFrame();
		frame.udpServer();
	}
}
