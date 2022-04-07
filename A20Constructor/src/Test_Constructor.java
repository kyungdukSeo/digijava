
class Car
{
	private String name;
	private int speed;
	private String color;
	
	/*
	 * ������(Constructor) : �ʱ�ȭ �޼ҵ�
	 * 1. �޼ҵ� �̸��� Ŭ���� �̸��� ����
	 * 2. return Ÿ���� ����.
	 * 3. �����ڰ� ���ǵǾ� ������ ���α׷����� ������ �ݿ��ϰ�,
	 *    ������ �ý����� �˾Ƽ� ������ش�.
	 */
	
	
	/*
	 * Default Constructor �⺻������ -> ()�ȿ� �ƹ��͵� ����...
	 * ���� ����Ʈ �����ڸ� �����, �����ڰ� �Ϻη� ������ ���Ƶδ°����� ������
	 * ���⼭ Car()�� �����, Car(name, speed, color) �� ����� �ǹ�..
	 */
	
	
	public Car() 
	{
		speed = 10;
		color = "none";
		name = "none";
		
		System.out.println("Car() created!!!");
	}
	
	public Car(String name, int speed, String color) // �ߺ�����
	{
		this.speed = 10;
		this.color = "none";
		this.name = "none";
		
		System.out.println("Car(name, spd, clr) created!!!");
	}
	
	
	
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getSpeed() 
	{
		return speed;
	}
	
	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
	
	public String getColor() 
	{
		return color;
	}
	
	public void setColor(String color) 
	{
		this.color = color;
	}
	
	
}



public class Test_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Constructor : ������ (�ʱ�ȭ �޼ҵ�)
		
		Car taxi = new Car();
		Car bus = new Car();
		Car truck = new Car("truck", 77, "red");
		
		
		
		System.out.println("End");
		
		System.out.println(taxi.getColor());
		System.out.println(taxi.getName());
		System.out.println(taxi.getSpeed());

		System.out.println(truck.getName());
		System.out.println(truck.getSpeed());
		System.out.println(truck.getColor());
	}

}
