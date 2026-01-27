package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class jdbc6 {
	
	
  private  static Connection con ;
  private  static String url = "jdbc:postgresql://localhost:5432/jsp";
  private  static String user = "postgres";
  private  static String password = "root";
    
  private static Scanner sc = new Scanner(System.in);
	
	static {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			
			 con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void insert()
	{
		try {
			PreparedStatement pst = con.prepareStatement("insert into trainer values(?,?,?)");
			System.out.print("Enter the id : ");
			int id = sc.nextInt();
			pst.setInt(1,id);
			
			System.out.print("Enter the trainer Name : ");
			String name = sc.next();
			pst.setString(2, name);
			
			System.out.print("Enter the Subject : ");
			String Subject = sc.next();
			pst.setString(3, Subject);
			
			
	
			
		 	 pst.execute();
		 	
		 	System.out.println("Record successfully Insert!");
		 
			System.out.println("you are inserting value Thanku!");
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void update()
	{
		try {
			PreparedStatement pst = con.prepareStatement("update trainer set subject = ? where  id = ?");
			
			System.out.print("Enter the subject : ");
			String subject = sc.next();
			pst.setString(1,subject);
			
			
			System.out.print("Enter the Id : ");
			int id  = sc.nextInt();
			pst.setInt(2, id);
			
			pst.execute();
			
			System.out.print("Update Record successfully!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static  void delect() {
		
		
		try {
			PreparedStatement pst =con.prepareStatement("delete from trainer where id = ?");
			
		
			System.out.println("Enter the Id : ");
			int id = sc.nextInt();
			pst.setInt(1, id);
			
			pst.execute();
			
			System.out.println("Delete Record successfully! ");
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
	}
	
	public static void fetch()
	{
		try {
			PreparedStatement pst = con.prepareStatement("select * from trainer");
			
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				
				System.out.println("____________________________");
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void fetchbyid()
	{
		try {
			PreparedStatement pst = con.prepareStatement("Select * from trainer where id = ?");
			System.out.println("Enter the Id : ");
			int id = sc.nextInt();
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				
				System.out.println("____________________");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void Close() {
		
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		boolean b = true;
		while(b)
		{
			System.out.println("If you want to insert then click on  =: 1");
			System.out.println("If you want to update then click on  =: 2");
			System.out.println("If you want to delect then click on  =: 3");
			System.out.println("If you want to fetch then click on  =: 4");
			System.out.println("If you want to fetchbyid then click on  =: 5");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter your number : ");
			
			switch (sc.nextInt()) {
			case 1:
				insert();
				break;

			case 2:
				update();
				break;
				
			case 3:
				delect();
				break;
				
			case 4:
				fetch();
				break;
				
			case 5:
				fetchbyid();
				break;
			default:
				
				System.out.println(" in this number not available any method! ");
				break;
			}
			System.out.println("Do you want execute  another  query (yes/no)");
			
			String ans = sc.next();
			
			if (ans.equalsIgnoreCase("no")) {
				
				b=false;
			}
			
		}
		
		System.out.println("exit");
		sc.close();
		
	}

}
