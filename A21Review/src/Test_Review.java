

class Car
{
	private int speed;

	public void deposit(int amt)
	{
		
		if(amt<0)
		{
			printError("AMOUT ERROR");
			return ; // void �϶� return ; �� �����ٴ� �Ҹ�
		}
		
		System.out.println("deposit : " + amt);
		
	}
	
	
	private void printError(String msg)
	{
		System.out.println("Message : " + msg);
	}
	
	public int add(double a, double b) // �ߺ�����  ������ �̸������� �޼ҵ带 ������ ������ִ�!
	{
		System.out.println("double, double");
		return (int)(a+b);
		//return (int)a + (int)b;
		
	}
		
	public int add(int a, int b) 
	{
		if(a < 1 || b < 1)
		{
			printError("0�̻��� ���� �ƴմϴ�");
			return -1; // �����ٴ� �Ҹ�
		}
		
		System.out.println("i am add");
		printXY(a, b);
		return a + b;
	}
	
	public void printXY(int x, int y) 
	{
		// �Ķ����(3,4)
		System.out.println("Parameter : (" + x + " , " + y + ")");
	}
	
}


public class Test_Review 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		String str1 = new String();
		String str2 = new String("Hello java");
		String str3 = "just String!";
		
		str1 = "After made";
		
		str1 = "ȫ�浿";
		str3 = str1.replace('ȫ', '��');
		str1 = str1.replace('ȫ', '��');
		System.out.println(str1);
		System.out.println(str3);
		
		int length = str1.length();
		
		System.out.println("length : " + length);
		
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));
		
		//-------------------------------------
		
		
		Car taxi = new Car();
		int add = taxi.add(3, 4);
		
		System.out.println(add);
		System.out.println("Mission 2 : " + taxi.add(7, 8));
		
		taxi.add(-4, 5);
		
		//taxi.printError("�޷�");
		
		taxi.deposit(-1);
		
	
		

				
	}
		
}
