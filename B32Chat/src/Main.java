import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 32 Chat

class MyFrame extends JFrame
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
		
		// 1. ��(frame)�� ���̾ƿ� ���ϱ�
		this.setLayout(new BorderLayout());
		
		
		// 2. ���÷��� �г� (center)
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		displayPanel.setBackground(Color.yellow);
		
		// ������Ʈ..
		display = new JTextArea(5,30);
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		displayFont = new Font("dialog", Font.BOLD, 15);
		display.setFont(displayFont);
		
		
		this.add(displayPanel, BorderLayout.CENTER);
		
		// 3. ��ǲ �г� (south)
		inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.setBackground(Color.blue);
		
		// ������Ʈ 
		input = new JTextField(10);
		inputPanel.add(input, BorderLayout.CENTER);
		
		inputFont = new Font("dialog", Font.BOLD, 15);
		input.setFont(inputFont);
		
		this.add(inputPanel, BorderLayout.SOUTH);
		
		// 4. �� �г��� �����ӿ� ���̱� 

		
		
		
		this.setVisible(true);
		
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
