package Demo;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo3 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the Product id: ");
        int id =sc1.nextInt();


        //Declare Resources

        Connection con=null;
        Statement stmt =null;

        // sql query
        String query =" delete from product_data where Product_Id="+id+"";
        // connection

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+"Product Deleted Successfully...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Connection closed successfully...");
            }
            if (stmt !=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Statement closed successfully...");
            }

        }
}}
