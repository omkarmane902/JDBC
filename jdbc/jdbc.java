package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

	public static void main(String[] args)  {
		
		
		try {
			
			//first step
			Class.forName("org.postgresql.Driver");
			
			
			// second step
			
		//	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp", "postgres", "root");
			
			
			Connection con  = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp?user=postgres&password=root");
			
			
			
			// third step
			
			Statement stm = con.createStatement();
			
			
			// fourth step
			
			boolean b  = stm.execute("delect ");
			
			System.out.println(b);
			
			
			// 5 th step
			
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
