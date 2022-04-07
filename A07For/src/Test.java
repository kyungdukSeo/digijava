
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * if()
		 * for(초기값; 조건; 증감)
		 */
		
		int i, j = 0;
		
		for(i=1 ; i<=10 ; i++ )
		{
			System.out.println(i);
			j = j + i;
		}
		System.out.println("최종 i : " + i);
		System.out.println("총합 : " + j);
		
		
		for(i=1 ; i<=100 ; i++ )
		{
			if(i%3==0)
			{
				System.out.println(i);
			}
			
		}
		
		System.out.println("abc\tdef\n");
		
		for(i=1; i<20; i++) {
			//System.out.print(i +"\t");
			System.out.printf("%05d\t", i);
		
		}
		
		// 달력 1~31일
		
		System.out.println();
		
		for(i=1; i<=31; i++) 
		{
			System.out.printf("%2d\t", i);
			if(i%7==0) 
			{
				System.out.println("");
			}
		}
		
	}

}
