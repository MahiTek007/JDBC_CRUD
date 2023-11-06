package storedFunction;

import java.sql.*;
import java.util.Scanner;

public class functionDemo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First Numbers");
        double no1=sc.nextDouble();

        Connection con;
        CallableStatement cstmt;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            cstmt=con.prepareCall("{?=call areaCircle(?)}");
            cstmt.setDouble(2,no1);
            cstmt.registerOutParameter(1, Types.DOUBLE);
            cstmt.execute();
            System.out.println("area is "+cstmt.getDouble(1));
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
