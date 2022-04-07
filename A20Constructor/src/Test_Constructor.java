
class Car
{
	private String name;
	private int speed;
	private String color;
	
	/*
	 * 생성자(Constructor) : 초기화 메소드
	 * 1. 메소드 이름은 클래스 이름과 같다
	 * 2. return 타입이 없다.
	 * 3. 생성자가 정의되어 있으면 프로그래머의 의지를 반영하고,
	 *    없으면 시스템이 알아서 만들어준다.
	 */
	
	
	/*
	 * Default Constructor 기본생성자 -> ()안에 아무것도 없는...
	 * 만약 디폴트 생성자를 지우면, 개발자가 일부러 못쓰게 막아두는것으로 이해함
	 * 여기서 Car()를 지우면, Car(name, speed, color) 만 쓰라는 의미..
	 */
	
	
	public Car() 
	{
		speed = 10;
		color = "none";
		name = "none";
		
		System.out.println("Car() created!!!");
	}
	
	public Car(String name, int speed, String color) // 중복정의
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
		// Constructor : 생성자 (초기화 메소드)
		
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
