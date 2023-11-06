package storedProcedure;

import java.sql.*;
import java.util.Scanner;

public class DisplayCategoryOfProduct {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Product Category:");
        String category= sc.next();

        Connection con;
        CallableStatement cstmt;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            cstmt= con.prepareCall("{call countproduct(?,?)}");
            cstmt.setString(1,category); // IN PARAMETER
            cstmt.registerOutParameter(2, Types.INTEGER);//OUT PARAMETER
            cstmt.execute();
            System.out.println("TOTAL NUMBER OF PRODUCTS: "+cstmt.getInt(2));
            System.out.println("Procedure Executed...");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
