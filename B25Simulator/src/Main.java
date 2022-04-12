import java.util.Scanner;

// Simulator


class Stack
{
	private int[] stack;
	private int top;
	
	
	public Stack() 
	{
		stack = new int[5];	// this(5)
		top = -1;
	}
	
	public Stack(int size) 
	{
		stack = new int[size];
		top = -1;
	}
	
	
	private void printError(String errorMsg)
	{
		System.out.println(errorMsg);
	}
	
	public boolean isFull()
	{
		if(this.top>= this.stack.length-1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty()
	{
		if(this.top == -1)
		{
			return true;
		}
		return false;
	}
	
	synchronized public void dump()	// dump : 처음부터 끝까지 출력  
	{
		System.out.println("==== Stack ====");
		
		for(int i=top; i>=0; i--)
		{
			System.out.println(stack[i]);
		}
	}
	
	synchronized public void push(int value)
	{
		if(isFull() == true)
		{
			printError("Stack is Full");
			return;
		}
		
		//stack[++top] = value;
		
		top++;
		stack[top] = value;
	}
	
	synchronized public void pop()
	{
		if(isEmpty() == true)
		{
			printError("Stack is Empty!!");
			return;
		}
		top--;
	}
	
}


class Producer implements Runnable
{
	private Stack stack;
	
	public Producer(Stack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			int sleepTime = 0;
			try {
				sleepTime = (int)(Math.random() * 1000);
				Thread.sleep(sleepTime);
			} catch (Exception e)
			{
				
			}
			
			// random..
			// int pushValue = (int)(Math.random() * 1000);
			stack.push(sleepTime);
			
		}
	}
}


class Consumer implements Runnable
{
	private Stack stack;
	
	public Consumer(Stack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			int sleepTime = 0;
			try {
				sleepTime = (int)(Math.random() * 1000);
				Thread.sleep(sleepTime);
			} catch (Exception e)
			{
				
			}
			
			// random..
			// int pushValue = (int)(Math.random() * 1000);
			stack.pop();
			
		}
	}
	
}

class Monitor implements Runnable // dump
{
	private Stack stack;
	
	public Monitor(Stack stack)
	{
		this.stack = stack;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			// int sleepTime = 0;
			try {
				// sleepTime = (int)(Math.random() * 1000);
				Thread.sleep(1000);
			} catch (Exception e)
			{
				
			}
			
			// random..
			// int pushValue = (int)(Math.random() * 1000);
			stack.dump();
			
		}
	}
	
}


public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// [1] Push [2] Pop [3] Dump [4] Exit
		Scanner scan = new Scanner(System.in);
		int cmd;
		int stackSize;
		
		System.out.print("Insert Stack Size : ");
		stackSize = scan.nextInt();
		Stack stack = new Stack(stackSize);
		
		// new Producer(stack);
		// new Consumer(stack);
		
		Producer p = new Producer(stack);
		Consumer c = new Consumer(stack);
		Monitor m = new Monitor(stack);
		
		Thread tp = new Thread(p);
		Thread tc = new Thread(c);
		Thread tm = new Thread(m);
		
		tp.start();
		tc.start();
		tm.start();
		
		
		scan.close();
		
	}

}
