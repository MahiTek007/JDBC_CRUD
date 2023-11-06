package daodto;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
    static Connection con;
    static {
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    static int addProduct(Product p1) {
        //insert query
        int count=0;
        String query="inset into product_data(Product_Name,Product_Category,Product_Price)values(?,?,?)";
        try {
            PreparedStatement pstmt= con.prepareStatement(query);
            pstmt.setString(1, p1.getProductName());
            pstmt.setString(2, p1.getProductCategory());
            pstmt.setDouble(3,p1.getPrice());
            count= pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return count;
    }

    static int deleteProduct(Product p1) {
        //delete query
        int count=0;
        String query="delete from product_data where Product_Id=?";
        try {
            PreparedStatement pstmt =con.prepareStatement(query);
            pstmt.setInt(1,p1.getProductId());
            count= pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }
    static ArrayList<Product> displayProduct(){
        //select query
        String query="select * from product_data";
        Statement stmt;
        ResultSet rs;
        ArrayList<Product> productList= new ArrayList<>();
        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
               int id= rs.getInt(1);
               String name= rs.getString(2);
               String category= rs.getString(3);
               double price= rs.getDouble(4);
                //add DTO class info
               Product p1=new Product();
               p1.setProductId(id);
               p1.setProductName(name);
               p1.setProductCategory(category);
               p1.setPrice(price);
               productList.add(p1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productList;
    }
}
