// Abstract class : 추상 클래스


abstract class Animal
{
	protected int legs;
	protected int wings;
	
	public void eat() 
	{
		System.out.println("Eat...");
	}
	
	// Animal 상속받으려면 무조건 move 정의해서 사용해야함. (상속에 제한을 둠)
	public abstract void move(); 
	
}


class Birds extends Animal
{

	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("flying");
	}
	
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Animal bird = new Animal();  	// 이게 불가능함 Animal이 Abstract 여서..
		Birds eagle = new Birds();			
	
		
	}

}
