// Inheritance

// final class Car --> final 달면 자식이 상속 받을수 없음 
class Car
{
	protected String name;
	protected int speed;
	protected String color;
	protected int data = 100;
	
	/* 
	 * private으로 해두면 나만쓰고 상속 받아도 못쓴다.
	 * protected로 해야 자식이 가져다 쓸수있다. 
	 */
	

	// 디폴트 생성자(Constructor)
	
	public Car() 
	{
		this("no name", 0, "no color");
	}
	
	// 생성자
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
	
	// 종단 메소드 (Final Method)
	// final public void print()   --> final 쓰면 자식이 재정의 불가능
	public void print()
	{
		System.out.println("XXXXXXX");
	}
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
	
}

// 원래 public class 라고 해야하지만(다른파일인경우) 같은 파일에 쓰니까 public 뺀다..
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

	
	// 부모의 메소드중 마음에 안드는 요소는 재정의 해서 사용할수 있다 ex, toString 
	// 상속받을때 빚은 안받고싶으니까..
	// 부모 메소드중 final은 재정의 해서 사용할수 없다.

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("자식 print() 재정의");
		// super.print();	// 부모 빚을 감추는거지, 없애는건 아니다. 메모리상에 남아있다!
		
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
		
		bmw.print();	// 부모 print 재정의해서 사용
		
		
	}

}
