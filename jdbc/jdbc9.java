package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbc9 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp", "postgres", "root");
			
			CallableStatement cs = con.prepareCall("call insert_student(?,?,?,?)");
			
			System.out.print("Enter the Id : ");
			 
			int id  = sc.nextInt();
			cs.setInt(1, id);
			
			sc.nextLine();
			System.out.print("Enter name : ");
			String name = sc.nextLine();
			cs.setString(2, name);
			
			System.out.print("Enter salary : ");
			double sal = sc.nextDouble();
			cs.setDouble(3, sal);
			
			System.out.print("Enter Phone No. : ");
			long phone = sc.nextLong();
			cs.setLong(4, phone);
			
			cs.execute();
			System.out.println("Data inserted");
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
