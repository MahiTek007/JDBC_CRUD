package storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertAndDeleteRecordsAtTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to delete a record:");
        int id = sc.nextInt();
        System.out.println("Enter user name: ");
        String userName=sc.next();
        System.out.println("Enter password:");
        String password= sc.next();
        Connection con;
        CallableStatement cstmt;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            cstmt= con.prepareCall("{call loginoperation(?,?,?)}");
            cstmt.setInt(1,id);
            cstmt.setString(2,userName);
            cstmt.setString(3,password) ;
            cstmt.execute();
            System.out.println("Procedure Executed...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
