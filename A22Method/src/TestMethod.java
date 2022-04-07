
class Car
{
	private String name;
	private int speed;
	private boolean engineOn;	
	
	/*
	 * ������ : Constructor = �ʱ�ȭ �޼ҵ�
	 * 1. �����ڴ� ���� Ÿ��(��)�� ���� (void�� ����)
	 * 2. class �̸��� ���� (�빮�� ����Ѵ�)
	 * 3. �����ڰ� ������ �˾Ƽ� �����������,
	 *    �ϳ��� ������ ���α׷����� ������ �ݿ��Ѵ�.
	 */
	
	public Car() 			// ����Ʈ(Default) Constructor = �Ķ���Ͱ� ���� ������
	{						// ���� ������, Copy Constructor
		this.engineOn = false;
//		System.out.println("Car()");
	}
		
	public Car(String name) 
	{
		this.name = name;
		this.speed = 0;
		this.engineOn = false;
//		System.out.println("Car(String)");
	}
	
	public Car(String name, int speed) 
	{
		this.name = name;
		this.speed = speed;
		this.engineOn = false;
//		System.out.println("Car(String) , int(speed)");
	}
	
	public void print() 
	{
		System.out.println("name : " + name + "\t speed : " + speed + "\t EngineOn : " + engineOn);
		return ;
	}

	private void printError(String msg) 
	{
		System.out.println("MSG : " + msg);
	}
	
	@Override
	public String toString() 
	{
		return "Car [name=" + name + ", speed=" + speed + ", engineOn=" + engineOn + "]";
	}

	
	public String getName() 
	{
		return this.name;
	}
		
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int setSpeed(int speed)
	{
		if(engineOn==false) 
		{
			printError( name + " ������ �����ֽ��ϴ�.");
			this.speed = 0;
			return -1;
		}
		
		if(speed<=0)
		{
			System.out.println(name +" -, 0 �ӵ��� 0 ����");
//			this.speed = 0;
			return -1;
		}
		
		return this.speed = speed;
	}

	public boolean isEngineOn() {
		return engineOn;
	}

	public void setEngineOn(boolean engineOn) {
		this.engineOn = engineOn;
	}

	public void startEngine()
	{
		if(this.engineOn == true)
		{
			///
			
			return;
		}
		this.engineOn = true;
	}
	
	
}

public class TestMethod 
{
// public class �� ������ �ڹ� ���Ϸ� ��������°� ��Ģ�̴�
		
	public static void main(String[] args) 
	{	// TODO Auto-generated method stub

		Car taxi = new Car();
		taxi.setName("taxi");
		taxi.setEngineOn(true);
		taxi.setSpeed(-1);
		
		Car bus = new Car();
		bus.setName("bus");
		bus.setSpeed(0);

		Car truck = new Car("truck");
		truck.setEngineOn(true);
		truck.setSpeed(30);
		
		System.out.println("1------------");
		Car bmw = new Car("BMW", 40);
		bmw.setEngineOn(false);
		bmw.setSpeed(77);
		System.out.println(bmw);
		
		Car kia = new Car("kia");
		kia.setEngineOn(true);
				
		
//		System.out.println(taxi.getName());
		System.out.println(taxi.getSpeed());
//		System.out.println(bus.getName());
//		System.out.println(bus.getSpeed());
				
		taxi.print();
		bus.print();
		truck.print();
		bmw.print();
		kia.print();

		System.out.println(taxi);
//		System.out.println(bus); //��ü�� ����ϰ� ������ toString�� ���!
//		System.out.println(BMW);
		//taxi.toString();
	
		
		
		/*
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		*/
		
		
	}

}
