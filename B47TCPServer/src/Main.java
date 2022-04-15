import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 47 TCP Server

class MyFrame extends JFrame implements ActionListener
{
	private 	JPanel 		displayPanel;
		private JTextArea 	display;
		private JScrollPane scroll;

	private 	JPanel 		inputPanel;
		private JTextField 	input;
	
	private 	Font		inputFont;
	private 	Font		displayFont;
	
	private int port = 10011;

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
		
		startServer();
		
	}

	public void startServer()
	{
		// 소켓 설정 : 수신 -> 출력 -> 응답   // 서버는 수신만 한다
		// TCP : Transmission Control Protocol
		
		ServerSocket serverSocket = null;
		display.setText("start TCP Server.. \n");
		
		try {
			serverSocket = new ServerSocket(port);
			display.append("Create Server Socket # : " + port + "\n");
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Cannot Open Port # : " + port + "\n");
		}
		
		Socket clientSocket = null;
		// 클라이언트가 접속하면, 접속한 정보를 확인하기 위한 정보
		
		try {
			clientSocket = serverSocket.accept();
			// 3-way handshake 하면 accept
			
			display.append("Accept OK\n");
			display.append("Client INFO : " + 
								clientSocket.getRemoteSocketAddress().toString() + 
								" : " + clientSocket.getPort() + "\n"
							);
			// 1.2.3.4:8080
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Accept Error\n");
		}
		
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			display.append("Create PrintWriter\n");
			
			BufferedReader in = new BufferedReader(
									new InputStreamReader(
											clientSocket.getInputStream()
										)
									);
			display.append("Create BufferedReader OK\n");
			
			String inputLine, outputLine;
			
			/*
			 *  C ------HELLO------> S
			 *  C <-----HELLO------- S 		(Echo Server)
			 */
			
			while( (inputLine = in.readLine()) != null ) 
			{
				display.append("RCV DATA \n<<" + inputLine + "\n");
				outputLine = "KBStar SERVER Says : " + inputLine;
				out.println(outputLine);
				out.flush();
				display.append(">> " + outputLine + "\n");
				
				if(inputLine.equals("quit"))
				{
					break;
				}
				
			}

			if(out != null)
				out.close();
			if(in != null)
				in.close();
			
			if(clientSocket != null)
				clientSocket.close();
			if(serverSocket != null)
				serverSocket.close();
			
			display.append("Resources are closed \n");
			
		} catch (Exception e) {
			// TODO: handle exception
			display.append("Error : " + e.getMessage()); 
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
			display.append("\n" + input.getText() );
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
		
	}
}
