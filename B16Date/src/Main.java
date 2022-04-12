// 포장클래스 : 변수를 클래스로 사용할수 있도록해주는것.. 
// tokenizer / 구분자


import java.util.Date;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date now = new Date();
		System.out.println("date  = " + now.getClass());
		
		System.out.println("now = " + now);
		System.out.println("Month = " + now.getMonth());
		
		// 문자열, tokenizer() 쪼개는 기능 (split)
		
		StringTokenizer st = new StringTokenizer("C,C++,Java,Python,JS,HTML", ",");
		
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
		
	}

}
