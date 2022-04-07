import java.util.Scanner;

public class TestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 4;
		int y = 0;
		
		int result = 0;
		
		if(y==0) {
			System.out.println("y=0 인경우 처리할수 없습니다.");
		}
		else 
		{
			result = x/y;
		}
		
		try {
			result = x/y;
			System.out.println("try result : " + result);
		}
		
		catch(ArithmeticException e) 
		{
			System.out.println("연산 오류");
		}
		
		catch(Exception e) {
			System.out.println("Divided by zero...");
			System.out.println(e.getMessage());
		}
	
		
		
		
		Scanner scan = new Scanner(System.in);
		
		int input;
		System.out.print("숫자를 입력하세요 : ");
		
		try {
			input = scan.nextInt();
//			System.out.print("숫자를 입력하세요 : ");
		}
		catch (Exception e)	{
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Fin");
		}
		
		
		
		scan.close();
		
		// catch 는 작은 단위를 위에 써줘야 한다.  아파요 를 맨 위에 두면 아래쪽으로 안내려감..
		
		System.out.println("result = " + result);
	}

}
