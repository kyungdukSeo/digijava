import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int age = 33;

		if (age < 20) {
			System.out.println("����� �̼������Դϴ�.");
		}

		if (age >= 20) {
			System.out.println("����� �����Դϴ�.");
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
			System.out.println("A �Դϴ�.");
		} else if (degree >= 80) {
			System.out.println("B �Դϴ�.");
		} else {
			System.out.println("F �Դϴ�.");
		}

		
		
		System.out.println("End");

		/*
		 * Scanner scan = new Scanner(System.in);
		 * System.out.printf("���̸� �Է��ϼ��� : "); 
		 * age = scan.nextInt();
		 * 
		 * if(age<20) {
		 * System.out.println("����� �̼������Դϴ�.");
		 * } else {
		 * System.out.println("����� �����Դϴ�."); }
		 */

	}

}
