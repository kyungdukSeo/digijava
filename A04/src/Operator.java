import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Mission 1.
		 * 두 숫자(정수) 입력받는다.
		 * operand1, operand2 이다.
		 * 연산의 결과는 result에 정수로 변환된다.
		 * 
		 * 두 오퍼랜드를 입력받아서 다음을 각각 출력
		 * + - * % << & ++ MAX
		 */
		
		int operand1, operand2, result;
		Scanner scan = new Scanner(System.in); //Ctrl+Shift+O
		
		System.out.printf("insert operand1 : ");
		operand1 = scan.nextInt();
		
		System.out.printf("insert operand2 : ");
		operand2 = scan.nextInt();
		
		// +
		result = operand1 + operand2;
		System.out.println("+ result = " + result);
		
		// -
		result = operand1 - operand2;
		System.out.println("- result = " + result);
		
		// * 
		result = operand1 * operand2;
		System.out.println("* result = " + result);
				
		// % 
		result = operand1 % operand2;
		System.out.println("% result = " + result);
		
		// << 
		result = operand1 << operand2;
		System.out.println("<< result = " + result);
				
		// & 
		result = operand1 & operand2;
		System.out.println("& result = " + result);
				
		// ++ 
		result = operand1++;
		System.out.println("++ result = " + result);
		// System.out.println("++ result = " + operand1);
				
		// MAX 
		result = operand1 > operand2 ? operand1 : operand2 ;
		System.out.println("MAX result = " + result);
				
		
		System.out.println("operand1 >= operand2 " + (operand1 >= operand2));
		System.out.println("operand1 <= operand2 " + (operand1 <= operand2));
				
		/*
		 * 복합연산자
		 * operand1 = operand1 + 1;
		 * operand1 += 1;
		 */
		
		System.out.println("!= " + (operand1 != operand2));

		
		double degree = 1.23;
		
		result = (int)degree + 1; // 형변환 : Type Casting
		System.out.println(result);
		
		
		double f = (double)5/(double)4;
		System.out.println("f= "+f);
		
		scan.close();
		
	}

}
