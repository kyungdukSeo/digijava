import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO for test

		String str = "kbstar good news";
		int no = 0;
		
		for(int i = 0; i<str.length(); i++)
		{
			if(str.charAt(i) == 's')
			{
				no++;
			}
			else
			{
				continue;
			}
			
			
		}
		
		
		
		/*
		 * for(초기값; 조건; 증감) {}
		 * 
		 * 1
		 * 1+2
		 * 1+2+3
		 * ...
		 * 1+2+3+...+ n
		 * 
		 */
		
		int sum = 0;
		for(int i=0; i<10; i++)
		{
			sum = sum + i;
			System.out.println("sum = " + sum);
		}
		
		
		
		System.out.println("---------------------1-------------------");
		
//		// 1. 카운트 다운 10~0
//		for(int i=10; i>=0; i--)
//		{
//			System.out.println("count : " + i);
//			
//		}
//		System.out.println("End!!");
		
		
		int i = 10;
		while( i > 0 )
		{
			System.out.println(i);
			i--;
		}
		
		System.out.println("---------------------2-------------------");

//		// 2. 1 3 5 7 9 	100 보다 작을때
//		for(int i=1; i<100; i=i+2)
//		{
//			System.out.println("i = " + i);
//		}
		
		
		
		i = 1;
		while(i<100)
		{
			System.out.println("i = " + i);
			i=i+2;
		}
		
		

		System.out.println("---------------------3-------------------");
		// 3. 1st, 2nd, 3rd, 4th... 10th
		//    11th, 12th, 13th..
		//    21st, 22nd, 23rd .. 99th
//		for(int i=1; i<100; i++)
//		{
//			if(i%10 == 1)
//			{
//				if(i==11)
//				{
//					System.out.println(i+"th");
//				}else
//				{
//					System.out.println(i+"st");
//				}
//			}else if(i%10==2)
//			{
//				if(i==12)
//				{
//					System.out.println(i+"th");
//				}else
//				{
//					System.out.println(i+"nd");
//				}
//			}else if(i%10==3)
//			{
//				if(i==13)
//				{
//					System.out.println(i+"th");
//				}else
//				{
//					System.out.println(i+"rd");
//				}
//			}
//			else
//			{
//				System.out.println(i+"th");
//			}
//			
//		}
		
		i=1;
		while(i<100)
		{
			if(i>10 && i<19)
				System.out.println(i+"th");
			else
			{
				if(i%10==1) 
					System.out.println(i+"st");
				else if(i%10==2)
					System.out.println(i+"nd");
				else if(i%10==3)
					System.out.println(i+"rd");
				else
					System.out.println(i+"th");
			}
				
			i++;
		}
		
		
		/*
		 * while(조건)
		 * {
		 * 		// 실행전에 눈으로 컴파일 필수!
		 * }
		 * 
		 * do
		 * {
		 * 
		 * }while(조건);
		 * 
		 */

		int counter = 1;
		while(counter <= 10)
		{
			System.out.println(counter);
			counter++;
		}
		
		
		// Math.random()  
		
		int rand = (int)(Math.random() * 10) + 1;
		System.out.println("rand = " + rand);
		
		Scanner scan = new Scanner(System.in);
		int tries = 0;
		
		int input;
		do
		{
			System.out.print("Insert 1~10 : ");
			input = scan.nextInt();
			tries++;
			
			if(rand != input)
			{
				System.out.println("wrong! try again!");
			}
		}while(rand != input);
		
		System.out.println("correct!! tries = " + tries);
		
		
		
		while(true)
		{
			System.err.print("[1] Push [2] Pop [3] Dump [4] Exit : ");
			
			input = scan.nextInt();

			
			
			if(input==4)
			{
				System.out.println("Exit!");
				break;
			}
			
		}
		
	
		
		/*
		 * 무한루프를 돌면서, 사용자로부터 구구단의 단을 입력받아
		 * 단(table)을 역순으로 출력합니다.
		 * while 문으로 
		 * 5 * 9 = 45
		 * ...
		 * 5 * 1 = 5
		 * 사용자가 0단을 입력하면 종료
		 */
		
		
		while(true)
		{
			
			System.out.print("구구단을 입력하시오(0 exit) : ");
			int table = scan.nextInt();
			
			if(table==0)
			{
				break;
			}
			else
			{
				int j = 9;
				while(j>=1) 
				{
					System.out.println(table + "*" +  j + " = " + table*j);
					j--;
				}
				
			}
		
		}
		System.out.println("구구단 종료!");
		
		
		scan.close();
		
	}

}
