import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//46 HTML Reader	SelectBox(ComboBox)

class MyFrame extends JFrame implements ActionListener
{
	private 	JPanel 		displayPanel;
		private JTextArea 	display;
		private JScrollPane scroll;

	private 	JPanel 		inputPanel;
		private JTextField 	input;
	
	private 	Font		inputFont;
	private 	Font		displayFont;
	
	String[] charset = {"UTF-8", "EUC-KR"};
	
	// Combobox : Select box
	JComboBox charsetList;
	

	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(800, 500);
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
		
		charsetList = new JComboBox(charset);
		charsetList.setSize(100,30);
		inputPanel.add(charsetList, BorderLayout.WEST);
	
		
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



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		// Event 3 : 코드 추가
		if(e.getSource() == input)
		{
			// display 에 input 내용을 append
			display.setText(""); 
			
			try {
				URL url = new URL(input.getText());
				
				String cs = (String)charsetList.getSelectedItem();
				
				BufferedReader in = new BufferedReader(
										new InputStreamReader(url.openStream(), cs)
									);
				
				String line;
				int count = 0;
				String lineCount = "";
				while( (line=in.readLine()) != null )	// 끝날때까지 계속 읽어라
				{
					count ++;
					lineCount = lineCount.format("%05d : ", count);
					
					display.append(lineCount + line + "\n");
				}
						
				try {
					if(in != null)
					{
						in.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
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
