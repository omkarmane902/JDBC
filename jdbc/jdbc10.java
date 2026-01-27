package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc10 {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/jsp";
        String user = "postgres";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("select * from trainer where id = 6");) 
        {
            while (rs.next()) {

                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getDouble("sal"));
                System.out.println(rs.getLong("phone"));
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

    }  

}   
          