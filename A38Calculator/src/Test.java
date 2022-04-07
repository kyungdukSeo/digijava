
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CalculatorFrame extends JFrame implements ActionListener
{
	
	private JPanel displayPanel;
	private JPanel buttonPanel;
	private JPanel debugPanel;
	
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnProduct;
	private JButton btnDivide;
	private JButton btnEqual;
	private JButton btnCE;
	private JButton[] btns;
	
	private JTextField resultTextField;
	private JTextField prevTextField;
	private JTextField opTextField;
	private JTextField flagTextField;

	private JLabel prevLabel;
	private JLabel opLabel;
	private JLabel flagLabel;
	
	
	
	public CalculatorFrame()
	{
		this.setTitle("내가만든 계산기");
		this.setSize(300,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public CalculatorFrame(String title) 
	{
		this.setTitle(title);
		this.setSize(300,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		//******************************************************************displayPanel
		displayPanel = new JPanel();
		displayPanel.setLayout(new FlowLayout());
		
		resultTextField = new JTextField("0", 30);
		resultTextField.setHorizontalAlignment(JTextField.RIGHT);
		
		displayPanel.add(resultTextField);
		
		//******************************************************************buttonPanel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,4, 5,10));
		buttonSet();
		
		//******************************************************************debugPanel
		debugPanel = new JPanel();
		debugPanel.setLayout(new FlowLayout());
		debugSet();
		
		attatchPanel();
				
		this.setVisible(true);
		
	}
	
	private void debugSet() {
		// TODO Auto-generated method stub

		prevLabel = new JLabel("prev");
		debugPanel.add(prevLabel);
		prevTextField = new JTextField("",5);
		debugPanel.add(prevTextField);
		
		opLabel = new JLabel("op");
		debugPanel.add(opLabel);
		opTextField = new JTextField("",3);
		debugPanel.add(opTextField);
		
		
		flagLabel = new JLabel("flag");
		debugPanel.add(flagLabel);
		flagTextField = new JTextField("false");
		debugPanel.add(flagTextField);
	
		
	}

	public void buttonSet() 
	{
				
		Font font = new Font("Serif", Font.BOLD|Font.ITALIC, 20 );
		
		btns = new JButton[10];
		
		for(int i=0; i<btns.length; i++)
		{
			btns[i] = new JButton(""+i);
			
			btns[i].setFont(font);
			btns[i].addActionListener(this);
		}

		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		btnProduct = new JButton("*");
		btnDivide = new JButton("/");
		btnEqual = new JButton("=");
		btnCE = new JButton("CE");
		
		btnPlus.addActionListener(this);
		btnMinus.addActionListener(this);
		btnProduct.addActionListener(this);
		btnDivide.addActionListener(this);
		btnEqual.addActionListener(this);
		btnCE.addActionListener(this);
		
		buttonPanel.add(btns[1]);
		buttonPanel.add(btns[2]);
		buttonPanel.add(btns[3]);
		buttonPanel.add(btnPlus);
		btnPlus.setFont(font);
		
		buttonPanel.add(btns[4]);
		buttonPanel.add(btns[5]);
		buttonPanel.add(btns[6]);
		buttonPanel.add(btnMinus);
		btnMinus.setFont(font);
		
		buttonPanel.add(btns[7]);
		buttonPanel.add(btns[8]);
		buttonPanel.add(btns[9]);
		buttonPanel.add(btnProduct);
		btnProduct.setFont(font);
		
		buttonPanel.add(btns[0]);
		buttonPanel.add(btnDivide);
		buttonPanel.add(btnEqual);
		buttonPanel.add(btnCE);
		btnCE.setFont(font);
		
	}
	
	public void attatchPanel() {
		// TODO Auto-generated method stub
		
		this.add(displayPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.add(debugPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
		for(int i=0; i<btns.length; i++)
		{
			if(e.getSource() == btns[i]) 
			{ 
				if(resultTextField.getText().equals("0"))
				{
					resultTextField.setText(""+i);
				//	prevTextField.setText(""+i);
				}
				else
				{
					if(opTextField.getText().equals("")) 
					{
						resultTextField.setText(resultTextField.getText() + i);
					//	prevTextField.setText(prevTextField.getText() + i);
					}
					else
					{
						if(flagTextField.getText().equals("false")) 
						{
							resultTextField.setText("" + i);
						//	prevTextField.setText(prevTextField.getText() + i);

							flagTextField.setText("true");
						}
						else
						{
							resultTextField.setText(resultTextField.getText() + i);
							//prevTextField.setText(prevTextField.getText() + i);

						}
															
					}
				
				}
													
			}
							
		}
		
		if(e.getSource()==btnEqual)
		{
			double op1, op2, result;
			op1 = Double.parseDouble(prevTextField.getText());
			op2 = Double.parseDouble(resultTextField.getText());
			
			if(opTextField.getText().equals("+"))
			{
				result = op1 + op2;
				resultTextField.setText(""+result);
			}
			
			if(opTextField.getText().equals("-"))
			{
				result = op1 - op2;
				resultTextField.setText(""+result);
			}
			
			if(opTextField.getText().equals("*"))
			{
				result = op1 * op2;
				resultTextField.setText(""+result);
			}
			
			if(opTextField.getText().equals("/"))
			{
				result = op1 / op2;
				resultTextField.setText(""+result);
			}
			
		}
		
		if(e.getSource()==btnPlus) 
		{
			prevTextField.setText(resultTextField.getText());
			opTextField.setText("+");
			flagTextField.setText("false");
		}
		
		if(e.getSource()==btnMinus)
		{
			prevTextField.setText(resultTextField.getText());
			opTextField.setText("-");
			flagTextField.setText("false");
		}

		if(e.getSource()==btnProduct)
		{
			prevTextField.setText(resultTextField.getText());
			opTextField.setText("*");
			flagTextField.setText("false");
		}
		
		if(e.getSource()==btnDivide)
		{
			prevTextField.setText(resultTextField.getText());
			opTextField.setText("/");
			flagTextField.setText("false");
		}
		
		
		if(e.getSource()==btnCE)
		{
			resultTextField.setText("0");
			prevTextField.setText("");
			opTextField.setText("");
			flagTextField.setText("false");		
		}
		
		
	}
	
}



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		CalculatorFrame calFrame = new CalculatorFrame("내가만든 계산기");
		
		/*

		 *
		 */
	}

}
