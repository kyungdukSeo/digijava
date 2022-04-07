

class Car
{
	// 원칙 : field는 private, method = public
	private int speed;
	
	// method Overloading : 중복정의
	// 조건 : signature가 구분이 가능해야된다.
	//       단, 리턴값만으로는 구분하지 못한다.
	
	public void setSpeed(double speed)
	{
		this.speed = (int)speed;
		// double을 int로 받는것 말고, 그대로 double로 받을수 있는가??
	}
	
	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}
	
	public void setSpeed(int speed1, int speed2) 
	{
		this.speed = speed1 + speed2;
	}
	
	public int getSpeed()
	{
		return speed;
	}

	@Override //Annotation : 오버라이딩 -> 재정의   중복정의(오버로딩)과 다름
	public String toString() 
	{
		return "Car [speed=" + speed + "]";
	}
	

}



public class Test_Class 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Car taxi = new Car();
		taxi.setSpeed(77);
		taxi.setSpeed(12.3);
		taxi.setSpeed(1, 2);
		
		System.out.println("taxi.speed = " + taxi.getSpeed());
		
		
		int taxiSpeed = taxi.getSpeed();
		System.out.println(taxiSpeed);
		
		System.out.println(taxi);
		
		
		
	}

}
