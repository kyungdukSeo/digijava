import java.util.Scanner;

public class Test_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 99이하의 숫자를 입력한다고 가정한다.
		 * 입력한 값의 369게임의 결과를 출력하시오
		 * 예1 : 27 입력한 경우 27 출력
		 * 예2 : 13, 31을 입력한 경우 "clap" 출력
		 * 예3 : 33 입력인 경우 "clap clap" 출력
		 * 
		 *  0 입력시까지 계속 반복한다.
		 *  
		 *   1의 자리수는 int one = 37 % 10
		 *  10의 자리수는 int ten = 37 / 10
		 */
		
		int input;
		int one, ten;
		
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Insert no : ");
			input = scan.nextInt();
			one = input % 10;
			ten = input / 10;
				
			if(input == 0) 
			{
				System.out.println("End");
				break;
			}
			
			else if(input >=100)
			{
				System.out.println("0~99 숫자 입력하세요");
			}
			else 
			{
				
				int cnt=0;
				
				if(ten==3 || ten==6 || ten==9)
				{
					cnt++;
				}
				
				if(one==3 || one==6 || one==9)
				{
					cnt++;
				}
				
				for(int i=1; i<=cnt; i++)
				{
					System.out.print("clap ");
				}
				
				
				if(cnt==0)
				{
					System.out.println("input : " + input);	
				}
				
				System.out.println();							
				
				
				/*
				switch(ten)
				{
					case 3:
					case 6:
					case 9:
						System.out.print("clap ");
					default :
						
						break;
				}
				
				switch(one)
				{
					case 3:
					case 6:
					case 9:
						System.out.println("clap ");
					default :
						
						break;
				}
				*/
				
		
			}
			
		}
		scan.close();
		
	}

}
