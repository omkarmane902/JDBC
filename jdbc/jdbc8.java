package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc8 {

	
	public static void main(String[] args) {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp", "postgres", "root");
			
			CallableStatement cs = con.prepareCall("call insert_student(17,'abhay',1234,9876543214)");
			
			cs.execute();
			
			System.out.println("insert");
			
			
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
