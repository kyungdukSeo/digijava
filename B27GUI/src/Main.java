import javax.swing.JFrame;

// GUI

class MyFrame extends JFrame
{
	public MyFrame()
	{
		createFrame();
		// createMenu();
		
	}
	
	
	public void createFrame() 
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming here
		
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
