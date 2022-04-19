import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// 54 Select

public class Main 
{
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub

		final String driver = "org.mariadb.jdbc.Driver";
		final String dbHost = "localhost";
		final String dbPort = "3306";
		final String dbUser = "mykb";
		final String dbName = "mykb";
		final String dbPass = "1111";
		final String dbUrl = "jdbc:mariadb://" + dbHost + ":" + dbPort + "/" + dbName + "?characterEncoding=UTF-8";		// utf8mb4
		// jdbc:mariadb://localhost:3306/mykb?characterEncoding=UTF-8
		
		
		System.out.println("Start DB : 한글");
		Connection conn = null;
		PreparedStatement ps = null;
		
		// $data = mysqli_fetch_array();
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			System.out.println("OK Driver");
			
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			if(conn != null) 
			{
				System.out.println("OK DB Connect");
			}else
			{
				System.out.println("Fail DB Connect");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Fail Driver Load");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception : " + e.getMessage());
		} 
		
		// 자원 해제
		
		Statement stmt;
		String sql;
		
		try {
			stmt = conn.createStatement();
			sql = "insert into online (id, name, age, address) values ('kbstar', '국민은행', '33', '서울')";

			sql = "select * from online";
			// int affectedCount = stmt.executeUpdate(sql);
			
			rs = stmt.executeQuery(sql);
			// ResultSet ==> fetch
			// $data = mysqli_fetch_array($result);
			// while($data){}
			
			
			int count = 0;
			while(rs.next())
			{
				// 출력, idx, id, name, age, address
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				
				System.out.print("idx = " + idx + "\t\t");
				System.out.print("id = " + id + "\t");
				System.out.print("name = " + name + "\t");
				System.out.print("age = " + age + "\t");
				System.out.println("address = " + address);
				
				String dbResult = "";
				dbResult = dbResult.format(name + "\t" + id + "\t" + age + "\t" + address);
				System.out.println(dbResult);
						
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			if(conn != null)
			{
				conn.close();
			}
			
		}
		
	}

}

/*
create table online (
	idx		int(10)		AUTO_INCREMENT,
	id		char(20)	unique,
	name	char(20),
	age		int(3) default '0',
	address	char(30),
	primary key(idx)
);
*/
