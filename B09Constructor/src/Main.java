

class Car 
{
	private String name;
	private int speed;
	private String color;
	static int numberOfCar;		// static : 메모리를 공유한다!

	// private 없으면 package 변수다!
	// !!!!!!!!!! 일반적으로 private은 변수, public은 메소드에 사용한다. 일반적으로 그렇고, 그렇지 않은경우도 있음
	
	/*
	 * 생성자 : 초기화 메소드
	 * 1. return 타입이 없다
	 * 2. 클래스와 이름이 같다
	 * 3. 생성자가 없으면 : 시스템이 알아서 만들어준다
	 * 4. 생성자가 하나라도 있으면
	 * 		프로그래머의 의지를 반영한다
	 * 
	 */
	
	public Car()  // Default Constructor(파라미터가 없는 생성자) 
	{
		this.name = "no name";
		this.color = "no color";
		this.speed = 0;
		// this("no name", 0, "no color");
	}
	
	/*
	public Car(String name)  // Copy Constructor(복제 생성자) // 생성자도 중복정의 가능 
	{
		this.name = name;
		this.color = "no color";
		this.speed = 0;
	}
	*/
	
	public Car(String name)  // Copy Constructor(복제 생성자) // 생성자도 중복정의 가능 
	{
		this(name, 0, "no color");
	}
	
	public Car(String name, int speed, String color)  // Copy Constructor(복제 생성자) // 생성자도 중복정의 가능 
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
	 * 중복정의는 Signature가 다르면 메소드를 중복정의 가능하다
	 * Signatrue : 파라미터의 갯수가 달라도
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
		
		truck.finalize(); 		// java에서는 잘 사용하지 않는다. 가비지컬렉터가 알아서함. C에서는 이렇게 끝내야한다.
		
		Car train = new Car("train", 77, "Black");
		System.out.println(train);
		
		taxi.numberOfCar = 3;
		bus.numberOfCar = 7;
		System.out.println(taxi.numberOfCar);
		System.out.println(Car.numberOfCar);	// 이렇게 사용하는게 바람직하다.
		
		// static method : 객체를 만들 필요가 없는경우 사용
		// Math.random() : 단발성으로 사용하는경우 (사용하고 버리는경우??)
		// static method는 static method 만 호출 가능하다
		
		int value = (int)Math.ceil(1.23);
		
		int result = add(1,2);
	}
	
	// add는 static 이어야만 Main 에서 호출가능하다 (main 이 static 이기 때문에..)
	public static int add(int a, int b)
	{
		return a+b;
	}
	
	
	

}
