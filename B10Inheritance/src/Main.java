// Inheritance

// final class Car --> final �޸� �ڽ��� ��� ������ ���� 
class Car
{
	protected String name;
	protected int speed;
	protected String color;
	protected int data = 100;
	
	/* 
	 * private���� �صθ� �������� ��� �޾Ƶ� ������.
	 * protected�� �ؾ� �ڽ��� ������ �����ִ�. 
	 */
	

	// ����Ʈ ������(Constructor)
	
	public Car() 
	{
		this("no name", 0, "no color");
	}
	
	// ������
	public Car(String name, int speed, String color) 
	{
		System.out.println("Car() ..");
		this.name = name;
		this.speed = speed;
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	// ���� �޼ҵ� (Final Method)
	// final public void print()   --> final ���� �ڽ��� ������ �Ұ���
	public void print()
	{
		System.out.println("XXXXXXX");
	}
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
	
}

// ���� public class ��� �ؾ�������(�ٸ������ΰ��) ���� ���Ͽ� ���ϱ� public ����..
class SportsCar extends Car
{
	private boolean turbo;
	private double data = 200.0;
	
	public SportsCar()
	{
		System.out.println("SportsCar()");
		
	}
	
	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

	@Override
	public String toString() {
		return "SportsCar [turbo=" + turbo + ", name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}

	
	// �θ��� �޼ҵ��� ������ �ȵ�� ��Ҵ� ������ �ؼ� ����Ҽ� �ִ� ex, toString 
	// ��ӹ����� ���� �ȹް�����ϱ�..
	// �θ� �޼ҵ��� final�� ������ �ؼ� ����Ҽ� ����.

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("�ڽ� print() ������");
		// super.print();	// �θ� ���� ���ߴ°���, ���ִ°� �ƴϴ�. �޸𸮻� �����ִ�!
		
		System.out.println("data = " + data);
		System.out.println("this.data = " + this.data);
		System.out.println("super.data = " + super.data);
	}
	
	
	
}


public class Main 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Car taxi = new Car("taxi", 33, "red");
		System.out.println(taxi);
		
		SportsCar bmw = new SportsCar();
		bmw.setName("bmw");
		
		bmw.print();	// �θ� print �������ؼ� ���
		
		
	}

}
