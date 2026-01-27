package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbc5 {
	
public static void main(String[] args) {
	
	
	Scanner sc = new Scanner(System.in);
	
	
		
		
	
	try {
		Class.forName("org.postgresql.Driver");
		
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp", "postgres", "root");
		
		
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
		
		
		
		
		 System.out.print("Enter student id: ");
         int id = sc.nextInt();
         sc.nextLine(); 

         System.out.print("Enter student name: ");
         String name = sc.nextLine();

         System.out.print("Enter salary: ");
         double salary = sc.nextDouble();

         System.out.print("Enter phone number: ");
         long phone = sc.nextLong();
		
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setDouble(3,salary);
	    ps.setLong(4, phone);
	    
	    
	    ps.execute();
	    
	    System.out.println();
	    
	    
	    
	    con.close();
		
		
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	sc.close();
	}

}
