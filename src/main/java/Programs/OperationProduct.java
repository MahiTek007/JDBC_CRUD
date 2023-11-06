package Programs;

import java.sql.*;
import java.util.Scanner;

public class OperationProduct {
    static Connection con;
    static Scanner sc = new Scanner(System.in);
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayAllProduct() {
        try {
            PreparedStatement pstmt = con.prepareStatement("select * from product");
            ResultSet rs =pstmt.executeQuery();
            System.out.println("Product Id\t\tProduct Name\t\tProduct Quantity\t\tProduct Price");
            while(rs.next()){
                System.out.println(" \t\t"+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getDouble(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addToCart(int id) {
        try {

            PreparedStatement pstmt = con.prepareStatement("select P_Name,P_Qty,P_Price from product where P_id=?");
            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();
                if (rs.next()){
                    String pName=rs.getString(1);
                    int qty=rs.getInt(2);
                    double price=rs.getDouble(3);

                    System.out.println("Enter The Number of Products");
                    int numberOfProducts= sc.nextInt();
                    if (numberOfProducts<=qty){

                        pstmt=con.prepareStatement("insert into cart (P_Name,P_Qty,P_Price) values(?,?,?,?)");
                        pstmt.setInt(1,id);
                        pstmt.executeUpdate();
                    }
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayCart() {

    }

    public void displayBill() {

    }
}
