import java.util.Scanner;

public class Test_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 99������ ���ڸ� �Է��Ѵٰ� �����Ѵ�.
		 * �Է��� ���� 369������ ����� ����Ͻÿ�
		 * ��1 : 27 �Է��� ��� 27 ���
		 * ��2 : 13, 31�� �Է��� ��� "clap" ���
		 * ��3 : 33 �Է��� ��� "clap clap" ���
		 * 
		 *  0 �Է½ñ��� ��� �ݺ��Ѵ�.
		 *  
		 *   1�� �ڸ����� int one = 37 % 10
		 *  10�� �ڸ����� int ten = 37 / 10
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
				System.out.println("0~99 ���� �Է��ϼ���");
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
