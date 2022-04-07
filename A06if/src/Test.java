
public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int degree = 88;
		
		if(degree>=90)
		{
			System.out.println("A2");
		}
		else if(degree>=80)
		{
			System.out.println("B2");
		}
		else if(degree>=70) 
		{
			System.out.println("C2");
		}
				
		else
		{
			System.out.println("F2");
		}
		
		System.out.println("-----------------------");
		
		if(degree>=90)
		{
			System.out.println("A3");
		}
		if(80<=degree && degree<=90) 
		{
			System.out.println("B3");
		}
		if(70<=degree && degree<=80)
		{
			System.out.println("F3");
		}
		
		
		
	}

}
