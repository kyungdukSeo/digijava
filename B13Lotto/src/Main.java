import java.util.Arrays;
import java.util.Scanner;

class Lotto implements CheckTries
{
	// 필드(변수
	private int tries;
	int[] lotto = new int[6];
	
	Scanner scan = new Scanner(System.in);
	
	
	// 메소드
	public int getTries() {
		return tries;
	}

	public void setTries() 
	{
		System.out.print("게임 횟수(1~5)를 입력하세요(0 Exit) : ");
		this.tries = scan.nextInt();
	}
	
	public void makeLotto()
	{
		for(int j=0; j<6; j++)
		{
			int rand = (int)(Math.random()*45)+1;
			lotto[j] = rand;
			
			for(int k=0; k<j; k++)
			{
				if(lotto[k]==lotto[j])
				{
					j--;
				}
			}
		}
	}
	
	public void sortLotto()
	{
		// Arrays.sort(lotto);
		
		// sort 로직 처리 필요
		int tmp;
		for(int i=0; i<lotto.length; i++)
		{
			for(int j=0; j<(lotto.length-1); j++)
			{
				if(lotto[j]>lotto[j+1])
				{
					tmp=lotto[j];
					lotto[j]=lotto[j+1];
					lotto[j+1] = tmp;
				}
			}
		}
	
	}
	
	public void printLotto()
	{
		for(int j=0; j<lotto.length; j++)
		{
			System.out.printf("%02d  ", lotto[j]);
		}
		System.out.println();
	}
	
	
	public void start()
	{
		// TODO Auto-generated method stub
		// 로또 게임횟수 설정 및 횟수체크, 중복 검사
		
		while(true) 
		{
			setTries();
			
			if(getTries()==0)
			{
				System.out.println("게임 종료!");
				scan.close();
				break;
			}		
			
			if(getTries()<0 || getTries()>5) 
			{
				System.out.println(TRIES_ERR);
			}
			else
			{
				for(int i=0; i<getTries(); i++)
				{
					System.out.print((i+1)+"게임 : " );
					
					// 로또번호를 먼저 array에 넣고,
					makeLotto();
					
					// 다 구해진 로또번호를 정렬
					sortLotto();
					
					// 정렬된 배열을 출력
					printLotto();
					
				}
			}
		}
		
	}
	
}

interface CheckTries
{
	public static String TRIES_ERR = "1~5 사이 숫자를 입력하세요!";
	// input err
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lotto lotto = new Lotto();
		lotto.start();
		
//		int tmp = 0;
//		int num[] = {2,1,3,5,4};
//		
//		System.out.print("정렬 전 : ");
//		for(int i=0; i<=4; i++)
//		{
//			if(i !=4)
//			{
//				System.out.print(num[i] + ",");
//			}
//			else
//			{
//				System.out.print(num[i]);
//			}
//		}
//		
//		for(int i=0; i<=4; i++)
//		{
//			for(int j=0; j<=3; j++)
//			{
//				if(num[j]>num[j+1])
//				{
//					tmp=num[j];
//					num[j]=num[j+1];
//					num[j+1] = tmp;
//				}
//			}
//		}
//		
//		System.out.println();
//		System.out.print("정렬 후 : ");
//		for(int i=0; i<=4; i++)
//		{
//			if(i !=4)
//			{
//				System.out.print(num[i] + ",");
//			}
//			else
//			{
//				System.out.print(num[i]);
//			}
//		}
		
		
		
	}

}
