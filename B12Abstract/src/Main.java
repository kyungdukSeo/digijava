// Abstract class : �߻� Ŭ����


abstract class Animal
{
	protected int legs;
	protected int wings;
	
	public void eat() 
	{
		System.out.println("Eat...");
	}
	
	// Animal ��ӹ������� ������ move �����ؼ� ����ؾ���. (��ӿ� ������ ��)
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

		// Animal bird = new Animal();  	// �̰� �Ұ����� Animal�� Abstract ����..
		Birds eagle = new Birds();			
	
		
	}

}
