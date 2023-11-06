package Demo;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo13 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the Username: ");
        String user= sc1.next();
        System.out.println("Enter Your Password: ");
        String password= sc1.next();
        Connection con =null;
        Statement stmt= null;
        ResultSet rs = null;
        String query =" select * from login_info where username='"+user+"' and password='"+password+"'";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
           if (rs.next()){
               System.out.println("Login Successfully...");
           }
           else {
               System.out.println("Login Failed");
           }
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }

    }
}
