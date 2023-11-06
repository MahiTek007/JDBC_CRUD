import java.sql.*;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
            PreparedStatement pstmt=con.prepareStatement("select * from car_info where category=?");
            System.out.println("Enter Category:");
            pstmt.setString(1,sc.next());
            ResultSet rs = pstmt.executeQuery();
            System.out.println("id\t\t model\t\t company \t\t category \t\t price \t\t");
            while (rs.next()){
                System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getDouble(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
