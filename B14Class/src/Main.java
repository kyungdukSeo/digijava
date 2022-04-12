// Inner Class
// 클래스 안에 클래스 설계


class Car
{
	private String name;
	private int speed;
	
	public Car()
	{
		InnerClass obj = new InnerClass();
		obj.getTest();

	}
	
	private class InnerClass
	{
		
		private int test;

				
		public InnerClass()
		{
			System.out.println("Inner Class");
		}
		
		public int getTest() {
			return test;
		}

		public void setTest(int test) {
			this.test = test;
		}
		
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
	
}



// Anonymous Class 무명 클래스
// 몸체는 정의하고, 이름은 없다
// 정의하면서 동시에 객체를 생성, 단발성으로 사용하고 버린다.

// download.oracle.com/javase

interface RemoteController {
	public void turnOn();
	public void turnOff();
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RemoteController tv = new RemoteController() {
			public void turnOn() {};
			public void turnOff() {};
		};
		
	}
}
