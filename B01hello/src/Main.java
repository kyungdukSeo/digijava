import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int age = 10;
		System.out.println("age = " + age);
		System.out.println("123" + 45);
		System.out.println(123 + 45);
		System.out.println("age = " + 123 + 45);
		System.out.println("age = " + (123 + 45));
		
		byte value = 127;
		System.out.println("next value = " + (value ++) );
		System.out.println("value = " + value );
		System.out.println("next byte = " + (++value) );
	
		
		short port = 80;
		float degree = 1.23F; // 10^38 
		double point = 1.23; // 10^308 
		long longValue = 1234; // 10^20 
		boolean on = false;
		 
		/*
		 * 변수이름에 허용 : _name, $name, 이름 
		 * 				_ : 시스템변수, $ : 다른랭귀지 변수선언시 사용하므로 지양한다.
		 * 				Name 대문자는 클래스
		 * 				1st 숫자로 시작하는건 불가
		 * 				키워드 변수선언 불가 ex, int
		 * 
		 * 바람직한 변수 : 카멜표기법
		 * 				소문자로 시작한다.
		 * 				int myFamilyCount			 
		 * 
		 * Final : 상수(constant)
		 * 		   read only Variable
		 * 		   선언과 동시에 같이 세팅
		 * 		   모두 대문자로 표기
		 * 
		 * 
		 */
		
		int 나이 = 12;
		System.out.println("나이 = " + 나이);
	
		final double PI = 3.14;
		// PI = 3.1415;
		final int MAX_MONTH = 12;
		
		char familyName = 'K';
		char fm = '가';
		System.out.println("fm = " + fm);
		
		char ufm = '\uAC00';		// [가-힣]
		System.out.println("ufm = " + ufm);
		System.out.println("ufm = " + '\uAC01');
		System.out.println("ufm = " + '\uAC02');
		System.out.println("ufm = " + '\uAC03');
		
		// 특수문자는 앞에 백슬래시
		// 화면에 가의 유니코드는 'uAC00'입니다.
		
		System.out.println("// 화면에 가의 유니코드는 \'uAC00\' 입니다");
		
		System.out.println("Test = " + '\007');
		
		/*
		 * 연산자 : Operator
		 * 피연산자 : Operand
		 * 		후위연산자 : age++, age--
		 * 		전위증감 : ++age, --age 
		 * 		*, /, %
		 * 		<<, >>
		 * 		= : 치환(대입)연산
		 *		==, != : true, false
		 *		논리연산 : &&, ||
		 *		비트연산 : &, | 
		 *  
		 */
		
		int x = 3;
		x = x << 2;		// shift left : * 효과    shift right : / 효과  
		System.out.println(x);
		
		x = 7;
		int y = 5;
		int max = 0;
		
		System.out.println("x & y = " + (x & y));
		System.out.println("x | y = " + (x | y));
		
		// 3항연산자    조건 ? 참 : 거짓;
		
		max = (x >= y) ? x:y;		
		System.out.println("max = " + max);
		// 위에 3항연산자와 같은 코드
		if(x>=y)
		{
			max = x;
		}else
		{
			max = y;
		}
		System.out.println("max = " + max);
		
		
		System.out.println(x>10 && y<10);
		System.out.println(x=1);
	

		/*
		 * Type Casting (형변환)
		 */
		
		int a = 1;
		int b = 2;
		int c;
		double d;	
		double e;
		
		c = (a+b)/2;
		d = (a+b)/2.0;
		e = (double)(a+b)/2;
		
		System.out.println("c = " + c );
		System.out.println("d = " + d );
		System.out.println("e = " + e );
		System.out.println("d = " + (int)d );
		
		
		/*
		 * if(조건) {}
		 * 
		 * if(){} else {}
		 * 
		 * if(){} else if{} ...else{}
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Insert Degree : ");
		int ptr = scan.nextInt();
		
		// 90~100 : A
		// 80~90 : B
		// 70~80 : C
		// else
		
		if (90<=ptr && ptr<=100) 
		{
			System.out.println("Degree : A, 점수 : " + ptr);
		}
		else if(80<=ptr && ptr<90) 
		{
			System.out.println("Degree : B, 점수 : " + ptr);
		}
		else if(70<=ptr && ptr<80) 
		{
			System.out.println("Degree : C, 점수 : " + ptr);
		}
		else
		{
			System.out.println("Degree : F, 점수 : " + ptr);
		}
			
		
		// 시간당 1000 8시간 이후 1.5배 1500
		// hour : 1~20 입력 받는다.
		// 20 초과 입력시 err
		
		
		System.out.print("Insert hour : ");
		int myHour = scan.nextInt();
		int workHour = 8;
		
		int pay = 1000;
		double payPlus = pay*1.5;
		double totalPay = 0;
		
		if(myHour<0 || 21<= myHour)
		{
			System.out.println("1~20 시간 까지 입력하세요.");
		}
		else
		{
			if(myHour<=workHour)
			{
				System.out.println("수당 : " + myHour*pay + " 일한시간 : " + myHour);
			}
			else
			{
				totalPay = workHour*pay + (myHour-workHour)*payPlus;
				System.out.println("수당 : " + (int)totalPay + " 일한시간 : " + myHour );
			}
			
		}
		

		// SWITCH
		/*
		 * break
		 * 		switch를 빠져나갈때
		 * 		나를 둘러싼 반복문 빠져나가기
		 */
		
		
		int month = 2;
		
		switch(month)
		{
			case 2:
				System.out.println("28");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30");
				break;
			default:
				System.out.println("31");
				break;
		}
		
		
		/*
		 * if(%4)
		 * 	// 29
		 * 	if(%100)
		 * 		// 28
		 * 		if(%400)
		 * 			// 29
		 * 	else
		 * 		// 29
		 * else
		 * 	// 28
		 * 
		 * ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)
		 * 
		 */
		
		
		scan.close();
		
	}

}
