


//public class Car
class Car
{
	//��������(����)
	int speed;
	String maker;
	double rate;
	
	//��������(�Լ�,class)
	void startEngine() 
	{
		System.out.println("startEngine");
	}
	
	void stopEngine()
	{
		System.out.println("stopEngine");
	}
	
	int speedUp() 
	{
		System.out.println("speedUp + 10");
		return speed + 10;
	}
	
	int speedDown()
	{
		System.out.println("speedDown - 10");
		return speed - 10;
	}
	
}





public class Test_Function {
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		/*
		 * void �� return ���� ������ ���
		 */
		
		int a=3, b=4;
		int result;
		
		result = add(a, b);
		System.out.println("result = " + result);
	
		result = add(77,88);
		System.out.println("result = " + result);
		
		Car sonata = new Car();
		Car k5 = new Car();
		Car taxi = new Car(); // �׳� �ϱ��ϴ°� ����
		
		
		sonata.speed = 77;
		k5.speed = 44;
		
		System.out.println("sonata.speed = " + sonata.speed);
		k5.speed = k5.speedUp();
		System.out.println("k5.speed = " + k5.speed);
		
	
	}
			
	public static int add(int x, int y)
	{
//		System.out.println("x = " + x + "\ty = " + y);
		return x + y + 3;
	}
	 
	
	
	
}
