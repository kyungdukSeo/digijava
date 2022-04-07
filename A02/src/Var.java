/*
 * ���� : variable
 * ���� : declaration
 */

// single line comment

public class Var {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// java�� ī��(Camel)ǥ����� �⺻, ��Ÿ�� ó�� �ҹ���+�빮�ڷ� ������ ����
		int age;
		int myFamilyCount;
		int yourAge;
		int myFatherAge;

		// �ٲ�� �ȵǴº��� final
		final int MAXMONTH = 12;

		// multiple variable
		int koreanDegree, mathDegree;

		// declaration, init
		int englishDegree = 77;
		int a = 1, b = 2;

		System.out.println("englishDegree = " + englishDegree);

		englishDegree = 88;
		System.out.println("englishDegree = " + englishDegree);

		// maxMonth = 13;
		System.out.println("MAXMONTH = " + MAXMONTH);

		a = a + 1;
		System.out.println("a = " + a);
		a++;
		System.out.println("a = " + a);

		System.out.println(a++); // ���߿� ���Ѵ�
		System.out.println(++a); // ���ϰ� �ִ´�
		System.out.println(++a);
		System.out.println(a++);
		System.out.println(a);

		double pi = 3.14;
		System.out.println("pi = " + pi);

		double result;
		result = pi + a;
		System.out.println("result = " + result);

		double average = 1 + 3;
		average = average / 3;
		System.out.println("average = " + average);
		System.out.printf("average = \t%.2f\n", average);

		// Hi "KB"
		System.out.println("Hi \"KB\"");

		// \n : new line \r + \f

		String myName = "kdhong";
		System.out.println("myName = " + myName);

		char init = 'K';
		String lee = "L";

		byte num = 127;
		System.out.println("num = " + num);

		num++; // overflow
		System.out.println("num++ -> " + num);

		num--; // underflow
		System.out.println("num-- -> " + num);

		final double PI = 3.1415927;	// final : read only variable
		boolean isOn = true; // or false (logical variable)
		System.out.println("isOn = " + isOn);
		
		double limit = 1.0/2.0;
		System.out.println("limit 1 " + limit);
		
		limit = 1.0/0.0;
		System.out.println("limit 2 " + limit);
		
		limit = 0.0/0.0; // NaN : Not a Number
		System.out.println("limit 3 " + limit);
		
		
		/*
		 * ������ ���� TEST
		 */
		
		char ch1 = 'A';
		char ch2 = '��';
		char ch3 = '\uac00';
		
		System.out.println("ch1 = " + ch1);
		System.out.println("ch2 = " + ch2);
		System.out.println("ch3 = " + ch3);
		
		
	}

}
