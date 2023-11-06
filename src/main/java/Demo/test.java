package Demo;

import java.sql.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //Driver load and register
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Class loaded successfully...");
            //Established the Connection

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9", "root","sql123" );
            System.out.println("connection created successfully..");
            //create Statement

//            Statement stmt = con.createStatement();
//            System.out.println("statement created successfully..");
//            //execute query
//            int count=stmt.executeUpdate("insert into record values(1,'abd','abc123',21,123456,'pune')");
//            System.out.println(count+" record inserted successfully");

            //create preparedstatment
            PreparedStatement pstmt= con.prepareStatement("select contact_number,age,city from record where username=? && password=?");
            System.out.println("Enter username");
            String username =sc.next();

            pstmt.setString(1, username);
            System.out.println("Enter Password:");
            String password =sc.next();
            pstmt.setString(2, password);

            ResultSet rs= pstmt.executeQuery();
            System.out.println(rs);
                   boolean status= rs.next();
            if (status){
                System.out.println("age"+rs.getInt(2));//age
                System.out.println("contact number"+rs.getInt(1));//contact number
                System.out.println("city"+rs.getString(3));//city
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
