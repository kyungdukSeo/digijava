import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 44 Byte Stream


public class Main {
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub

		// Byte : InputStream, OutputStream
		
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			int c;
			out = new FileOutputStream("data.txt", false);
			
			for(int i=1; i<=100000; i++)
			{
				out.write(i);
			}
			
			out.flush();
			
			in = new FileInputStream("data.txt");
			while((c = in.read()) != -1)
			{
				System.out.println(c + " ");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally
		{
			if(in != null)
			{
				in.close();		// ÀÌ°Í¶§¹®¿¡ ¸ÞÀÎ¿¡ throws IOException ÇØÁÜ
			}
			if(out != null)
			{
				out.close();
			}
		}
		
		
		/*
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try {
			int c;
			out = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("data.txt")
							)
					);
			
			for(int i=1; i<10; i++)
			{
				out.writeInt(i);
				
			}
			out.writeUTF("English ÇÑ±Û ùÓí® ¡Ø¡Ú");
		} catch (Exception e) {
			
		}
		*/
		
		
		
		
	}

}
