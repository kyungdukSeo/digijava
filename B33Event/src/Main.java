import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// 33 Event

class MyFrame extends JFrame implements ActionListener
{
	// 북 : 버튼
	// 남 : Textarea
	
	private JPanel buttonPanel;
		private JButton btn1;
		private JButton btn2;
		private JButton btn3;
		
	private JPanel displayPanel;
		private JScrollPane scroll;
		private JTextArea display;
		
	
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		// 1. 레이아웃 결정
		this.setLayout(new BorderLayout());
		
		
		// 2. 북쪽 button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		btn1 = new JButton("button 1");		// Event 1 버튼 만들고
		btn2 = new JButton("random color");
		btn3 = new JButton("RGB Alpha");
		
		// Event 2 : 이벤트 등록
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
				
		buttonPanel.add(btn1);
		buttonPanel.add(btn2);
		buttonPanel.add(btn3);
		
		this.add(buttonPanel, BorderLayout.NORTH);
		
		
		// 3. 센터 display panel
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		
		display = new JTextArea();
		display.setBackground(Color.yellow);
		
		scroll = new JScrollPane(display);
		
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		this.add(displayPanel, BorderLayout.CENTER);
		
		
		
		this.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// Event 3 : 동작 정의
		if(e.getSource() == btn1)
		{
			System.out.println("btn1 click");
			
			//display.setText("btn1 click");
			display.append("btn1 click\n");
		}
		
		if(e.getSource() == btn2)
		{
			// Color.yellow, Colro(r,g,b)
			// RGB : Red, Green, Blue : 빛의 3원색
			//		0-255, 00-FF
			// RGBA : 투명도까지
			
			int r, g, b;
			
			r = (int)(Math.random() * 256 );
			g = (int)(Math.random() * 256 );
			b = (int)(Math.random() * 256 );
			
			Color color = new Color(r,g,b);
			
			display.setBackground(color);
			display.append("RGB : " + r +", " + g +", " + b + "\n" );
		}
		
		if(e.getSource() == btn3)
		{
			// Color.yellow, Colro(r,g,b)
			// RGB : Red, Green, Blue : 빛의 3원색
			//		0-255, 00-FF
			// RGBA : 투명도까지
			
			int r, g, b;
			int alpha;
			
			r = (int)(Math.random() * 256 );
			g = (int)(Math.random() * 256 );
			b = (int)(Math.random() * 256 );
			alpha = (int)(Math.random() * 256 );
			
			Color color = new Color(r, g, b, alpha);
			
			display.setBackground(color);
			display.append("RGB : " + r +", " + g +", " + b + ", " + alpha + "\n" );
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
