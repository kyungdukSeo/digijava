
public class Main {

	public static void main(String[] args)
	{
		// 배열 10개 정수형
		// 3,6,9,12... 3의 배수를 넣는다
		// 배열의 총합을 구하시오
		
		int[] array = new int[10];
		int sum=0;
		
		for(int i=0; i<array.length; i++)
		{
			array[i] = (i+1)*3;
			//System.out.println(array[i]);
				
		}
	
		for(int j=0;j<array.length;j++) 
		{
			sum = sum + array[j];
			System.out.println("sum : " + sum);	
		}

		
		/*
		 create table user_table(
		 	idx 	int(10) 	auto_increment,
		 	id		char(20)	unique,
		 	name	char(20),
		 	age		int(3)		default'10',
			time 	datetime,
			-- 2022-02-18 12:34:56
			
		 	primary key(idx)
		 );
		 
		 insert into user_table(id, name, age, time)
		 values('test','테스트','11', now());
		 
		 insert into user_table(id, name, age, time)
		 values('kim','김유신','33', now());
		 
		 insert into user_table(id, name, age, time)
		 values('kim2','김모모','31', now());
		 
		 insert into user_table(id, name, age, time)
		 values('hong2','홍길동2', now());
		 
		 insert into user_table(id, name, age, time)
		 values('lim','임꺽정','9', now());
		 
		 
		 
		 */
		                            
		
	}
}
