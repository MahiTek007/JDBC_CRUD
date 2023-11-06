package Demo;

import java.sql.*;

public class JdbcDemo16 {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        //create a query
        String query="delete from product_data where Product_Id=?";


        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,0);
            int count1 = pstmt.executeUpdate();
            pstmt.setInt(1,5);
            int count2 = pstmt.executeUpdate();

            System.out.println(count1+ count2+"Record Removed Successfully...");
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
