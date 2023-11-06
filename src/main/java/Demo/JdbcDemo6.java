package Demo;

import java.sql.*;

public class JdbcDemo6 {
    public static void main(String[] args) {
        Connection con;
        Statement stmt;
        ResultSet rs;

        // Selection Query
        String query =" select * from product_data";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            stmt=con.createStatement();
            rs =stmt.executeQuery(query);
            while (rs.next()){
                System.out.println("Product ID: "+rs.getInt("Product_Id"));
                System.out.println("Product Name: "+rs.getString("Product_Name"));
                System.out.println("Product Category:"+rs.getString("Product_Category"));
                System.out.println("Product Price:"+rs.getDouble("Product_Price"));
                System.out.println("==========================================================");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
