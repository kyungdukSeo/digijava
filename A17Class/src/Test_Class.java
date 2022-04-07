

class Car
{
	// ��Ģ : field�� private, method = public
	private int speed;
	
	// method Overloading : �ߺ�����
	// ���� : signature�� ������ �����ؾߵȴ�.
	//       ��, ���ϰ������δ� �������� ���Ѵ�.
	
	public void setSpeed(double speed)
	{
		this.speed = (int)speed;
		// double�� int�� �޴°� ����, �״�� double�� ������ �ִ°�??
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

	@Override //Annotation : �������̵� -> ������   �ߺ�����(�����ε�)�� �ٸ�
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
