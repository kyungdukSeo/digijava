import java.util.Scanner;

public class Test_Dice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * random : 0~1������ ������ ����
		 * 
		 * ���ѷ����� ���鼭 �ֻ��� ��ȣ�� �����ϱ�
		 * 1. �ֻ��� ������ �Է�
		 * 2. �ֻ����� ������
		 *    ����� ������� ������ϴ�.
		 * 3. Ʋ�������� Ʋ���� ǥ�����ֱ�
		 * 
		 * ���Ϲ� ���鼭 ���������� Ʋ���� ī��Ʈ�� ������Ű��
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

			System.out.print("������ �Է� : ");
			guess = scan.nextInt();
			
			diceFace = (int) (Math.random() * 6)+1;
			
			if(guess==diceFace) 
			{
				System.out.println(cnt+"��° ������ϴ�!");
				break;
			}
			else
			{
				cnt++;
				System.out.println("�ֻ��� ���� : "+diceFace);
			}
			
		}
		scan.close();
		
	}

}
