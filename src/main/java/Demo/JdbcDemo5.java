package Demo;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo5 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String query=null;
        System.out.println("Enter the Product id: ");
        int id =sc1.nextInt();
        System.out.println(" Enter your Choice:\n 1.Update Product Name \n 2.Update Product Category \n 3.Update Product Price");
        int choice=sc1.nextInt();
        if (choice==1){
            System.out.println("Enter the Name to update: ");
            String name = sc1.next();
            query=" update product_data set Product_Name='"+name+"' where Product_Id="+id+"";
        } else if (choice==2) {
            System.out.println("Enter the New Category : ");
            String category=sc1.next();
            query=" update product_data set Product_Category='"+category+"' where Product_Id="+id+"";
        } else if (choice==3) {
            System.out.println("Enter the New Price to Update:");
            double price = sc1.nextDouble();
            query=" update product_data set Product_Price="+price+" where Product_Id="+id+"";
        }
        //Declare Resources

        Connection con=null;
        Statement stmt =null;

        // sql query

        // connection

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            if (choice==1){
                System.out.println(count+" Product Name Change Successfully...");
            } else if (choice==2) {
                System.out.println(count+" Product  Category Change Successfully...");
            } else if (choice==3) {
                System.out.println(count+" Product Price Change Successfully...");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Connection closed successfully...");
            }
            if (stmt != null) {
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
