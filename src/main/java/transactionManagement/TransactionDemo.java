package transactionManagement;

import java.sql.*;
import java.util.*;

public class TransactionDemo {
    public static void main(String[] args) {
        Scanner sc1= new Scanner(System.in);
        System.out.println("Enter the product id to delete: ");
        int id= sc1.nextInt();

        Connection con=null;
        PreparedStatement pstmt=null;

        String query= "delete from product_data where Product_Id=?";

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
            con.setAutoCommit(false);
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();

            System.out.println(" Are you sure:\n1.YES\n2.NO");
            int choice= sc1.nextInt();
            if (choice==1){
                con.commit();
                System.out.println("Product deleted successfully...");
            }
            else if(choice==2){
                con.rollback();
                System.out.println("Delete Process cancelled successfully...");
            }
            else {
                System.out.println("Invalid Choice...");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
