import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

// 38 ToolBar


class MyFrame extends JFrame
{
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		
		createToolBar();
		
		
		this.setVisible(true);
		
	}
	
	
	public void createToolBar() 
	{
		JToolBar toolBar = new JToolBar("Tool Bar Menu Test");
		Color color = new Color(240,240,240);
		toolBar.setBackground(color);		// Color.LIGHT_GRAY
		toolBar.add(new JButton("New"));
		// toolBar.add(new JButton(new ImageIcon("image/kbstar.jpg")));
		toolBar.add(new JButton("Save"));
		toolBar.addSeparator();
		toolBar.add(new JLabel("°Ë»ö¾î"));
		toolBar.add(new JTextField("Keyword"));
		
		this.add(toolBar, BorderLayout.NORTH);
		
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
