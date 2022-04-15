import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

// 43 Graphic

class MyFrame extends JFrame
{
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		this.setLayout(new BorderLayout());
		this.add(new MyComponent(), BorderLayout.CENTER);
		
		
		this.setVisible(true);
		
	}
}

class MyComponent extends JComponent
{
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		Font font = new Font("Dialog", Font.BOLD, 10);
		g.setFont(font);
		
		g.drawString("2D Graphic Test", 100, 30);
//		g.drawString("한글", 300, 200);
//		
//		g.drawLine(50, 50, 450, 50);
//		g.drawLine(50, 40, 450, 450);
		
		/*
		for(int i=50; i<=450; i=i+50)
		{
			for(int j=50; j<=450; j=j+50)
			{
				g.drawLine(i, 50, j, 450);
				g.drawLine(50, i, 450, j);
			}
		}
		*/
		
		g.setColor(Color.blue);
		// Rect 사각형
		g.drawRect(50, 50, 400, 400);
		g.fillRect(60, 60, 380, 380);
		
		g.setColor(Color.red);
		// Oval 타원
		g.fillOval(100, 200, 300, 100);
		
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
