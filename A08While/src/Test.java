import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		/*
		 * while �� ���������� �ݵ�� ������ Ȯ���Ұ�!
		 * ���������� ������ �ִ°�??
		 */
		
		int i=10;
		
		while(i>=0) 
		{
			System.out.println(i);
			i--;
		}
		
		// ���ѷ���
		
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
				 * 1. ���� �ѷ��� �ݺ����� ����
				 * 2. switch���� ����
				 */
			}
			System.out.println("input : " + input);
		
			int sum = 0;
			
			for (i=1; i<=input; i++)
			{
				sum = sum + i; //sum += i;
				
			}
			System.out.println("1+...+ " + input + "�� " + sum + "�Դϴ�.");
			
		}
		System.out.println("end");
		scan.close();
		
	}

}
