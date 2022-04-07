import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int age = 33;

		if (age < 20) {
			System.out.println("당신은 미성년자입니다.");
		}

		if (age >= 20) {
			System.out.println("당신은 성인입니다.");
		}

		boolean isMale = true;

		if (isMale) {
			System.out.println("Male 1");
		} else {
			System.out.println("Female 1");
		}

		if (!isMale) {
			System.out.println("FeMale 2");
		} else {
			System.out.println("Male 2");
		}

		int degree = 70;

		if (degree >= 90) {
			System.out.println("A 입니다.");
		} else if (degree >= 80) {
			System.out.println("B 입니다.");
		} else {
			System.out.println("F 입니다.");
		}

		
		
		System.out.println("End");

		/*
		 * Scanner scan = new Scanner(System.in);
		 * System.out.printf("나이를 입력하세요 : "); 
		 * age = scan.nextInt();
		 * 
		 * if(age<20) {
		 * System.out.println("당신은 미성년자입니다.");
		 * } else {
		 * System.out.println("당신은 성인입니다."); }
		 */

	}

}
