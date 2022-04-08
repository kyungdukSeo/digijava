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
			// �� ���� ���� ���´�
			// 0�����̸� ���α׷� ����
			
			System.out.print("����Ƚ���� �Է��Ͻÿ�(0 ����) : ");
			int games = scan.nextInt();
			
			if(games==0)
				break;
			
			for(int i=1; i<=games; i++)
			{
				/*
				 * 6���� �ζ� ��ȣ 1~45 �����Ѵ�
				 * ���� �������� �ߺ��� ���� ����
				 * ���Ӵ� 03 10 20 3035 40 �� ���� �������� ����Ѵ�.(������������ ����)
				 * �����ڵ� sysout("%02d",3);
				 * 
				 * ���ڸ��� Demical�� ����ϴµ�
				 * �� �ڸ����� 03�� ���� ��½�Ű�� ��� Format ���ߴ� �Լ� pritnf() ���
				 */
				
				System.out.print(i+"���� : " );
				
				// �ζǹ�ȣ�� ���� array�� �ְ�,
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
				
				// �� ������ �ζǹ�ȣ�� ����
				Arrays.sort(lotto);
				 
				// ���ĵ� �迭�� ���
				for(int j=0; j<lotto.length; j++)
				{
					System.out.printf("%02d  ", lotto[j]);
				}
				System.out.println();
			}
			
		}
		System.out.println("��������");
		scan.close();
		
		
		
		
	}
		
}



interface InputCheck 
{
	public static String TRIES_ERR = "1~5 ���� ���ڸ� �Է��ϼ���!";
	// input err
}





public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lotto lotto = new Lotto();
		lotto.start();
		
	}

}
