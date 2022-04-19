import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

// 50 Network Simulator

class NetworkSimulator extends JFrame implements ActionListener
{
	private 	JPanel 		headPanel;
		private	JPanel		optionPanel;
			private JPanel	serverClientPanel;
				private JRadioButton radioServer;
				private JRadioButton radioClient;
				private JCheckBox echoServer;
				private JCheckBox receiveClient;
			private JPanel	protocolPanel;
				private JRadioButton radioTCP;
				private JRadioButton radioUDP;
		private	JPanel		startStopPanel;
			private JButton startBtn;
			private JButton stopBtn;
			private JButton exitBtn;
		private	JPanel		ipPortPanel;
			private JTextField inputIP;
			private JTextField inputPort;
			private JTextField debugMsg;
	private JPanel bodyPanel;
		private JScrollPane tableScroll;
		private JTable table;
		private DefaultTableModel tableModel;
		private Vector<String> userColumn;
		private int tableNo;
		
		private JPanel displayPanel;
		private JScrollPane displayScroll;
		private JTextArea display;
		private JPanel filePanel;
			private JButton[] fileButton; 
			private JButton saveButton;
			private JFileChooser fc;
		
	private JPanel tailPanel;
		private JSpinner sleepSpinner;
		private JSpinner countSpinner;
		private JButton sendBtn;
		private JCheckBox checkRandom;
		
	// A01 각 모드 (UDP server, client, TCP Server, client)
	private boolean isUdpServerMode = false;
	private boolean isUdpClientMode = false;
	private boolean isTcpServerMode = false;
	private boolean isTcpClientMode = false;
	
	private boolean isRunning = false;
	private boolean udpClientReadyFlag = false; // 보낼데이터가 있다
	
	private Thread thread;	
	private boolean threadFlag = false;
	
	public NetworkSimulator()
	{
		// Programming here
		// 0.
		initFrame();
		
		// 1. HeadPanel 
		headPanel = createPanel();
		headPanel.setBackground(Color.yellow);
		this.add(headPanel, BorderLayout.NORTH);
		buildHeadPanel();
		

		// 2. bodyPanel
		bodyPanel = createPanel();
		//bodyPanel.setBackground(Color.green);
		
		buildBodyPanel();
		
		// 3. tailPanel
		tailPanel = createPanel();
		//tailPanel.setBackground(Color.orange);
		this.add(tailPanel, BorderLayout.SOUTH);
		buildTailPanel();
		
		
		setDefaultUDPClient();
		this.setVisible(true);
		
	}
	
	
	public JCheckBox getReceiveClient() {
		return receiveClient;
	}

	
	public JCheckBox getCheckRandom() {
		return checkRandom;
	}


	public boolean isUdpClientMode() {
		return isUdpClientMode;
	}
	public void setUdpClientMode(boolean isUdpClientMode) {
		this.isUdpClientMode = isUdpClientMode;
	}


