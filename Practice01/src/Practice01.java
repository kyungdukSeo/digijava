import java.util.Scanner;

public class Practice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 
		 * EB : P*K
		 * PB : T*K
		 * TB : G*K
		 * GB : M*K
		 * MB : K*K 
		 * KB : kilo 1024 2^10
		 * 1
		 * ms : 10^-3
		 * us : -6
		 * ns : -9
		 *    : -10
		 * ps : -12
		 */
		
		/*
		 * 10������ �� ���� �Է� �޾Ƽ�,
		 * x�� ����̸鼭 y�� ����� ���� ��� ����Ͻÿ�
		 * */
		
		int x, y;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("x�� �Է��Ͻÿ� : ");
		x = scan.nextInt();
		
		System.out.print("y�� �Է��Ͻÿ� : ");
		y = scan.nextInt();
		
		for(int i=1; i<=100; i++) 
		{
			if( (i%x)==0 && (i%y)==0) 
			{
				System.out.println("��� : " + i);
			}
		}
		
		// 100 ���� ���
		
		for(int i=1; i<=100; i++) {
			if((100%i)==0)
			{
				System.out.println("100�� ��� : "+ i);
			}
			
		}
		scan.close();

		/*
		int[] lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = i;
		}
		System.out.println(lotto[6]);
		*/
		
		
		
		
		
	}

}
