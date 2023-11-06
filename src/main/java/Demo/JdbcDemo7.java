package Demo;

import java.sql.*;
import java.util.Scanner;


public class JdbcDemo7 {
    public static void main(String[] args) {
        Scanner sc1= new Scanner(System.in);

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        System.out.println("Enter your Product id: ");
        int id=sc1.nextInt();
        String query="select * from product_data where Product_Id="+id;


        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9", "root","sql123");
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            if (rs.next()){
                System.out.println("Product ID: "+rs.getInt("Product_Id"));
                System.out.println("Product Name: "+rs.getString("Product_Name"));
                System.out.println("Product Category:"+rs.getString("Product_Category"));
                System.out.println("Product Price:"+rs.getDouble("Product_Price"));
                System.out.println("==========================================================");
            }
            else {
                System.out.println("Product is not found.....");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }

    }
}
