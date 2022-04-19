import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

// B58 Adapter

class MyFrame extends JFrame implements ActionListener
{
	private JPanel displayPanel;
		private JScrollPane scroll;
		private JTextArea display;
		
	private JPanel buttonPanel;
		private JButton open;
		private JButton save;
		private JFileChooser fc;
		private JButton color;
		private JButton calendar;
		private JButton close;
	
	
	public MyFrame()
	{
		initFrame();
		buildDisplay();
		buildButtonPanel();
		
		this.addWindowFocusListener(new MyWindowAdapter());
		
		this.setVisible(true);
	}

	class MyWindowAdapter extends WindowAdapter
	{
		
		@Override
		public void windowGainedFocus(WindowEvent e) {
			// TODO Auto-generated method stub
			
			display.append("Window Gain Focus\n");
			// super.windowGainedFocus(e);
		}

		@Override
		public void windowLostFocus(WindowEvent e) {
			// TODO Auto-generated method stub
			display.append("Window Lost Focus\n");
			// super.windowLostFocus(e);
		}
		
	}

	
	public void buildButtonPanel()
	{
		buttonPanel = new JPanel();
		// buttonPanel.setLayout(new FlowLayout()); 	// flow layout : panel default
		
		open = new JButton("Open");
		save = new JButton("Save");
		color = new JButton("Color");
		calendar = new JButton("Calendar");
		close = new JButton("Close");
		
		fc = new JFileChooser();
		
		open.addActionListener(this);
		save.addActionListener(this);
		color.addActionListener(this);
		calendar.addActionListener(this);
		close.addActionListener(this);
		
		buttonPanel.add(open);
		buttonPanel.add(save);
		buttonPanel.add(color);
		buttonPanel.add(calendar);
		buttonPanel.add(close);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	
	public void buildDisplay()
	{
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		
		display = new JTextArea(10, 10);
		scroll = new JScrollPane(display);
		
		displayPanel.add(scroll, BorderLayout.CENTER);
		
		this.add(displayPanel, BorderLayout.CENTER);
		
	}
	
	
	public void initFrame() 
	{
		this.setTitle("File Open/Save");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		
		this.setLayout(new BorderLayout());
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub

		if(e.getSource() == open)
		{
			/*
			 * File 이름 = 파일명.확장자, 확장자는 보통 3글자 txt, jpg..
			 */
			
			// FileNameExtensionFilter filter = new FileNameExtensionFilter("Image File", "jpg","png");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
			int result;
			
			fc.setFileFilter(filter);
			result = fc.showOpenDialog(this);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				// Open 버튼을 클릭했을때만 파일을 가져온다.
				// File : 화일 vs 파일 
				//        경로명/파일명.확장자
				String path = fc.getSelectedFile().getPath();
				System.out.println("path = " + path);
				
				FileReader in = null;
				BufferedReader br = null;
				
				display.setText("");
				String line = null;
				
				try {
					in = new FileReader(path);
					br = new BufferedReader(in);
					
					while( (line = br.readLine()) != null )
					{
						display.append(line + "\n");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					display.append("File Open Error : " + e2.getMessage() + "\n");
					System.out.println("error : " + e2.getMessage() + "\n");
				}
				finally
				{
					try {
						if ( in != null)
						{
							in.close();
						}
						if( br != null)
						{
							br.close();
						}
					} catch (Exception e3) {
						// TODO: handle exception
					}
					
				}
				
			}
			
		}
		
		if(e.getSource() == save)
		{
			int result;
			result = fc.showSaveDialog(this);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				// System.out.printf("result = %02d\n", result);
				FileWriter out = null;
				BufferedWriter bw = null;
				String fileContents = display.getText();
				
				String path = fc.getSelectedFile().getPath();
				System.out.println("Save File = " + path);
				
				try {
					out = new FileWriter(path);
					bw = new BufferedWriter(out);
					
					// bw = new BufferedWriter(new FileWriter(path))
					
					StringTokenizer st = new StringTokenizer(fileContents, "\n");
					while(st.hasMoreTokens())
					{
						bw.write(st.nextToken());
						bw.newLine();
						bw.flush();
						
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Exception = " + e2.getMessage());
				}
				finally
				{
					try {
						if(out != null)
						{
							out.close();
							// System.out.println("out =" + out);
						}
						if(bw != null)
						{
							bw.close();
						}
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
				
			}
			
		}
		
		if(e.getSource() == color)
		{
			JColorChooser chooser = new JColorChooser();
			Color selectedColor =  chooser.showDialog(null, "Color", Color.DARK_GRAY);
			
			if(selectedColor != null)
			{
				display.setForeground(selectedColor);
			}
		}
		
		if(e.getSource() == calendar)
		{
			Date today = new Date();
			display.append("today = " + today + "\n");

			Calendar gc = new GregorianCalendar();
			display.append("year = " + gc.get(Calendar.YEAR) +"\n");
			display.append("month = " + gc.get(Calendar.MONTH) +"\n");
			display.append("date = " + gc.get(Calendar.DATE) +"\n");
			
			display.append("hour = " + gc.get(Calendar.HOUR) +"\n");
			display.append("minute = " + gc.get(Calendar.MINUTE) +"\n");
			display.append("second = " + gc.get(Calendar.SECOND) +"\n");

			display.append("day = " + gc.get(Calendar.DAY_OF_WEEK) +"\n");
			
		}
		
		if(e.getSource() == close)
		{
			System.exit(1);
		}
		
	}
}


public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
		
	}

}
