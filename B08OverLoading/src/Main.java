

class Car 
{
	private String name;
	private int speed;
	private String color;

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
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
}



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car taxi = new Car();
		
		taxi.setName("taxi");
		taxi.setSpeed(33);
		taxi.setColor("RED");
		System.out.println(taxi);
		
		
		
		
	}

}
