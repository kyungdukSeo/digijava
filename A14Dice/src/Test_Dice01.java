import java.util.Scanner;

public class Test_Dice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * random : 0~1사이의 더블값을 전달
		 * 
		 * 무한루프를 돌면서 주사위 번호를 예측하기
		 * 1. 주사위 예측값 입력
		 * 2. 주사위를 던지기
		 *    당신은 몇번만에 맞췄습니다.
		 * 3. 틀렸을때는 틀린값 표시해주기
		 * 
		 * 와일문 돌면서 맞을때까지 틀리면 카운트값 증가시키고
		 */

		/*
		for(i=1; i<=10; i++)
		{
			diceFace = (int) (Math.random() * 6)+1;
			System.out.println(diceFace);
		}
		*/
		
		
		int cnt=1;
		int diceFace;
		int guess;
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) 
		{

			System.out.print("예측값 입력 : ");
			guess = scan.nextInt();
			
			diceFace = (int) (Math.random() * 6)+1;
			
			if(guess==diceFace) 
			{
				System.out.println(cnt+"번째 맞췄습니다!");
				break;
			}
			else
			{
				cnt++;
				System.out.println("주사위 숫자 : "+diceFace);
			}
			
		}
		scan.close();
		
	}

}
