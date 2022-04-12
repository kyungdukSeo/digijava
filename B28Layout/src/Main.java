
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Layout

class MyFrame extends JFrame
{
	private JButton btn1;
	private JButton btn2;
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		
		// 1. 컨테이너 : 레이아웃 결정
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("Hello Button");
		btn2 = new JButton();
		btn2.setText("Second Button");
		
		this.add(btn1);
		this.add(btn2);
		
		
		
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
