import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 48 TCP Client

class MyFrame extends JFrame implements ActionListener
{
	private 	JPanel 		displayPanel;
		private JTextArea 	display;
		private JScrollPane scroll;

	private 	JPanel 		inputPanel;
		private JTextField 	input;
	
	private 	Font		inputFont;
	private 	Font		displayFont;
	
	private int serverPort = 10011;
	private String serverIP = "127.0.0.1";
	
	private Socket toSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	

	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		
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
		
		startClient();
		
	}

	
	
	public void startClient()
	{
		display.setText("start TCP Client\n");
		
		try {
			toSocket = new Socket(serverIP, serverPort);
			out = new PrintWriter(toSocket.getOutputStream(), true);
			
			in = new BufferedReader(
					new InputStreamReader(
							toSocket.getInputStream()
						)
					);
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Error : " + e.getMessage() + "\n");
			System.exit(1);
			
		}
		
		// End : 3-Way handshaking
		display.append("Connection OK\n");
		
	}

	public void receive()
	{
		// 데이터 수신 .. 에코 데이터
		
		String fromServer;
		
		while(true)
		{
			try {
				fromServer = in.readLine();
				display.append("<< " + fromServer + "\n");
				
				if(fromServer.equals("KBStar SERVER Says : quit") == true)
				{
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				
			}
		}
		closeClient();
		
	}
	
	public void closeClient()
	{
		try {
			if(in != null)
				in.close();
			if(out != null)
				out.close();
			if(toSocket != null)
				toSocket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
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
			display.append(">> " + input.getText() + "\n" );
			
			out.println(input.getText() );
			
						
			
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
		frame.receive();
		
	}
}




