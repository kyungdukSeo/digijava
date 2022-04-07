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
		 * Scanner를 이용해 수행할 명령을 입력받는다.
		 * [1] Add [2] Set [3] Remove [4] Show [5] Exit
		 * intList의 동작은 사용자명령 1~5로 결정된다
		 * Add : 수를 입력받아 맨 뒤에 붙인다.
		 * Set : 0번째 값을 새로 입력받는다.
		 * Remove : 0번째 값을 지운다.
		 */
		System.out.println("**********************************");
		
		Scanner scan = new Scanner(System.in);
				
		while(true)
		{
			System.out.println("[1] Add [2] Set [3] Remove [4] Show [5] Exit");
			System.out.printf("수행할 명령을 입력하세요 : ");
			
			int no = scan.nextInt();
			
			if(no==1)
			{
				System.out.print("Add 숫자를 입력하세요 : ");
				int inputAdd;
				inputAdd = scan.nextInt();
				intList.add(inputAdd);
				
			}
			else if(no==2)
			{
				System.out.print("Set 숫자를 입력하세요 : ");
				int inputSet;
				inputSet = scan.nextInt();
				intList.set(0, inputSet);
			}
			else if(no==3)
			{
				System.out.println("0 번째 숫자 Remove");
				intList.remove(0);
			}
			else if(no==4)
			{
				System.out.println(intList);
			}
			else if(no==5)
			{
				System.out.println("프로그램 종료");
				break;
			}

			
		}
		
		scan.close();
		
	}

}
