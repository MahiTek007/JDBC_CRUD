package storedProcedure;

import java.sql.*;
import java.util.Scanner;

public class InsertRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Model Name: ");
        String model= sc.next();
        System.out.println("Enter company Name: ");
        String company = sc.next();
        System.out.println("Enter Product Price:");
        double price = sc.nextDouble();
        System.out.println("Enter Stock: ");
        int stock= sc.nextInt();
        Connection con;
        CallableStatement cstmt;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            cstmt= con.prepareCall("{call addmobileinfo(?,?,?,?)}");
           cstmt.setString(1,model);
           cstmt.setString(2,company);
           cstmt.setDouble(3,price);
           cstmt.setInt(4,stock);
           cstmt.execute();
            System.out.println("Procedure Executed...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
