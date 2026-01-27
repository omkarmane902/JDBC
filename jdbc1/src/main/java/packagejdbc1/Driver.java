package packagejdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc2", "postgres", "root");
				Statement stm = con.createStatement();
				boolean b = stm.execute("update student set age = '21' where id = '1'");
				System.out.println(b);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
