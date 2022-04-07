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
		 * 10이하의 두 수를 입력 받아서,
		 * x의 배수이면서 y의 배수인 값을 모두 출력하시오
		 * */
		
		int x, y;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("x를 입력하시오 : ");
		x = scan.nextInt();
		
		System.out.print("y를 입력하시오 : ");
		y = scan.nextInt();
		
		for(int i=1; i<=100; i++) 
		{
			if( (i%x)==0 && (i%y)==0) 
			{
				System.out.println("결과 : " + i);
			}
		}
		
		// 100 이하 약수
		
		for(int i=1; i<=100; i++) {
			if((100%i)==0)
			{
				System.out.println("100의 약수 : "+ i);
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
