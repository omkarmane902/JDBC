package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc7 {
	
    static String url = "jdbc:postgresql://localhost:5432/jsp";
    static	String user = "postgres";
    static	String password = "root";
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection(url,user,password);
			
			
			Statement st = con.createStatement();
			
			st.addBatch("insert into trainer values (4, 'PrasadSir', 'webtech'), (5, 'nirbhaySir', 'API_Testing'), (6, 'omkar', 'timepass')");
			st.addBatch("update trainer set subject = 'Java' where id = 1");
			st.addBatch("delete from trainer where id = 6");
			
			st.executeBatch();
			
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}		
	}

}
