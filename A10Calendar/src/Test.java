import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		/*
		 * 사용자로부터 year, month 를 입력받는다
		 * 
		 * 2월인 경우 다음의 조건에 따른다
		 * 4의 배수이면 29일, else 28일이다.
		 * + 4의 배수이고, 100의 배수이면 28일이 된다
		 * + 4의 배수이고, 100의 배수이고, 400의 배수이면 29일이 된다
		 * 
		 *  그 달의 1일이 일요일이라고 가정하고, 그 달의 달력을 출력
		 */
		
		
		int year, month;
		int lastDay = 0 ;
		
		Scanner scan = new Scanner(System.in);
				
		while(true)
		{
			System.out.print("insert year : ");
			year = scan.nextInt();
			
			System.out.print("insert month : ");
			month = scan.nextInt();
			
			if(month > 12 || month < 1) 
			{
				System.out.println("month error, end");
				break;
			}
			
			switch(month)
			{
				default :
					lastDay = 31;
					break;
				case 4 :
				case 6 :
				case 9 :
				case 11 :
					lastDay = 30;
					break;
				case 2 :
					
					if(year%4==0)
					{ //29
						if(year%100==0)
						{ //28
							if(year%400==0)
							{ //29
								lastDay =29;
							}
						}
						else
						{
							lastDay=29;
						}
					}
					else
					{
						lastDay=28;
					}
					
					
					
					
					/*
					if( (year%4==0) && !(year%100==0) || (year%400==0) )
					{
						lastDay=29;
					}
					else
					{
						lastDay=28;
					}
					*/
					
														
					/*
					if(year%400==0) 
					{
						lastDay=29;
					}
					else if(year%100==0)
					{
						lastDay=28;
					}
					else if(year%4==0)
					{
						lastDay=29;
					}
					else
					{
						lastDay=28;
					}
					*/
					
					
					
					/*  내 코드
					if(year%4==0)
					{
						lastDay = 29;
						if(year%100==0) 
						{
							lastDay = 28;
							if(year%400==0) 
							{
								lastDay = 29;
							}
						}
					}
					else
					{
						lastDay = 28;
					}
					*/
					
					
					
					break;
					
					
					
			}
			System.out.println(lastDay);
			
		} 
		scan.close();
		
	}

}
