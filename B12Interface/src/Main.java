
/*
 * Interface : 모든 메소드가 추상메소드인 클래스
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
		System.out.println("일요일 = " + SUN);
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
