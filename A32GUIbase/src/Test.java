import javax.swing.JFrame;

class KbFrame extends JFrame
{
	//
	
	public KbFrame()
	{
		this.setTitle("KB Star");
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public KbFrame(String title) 
	{
		this.setTitle(title);
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//KbFrame frame = new KbFrame();
		KbFrame frame = new KbFrame("KB* GUI");
		
	}

}
