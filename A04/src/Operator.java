import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Mission 1.
		 * �� ����(����) �Է¹޴´�.
		 * operand1, operand2 �̴�.
		 * ������ ����� result�� ������ ��ȯ�ȴ�.
		 * 
		 * �� ���۷��带 �Է¹޾Ƽ� ������ ���� ���
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
		 * ���տ�����
		 * operand1 = operand1 + 1;
		 * operand1 += 1;
		 */
		
		System.out.println("!= " + (operand1 != operand2));

		
		double degree = 1.23;
		
		result = (int)degree + 1; // ����ȯ : Type Casting
		System.out.println(result);
		
		
		double f = (double)5/(double)4;
		System.out.println("f= "+f);
		
		scan.close();
		
	}

}
