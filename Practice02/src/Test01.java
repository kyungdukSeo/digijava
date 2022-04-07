import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 문제 1
		
		int input;
		int sum=0;
	//	int minus=0;
		
		Scanner scan = new Scanner(System.in);
		
		//System.out.print("x를 입력하시오 : ");
		input = scan.nextInt();
	
		for(int i=0; i<input; i++) 
		{			
			if(i%3==0 || i%5==0)
			{
				sum = sum + i;
			}
		
		}
		
		
		System.out.println(sum);
		scan.close();
//		
//		for(int i = 0; i<input; i++)
//		{
//			if(input%3==0 && input%5==0) 
//			{
//				minus = minus + i;
//			}
//		}
//		
//		
//		
//		for(int i=0; i<input; i++) 
//		{
//			if(input%5==0)
//			{
//				sum5 = sum5 + i;
//			}
//		}
	
		
		
		// 문제 2
		
//		Scanner scan = new Scanner(System.in);
//		String str = scan.nextLine();
//		String[] msg = str.split(" ");
//				
//		System.out.println("length = " + msg.length);
//		
//		for(int i = 0; i<msg.length; i++) 
//		{
//			if(msg[i].equals(" ") == false) 
//			{
//				
//			}
//		}
				
		
		
		
		
		
		
	}

}
