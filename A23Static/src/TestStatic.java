import java.util.Scanner;

class Car
{
	public static int count;
	public String name;
	
	
	public Car()
	{
		//this.name = "no name";
		//count++;

		this("no name");	// this 를 메소드 처럼 사용도 가능하다
	}
	
	public Car(String name) 
	{
		this.name = name;
		count++;
	}
	
	
	@Override
	public String toString() {
		return "Car [ name = " + name + " , count = " + count + " ]";
	}


	public static int getCount() 
	{
		return count;
	}
	public static void setCount(int count) 
	{
		Car.count = count;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	
}


public class TestStatic
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		print();
		
		Car none = new Car();
		System.out.println(none);
		
		Car taxi = new Car("taxi");
		System.out.println(taxi);
		
		Car bus = new Car("bus");
		System.out.println(bus);
		
		System.out.println(taxi);


		/*
		 * RR(Round Robin) 라운드 로빈
		 * W-RR(Weighted-RR) 가중치 라운드로빈
		 * Priority Queue -> 이걸 무조건 제일먼저!
		 */
		
		int[] lotto = new int[6];	// 암기필요!     [n] : n을 첨자(index) 라고 한다. 
		int index;
		

		for(index=0; index<lotto.length; index++)
		{
			lotto[index] = (index+1)*2;
		
		}
	
		for(index=0; index<lotto.length; index++)
		{
			System.out.println("lotto [" + (index+1) +"] = " + lotto[index]);
		}
		
		/*
		 * 로또 6개 입력 받고,
		 * 로또 입력값 출력
		 * 입력받은 로또의 평균 값
		 */
		
		Scanner scan = new Scanner(System.in);
		int[] input = new int[6];
		double sum = 0.0;
		
		System.out.println("1~45 로또 숫자를 6자리를 입력하세요.");
		
		for(index=0; index<lotto.length; index++)
		{
			System.out.print((index+1) + " 번째 숫자 : ");
			input[index] = scan.nextInt();			
			
			sum = sum+input[index];
	
//			if(0 < input[index] || input[index] <=45)
//			{
//				input[index] = scan.nextInt();
//				sum = sum+input[index];
//			}
//			else if(input[index]>45) 
//			{
//				System.out.println("46 이상의 숫자를 입력했습니다. 1~45까지 숫자를 입력해주세요.");
//			}
//			else(input[index]<=0)
//			{
//				System.out.println("0 이하의 숫자를 입력했습니다. 1~45까지 숫자를 입력해주세요.");
//			}
			
		}
		
		for(index=0; index<lotto.length; index++) 
		{
			System.out.print((index+1) + "번째 입력한 숫자 : " + input[index] + "\t");
		}
		
		System.out.println();
		System.out.println("총합 : " + sum +"\t 평균 : " + sum/lotto.length);
		
		/*
		// Enhanced for()
		// for(값 : 배열)
		for(int value : lotto)
		{
			System.out.println(value);
		}
		*/

		printArray(lotto);
		
		scan.close();
	
	}
	
	public static void printArray(int[] array)
	{
		System.out.println("printArray()");
		
		for (int i=0; i<array.length; i++) 
		{
			System.out.println(array[i]);
		}
	}
	
	public static void print()	// static 으로 되어있어야 메인에서 호출가능(메인이 static 이니까..)
	{
		System.out.println("print...");
	}
	
}
