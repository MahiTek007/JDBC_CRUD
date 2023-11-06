package Demo;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo8 {
    public static void main(String[] args) {
        Scanner sc1= new Scanner(System.in);

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        System.out.println("Enter the lower Price of an Product:");
            double lowerPrice= sc1.nextDouble();
        System.out.println("Enter the Higher Price:");
            double highPrice= sc1.nextDouble();

        String query="select * from product_data where Product_Price between "+lowerPrice+" and "+highPrice+"";


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9", "root","sql123");
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("Product ID: "+rs.getInt("Product_Id"));
                System.out.println("Product Name: "+rs.getString("Product_Name"));
                System.out.println("Product Category:"+rs.getString("Product_Category"));
                System.out.println("Product Price:"+rs.getDouble("Product_Price"));
                System.out.println("==========================================================");
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
