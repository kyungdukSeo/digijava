// 40 Table

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class MyFrame extends JFrame
{
	public MyFrame()
	{
		this.setTitle("KBStar GUI");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Programming Here
		// 이름, 주소, 나이, 가입여부
		String[] colName = {"이름", "주소", "나이", "가입여부" };
		Object[][] data = {
				{"홍길동", "서울", 33, false	},
				{"이순신", "경상", 44, true   },
				{"킹세종", "전라", 55, true   }
		};
		
		JTable table = new JTable(data, colName);
		table.setPreferredScrollableViewportSize(new Dimension(500, 150));
		table.setFillsViewportHeight(true);
		
		JScrollPane scroll = new JScrollPane(table);
		this.add(scroll);
		
		this.setVisible(true);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame frame = new MyFrame();
	}

}
