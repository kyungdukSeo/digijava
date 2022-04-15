import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 37 Tab Menu

class MyFrame extends JFrame
{
	public MyFrame()
	{
		
		createFrame();
		
		// Programming here
		this.setLayout(new BorderLayout());
		
		this.add(createTabbedPane(), BorderLayout.CENTER);
		
		
		this.setVisible(true);
		
	}
	
	public void createFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public JTabbedPane createTabbedPane()
	{
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Tab 1", new JLabel("Tab menu 1"));
		pane.addTab("Tab 2", new JLabel("Tab menu 2"));
		pane.addTab("Tab 3", new JLabel(new ImageIcon("image/kbstar.png")));
		pane.addTab("MyPanel", new MyPanel());
		
		return pane;
	}

	
}


class MyPanel extends JPanel
{
	
	public MyPanel()
	{
		this.setLayout(new BorderLayout());
		
		JTextArea display = new JTextArea(15,40);
		JScrollPane scroll = new JScrollPane(display);
		JTextField input = new JTextField(40);
		
		this.add(scroll, BorderLayout.CENTER);
		this.add(input, BorderLayout.SOUTH);
		
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
