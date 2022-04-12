import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 35 Event

class MyFrame extends JFrame implements ActionListener, MouseListener, KeyListener
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
		
		display.addMouseListener(this);
		
		this.add(displayPanel, BorderLayout.CENTER);
		
		// 3. 인풋 패널 (south)
		inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputPanel.setBackground(Color.blue);
		
		// 컴포넌트 
		input = new JTextField(10);						// Event 1
		
		// Event 2 : 이벤트 등록
		input.addActionListener(this);					// enter 쳤을때만 event 발생
		input.addKeyListener(this);						// key 쳤을때
		
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
			display.append("\n" + input.getText() );
			input.selectAll();
			display.setCaretPosition(display.getDocument().getLength());
		
		}
		
	}

	
	// -------------------------------key

		@Override
		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
			// CTRL, ALT, SHIFT
			char c = e.getKeyChar();
			String info = "(CTRL, SHIFT, ALT) = (" + e.isControlDown() + ", " + e.isShiftDown() + ", " + e.isAltDown() + ")";
			info = "PRESS " + c + info;
			
			display.append(info + "\n");
			display.setCaretPosition(display.getDocument().getLength());
		}


		@Override
		public void keyPressed(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyReleased(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}
	
	// ---------------------------mouse

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int count = e.getClickCount();
		
		String info = "Mouse Click : " + x + ", " + y + " #" + count;
		System.out.println(info);
		display.append(info + "\n");
		display.setCaretPosition(display.getDocument().getLength());
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int count = e.getClickCount();
		
		String info = "Mouse Pressed : " + x + ", " + y + " #" + count;
		System.out.println(info);
		display.append(info + "\n");
		display.setCaretPosition(display.getDocument().getLength());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
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
