import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 사용자로부터 입력을 무한히 반복해서 받는다
		 * 0을 입력하면 프로그램 종료
		 * 숫자를 입력하면, 해당 단(table)의 구구단을 출력하시오
		 * 
		 * 0일때 1~9단 / - 일때 종료
		 */
		
		int table;
		int i,j;
		
		
		Scanner scan = new Scanner(System.in);
				
		while(true)
		{
			System.out.print("insert Table : ");
			table = scan.nextInt();
			
			if(table<0)
			{
				System.out.println("End");
				break;
			}
			else if(table==0)
			{
				for(i=1;i<10;i++)
				{
					for(j=1;j<10;j++) 
					{
						System.out.printf(j + "*" + i + "=" + (i*j) +"\t");
												
						if(j==9) 
						{
							System.out.println("");
						}
				
					}
				}
			}
			else
			{
				for(i=1;i<10;i++) 
				{
					System.out.println(table + "*" + i + "=" + (table*i));
				}
			}
		}
		scan.close();
	}

}
