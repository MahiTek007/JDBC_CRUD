package Demo.mobileshop;

import java.sql.*;

public class MobileOperation {
    static Connection con=null;
    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void getCompanyNames(){
        Statement stmt=null;
        ResultSet rs =null;
        String query = "select distinct(company) from mobile_info";

        try {
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getDisplayModels(String company) {
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="select model from mobile_info where company=?";
        try {
            pstmt= con.prepareStatement(query);
            pstmt.setString(1,company);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void getPurches(String model, int units) {
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="select price,stock from mobile_info where model=?";
        String query1= "update mobile_info set stock=? where model=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,model);
            rs=pstmt.executeQuery();
            if (rs.next()){
                double price= rs.getDouble(1);
                int stock = rs.getInt(2);
                if (units<=stock){
                    double total =price*units;
                    System.out.println("Total Amount is: "+total);
                    pstmt= con.prepareStatement(query1);
                    pstmt.setInt(1,stock-units);
                    pstmt.setString(2,model);
                    pstmt.executeUpdate();
                    System.out.println("Stock Updated Successfully...");
                }else {
                    System.out.println("Out of stock...");
                }

            }
            else {
                System.out.println("Invalid Model");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
