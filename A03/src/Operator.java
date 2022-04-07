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
		 * a,b : operand, 이항연산자
		 * ++a : 단항연산자
		 * a=5 : a에 5 대입 : 대입연산자
		 * a==5 : a와 5가 같냐??
		 * 3항 연산자 : 모든 랭귀지 공통
		 * ->  ?:
		 * 조건 ? 참일때 : 거짓일때
		 */
		
		d = a % c; // modular 나머지 연산자
		System.out.println("modular(%) 연산자 : " + d);
		System.out.println("a==b : " + (a==b));
		

		/* 
		 * & : bit and / 둘다 참일때 참
		 * | : bit or  / 둘다 거짓일때 거짓
		 * 1 : true , 0 : false
		 */
				
		d = a & b;
		System.out.println("a & b : " + d);
		
		d = a | b;
		System.out.println("a | b : " + d);
		
		a = a<<3;
		System.out.println("a<<3 : " + a);
		
		
		/*
		 * 논리AND , 논리OR  --> 문장??
		 * 3항 연산자 : 모든 랭귀지 공통
		 * ->  ?:
		 * 조건 ? 참일때 : 거짓일때
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
		System.out.println("입력값 : " + a);
		
		System.out.printf("insert b : ");
		b = scan.nextInt();
		System.out.println("입력값 : " + b);
		
		int sum = a+b;
		System.out.println("a+b = " + sum);
		
		
		scan.close();
		
		
		
		
	}

}
