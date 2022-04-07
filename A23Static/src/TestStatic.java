import java.util.Scanner;

class Car
{
	public static int count;
	public String name;
	
	
	public Car()
	{
		//this.name = "no name";
		//count++;

		this("no name");	// this �� �޼ҵ� ó�� ��뵵 �����ϴ�
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
		 * RR(Round Robin) ���� �κ�
		 * W-RR(Weighted-RR) ����ġ ����κ�
		 * Priority Queue -> �̰� ������ ���ϸ���!
		 */
		
		int[] lotto = new int[6];	// �ϱ��ʿ�!     [n] : n�� ÷��(index) ��� �Ѵ�. 
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
		 * �ζ� 6�� �Է� �ް�,
		 * �ζ� �Է°� ���
		 * �Է¹��� �ζ��� ��� ��
		 */
		
		Scanner scan = new Scanner(System.in);
		int[] input = new int[6];
		double sum = 0.0;
		
		System.out.println("1~45 �ζ� ���ڸ� 6�ڸ��� �Է��ϼ���.");
		
		for(index=0; index<lotto.length; index++)
		{
			System.out.print((index+1) + " ��° ���� : ");
			input[index] = scan.nextInt();			
			
			sum = sum+input[index];
	
//			if(0 < input[index] || input[index] <=45)
//			{
//				input[index] = scan.nextInt();
//				sum = sum+input[index];
//			}
//			else if(input[index]>45) 
//			{
//				System.out.println("46 �̻��� ���ڸ� �Է��߽��ϴ�. 1~45���� ���ڸ� �Է����ּ���.");
//			}
//			else(input[index]<=0)
//			{
//				System.out.println("0 ������ ���ڸ� �Է��߽��ϴ�. 1~45���� ���ڸ� �Է����ּ���.");
//			}
			
		}
		
		for(index=0; index<lotto.length; index++) 
		{
			System.out.print((index+1) + "��° �Է��� ���� : " + input[index] + "\t");
		}
		
		System.out.println();
		System.out.println("���� : " + sum +"\t ��� : " + sum/lotto.length);
		
		/*
		// Enhanced for()
		// for(�� : �迭)
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
	
	public static void print()	// static ���� �Ǿ��־�� ���ο��� ȣ�Ⱑ��(������ static �̴ϱ�..)
	{
		System.out.println("print...");
	}
	
}
