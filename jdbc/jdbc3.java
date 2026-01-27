package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc3 {
	
	public static void main(String[] args) {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp", "postgres", "root");
			
			Statement stm = con.createStatement();
			
			ResultSet rst = stm.executeQuery("select * from student");
			
			while(rst.next())
			{
				System.out.println(rst.getInt(1));
				System.out.println(rst.getString(2));
				System.out.println(rst.getDouble(3));
				System.out.println(rst.getLong(4));
			}
			
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
