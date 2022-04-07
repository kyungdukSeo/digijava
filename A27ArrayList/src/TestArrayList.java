import java.util.ArrayList;
import java.util.Scanner;


public class TestArrayList 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		ArrayList<String> strList = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		strList.add("AA");		// AA -
		strList.add("BB");		// AA - BB
		strList.add("CC");		// AA - BB - CC
		strList.add(1, "DD");	// AA - DD - BB - CC
		
		for(int i=0; i<strList.size(); i++)
		{
			System.out.println(strList.get(i));
		}

		System.out.println(strList);
		
		strList.remove("BB");
		System.out.println(strList);
	
		int index = strList.indexOf("DD");
		System.out.println(index); 
		
		strList.set(index, "KK");
		System.out.println(strList);
		
		
		/*
		 * Scanner�� �̿��� ������ ����� �Է¹޴´�.
		 * [1] Add [2] Set [3] Remove [4] Show [5] Exit
		 * intList�� ������ ����ڸ�� 1~5�� �����ȴ�
		 * Add : ���� �Է¹޾� �� �ڿ� ���δ�.
		 * Set : 0��° ���� ���� �Է¹޴´�.
		 * Remove : 0��° ���� �����.
		 */
		System.out.println("**********************************");
		
		Scanner scan = new Scanner(System.in);
				
		while(true)
		{
			System.out.println("[1] Add [2] Set [3] Remove [4] Show [5] Exit");
			System.out.printf("������ ����� �Է��ϼ��� : ");
			
			int no = scan.nextInt();
			
			if(no==1)
			{
				System.out.print("Add ���ڸ� �Է��ϼ��� : ");
				int inputAdd;
				inputAdd = scan.nextInt();
				intList.add(inputAdd);
				
			}
			else if(no==2)
			{
				System.out.print("Set ���ڸ� �Է��ϼ��� : ");
				int inputSet;
				inputSet = scan.nextInt();
				intList.set(0, inputSet);
			}
			else if(no==3)
			{
				System.out.println("0 ��° ���� Remove");
				intList.remove(0);
			}
			else if(no==4)
			{
				System.out.println(intList);
			}
			else if(no==5)
			{
				System.out.println("���α׷� ����");
				break;
			}

			
		}
		
		scan.close();
		
	}

}
