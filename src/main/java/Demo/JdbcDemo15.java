package Demo;

import java.sql.*;

//Program to insert a records inside a table using prepared Statement
public class JdbcDemo15 {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        //create a query
        String query="insert into product_data values(?,?,?,?)";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            pstmt = con.prepareStatement(query);

            // Set a values for placeholders
            pstmt.setInt(1,0);
            pstmt.setString(2,"PROJECTOR");
            pstmt.setString(3,"ELECTRONICS");
            pstmt.setDouble(4,45000.50);
            int count1 = pstmt.executeUpdate();

            pstmt.setInt(1,7);
            pstmt.setString(2,"LAPTOP");
            pstmt.setString(3,"ELECTRONICS");
            pstmt.setDouble(4,50000.50);
            int count2 = pstmt.executeUpdate();
            System.out.println(count1+count2+"Records inserted Successfully...");
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
            if (pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
