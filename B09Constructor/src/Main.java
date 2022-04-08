

class Car 
{
	private String name;
	private int speed;
	private String color;
	static int numberOfCar;		// static : �޸𸮸� �����Ѵ�!

	// private ������ package ������!
	// !!!!!!!!!! �Ϲ������� private�� ����, public�� �޼ҵ忡 ����Ѵ�. �Ϲ������� �׷���, �׷��� ������쵵 ����
	
	/*
	 * ������ : �ʱ�ȭ �޼ҵ�
	 * 1. return Ÿ���� ����
	 * 2. Ŭ������ �̸��� ����
	 * 3. �����ڰ� ������ : �ý����� �˾Ƽ� ������ش�
	 * 4. �����ڰ� �ϳ��� ������
	 * 		���α׷����� ������ �ݿ��Ѵ�
	 * 
	 */
	
	public Car()  // Default Constructor(�Ķ���Ͱ� ���� ������) 
	{
		this.name = "no name";
		this.color = "no color";
		this.speed = 0;
		// this("no name", 0, "no color");
	}
	
	/*
	public Car(String name)  // Copy Constructor(���� ������) // �����ڵ� �ߺ����� ���� 
	{
		this.name = name;
		this.color = "no color";
		this.speed = 0;
	}
	*/
	
	public Car(String name)  // Copy Constructor(���� ������) // �����ڵ� �ߺ����� ���� 
	{
		this(name, 0, "no color");
	}
	
	public Car(String name, int speed, String color)  // Copy Constructor(���� ������) // �����ڵ� �ߺ����� ���� 
	{
		this.name = name;
		this.color = color;
		this.speed = speed;
	}
	
	
	public String getName()
	{
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	
	/*
	 * �ߺ����Ǵ� Signature�� �ٸ��� �޼ҵ带 �ߺ����� �����ϴ�
	 * Signatrue : �Ķ������ ������ �޶�
	 * 
	 * Constructor
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setSpeed(int speed, int speed2) {
		this.speed = speed+speed2;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	protected void finalize()
	{
		System.out.println("Final");
	}
	
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
}



public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Car taxi = new Car();
		taxi.setName("taxi");
		taxi.setSpeed(33);
		taxi.setColor("RED");
		System.out.println(taxi);
		
		Car bus = new Car();
		System.out.println(bus);
		
		Car truck = new Car("truck");
		System.out.println(truck);
		
		truck.finalize(); 		// java������ �� ������� �ʴ´�. �������÷��Ͱ� �˾Ƽ���. C������ �̷��� �������Ѵ�.
		
		Car train = new Car("train", 77, "Black");
		System.out.println(train);
		
		taxi.numberOfCar = 3;
		bus.numberOfCar = 7;
		System.out.println(taxi.numberOfCar);
		System.out.println(Car.numberOfCar);	// �̷��� ����ϴ°� �ٶ����ϴ�.
		
		// static method : ��ü�� ���� �ʿ䰡 ���°�� ���
		// Math.random() : �ܹ߼����� ����ϴ°�� (����ϰ� �����°��??)
		// static method�� static method �� ȣ�� �����ϴ�
		
		int value = (int)Math.ceil(1.23);
		
		int result = add(1,2);
	}
	
	// add�� static �̾�߸� Main ���� ȣ�Ⱑ���ϴ� (main �� static �̱� ������..)
	public static int add(int a, int b)
	{
		return a+b;
	}
	
	
	

}
