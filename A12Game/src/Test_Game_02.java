import java.util.Scanner;

public class Test_Game_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 6123456
		 * 10���� ��� ������, 0���� Ŭ�� ī��Ʈ
		 */
		
		
		Scanner scan = new Scanner(System.in);
		
		int input, cnt, i, org;
				
		while(true) 
		{
			System.out.print("insert no : ");
			input = scan.nextInt();
			org = input;
			
			if(input == 0) 
			{
				System.out.println("End");
				break;
			}
			
			cnt=0;
			while(input>0) 
			{
				int one;
				one = input%10;
				
				if(one==3 || one==6 || one==9)
				{
					cnt++;
				}
				
				input = input / 10;
			}
			
			for(i=1; i<=cnt; i++) 
			{
				System.out.print("clap!! ");	
			}
			
			System.out.println();
			
			if(cnt==0)
			{
				System.out.println(org);
			}
		}
		
		scan.close();
		
	}

}