	public JTextArea getDisplay() {
		return display;
	}
	public void setDisplay(JTextArea display) {
		this.display = display;
	}

	
	public JTextField getInputIP() {
		return inputIP;
	}
	public JTextField getInputPort() {
		return inputPort;
	}


	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}


	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}


	public int getTableNo() {
		return tableNo;
	}

	
	
	public JSpinner getSleepSpinner() {
		return sleepSpinner;
	}
	public JSpinner getCountSpinner() {
		return countSpinner;
	}


	
	public void setDefaultUDPClient()
	{
		tableNo = 0;
		radioClient.setSelected(true);
		receiveClient.setEnabled(true);
		radioUDP.setSelected(true);
		
		stopBtn.setEnabled(false);
		startBtn.setEnabled(true);
		
		inputIP.setText("127.0.0.1");
		inputPort.setText("10000");			// server ip/port #
		this.debugMsg.setText("Ready to Simulate");
		
	}
	
	
	public void buildTailPanel() 
	{
		tailPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		Border border = BorderFactory.createTitledBorder("Simulation Option");
		tailPanel.setBorder(border);
		
		SpinnerModel smSleep = new SpinnerNumberModel(1000, 0, 10000, 100);		// default, min, max, gap
		sleepSpinner = new JSpinner(smSleep);
		
		SpinnerModel smCount = new SpinnerNumberModel(10, 1, 10000000, 10);		
		countSpinner = new JSpinner(smCount);
		
		tailPanel.add(new JLabel("Sleep(msec)"));
		tailPanel.add(sleepSpinner);
		tailPanel.add(new JLabel("Repeat Count"));
		tailPanel.add(countSpinner);
		
		tailPanel.add(new JLabel("Random(File)"));
		checkRandom = new JCheckBox();
		
		sendBtn = new JButton("Send");
		sendBtn.setEnabled(false);
		// Event 등록
		sendBtn.addActionListener(this);
		
		
		tailPanel.add(checkRandom);
		tailPanel.add(sendBtn);
		
	}
	
	
	public void buildBodyPanel()
	{
		this.add(bodyPanel, BorderLayout.CENTER);
		
		tableScroll = createScrollTable();
		bodyPanel.add(tableScroll, BorderLayout.CENTER);
		
		filePanel = createPanel();
		buildFilePanel();
		
		buildDisplay();
		
	}
	
	public void buildDisplay()
	{
		display = new JTextArea(10, 35);
		displayScroll = new JScrollPane(display);
		
		Font font = new Font("Dialog", Font.PLAIN, 20);
		display.setFont(font);
		
		displayPanel = createPanel();
		displayPanel.setLayout(new FlowLayout());
		
		Border border = BorderFactory.createTitledBorder("File Info/Send Msg");
		displayPanel.setBorder(border);
		displayPanel.add(displayScroll);
		
		bodyPanel.add(displayPanel, BorderLayout.SOUTH);
		
	}
	
	
	public void buildFilePanel()
	{
		filePanel.setLayout(new GridLayout(0,1));
		
		Border border = BorderFactory.createTitledBorder("File Select");
		filePanel.setBorder(border);
		
		// int[] lotto = new int[6];
		// JButton[] fileButton = new JButton[6];
		
		fileButton = new JButton[6];
		for(int i=0; i<fileButton.length; i++)
		{
			fileButton[i] = new JButton("File " + (i+1));
			fileButton[i].addActionListener(this);
			filePanel.add(fileButton[i]);
		}

		filePanel.add(new JLabel(""));
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		filePanel.add(saveButton);
		
		bodyPanel.add(filePanel, BorderLayout.EAST);
		
	}
	
	public JScrollPane createScrollTable() 
	{
		userColumn = new Vector<String>();
		userColumn.addElement("No");
		userColumn.addElement("In/Out");		
		userColumn.addElement("IP");
		userColumn.addElement("Port");
		userColumn.addElement("Messages");
		
		tableModel = new DefaultTableModel(userColumn, 0)
		// 수정불가
		{
		    @Override
		    public boolean isCellEditable(int row, int column) 
		    {
		       //all cells false
		       return false;
		    }
		};
		
		table = new JTable(tableModel);
	
		table.setPreferredScrollableViewportSize(new Dimension(500,220));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		
		JScrollPane scroll = new JScrollPane(table);
		
		return scroll;
		
	}
	
	public void buildHeadPanel()
	{
		this.headPanel.setLayout(new BorderLayout());
		
		buildOptionPanel();
		buildStartStopPanel();
		buildIPPortPanel();
						
	}
	
	public void buildIPPortPanel() 
	{
		this.ipPortPanel = createPanel();
		ipPortPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		Font font = new Font("Dialog", Font.BOLD, 20);
		
		ipPortPanel.add(new JLabel("IP"));
		inputIP = new JTextField(10);
		inputIP.setFont(font);
		ipPortPanel.add(inputIP);
		
		ipPortPanel.add(new JLabel("Port"));
		inputPort = new JTextField(10);
		inputPort.setFont(font);
		ipPortPanel.add(inputPort);
		
		ipPortPanel.add(new JLabel("Debug"));
		debugMsg = new JTextField(10);
		debugMsg.setFont(font);
		debugMsg.setBackground(new Color(240, 240, 240));
		debugMsg.setEditable(false);
		ipPortPanel.add(debugMsg);
		
		headPanel.add(ipPortPanel, BorderLayout.SOUTH);
		
	}
	
	public void buildStartStopPanel()
	{
		this.startStopPanel = createPanel();
		startStopPanel.setLayout(new FlowLayout());
		
		startBtn = new JButton("Start");
		stopBtn = new JButton("Stop");
		exitBtn = new JButton("Exit");
		
		// A02 : 버튼에 이벤트 등록
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		Border border = BorderFactory.createTitledBorder("Start/Stop");
		startStopPanel.setBorder(border);
		
		startStopPanel.add(startBtn);
		startStopPanel.add(stopBtn);
		startStopPanel.add(exitBtn);
		
		startBtn.setEnabled(false);
		stopBtn.setEnabled(false);
		
		
		
		this.headPanel.add(startStopPanel, BorderLayout.EAST);
		// headPanel.add(startStopPanel, BorderLayout.EAST);
		
	}
	
	public void buildOptionPanel()
	{
		this.optionPanel = createPanel();
		optionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		serverClientPanel = createPanel();
		serverClientPanel.setLayout(new FlowLayout());
		
		radioServer = new JRadioButton("Server");
		radioClient = new JRadioButton("Client");
		echoServer = new JCheckBox("Echo");
		receiveClient = new JCheckBox("RCV");
		
		ButtonGroup ServerOrClient = new ButtonGroup();
		ServerOrClient.add(radioServer);
		ServerOrClient.add(radioClient);
		
		Border border = BorderFactory.createTitledBorder("Server/Client");
		serverClientPanel.setBorder(border);
		serverClientPanel.add(radioServer);
		serverClientPanel.add(echoServer);
		serverClientPanel.add(radioClient);
		serverClientPanel.add(receiveClient);
		
		optionPanel.add(serverClientPanel);
		
		headPanel.add(optionPanel);
		
		
			// head - protocol 
		protocolPanel = createPanel();
		protocolPanel.setLayout(new FlowLayout());

		radioTCP = new JRadioButton("TCP");
		radioUDP = new JRadioButton("UDP");
		
		ButtonGroup protocol = new ButtonGroup();
		protocol.add(radioTCP);
		protocol.add(radioUDP);
		
		Border borderProtocol = BorderFactory.createTitledBorder("Protocol");
		protocolPanel.setBorder(borderProtocol);
		protocolPanel.add(radioTCP);
		protocolPanel.add(radioUDP);

		optionPanel.add(protocolPanel);
	}
	
	public JPanel createPanel()
	{
		JPanel panel = new JPanel();
		return new JPanel();
	}
	
	
	public void initFrame()
	{
		this.setTitle("KBStar Network Simulator");
		this.setSize(700, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
	}

	public void printStatus()
	{
		// (us, uc, ts, tc) = (false, false, true, false,);
		System.out.println("(us, uc, ts, tc) = (" + isUdpServerMode + ", "
													+ isUdpClientMode + ", "
													+ isTcpServerMode + ", "
													+ isTcpClientMode + ") "
													);
	}

	public void doStart()
	{
		this.debugMsg.setText("Start");
		startBtn.setEnabled(false);
		stopBtn.setEnabled(true);
		
		if(radioServer.isSelected())
		{
			radioClient.setEnabled(false);
		}else
		{
			radioServer.setEnabled(false);
		}

		isUdpServerMode = false;
		isUdpClientMode = false;
		isTcpServerMode = false;
		isTcpClientMode = false;
		
		if(this.radioServer.isSelected() == false && this.radioUDP.isSelected())
		{
			isUdpClientMode = true;
			System.out.println("UDP Client");
		}else if(this.radioServer.isSelected() && this.radioUDP.isSelected())
		{
			isUdpServerMode = true;
			System.out.println("UDP Server");
		}else if(this.radioServer.isSelected() == false && this.radioTCP.isSelected())
		{
			isTcpClientMode = true;
			System.out.println("TCP Client");
		}else if(this.radioServer.isSelected() && this.radioTCP.isSelected())
		{
			isTcpServerMode = true;
			System.out.println("TCP Server");
		}
		
		if(isTcpServerMode || isTcpClientMode || isUdpServerMode || isUdpClientMode)
		{
			thread = new Thread(new Runnable() {
				public void run()
				{
					try {
						if(isUdpClientMode == true) 
						{
							startUDPClient();
						}
						// TODO 나머지 상태 추가 예정
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			});
			
			thread.start();
		}
		
	}

	public void startUDPClient() 
	{
		threadFlag = true;
		stopBtn.setEnabled(true);
		startBtn.setEnabled(false);
		sendBtn.setEnabled(true);
		
		isRunning = false;			// 동작중이다..
		
		
		while(true)
		{
			// if(isRunning == false && udpClientReadyFlag == true)
			if(isRunning == false)
			{
				isRunning = true;
				UDPClient udpClient = new UDPClient(this);
				System.out.println("Create UDP Client...");
				// isRunning = true;
			}

			try {
				Thread.sleep(500);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if(isUdpClientMode == false )
			{
				break;
			}
			
		}
		
	}
	
	
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public boolean isUdpClientReadyFlag() {
		return udpClientReadyFlag;
	}

	public void setUdpClientReadyFlag(boolean udpClientReadyFlag) {
		this.udpClientReadyFlag = udpClientReadyFlag;
	}


	public void sendData()
	{
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		// A03 startBtn 실행
		if(e.getSource() == startBtn)
		{
			// 현재 상태
			printStatus();
			doStart();
			
			/*
			if(getReceiveClient().isSelected() == true)
			{
				UDPClient.receive();
			}
			*/
		}
		
		if(e.getSource() == sendBtn )
		{
			// 데이터 전송.. 메시지 읽어서 보내기..
			udpClientReadyFlag = true;
		}
		
		fileControl(e);
		
	}
	
	
	
	public void fileControl(ActionEvent e)
	{
		for(int i=0; i<6; i++)
		{
			if(e.getSource() == fileButton[i])
			{
				FileReader in = null;
				BufferedReader br = null;
				
				String fileContents = "";
				String path = "d:/kbstar/" + (i+1) + ".txt";
				
				try {
					in = new FileReader(path);
					br = new BufferedReader(in);
					
					String line = "";
					display.setText("");
					
					while( (line = br.readLine()) != null )
					{
						display.append(line + "\n");
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					
				}
				finally
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
				
			}
		}
		
		if(e.getSource() == saveButton )
		{
			fc = new JFileChooser();
			fc.setCurrentDirectory(new File("D:\\kbstar"));
			
			int result;
			result = fc.showSaveDialog(this);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				// System.out.printf("result = %02d\n", result);
				FileWriter out = null;
				BufferedWriter bw = null;
				String fileContents = display.getText();
				
				String path = fc.getSelectedFile().getPath();
				System.out.println("Save File = " + path);
				
				try {
					out = new FileWriter(path);
					bw = new BufferedWriter(out);
					
					// bw = new BufferedWriter(new FileWriter(path))
					
					StringTokenizer st = new StringTokenizer(fileContents, "\n");
					while(st.hasMoreTokens())
					{
						bw.write(st.nextToken());
						bw.newLine();
						bw.flush();
						
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Exception = " + e2.getMessage());
				}
				finally
				{
					try {
						if(out != null)
						{
							out.close();
							// System.out.println("out =" + out);
						}
						if(bw != null)
						{
							bw.close();
						}
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
				
			}
		}
		
		
	}
	
}


public class Main 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		NetworkSimulator simulator = new NetworkSimulator();
		
	}
}
