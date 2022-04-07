
import java.util.*;

class Car {
	
}

public class Main
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int no1=0, no2=0;
		int x=0, y=0;
		
		System.out.print("insert no1 : ");
		no1 = scan.nextInt();
		
		System.out.print("insert no2 : ");
		no2 = scan.nextInt();
		
		if(no1<no2)
		{
			x = no1;
			y = no2;
		}
		else if(no1>no2)
		{
			y = no1;
			x = no2;
		}
		
		for(int i=x; i<=y; i++)
		{
			if((i%2)==0 || (i%3)==0)
			{
				System.out.println(i);
			}
		}
		
		
		int[] ar = new int[6];
		
		for(int i=0; i<ar.length;i++) 
		{
			ar[i] = 100 + i;
			System.out.println(ar[i]+1);
		}
		
		
		
		
		
		Car taxi = new Car();
		
		
		
		scan.close();
		
		
	}
	
}
