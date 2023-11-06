package Demo;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Stream to find:");
        String stream= sc.next();
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;

        String query ="select count(stream) from student_info where strem=?";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,stream);
            rs=pstmt.executeQuery();
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
