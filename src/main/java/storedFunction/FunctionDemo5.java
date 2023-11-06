package storedFunction;

import java.sql.*;
import java.util.Scanner;

public class FunctionDemo5 {
    public static void main(String[] args)  {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter quantity of an product: ");
        int qty= sc1.nextInt();
        System.out.println("Enter price of an product: ");
        double price= sc1.nextDouble();

        Connection con;
        CallableStatement cstmt;
        try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            cstmt = con.prepareCall("{?= call productbill(?,?)}");
            cstmt.setInt(2, qty);
            cstmt.setDouble(3, price);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("TOTAL AMOUNT: " + cstmt.getDouble(1));
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
