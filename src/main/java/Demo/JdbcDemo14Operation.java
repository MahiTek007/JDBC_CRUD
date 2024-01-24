package Demo;

import java.sql.*;

public class JdbcDemo14Operation {
    static Connection con=null;
    static {
        try {

            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String login() {

        return null;
    }
    public void addProduct(int id,String name, String category, double price) {
        Statement stmt=null;
        String query ="inset into product_data values("+id+",'"+name+"','"+category+"',"+price+")";
        try {
            stmt= con.createStatement();
            int n =stmt.executeUpdate(query);
            System.out.println(n+" Product Added Successfully...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProduct(int id) {
        Statement stmt=null;
        String query=" delete from product_data where Product_Id="+id;
        try {
            stmt= con.createStatement();
            int n = stmt.executeUpdate(query);
            System.out.println("Product Removed Successfully...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void displayProduct() {
        Statement stmt=null;
        ResultSet rs=null;
        String query=" select * from product_data";
        try {

            stmt= con.createStatement();
            rs =stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getInt(1)+": \t");
                System.out.println(" "+rs.getString(2)+"\t");
                System.out.println(" "+rs.getString(3)+"\t");
                System.out.println(" "+rs.getDouble(4)+"\t");
                System.out.println("=============================================================");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
