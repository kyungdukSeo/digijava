import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatFrame extends JFrame implements ActionListener
{
	private JTextArea display;
	private JTextField input;
	private JScrollPane scroll;
	
	private DatagramSocket socket;
	private DatagramPacket packet;
	private InetAddress address = null;
	
	private int myPort = 10000;
	private int yourPort = 10000;
	
	
	public ChatFrame()
	{
		this.setTitle("KB* Chat");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Network 설정
		try {
			address = InetAddress.getByName("127.0.0.1");
			socket = new DatagramSocket(myPort);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			
		// 0. 컨테이너는 레이아웃을 결정했는가?
		this.setLayout(new BorderLayout());
		display = new JTextArea(10, 30);
		
		// 스크롤페인에 display를 넣음
		scroll = new JScrollPane(display);
				
		input = new JTextField(30);
		input.addActionListener(this);
		
		this.add(scroll, BorderLayout.CENTER);
		this.add(input, BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}
	
	public void process()
	{
		while(true)
		{
			try {
				byte[] buffer = new byte[1024];
				packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				
				display.append("홍길동 > " + new String(buffer)  + "\n");
				
				display.setCaretPosition(display.getDocument().getLength());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == input)
		{			
			String msg = input.getText();
			
			byte[] buffer = msg.getBytes();
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length, address, yourPort);
			
			try {
				socket.send(packet);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			display.append("나 > " + msg + "\n");
			display.setCaretPosition(display.getDocument().getLength());
			input.selectAll();
		}
	}
	
}

public class TestChat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatFrame frame = new ChatFrame();
		frame.process();
	}

}
