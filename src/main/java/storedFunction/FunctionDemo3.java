package storedFunction;

import java.sql.*;
import java.util.Scanner;

public class FunctionDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER Number: ");
        int num1= sc.nextInt();

        Connection con;
        CallableStatement cstmt;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            cstmt= con.prepareCall("{?= call squarenumbers(?)}");
            cstmt.setInt(2,num1);
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.execute();
            System.out.println("RESULT : "+cstmt.getString(1));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
