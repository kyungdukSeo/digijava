import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// 36 Menu

class MyFrame extends JFrame implements ActionListener
{
	private JMenuItem eventItem1;
	private JPanel displayPanel;
	private JScrollPane scroll;
	private JTextArea display;
	
	
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		
		createMenu();
		createDisplay();
		
		
		this.setVisible(true);
		
	}
	
	
	public void createDisplay()
	{
		
		this.setLayout(new BorderLayout());
		
		displayPanel = new JPanel();					// default - flowlayout
		displayPanel.setLayout(new BorderLayout());
		display = new JTextArea();
		scroll = new JScrollPane(display);
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		this.add(displayPanel);
		
	}
	
	public void createMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		
		menuBar.add(fileMenu);
		fileMenu.add(new JMenuItem("New"));
		fileMenu.add(new JMenuItem("Open File"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("Save"));
		
		// 객체를 만들어서 JMenuItem 추가
		// JMenuItem eventItem1;	-> 맨 위에서 선언 
		eventItem1 = new JMenuItem("Event Test", KeyEvent.VK_E);
		eventItem1.addActionListener(this);
		fileMenu.add(eventItem1);
		
		
		JMenu subMenu = new JMenu("서브메뉴");
		fileMenu.add(subMenu);
		subMenu.add(new JMenuItem("Sub Menu 1"));
		subMenu.add(new JMenuItem("Sub Menu 2"));
		
		
		menuBar.add(editMenu);
		
		
		// this.add(menuBar);
		this.setJMenuBar(menuBar);
		
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	
		if(e.getSource() == eventItem1)
		{
			System.out.println("event 1");
			display.append("Event 1...\n");
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
