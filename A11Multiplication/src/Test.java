import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * ����ڷκ��� �Է��� ������ �ݺ��ؼ� �޴´�
		 * 0�� �Է��ϸ� ���α׷� ����
		 * ���ڸ� �Է��ϸ�, �ش� ��(table)�� �������� ����Ͻÿ�
		 * 
		 * 0�϶� 1~9�� / - �϶� ����
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
