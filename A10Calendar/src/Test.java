import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		/*
		 * ����ڷκ��� year, month �� �Է¹޴´�
		 * 
		 * 2���� ��� ������ ���ǿ� ������
		 * 4�� ����̸� 29��, else 28���̴�.
		 * + 4�� ����̰�, 100�� ����̸� 28���� �ȴ�
		 * + 4�� ����̰�, 100�� ����̰�, 400�� ����̸� 29���� �ȴ�
		 * 
		 *  �� ���� 1���� �Ͽ����̶�� �����ϰ�, �� ���� �޷��� ���
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
					
					
					
					/*  �� �ڵ�
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
