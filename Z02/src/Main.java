
public class Main {

	public static void main(String[] args)
	{
		// �迭 10�� ������
		// 3,6,9,12... 3�� ����� �ִ´�
		// �迭�� ������ ���Ͻÿ�
		
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
		 values('test','�׽�Ʈ','11', now());
		 
		 insert into user_table(id, name, age, time)
		 values('kim','������','33', now());
		 
		 insert into user_table(id, name, age, time)
		 values('kim2','����','31', now());
		 
		 insert into user_table(id, name, age, time)
		 values('hong2','ȫ�浿2', now());
		 
		 insert into user_table(id, name, age, time)
		 values('lim','�Ӳ���','9', now());
		 
		 
		 
		 */
		                            
		
	}
}
