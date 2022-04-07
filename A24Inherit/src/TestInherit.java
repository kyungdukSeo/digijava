

abstract class Car
{
	protected String name;
	protected int speed;
	
	public abstract void print();	//�̰� ���� ������ �ؼ� ����ؾ� �Ѵٴ� �ǹ� {}���� ;  

	
	
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
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + "]";
	}
	
}

class SportsCar extends Car
{
	private String color;

	
	
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
		System.out.println("�ѷ�");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "SportsCar [color=" + color + ", name=" + name + ", speed=" + speed + "]";
	}



	
}




public class TestInherit 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		
		
		
		
	}

}
