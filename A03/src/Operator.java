import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=5, b=4, c=2, d;
		
		d = a+b*c;
		System.out.println(d);
		
		d = (a+b)*c;
		System.out.println(d);
						
		/*
		 * + operator
		 * a,b : operand, ���׿�����
		 * ++a : ���׿�����
		 * a=5 : a�� 5 ���� : ���Կ�����
		 * a==5 : a�� 5�� ����??
		 * 3�� ������ : ��� ������ ����
		 * ->  ?:
		 * ���� ? ���϶� : �����϶�
		 */
		
		d = a % c; // modular ������ ������
		System.out.println("modular(%) ������ : " + d);
		System.out.println("a==b : " + (a==b));
		

		/* 
		 * & : bit and / �Ѵ� ���϶� ��
		 * | : bit or  / �Ѵ� �����϶� ����
		 * 1 : true , 0 : false
		 */
				
		d = a & b;
		System.out.println("a & b : " + d);
		
		d = a | b;
		System.out.println("a | b : " + d);
		
		a = a<<3;
		System.out.println("a<<3 : " + a);
		
		
		/*
		 * ��AND , ��OR  --> ����??
		 * 3�� ������ : ��� ������ ����
		 * ->  ?:
		 * ���� ? ���϶� : �����϶�
		 */
		
		System.out.println("AND : " + (5>3 && 5>1) );
		System.out.println("AND : " + (5>3 && 5<1) );
		
		System.out.println("OR : " + (5>3 || 5>1) );
		System.out.println("OR : " + (5<3 || 5<1) );
		
		a=5;
		b=13;
		d = a > b ? a : b ;
		System.out.println("max = " + d);
		
		
		Scanner scan = new Scanner(System.in); // Ctrl+Shift+O (import)
		System.out.printf("insert a : ");
		a = scan.nextInt();
		System.out.println("�Է°� : " + a);
		
		System.out.printf("insert b : ");
		b = scan.nextInt();
		System.out.println("�Է°� : " + b);
		
		int sum = a+b;
		System.out.println("a+b = " + sum);
		
		
		scan.close();
		
		
		
		
	}

}
