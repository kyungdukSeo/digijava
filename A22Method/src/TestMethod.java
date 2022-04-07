
class Car
{
	private String name;
	private int speed;
	private boolean engineOn;	
	
	/*
	 * 생성자 : Constructor = 초기화 메소드
	 * 1. 생성자는 리턴 타입(값)이 없다 (void도 없음)
	 * 2. class 이름과 같다 (대문자 사용한다)
	 * 3. 생성자가 없으면 알아서 만들어주지만,
	 *    하나라도 있으면 프로그래머의 의지를 반영한다.
	 */
	
	public Car() 			// 디폴트(Default) Constructor = 파라미터가 없는 생성자
	{						// 복제 생성자, Copy Constructor
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
			printError( name + " 엔진이 꺼져있습니다.");
			this.speed = 0;
			return -1;
		}
		
		if(speed<=0)
		{
			System.out.println(name +" -, 0 속도는 0 셋팅");
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
// public class 는 독립된 자바 파일로 만들어지는게 원칙이다
		
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
//		System.out.println(bus); //객체를 출력하고 싶으면 toString을 써라!
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
