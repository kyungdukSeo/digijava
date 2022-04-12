// Generic


class Car<T>
{
	private String name;
	private T speed;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getSpeed() {
		return speed;
	}
	public void setSpeed(T speed) {
		this.speed = speed;
	}
	
	
}

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Car<Integer> taxi = new Car();
		Car<Double> bus = new Car();
		Car<String> truck = new Car();
		
		taxi.setSpeed(12);
		bus.setSpeed(12.0);
		truck.setSpeed("½ÊÀÌ");
		
		System.out.println(taxi.getSpeed());
		System.out.println(bus.getSpeed());
		System.out.println(truck.getSpeed());
		
		
	}

}
