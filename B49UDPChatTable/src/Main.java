import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// 49 UDP ChatTable


class MyFrame extends JFrame implements ActionListener
{
	
	private DatagramSocket socket; 	// UDP = User Datagram Protocal
	private DatagramPacket packet;
	private InetAddress address;
	
	private int myPort = 10000;
	private int yourPort = 10001;		// 10000 	210.181.122.72
	
	
	private 	JPanel 		displayPanel;
		// private JTextArea 	display;
		private	JTable		table; 
		private DefaultTableModel	tableModel;
		private Vector<String> userColumn;
		
		// scroll(display) --> scroll(table)
		
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
			address = InetAddress.getByName("127.0.0.1");	// 127.0.0.1
			socket = new DatagramSocket(myPort);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		// 1. ��(frame)�� ���̾ƿ� ���ϱ�
		this.setLayout(new BorderLayout());
		
		
		// 2. ���÷��� �г� (center)
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		displayPanel.setBackground(Color.yellow);
		
		// ������Ʈ..
		
		// display = new JTextArea(5,30);
		
		userColumn = new Vector<String>();
		userColumn.addElement("No");
		userColumn.addElement("In/Out");		// In/Out
		userColumn.addElement("IP");
		userColumn.addElement("Port");
		userColumn.addElement("Messages");
		
		tableModel = new DefaultTableModel(userColumn, 0);
		table = new JTable(tableModel);
	
		table.setPreferredScrollableViewportSize(new Dimension(450,350));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		
		
		scroll = new JScrollPane(table);
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		// displayFont = new Font("dialog", Font.BOLD, 15);
		// display.setFont(displayFont);
		
		// ȸ��(��ä��, RGB ������ ����) 0�� ������ ����, 255�� ��������� ���
		// display.setBackground(new Color(230,230,230));
		
		// display.setEditable(false);	// ���� ���ϰ� ����
		
		this.add(displayPanel, BorderLayout.CENTER);
		
		// 3. ��ǲ �г� (south)
		inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.setBackground(Color.blue);
		
		// ������Ʈ 
		input = new JTextField(10);						// Event 1
		
		// Event 2 : �̺�Ʈ ���
		input.addActionListener(this);
		
		inputPanel.add(input, BorderLayout.CENTER);
		
		inputFont = new Font("dialog", Font.BOLD, 15);
		input.setFont(inputFont);
		
		this.add(inputPanel, BorderLayout.SOUTH);
		
		// 4. �� �г��� �����ӿ� ���̱� 

		
		
		this.setVisible(true);
		
	}
	
	public void udpServer()
	{
		// ����(����)
		while(true)
		{
			byte[] buffer = new byte[1204];		// 2^n 2�� �ŵ��������� �����
			packet = new DatagramPacket(buffer, buffer.length);
			try {
				System.out.println("wait..");
				socket.receive(packet);
				System.out.println("receive..");
				
				int nextTableNo = table.getRowCount() + 1;
				
				System.out.println("next = " + nextTableNo);
				tableModel = (DefaultTableModel)table.getModel();
				
				// ����, ���̵�, �̸�, ����, �ּ�
				Object[] tmp = new Object[] { nextTableNo, "In", packet.getAddress().getHostAddress(), packet.getPort(), new String(buffer) };
				tableModel.addRow(tmp);
				
				// display.append("KBStar << " + new String(buffer) + "\n");
				// display.setCaretPosition(display.getDocument().getLength());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		// Event 3 : �ڵ� �߰�
		if(e.getSource() == input)
		{
			// display �� input ������ append
			
			String sendMsg = input.getText();
			byte[] buffer = sendMsg.getBytes();
			
			DatagramPacket packet;
			packet = new DatagramPacket(buffer, buffer.length, address, yourPort);
			
			try {
				socket.send(packet);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			int nextTableNo = table.getRowCount() + 1;
			
			System.out.println("next = " + nextTableNo);
			tableModel = (DefaultTableModel)table.getModel();
			
			// ����, ���̵�, �̸�, ����, �ּ�
			Object[] tmp = new Object[] { nextTableNo, "Out", address.getHostAddress(), yourPort, input.getText() };
			tableModel.addRow(tmp);
			
			
			// display.append("�� >> " + sendMsg + "\n" );
			input.selectAll();
			// display.setCaretPosition(display.getDocument().getLength());			
		
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
