import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener
{
	private JButton eventButton;
	MyDialog dialog;

	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		
		dialog = new MyDialog(this, "Dialog Title");
		
		this.setLayout(new FlowLayout());
		eventButton = new JButton("Event Button"); // Event 1
		eventButton.addActionListener(this); // Event 2
		this.add(eventButton);
		
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == eventButton)
		{
			dialog.setVisible(true);
		}
	}
}

class MyDialog extends JDialog implements ActionListener
{
	// ___________ ¹öÆ°
	
	private JTextField name;
	private JButton okBtn;
	
	public MyDialog(JFrame frame, String title)
	{
		super(frame, title);
		
		this.setLayout(new FlowLayout());
		
		name = new JTextField(10);
		okBtn = new JButton("OK");
		
		this.add(name);
		this.add(okBtn);
		
		okBtn.addActionListener(this);
		
		this.setSize(400, 300);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okBtn)
		{
			this.setVisible(false);
		}
	}
	
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
	}

}
