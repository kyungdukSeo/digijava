import java.io.IOException;

// Exception

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 4;
		int b = 0;
		int result;
		
		try {
			result = a/b;
		}
		catch (ArithmeticException e)
		{
			System.out.println("ArithmeticException : " + e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		
		}
		finally // �����ص�, �����ص� ����� �´�. -> �ڿ� �ݳ��ض�..
		{
			System.out.println("Finally");
		}
		
		System.out.println("End");
//		System.out.println("result = " + result);
		
		
		
		System.out.println("--------------");
		String msg;
		msg = readMessage();
		System.out.println("msg = " + msg);
		
		
		// readMessage2
		try {
			msg = readMessage2();
			System.out.println("msg = " + msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static String readMessage()
	{
		byte[] buffer = new byte[1024];		// buffer : �ӽø޸� ��� ��
		System.out.println("���ڿ� �Է��Ͻÿ�.");
		
		try {
			System.in.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		return new String(buffer);
	}
	
	
	public static String readMessage2() throws IOException
	{
		byte[] buffer = new byte[1024];		// buffer : �ӽø޸� ��� ��
		System.out.println("���ڿ� �Է��Ͻÿ�.");
		
		System.in.read(buffer);
		
		return new String(buffer);
	}
	
	
	
	

}
