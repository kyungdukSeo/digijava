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
		 * º¯¼öÀÌ¸§¿¡ Çã¿ë : _name, $name, ÀÌ¸§ 
		 * 				_ : ½Ã½ºÅÛº¯¼ö, $ : ´Ù¸¥·©±ÍÁö º¯¼ö¼±¾ğ½Ã »ç¿ëÇÏ¹Ç·Î Áö¾çÇÑ´Ù.
		 * 				Name ´ë¹®ÀÚ´Â Å¬·¡½º
		 * 				1st ¼ıÀÚ·Î ½ÃÀÛÇÏ´Â°Ç ºÒ°¡
		 * 				Å°¿öµå º¯¼ö¼±¾ğ ºÒ°¡ ex, int
		 * 
		 * ¹Ù¶÷Á÷ÇÑ º¯¼ö : Ä«¸áÇ¥±â¹ı
		 * 				¼Ò¹®ÀÚ·Î ½ÃÀÛÇÑ´Ù.
		 * 				int myFamilyCount			 
		 * 
		 * Final : »ó¼ö(constant)
		 * 		   read only Variable
		 * 		   ¼±¾ğ°ú µ¿½Ã¿¡ °°ÀÌ ¼¼ÆÃ
		 * 		   ¸ğµÎ ´ë¹®ÀÚ·Î Ç¥±â
		 * 
		 * 
		 */
		
		int ³ªÀÌ = 12;
		System.out.println("³ªÀÌ = " + ³ªÀÌ);
	
		final double PI = 3.14;
		// PI = 3.1415;
		final int MAX_MONTH = 12;
		
		char familyName = 'K';
		char fm = '°¡';
		System.out.println("fm = " + fm);
		
		char ufm = '\uAC00';		// [°¡-ÆR]
		System.out.println("ufm = " + ufm);
		System.out.println("ufm = " + '\uAC01');
		System.out.println("ufm = " + '\uAC02');
		System.out.println("ufm = " + '\uAC03');
		
		// Æ¯¼ö¹®ÀÚ´Â ¾Õ¿¡ ¹é½½·¡½Ã
		// È­¸é¿¡ °¡ÀÇ À¯´ÏÄÚµå´Â 'uAC00'ÀÔ´Ï´Ù.
		
		System.out.println("// È­¸é¿¡ °¡ÀÇ À¯´ÏÄÚµå´Â \'uAC00\' ÀÔ´Ï´Ù");
		
		System.out.println("Test = " + '\007');
		
		/*
		 * ¿¬»êÀÚ : Operator
		 * ÇÇ¿¬»êÀÚ : Operand
		 * 		ÈÄÀ§¿¬»êÀÚ : age++, age--
		 * 		ÀüÀ§Áõ°¨ : ++age, --age 
		 * 		*, /, %
		 * 		<<, >>
		 * 		= : Ä¡È¯(´ëÀÔ)¿¬»ê
		 *		==, != : true, false
		 *		³í¸®¿¬»ê : &&, ||
		 *		ºñÆ®¿¬»ê : &, | 
		 *  
		 */
		
		int x = 3;
		x = x << 2;		// shift left : * È¿°ú    shift right : / È¿°ú  
		System.out.println(x);
		
		x = 7;
		int y = 5;
		int max = 0;
		
		System.out.println("x & y = " + (x & y));
		System.out.println("x | y = " + (x | y));
		
		// 3Ç×¿¬»êÀÚ    Á¶°Ç ? Âü : °ÅÁş;
		
		max = (x >= y) ? x:y;		
		System.out.println("max = " + max);
		// À§¿¡ 3Ç×¿¬»êÀÚ¿Í °°Àº ÄÚµå
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
		 * Type Casting (Çüº¯È¯)
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
		 * if(Á¶°Ç) {}
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
			System.out.println("Degree : A, Á¡¼ö : " + ptr);
		}
		else if(80<=ptr && ptr<90) 
		{
			System.out.println("Degree : B, Á¡¼ö : " + ptr);
		}
		else if(70<=ptr && ptr<80) 
		{
			System.out.println("Degree : C, Á¡¼ö : " + ptr);
		}
		else
		{
			System.out.println("Degree : F, Á¡¼ö : " + ptr);
		}
			
		
		// ½Ã°£´ç 1000 8½Ã°£ ÀÌÈÄ 1.5¹è 1500
		// hour : 1~20 ÀÔ·Â ¹Ş´Â´Ù.
		// 20 ÃÊ°ú ÀÔ·Â½Ã err
		
		
		System.out.print("Insert hour : ");
		int myHour = scan.nextInt();
		int workHour = 8;
		
		int pay = 1000;
		double payPlus = pay*1.5;
		double totalPay = 0;
		
		if(myHour<0 || 21<= myHour)
		{
			System.out.println("1~20 ½Ã°£ ±îÁö ÀÔ·ÂÇÏ¼¼¿ä.");
		}
		else
		{
			if(myHour<=workHour)
			{
				System.out.println("¼ö´ç : " + myHour*pay + " ÀÏÇÑ½Ã°£ : " + myHour);
			}
			else
			{
				totalPay = workHour*pay + (myHour-workHour)*payPlus;
				System.out.println("¼ö´ç : " + (int)totalPay + " ÀÏÇÑ½Ã°£ : " + myHour );
			}
			
		}
		

		// SWITCH
		/*
		 * break
		 * 		switch¸¦ ºüÁ®³ª°¥¶§
		 * 		³ª¸¦ µÑ·¯½Ñ ¹İº¹¹® ºüÁ®³ª°¡±â
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
