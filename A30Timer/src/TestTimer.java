
// Thread 는 Runnable Interface를 구현..
class Bell implements Runnable
{
	private int ms;
	private String name;
	private int cnt;
	
	public Bell(String name, int sec) 
	{
		this.name = name;
		this.ms = sec * 1000;
		this.cnt = 0;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true) {
		
			try {
				Thread.sleep(this.ms);
				cnt++;
				System.out.println(this.name + " : " + cnt);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
}


public class TestTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bell bell1 = new Bell("one", 1);
		Thread t1 = new Thread(bell1);
		t1.start();
		
		Bell bell3 = new Bell("Three", 3);
		Thread t3 = new Thread(bell3);
		t3.start();
		
		Bell bell5 = new Bell("Five", 5);
		Thread t5 = new Thread(bell5);
		t5.start();
		
		
		
		
		
		
		/*
		int cnt=0;
		
		while(true) 
		{
			//1초 쉬고..cnt 증가
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//cnt++;
			System.out.println(++cnt);
			
			if(cnt>10) {
				break;
			}
		}
		*/
		
	}

}

