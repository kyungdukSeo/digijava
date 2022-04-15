import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// 52 DataBase

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
			int affectedCount = stmt.executeUpdate(sql);
			
			System.out.println("affectedCount = " + affectedCount);
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
	idx		int(10)		auto_increament,
	id		char(20)	unique,
	name	char(20)
	age		int(3) default '0',
	address	char(30),
	primary key(idx)
);
*/
