class Car
{
	private String name;
	private int speed;
	private boolean engineOn;

	public Car(String name)
	{
		this.name = name;
		this.speed = 0;
		this.engineOn = false;
	}

	@Override
	public String toString() 
	{
		return "Car [name = " + name + "   speed = " + speed + "\t engineOn = " + engineOn + "]";
	}

	public boolean startEngine()
	{
		if(engineOn==true) {
			error(name + " already engineOn");
		}
		else if(engineOn==false)
		{
			System.out.println(name + " startEngine 성공");
		}
		return this.engineOn = true;
	}

	public boolean stopEngine()
	{
		if(engineOn==false)
		{
			error(name + " already engineOff");
		}
		else if(engineOn==true)
		{
			System.out.println(name + " stopEngine 성공");
			this.speed = 0;
		}
		return this.engineOn = false;

	}

	private void error(String errorMessage) 
	{
		System.out.println("errorMessage : " + errorMessage);
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

	public int setSpeed(int speed) 
	{
		if(engineOn==false)
		{
			error("engineStart First! (speed = 0 셋팅)");	
			speed = 0;
		}
		else if(engineOn==true) 
		{
			System.out.println(name + " setSpeed : " + speed);
		}

		return this.speed = speed;

	}

	public int setSpeed(double speed) 
	{
		if(engineOn==false)
		{
			error("engineStart First! (speed = 0 셋팅)");			
			this.speed = 0;
		}
		System.out.println(name + " setSpeed : " + speed);

		return this.speed = (int)speed;
	}

	public boolean isEngineOn() 
	{
		return engineOn;
	}

	public void setEngineOn(boolean engineOn) 
	{
		this.engineOn = engineOn;
	}

}

public class TestHomework 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Car taxi = new Car("taxi");
		Car bus = new Car("bus");

		taxi.setSpeed(10);				// engineOn = false 일때, speed = 0 셋팅
		System.out.println(taxi);

		bus.startEngine();
		System.out.println(bus);

		bus.setSpeed(44.0);				// setSpeed(double speed) 확인을 위해 소수점 입력
		System.out.println(bus);

		bus.startEngine();
		System.out.println(bus);

		taxi.startEngine();
		System.out.println(taxi);

		taxi.setSpeed(20);
		System.out.println(taxi);

		taxi.stopEngine();
		System.out.println(taxi);

		taxi.stopEngine();					
		System.out.println(taxi);

		bus.stopEngine();
		System.out.println(bus);

		System.out.println(taxi.getName() + ".isEngineOn : " + taxi.isEngineOn());    // taxi.isEngineOn(); 호출 test
		System.out.println(bus.getName() + ".isEngineOn : " + bus.isEngineOn());	  // bus.isEngineOn(); 호출 test

 

	}

 

}