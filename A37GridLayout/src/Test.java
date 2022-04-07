
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class KbFrame extends JFrame implements ActionListener
{
	
	private JPanel panel;
	private JButton btn;
	
	private JButton[] btns;
	
	
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
	
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3));
				
		btn = new JButton("Button");
		btn.addActionListener(this);

		btns = new JButton[10];
		
		for(int i=0; i<btns.length; i++) 
		{
			btns[i] = new JButton("Button" + i);
			panel.add(btns[i]);
		}
		
		
		
		this.add(panel);
		//this.pack();		// 사이즈에 맞게 윈도우창 packing
		
		this.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
		if(e.getSource() == btn) 
		{
			if(btn.getText().equals("Button")) 
			{
				btn.setText("Hello Button");	
			}else
			{
				btn.setText("Button");
			}
		}
	}
}



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//KbFrame frame = new KbFrame();
		KbFrame frame = new KbFrame("KB* GUI");
	
		
	}

}
