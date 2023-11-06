package storedProcedure;

import java.sql.*;
import java.util.Scanner;

public class DisplayProduct {
    public static void main(String[] args) {

        Connection con;
        CallableStatement cstmt;
        ResultSet rs;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            cstmt= con.prepareCall("{call displayproduct()}");
            boolean status= cstmt.execute();
            rs= cstmt.getResultSet();

            while (rs.next()){
                System.out.println("Product_Id: "+rs.getInt(1)+" | Product_Name: "+rs.getString(2)+" | Product_Category: "+rs.getString(3)+" | Product_Price: "+rs.getDouble(4));
                System.out.println();
            }
            System.out.println("Procedure Executed...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
