package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo4 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the Product id: ");
        int id =sc1.nextInt();
//        System.out.println("Enter the Product Name: ");
//        String name = sc1.next();
//        System.out.println("Enter the Product Category: ");
//        String category = sc1.next();
        System.out.println("Enter the Price of Product: ");
        double price = sc1.nextDouble();

        //Declare Resources

        Connection con=null;
        Statement stmt =null;

        // sql query
        String query =" update product_data set Product_Price="+price+" where Product_Id="+id+"";
        // connection

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            System.out.println(count+"Product Price updated  Successfully...");
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
    }
}

