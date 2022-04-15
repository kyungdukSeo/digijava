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
		
			// ȸ��(��ä��, RGB ������ ����) 0�� ������ ����, 255�� ��������� ���
		display.setBackground(new Color(230,230,230));
		
		display.setEditable(false);	// ���� ���ϰ� ����
		
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


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		// Event 3 : �ڵ� �߰�
		if(e.getSource() == input)
		{
			// display �� input ������ append
			
			String regex = "^010-[0-9]{4}-\\d{4}$";
			// String regex = "010-[0-9]{4}-\\d{4}";     // �����Ŷ� ���̸� �����ؾ���
			
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
