import java.util.Arrays;
import java.util.Scanner;

class Lotto implements InputCheck
{

	private int tries;
	int[] lotto = new int[6];
	
	Scanner scan = new Scanner(System.in);
	
	
	
	public void start() {
		// TODO Auto-generated method stub
		
		while(true) {
			// 몇 게임 할지 묻는다
			// 0게임이면 프로그램 종료
			
			System.out.print("게임횟수를 입력하시오(0 중지) : ");
			int games = scan.nextInt();
			
			if(games==0)
				break;
			
			for(int i=1; i<=games; i++)
			{
				/*
				 * 6개의 로또 번호 1~45 추출한다
				 * 추출 과정에서 중복된 수는 제거
				 * 게임당 03 10 20 3035 40 과 같은 형식으로 출력한다.(오름차순으로 정렬)
				 * 참고코드 sysout("%02d",3);
				 * 
				 * 두자리의 Demical로 출력하는데
				 * 한 자리수는 03과 같이 출력시키는 출력 Format 맞추는 함수 pritnf() 사용
				 */
				
				System.out.print(i+"게임 : " );
				
				// 로또번호를 먼저 array에 넣고,
				String msg = "";
				
				
				for(int j=0; j<6; j++)
				{
					int rand = (int)(Math.random()*45)+1;
					
					for(int k=0; k<j; k++)
					{
						if(lotto[k]==lotto[j])
						{
							j--;
						}
					}
					lotto[j] = rand;
				}
				
				// 다 구해진 로또번호를 정렬
				Arrays.sort(lotto);
				 
				// 정렬된 배열을 출력
				for(int j=0; j<lotto.length; j++)
				{
					System.out.printf("%02d  ", lotto[j]);
				}
				System.out.println();
			}
			
		}
		System.out.println("게임종료");
		scan.close();
		
		
		
		
	}
		
}



interface InputCheck 
{
	public static String TRIES_ERR = "1~5 사이 숫자를 입력하세요!";
	// input err
}





public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lotto lotto = new Lotto();
		lotto.start();
		
	}

}
