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
		 * �����̸��� ��� : _name, $name, �̸� 
		 * 				_ : �ý��ۺ���, $ : �ٸ������� ��������� ����ϹǷ� �����Ѵ�.
		 * 				Name �빮�ڴ� Ŭ����
		 * 				1st ���ڷ� �����ϴ°� �Ұ�
		 * 				Ű���� �������� �Ұ� ex, int
		 * 
		 * �ٶ����� ���� : ī��ǥ���
		 * 				�ҹ��ڷ� �����Ѵ�.
		 * 				int myFamilyCount			 
		 * 
		 * Final : ���(constant)
		 * 		   read only Variable
		 * 		   ����� ���ÿ� ���� ����
		 * 		   ��� �빮�ڷ� ǥ��
		 * 
		 * 
		 */
		
		int ���� = 12;
		System.out.println("���� = " + ����);
	
		final double PI = 3.14;
		// PI = 3.1415;
		final int MAX_MONTH = 12;
		
		char familyName = 'K';
		char fm = '��';
		System.out.println("fm = " + fm);
		
		char ufm = '\uAC00';		// [��-�R]
		System.out.println("ufm = " + ufm);
		System.out.println("ufm = " + '\uAC01');
		System.out.println("ufm = " + '\uAC02');
		System.out.println("ufm = " + '\uAC03');
		
		// Ư�����ڴ� �տ� �齽����
		// ȭ�鿡 ���� �����ڵ�� 'uAC00'�Դϴ�.
		
		System.out.println("// ȭ�鿡 ���� �����ڵ�� \'uAC00\' �Դϴ�");
		
		System.out.println("Test = " + '\007');
		
		/*
		 * ������ : Operator
		 * �ǿ����� : Operand
		 * 		���������� : age++, age--
		 * 		�������� : ++age, --age 
		 * 		*, /, %
		 * 		<<, >>
		 * 		= : ġȯ(����)����
		 *		==, != : true, false
		 *		������ : &&, ||
		 *		��Ʈ���� : &, | 
		 *  
		 */
		
		int x = 3;
		x = x << 2;		// shift left : * ȿ��    shift right : / ȿ��  
		System.out.println(x);
		
		x = 7;
		int y = 5;
		int max = 0;
		
		System.out.println("x & y = " + (x & y));
		System.out.println("x | y = " + (x | y));
		
		// 3�׿�����    ���� ? �� : ����;
		
		max = (x >= y) ? x:y;		
		System.out.println("max = " + max);
		// ���� 3�׿����ڿ� ���� �ڵ�
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
		 * Type Casting (����ȯ)
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
		 * if(����) {}
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
			System.out.println("Degree : A, ���� : " + ptr);
		}
		else if(80<=ptr && ptr<90) 
		{
			System.out.println("Degree : B, ���� : " + ptr);
		}
		else if(70<=ptr && ptr<80) 
		{
			System.out.println("Degree : C, ���� : " + ptr);
		}
		else
		{
			System.out.println("Degree : F, ���� : " + ptr);
		}
			
		
		// �ð��� 1000 8�ð� ���� 1.5�� 1500
		// hour : 1~20 �Է� �޴´�.
		// 20 �ʰ� �Է½� err
		
		
		System.out.print("Insert hour : ");
		int myHour = scan.nextInt();
		int workHour = 8;
		
		int pay = 1000;
		double payPlus = pay*1.5;
		double totalPay = 0;
		
		if(myHour<0 || 21<= myHour)
		{
			System.out.println("1~20 �ð� ���� �Է��ϼ���.");
		}
		else
		{
			if(myHour<=workHour)
			{
				System.out.println("���� : " + myHour*pay + " ���ѽð� : " + myHour);
			}
			else
			{
				totalPay = workHour*pay + (myHour-workHour)*payPlus;
				System.out.println("���� : " + (int)totalPay + " ���ѽð� : " + myHour );
			}
			
		}
		

		// SWITCH
		/*
		 * break
		 * 		switch�� ����������
		 * 		���� �ѷ��� �ݺ��� ����������
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
