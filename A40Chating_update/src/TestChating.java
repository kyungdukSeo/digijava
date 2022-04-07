import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


class ChatFrame extends JFrame implements ActionListener
{

	private JPanel namePanel;
	private JPanel setupPanel;
	private JPanel chatPanel;
	
	private JTextField ipField;
	private JTextField portField;
	private JTextField myNameField; 
	private JTextField yourNameField;
	
	private JLabel ipLabel;
	private JLabel portLabel;
	private JLabel myNameLabel;
	private JLabel yourNameLabel;
	
	private JButton resetBtn;
	private JButton startBtn;
	
	private JTextArea display;
	private JTextField input;
	private JScrollPane scroll;
	
	private DatagramSocket socket;
	private DatagramPacket packet;
	private InetAddress address = null;
	
	private int myPort = 30001;
	private int yourPort = 10000;
	
	
	public ChatFrame() 
	{
		this.setTitle("KB Chat");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		//0. �����̳ʴ� ���̾ƿ��� �����ߴ°�?
		this.setLayout(new BorderLayout());
		
		setupPanel = new JPanel();
		setupPanel.setLayout(new GridLayout(5, 2));
		
		infoSet();
		
		resetBtn.addActionListener(this);
		startBtn.addActionListener(this);
		
		this.add(setupPanel);
		
		this.setVisible(true);
		
		
		chatPanel = new JPanel();
		
		
		/*	���� �̸� �ִ�ĭ �ǳ�
		namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout());
		nameSet();	-> infoSet();
		*/
		
		display = new JTextArea(10,30);
		
		// JScrollPane �� display�� ����
		scroll = new JScrollPane(display);
		
		input = new JTextField(30);
		input.addActionListener(this);
		
		
		this.add(scroll, BorderLayout.CENTER);
		this.add(input, BorderLayout.SOUTH);
		//this.add(namePanel, BorderLayout.NORTH);
		

		// Network ����
		try
		{
			System.out.println("CP 1 : " + ipField.getText());
			address = InetAddress.getByName(ipField.getText()); //ip �����ּ� ������ ����
			socket = new DatagramSocket(myPort);

		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//this.setVisible(true);
	}
	
	private void infoSet() 
	{
		// TODO Auto-generated method stub
		
		ipLabel = new JLabel("IP : ");
		setupPanel.add(ipLabel);
		ipField = new JTextField(15);
		ipField.setText("127.0.0.1");
		setupPanel.add(ipField);
		
		portLabel = new JLabel("��Ʈ : ");
		setupPanel.add(portLabel);
		portField = new JTextField("",5);
		setupPanel.add(portField);
		
		myNameLabel = new JLabel("���̸� : ");
		setupPanel.add(myNameLabel);
		myNameField = new JTextField("",5);
		setupPanel.add(myNameField);
		
		yourNameLabel = new JLabel("���� : ");
		setupPanel.add(yourNameLabel);
		yourNameField = new JTextField("",5);
		setupPanel.add(yourNameField);
		
		// �ʱ�ȭ ��ư
		resetBtn = new JButton("�ʱ�ȭ");
		setupPanel.add(resetBtn);
				
		// ���� ��ư
		startBtn = new JButton("����");
		setupPanel.add(startBtn);
		
	}

	public void process()
	{
		while(true) 
		{
			try {
				byte[] buffer = new byte[1024];
				packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				
				display.append(yourNameField.getText() + " > " + new String(buffer) + "\n");
				
				display.setCaretPosition(display.getDocument().getLength());
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource() == resetBtn) 
		{
			ipField.setText("");
			portField.setText("");
			myNameField.setText("");
			yourNameField.setText("");
		}
		
		if(e.getSource() == startBtn) 
		{
			
			this.add(chatPanel);
		}
		
		if(e.getSource()==input) 
		{
			String msg = input.getText();
			
			byte[] sendBuffer = msg.getBytes();
			DatagramPacket packet;
			packet = new DatagramPacket(sendBuffer, sendBuffer.length, address, yourPort);
			
			try {
				socket.send(packet);
				
			}catch (Exception e2) {
				// TODO: handle exception
			}
			
			display.append(myNameField.getText() + " > " + msg + "\n");
			display.setCaretPosition(display.getDocument().getLength());
			input.selectAll();
			input.setText("");
			
		}
		
	}
	
}


public class TestChating
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		ChatFrame frame = new ChatFrame();
		frame.process();
		
	}

}
