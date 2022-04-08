import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int[] ages = new int[3];
		
		int sum=0;
		for(int i=0; i < ages.length; i++)
		{
			System.out.print("Insert Age " + (i+1) + " : ");
			ages[i] = scan.nextInt();
			sum += ages[i];
			
		}
		
		System.out.println("평균 = " + (double)sum/ages.length);
		System.out.printf("평균 = %.2f", (double)sum/ages.length);
		System.out.println();
		
		
		int a=3, b=12, c=123;
		System.out.printf("a =%5d, b =%05d, c =%d", a, b, c);
		System.out.println();
		
		
		int result = add(1,2);
		System.out.println(result);
		
		printArray(ages);
		
		
		// 2차원 배열
		int[][] ptr = new int[2][4];
		
		//ptr.length = 2 , ptr[0].length = 4
		for(int i=0; i<ptr.length; i++)
		{
			for(int j=0; j<ptr[0].length; j++)
			{
				System.out.printf("ptr[%d][%d] : ", i, j);
				ptr[i][j] = scan.nextInt();
			}
		}
		
		for(int i=0; i<2; i++)
		{
			for(int j=0; j<4; j++)
			{
				System.out.printf("ptr[%d][%d] = %d\n", i, j, ptr[i][j]);
			}
		}
		
		
		scan.close();
	}

	// 같은 파일에서는 static은 static만 호출할수 있다
	
	private static int add(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}

	public static void printArray(int[] array)
	{
		System.out.println("print array..");
		for(int i=0; i<array.length; i++)
		{
			// array[0] = 11
			System.out.println("array["+ i +"] = " + array[i]);
			System.out.printf("array[%d] = %d\n", i, array[i]);
			
		}
	}
	
	
}
