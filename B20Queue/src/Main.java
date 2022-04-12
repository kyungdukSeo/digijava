import java.util.Scanner;

// Circular Queue


class Queue
{
	private int[] queue;
	private int in;
	private int out;
	
	
	
	
	public Queue(int queueSize)
	{
		queue = new int[queueSize];
		in = -1;
		out = -1;
	}
	
	private void printError(String errorMsg)
	{
		System.out.println(errorMsg);
	}
	
	
	public void enqueue(int value)
	{
		if(isFull()==true)
		{
			printError("Q is Full");
			return;
		}
		
		in = (++in) % queue.length;
		queue[in] = value;
	}
	
	public void dequeue()
	{
		if(isEmpty() == true)
		{
			printError("Q is Empty");
			return;
		}
		
		out = (++out) % queue.length;
		
	}
	
	public void dump()	// dump : 처음부터 끝까지 출력  
	{
		System.out.println("==== Queue ====");
		
		for(int i=in; i<queue.length; i++)
		{
			System.out.println(queue[i]);
		}
	}
	
	
	public boolean isFull()
	{
		if((in+1)%this.queue.length == out)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty()
	{
		if(this.out==this.in)
		{
			return true;
		}
		return false;
	}
	
	
	public int getIn() {
		return in;
	}
	public void setIn(int in) {
		this.in = in;
	}
	public int getOut() {
		return out;
	}
	public void setOut(int out) {
		this.out = out;
	}
	
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// [1] Enqueue [2] Dequeue [3] Dump [4] Exit
		Scanner scan = new Scanner(System.in);
		int cmd;
		int queueSize;
		int input;
		
		System.out.print("Insert Q size : ");
		queueSize = scan.nextInt();
		Queue queue = new Queue(queueSize);
		
		
		while(true)
		{
			System.out.print("[1] Enqueue [2] Dequeue [3] Dump [4] Exit : ");
			
			cmd = scan.nextInt();
			
			if(cmd==1)
			{
				System.out.print("Insert Input : ");
				input = scan.nextInt();
				queue.enqueue(input);
			}else if(cmd==2)
			{
				queue.dequeue();
			}else if(cmd==3)
			{
				queue.dump();
			}else if(cmd==4)
			{
				System.out.println("Bye~");
				break;
			}
			
		}
		
		scan.close();

	}

}
