

public class Test_String 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// Car taxi = new Car();
		
		String str1 = "Hello World";
		String str2 = "hello world";
		
		System.out.println("str1 == str2 : " + (str1 == str2));
		
		int length;
		length = str1.length();
		
		System.out.println("length : "+length);
		
		int i ;
		
		for(i=0; i<length; i++)
		{
			char c = str1.charAt(i);
			System.out.println(i + " : " + c);
			
			// System.out.println(str1.charAt(i));
		}
	
		char third = str1.charAt(3);
		System.out.println(third);
		
		boolean isSame = str1.equalsIgnoreCase(str2);
		System.out.println("isSame : " + isSame);
		
		isSame = str1.equals(str2);
		String str3 = str1.replace('l', 'K');
		System.out.println("str3 : " + str3);
		
		str3 = str1.substring(2, 4);
		System.out.println("str3 = " + str3);
		
		str3 = str1.toLowerCase();
		System.out.println(str3);
		
		str3 = str1.toUpperCase();
		System.out.println(str3);
		
		
		str1 = "prev";
		str2 = "next";
		str3 = str1 + str2;
		str3 = "Hello" + 123;
		str3 = "12" + 34;
		str3 = "ABC";
		
		System.out.println(str3);
		
		int a = 34;
		int b = 77;

		System.out.println("12"+a);
		
		System.out.println("str3 = " + str3 + " , " + "a = " + a);
		
		// (a,b) = (11,22)
		// System.out.printf("(a,b) = (%d,%d)", a, b);
		
		printXY(a, b);
		printXY(3, 4);
		
		
		for(a=1; a<=9; a++)
		{
			for(b=1; b<=9; b++)
			{
				printXY(a, b);
			}
		}
		
		
		
	}
	
		public static void printXY(int x, int y)
		{
			System.out.println("(" + x + "," + y + ")");
		
		}
		
}


