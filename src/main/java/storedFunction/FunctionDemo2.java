package storedFunction;

import java.sql.*;
import java.util.Scanner;

public class FunctionDemo2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Number");
        int no1= sc.nextInt();
        System.out.println("Enter Second Number");
        int no2= sc.nextInt();

        Connection con;
        CallableStatement cstmt;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            cstmt=con.prepareCall("{?=call addnumbers(?,?)}");
            cstmt.setInt(2,no1);
            cstmt.setInt(3,no2);
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.execute();
            System.out.println("ADDITION IS "+cstmt.getInt(1));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
