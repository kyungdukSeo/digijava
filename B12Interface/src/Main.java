
/*
 * Interface : ��� �޼ҵ尡 �߻�޼ҵ��� Ŭ����
 *  
 */
 
interface RemoteController
{
	public void turnOn();
	public void turnOff();
	
	
}

class TV implements RemoteController, Days
{

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("turnOn");
		System.out.println("�Ͽ��� = " + SUN);
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}
	
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TV tv = new TV();
		tv.turnOn();
		
		System.out.println();
		
		
	}

}
