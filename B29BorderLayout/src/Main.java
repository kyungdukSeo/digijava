
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Layout

class MyFrame extends JFrame
{
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		
		// 1. 컨테이너 : 레이아웃 결정
		this.setLayout(new BorderLayout());
		
		btn1 = new JButton("Center Button");
		btn2 = new JButton();
		btn2.setText("North Button");
		btn3 = new JButton("West Button");
		btn4 = new JButton("East Button");
		btn5 = new JButton("South Button");
		
		this.add(btn1, BorderLayout.CENTER);
		this.add(btn2, BorderLayout.NORTH);
		this.add(btn3, BorderLayout.WEST);
		this.add(btn4, BorderLayout.EAST);
		this.add(btn5, BorderLayout.SOUTH);
		
		
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
