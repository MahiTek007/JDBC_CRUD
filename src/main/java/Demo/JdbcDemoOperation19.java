package Demo;

import java.sql.*;

public class JdbcDemoOperation19 {
    static Connection con =null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    static boolean login(String username, String password) {
        Statement stmt=null;
        ResultSet rs= null;
        boolean sucess=false;
        String query="select username,password from login_info where username='"+username+"' and password='"+password+"'";

        try {
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
             sucess=rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sucess;
    }

    static boolean signUp(String username, String password) {
        boolean success=false;
        PreparedStatement pstmt=null;
        String query="insert into login_info(username,password) values(?,?)";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.executeUpdate();
            success=true;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return success;
    }

    static void addProduct(String productName, String category, double price) {
        PreparedStatement pstmt=null;

        String query ="insert into product_data(Product_Name,Product_Category,Product_Price) values(?,?,?)";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(1,productName);
            pstmt.setString(2,category);
            pstmt.setDouble(3,price);
            pstmt.executeUpdate();
            System.out.println("Product Added Successfully...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    static void displayProduct(String name) {
        PreparedStatement pstmt=null;
        ResultSet rs =null;
        try {
            pstmt= con.prepareStatement("select * from product_data where Product_Name=?");
            pstmt.setString(1,name);

            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
