
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = new String("Hello String World") ;
		String str2 = "Hello Java World";
		String str3, str4;
		
		int len = str1.length();
		System.out.println("str1 length = " + len + "\t" + str1);
		str3 = str1.concat("Concat");
		System.out.println("str3 = " + str3);
		str3 = str1.replace('l', 'L');
		System.out.println("str3 = " + str3);
		str3 = str1.substring(1,5);
		System.out.println("str3 = " + str3);
		str3 = str1.toUpperCase();
		str4 = str1.toLowerCase();
		System.out.println("Upper : " + str3);
		System.out.println("Lower : " + str4);
	
		
		// charAt
		for(int i=0; i< str1.length(); i++)
		{
			System.out.println(i + " : " + str1.charAt(i));
		}
		
		str4 = str1 + str2;
		System.out.println(str4);
		System.out.println("100" + 20);
		System.out.println(100+20);
		
	}

}
