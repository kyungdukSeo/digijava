import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 51 Regular Expression

class MyFrame extends JFrame implements ActionListener
{
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


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		// Event 3 : 코드 추가
		if(e.getSource() == input)
		{
			// display 에 input 내용을 append
			
			String regex = "^010-[0-9]{4}-\\d{4}$";
			// String regex = "010-[0-9]{4}-\\d{4}";     // 위에거랑 차이를 이해해야함
			
			if(Pattern.matches(regex, input.getText()) == false)
			{
				//error
				
			}else
			{
				display.append("\nMobile # ");
			}
			
			
			
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
