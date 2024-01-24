package Demo;

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt =null;
        String query = " insert into product_data values(4,'WATCH','GADGETS',5000.25)";
            // Step1:- Load And register the Driver

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Class loaded Successfully...");

            //Step2:- Established Connection

           con =  DriverManager.getConnection("3.631ejm9" ,"root","sql123" );
            System.out.println(" connection successfully");
            //step3: create a statement platform

            stmt=con.createStatement();

            //step4:- execute query
            stmt.executeUpdate(query);
            System.out.println("Record inserted successfully");
        }catch( ClassNotFoundException e){
            System.out.println(e);
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
                System.out.println("Connection closed successfully...");
            }
            if (stmt !=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
                System.out.println("Statement closed successfully...");
            }

        }
    }
}
