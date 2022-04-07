import java.util.Scanner;

public class TestException02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Scanner scan = new Scanner(System.in);
		int age;
		System.out.print("Insert age : " );
		
		try {
			age = scan.nextInt();
			System.out.println("age = " + age);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		scan.close();
		
		*/
		
		int age = getAge();
		
	}
	
	public static int getAge() 
	{
		Scanner scan = new Scanner(System.in);
		int age = 0;
		System.out.print("Insert age : " );
		
		try {
			age = scan.nextInt();
			System.out.println("age = " + age);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("잘못 입력해서 1살로 세팅");
			age = 1;
		}
		scan.close();
		
		return age;
		
	}
	
}
