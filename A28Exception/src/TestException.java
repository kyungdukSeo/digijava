import java.util.Scanner;

public class TestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 4;
		int y = 0;
		
		int result = 0;
		
		if(y==0) {
			System.out.println("y=0 �ΰ�� ó���Ҽ� �����ϴ�.");
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
			System.out.println("���� ����");
		}
		
		catch(Exception e) {
			System.out.println("Divided by zero...");
			System.out.println(e.getMessage());
		}
	
		
		
		
		Scanner scan = new Scanner(System.in);
		
		int input;
		System.out.print("���ڸ� �Է��ϼ��� : ");
		
		try {
			input = scan.nextInt();
//			System.out.print("���ڸ� �Է��ϼ��� : ");
		}
		catch (Exception e)	{
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Fin");
		}
		
		
		
		scan.close();
		
		// catch �� ���� ������ ���� ����� �Ѵ�.  ���Ŀ� �� �� ���� �θ� �Ʒ������� �ȳ�����..
		
		System.out.println("result = " + result);
	}

}
