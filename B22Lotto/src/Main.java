import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Lotto Array
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		List<Integer> lotto = new ArrayList<Integer>();
		
		for(int i=1; i<=45; i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);

		for(int i=1; i<=6; i++)
		{
			lotto.add(list.get(i));
		}
		Collections.sort(lotto);
		System.out.println(lotto);
		
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Insert Age : ");
		int age = scan.nextInt();
		
		System.out.println("Age = " + age);
		scan.close();
		
		
		
	}

}
