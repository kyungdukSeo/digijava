import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

// List, Hash 


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("A");	// A
		list.add("B");	// A-B
		list.add("C");	// A-B-C
		list.add(1, "D");	// A-D-B-C
		list.set(2, "K");	// A-D-K-C
		list.remove(2);	// A-D-C
		// list.remove("K");	// A-D-C

		System.out.println("KKK index = " + list.indexOf("KKK"));
		System.out.println("D index = " + list.indexOf("D"));
		System.out.println("size = " + list.size());
		System.out.println(list);
		
		for(int i=0; i<list.size(); i++)
		{
			// list[2] = K
			System.out.printf("list[%d] = %s\n", i , list.get(i));
		}
		
		
		System.out.println("--------Enhanced For--------");
		// for(int value : lotto)
		
		for(String value : list)
		{
			System.out.println(value);
		}
		
		System.out.println("-------Iterator(�ݺ���)-------");
		
		Iterator e = list.iterator();
		while(e.hasNext())
		{
			String value = (String)e.next();
			System.out.println(value);
		}
		
		
		
		// ----------- SET : �ߺ��� ������� �ʴ� �ڷᱸ��
		// Hash : ���Լ��� �������� �ʴ� �Լ�
		System.out.println("----------SET----------");
		
		// HashSet<String> set = new HashSet<String>();
		TreeSet<String> set = new TreeSet<String>();
		// {A, A, A} = {A}

		set.add("A");
		set.add("B");
		set.add("C");
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("A");
		set.add("A");
		
		System.out.println("set = " + set);
		
		
		System.out.println("---------Queue---------");
		Queue<String> q = new LinkedList<String>();
		q.add("AAA");
		q.add("BBB");	// AAA - BBB
		q.add("CCC");	// AAA - BBB - CCC
		q.add("DDD");	// AAA - BBB - CCC - DDD
		
		q.remove();		// BBB - CCC - DDD
		System.out.println("q = " + q);
		
		for(String value : q)
		{
			System.out.println(value);
		}
		
		
		System.out.println("---------Stack--------");
		Stack<Integer> intStack = new Stack<Integer>();
		Stack<String> strStack = new Stack<String>();
		
		intStack.push(11);
		intStack.push(22);
		intStack.push(33);
		intStack.add(44);	// push , add �Ѵ� ��밡��
		
		intStack.pop();
		System.out.println("intStack = " + intStack);
		
		strStack.push("AA");
		strStack.push("BB");
		strStack.add("CC");
		System.out.println("strStack = " + strStack);
		
		System.out.println("---------ArrayList--------");
		List<String> sList = new ArrayList<String>();
		
		sList.add("Java");
		sList.add("Python");
		sList.add("HTML");
		sList.add("JS");
		
		System.out.println("sList = " + sList);
		Collections.shuffle(sList);
		System.out.println("sList = " + sList);
		Collections.sort(sList);
		System.out.println("sList = " + sList);
		
		String[] name = {"�̼���", "ȫ�浿", "������", "������", "�۽ÿ�" };
		List<String> nameList = Arrays.asList(name);
		Collections.sort(nameList);
		
		System.out.println("nameList = " + nameList);
		
		
	}

}
