
import java.sql.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter car model:");
        String modelName = sc.next();
        System.out.println("Enter Company Name:");
        String company = sc.next();
        System.out.println("Enter category:");
        String category = sc.next();
        System.out.println("Enter Price:");
        String price = sc.next();


        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9", "root", "sql123");
            PreparedStatement pstmt = con.prepareStatement("insert into car_info(model,company,category,price)values(?,?,?,?)");
            pstmt.setString(1, modelName);
            pstmt.setString(2, company);
            pstmt.setString(3, category);
            pstmt.setString(4, price);
            int count = pstmt.executeUpdate();
            System.out.println(count + "Car Details Inserted Successfully...");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
