package Demo;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo11 {
    public static void main(String[] args) {
        Scanner sc1= new Scanner(System.in);
        System.out.println("Select option \n 1.Product With Maximum price \n 2.Product with Minimum price ");
        int choice= sc1.nextInt();

        Connection con =null;
        Statement stmt = null;
        ResultSet rs =null;
        String query =null;

        if (choice==1){
            query="select * from product_data where Product_Price in(select max(Product_Price) from product_data)";
        } else if (choice==2) {
            query="select * from product_data where Product_Price in(select min(Product_Price) from product_data)";
        }
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            stmt= con.createStatement();
            rs= stmt.executeQuery(query);
            if (rs.next()){
                System.out.println(rs.getInt(1)+"\t");
                System.out.println(" "+rs.getString(2)+"\t");
                System.out.println(" "+rs.getString(3)+"\t");
                System.out.println(" "+rs.getDouble(4)+"\t");
                System.out.println("======================================================");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if(con!=null){
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
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

        }
    }
}
