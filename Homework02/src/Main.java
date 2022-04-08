// homework02

import java.util.Scanner;

class Lotto implements CheckTries
{
	// �ʵ�(����
	private int tries;
	int[] lotto = new int[6];
	
	Scanner scan = new Scanner(System.in);
	
	
	// �޼ҵ�
	public int getTries() {
		return tries;
	}

	public void setTries() 
	{
		System.out.print("���� Ƚ��(1~5)�� �Է��ϼ���(0 Exit) : ");
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
		
		// sort ���� ó�� �ʿ�
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
		// �ζ� ����Ƚ�� ���� �� Ƚ��üũ, �ߺ� �˻�
		
		while(true) 
		{
			setTries();
			
			if(getTries()==0)
			{
				System.out.println("���� ����!");
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
					System.out.print((i+1)+"���� : " );
					
					// �ζǹ�ȣ�� ���� array�� �ְ�,
					makeLotto();
					
					// �� ������ �ζǹ�ȣ�� ����
					sortLotto();
					
					// ���ĵ� �迭�� ���
					printLotto();
					
				}
			}
		}
		
	}
	
}

interface CheckTries
{
	public static String TRIES_ERR = "1~5 ���� ���ڸ� �Է��ϼ���!";
	// input err
}


public class Main 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Lotto lotto = new Lotto();
		lotto.start();
		
	}

}
