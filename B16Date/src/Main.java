// ����Ŭ���� : ������ Ŭ������ ����Ҽ� �ֵ������ִ°�.. 
// tokenizer / ������


import java.util.Date;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date now = new Date();
		System.out.println("date  = " + now.getClass());
		
		System.out.println("now = " + now);
		System.out.println("Month = " + now.getMonth());
		
		// ���ڿ�, tokenizer() �ɰ��� ��� (split)
		
		StringTokenizer st = new StringTokenizer("C,C++,Java,Python,JS,HTML", ",");
		
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
		
	}

}
