import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		/*
		 * while 문 실행전에는 반드시 눈으로 확인할것!
		 * 빠져나가는 조건이 있는가??
		 */
		
		int i=10;
		
		while(i>=0) 
		{
			System.out.println(i);
			i--;
		}
		
		// 무한루프
		
		Scanner scan = new Scanner(System.in);
		int input;
		
		while(true) 
		{
			System.out.print("Insert Number [0] to exit : ");
			input = scan.nextInt();
			
			if(input==0)
			{
				break;
				/*
				 * 1. 나를 둘러싼 반복문의 종료
				 * 2. switch문의 종료
				 */
			}
			System.out.println("input : " + input);
		
			int sum = 0;
			
			for (i=1; i<=input; i++)
			{
				sum = sum + i; //sum += i;
				
			}
			System.out.println("1+...+ " + input + "은 " + sum + "입니다.");
			
		}
		System.out.println("end");
		scan.close();
		
	}

}
