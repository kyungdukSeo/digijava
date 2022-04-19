import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

// 53 DB homework

class MyFrame extends JFrame implements ActionListener 
{
	private JPanel tablePanel;
	
	private Vector<String> userColumn;
	private DefaultTableModel tableModel;
	
	private JPanel inputPanel;
	
	private JTable table;
	
	
	// 이름, ID, address, age
	
	private JTextField name;
	private JTextField id;
	private JTextField address;
	private JSpinner age;
	
	//-----------------DataBase------------
	private final String driver = "org.mariadb.jdbc.Driver";
	private final String dbHost = "localhost";
	private final String dbPort = "3306";
	private final String dbUser = "mykb";
	private final String dbName = "mykb";
	private final String dbPass = "1111";
	private final String dbUrl = "jdbc:mariadb://" + dbHost + ":" + dbPort + "/" + dbName + "?characterEncoding=UTF-8";		// utf8mb4
	// jdbc:mariadb://localhost:3306/mykb?characterEncoding=UTF-8
	
	private Connection conn = null;
	private ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	
	public MyFrame()
	{
		
		initFrame("테이블 연습");
		
		// Programming Here
		tablePanel = createTablePanel();
		buildTabelPanel();
	
		inputPanel = createInputPanel();
		buildInputPanel();
		
		this.add(tablePanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		dbConnect();
		
		this.setVisible(true);
	}
	
	public void dbConnect()
	{
		
		try {
			Class.forName(driver);
			System.out.println("OK Driver");
			
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			if(conn != null) 
			{
				System.out.println("OK DB Connect");
			}else
			{
				System.out.println("Fail DB Connect");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Fail Driver Load");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		} 
		
	}

	public void buildInputPanel()
	{
		// name, age(Spinner), address, id
		name = new JTextField(10);
		id = new JTextField(10);
		address = new JTextField(10);

		SpinnerModel smAge = new SpinnerNumberModel(20, 1, 100, 1);
		age = new JSpinner(smAge);
		
		inputPanel.add(new JLabel("ID"));
		inputPanel.add(id);
		inputPanel.add(new JLabel("Name"));
		inputPanel.add(name);
		inputPanel.add(new JLabel("Age"));
		inputPanel.add(age);
		inputPanel.add(new JLabel("Addr"));
		inputPanel.add(address);
		
		address.addActionListener(this);
		
	}
	
	public JPanel createInputPanel()
	{
		JPanel panel = new JPanel();
		return panel;
	}

	
	public void buildTabelPanel()
	{
		userColumn = new Vector<String>();
		userColumn.addElement("idx");
		userColumn.addElement("ID");
		userColumn.addElement("Name");
		userColumn.addElement("Age");
		userColumn.addElement("Address");
		
		tableModel = new DefaultTableModel(userColumn, 0);
//		JTable table = new JTable(tableModel);
		table = new JTable(tableModel);
		
		table.setPreferredScrollableViewportSize(new Dimension(450, 350));
		table.setFillsViewportHeight(true);
		
		JScrollPane tableScroll = new JScrollPane(table);
		table.setAutoCreateRowSorter(true);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		
		tablePanel.add(tableScroll);
		
	}
	
	public JPanel createTablePanel() 
	{
		JPanel panel = new JPanel();

		return panel;
	}
	
	
	public void initFrame(String title)
	{
		this.setTitle(title);
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setLayout(new BorderLayout());
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == address)
		{
			int nextTableNo = table.getRowCount() + 1;
			tableModel = (DefaultTableModel)table.getModel();
			
			// 순서, 아이디, 이름, 나이, 주소
			Object[] tmp = new Object[] { nextTableNo, id.getText(), name.getText(), age.getValue() , address.getText() };
			tableModel.addRow(tmp);
			
			
			// insert data to DB
			Statement stmt;
			String sql;
			
			try {
				
				sql = "insert into online (id, name, age, address) values (?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, id.getText());
				pstmt.setString(2, name.getText());
				pstmt.setString(3, Integer.toString((int)age.getValue()));		// 작동 O
				// pstmt.setString(3, (String)age.getValue());					// 작동 X
				// pstmt.setInt(3, ((int)age.getValue()));						// 작동 O
				pstmt.setString(4, address.getText());
				
				pstmt.executeUpdate();
				
//				stmt = conn.createStatement();
//				sql = "insert into online (id, name, age, address) values"
//						+ "('" + id.getText() + "', "
//						+ "'" + name.getText() + "', "
//						+ "'" + age.getValue() + "', "
//						+ "'" + address.getText() + "')";
				
//				int affectedCount = stmt.executeUpdate(sql);
				
//				System.out.println("affectedCount = " + affectedCount);

			} catch (Exception e2) {
				// TODO Auto-generated catch block
				
				System.out.println(e2.getMessage());
				if(conn != null)
				{
					try {
						if(conn != null) 
						{
							conn.close();
						}
						if(pstmt != null) 
						{
							pstmt.close();
						}
						if(rs != null) 
						{
							rs.close();
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
	}

}
