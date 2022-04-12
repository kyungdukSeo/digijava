
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Grid Layout

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
		
		// 1. �����̳� : ���̾ƿ� ����
		this.setLayout(new GridLayout(0,2));
		
		Font font = new Font("serif", Font.BOLD, 30);
		// Font : Serif(��ħ, ex-����ü ) font family(�ü�ü)
		// | or �ǹ� ������ 
		// | and �� ���Ǵ� 2��� : font, 
		
		btn1 = new JButton("Center Button");
		btn1.setFont(font);
		
		btn2 = new JButton();
		btn2.setText("2nd Button");
		System.out.println("btn2 = " + btn2.getText());
		
		btn3 = new JButton("3rd Button");
		btn4 = new JButton("4th Button");
		btn5 = new JButton("5th Button");
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		
		
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
