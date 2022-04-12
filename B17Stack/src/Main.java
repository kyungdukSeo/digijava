import java.util.Scanner;

// stack


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
	
	public void dump()	// dump : 처음부터 끝까지 출력  
	{
		System.out.println("==== Stack ====");
		
		for(int i=top; i>=0; i--)
		{
			System.out.println(stack[i]);
		}
	}
	
	public void push(int value)
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
	
	public void pop()
	{
		if(isEmpty() == true)
		{
			printError("Stack is Empty!!");
			return;
		}
		top--;
	}
	
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// [1] Push [2] Pop [3] Dump [4] Exit
		Scanner scan = new Scanner(System.in);
		int cmd;
		int stackSize;
		
		System.out.print("Insert Stack Size : ");
		stackSize = scan.nextInt();
		Stack stack = new Stack(stackSize);
		
		int input;
		
		while(true)
		{
			System.out.print("[1] Push [2] Pop [3] Dump [4] Exit : ");
			
			cmd = scan.nextInt();
			
			if(cmd==1)
			{
				System.out.print("Insert Input : ");
				input = scan.nextInt();
				stack.push(input);
			}else if(cmd==2)
			{
				stack.pop();
			}else if(cmd==3)
			{
				stack.dump();
			}else if(cmd==4)
			{
				System.out.println("Bye~");
				break;
			}
			
		}
		
		scan.close();
		
	}

}
