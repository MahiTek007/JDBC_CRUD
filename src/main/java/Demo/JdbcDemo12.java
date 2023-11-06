package Demo;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo12 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the Username: ");
        String user= sc1.next();
        System.out.println("Enter Your Password: ");
        String password= sc1.next();
        Connection con =null;
        Statement stmt= null;
        ResultSet rs = null;
        String query =" select username,password from login_info";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            stmt=con.createStatement();
            rs= stmt.executeQuery(query);
            boolean status=false;
            while (rs.next()){
                String dbuser= rs.getString(1);
                String dbpassword= rs.getString(2);
                if (dbuser.equals(user)&& dbpassword.equals(password)){
                    System.out.println("Login Successfully...");
                    status=true;
                }
            }
            if (!status){
                System.out.println("Login Failed...");
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
