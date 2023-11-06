package daodto;

import java.sql.*;
import java.util.ArrayList;

//
public class BookDAO {
    static Connection con;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9","root","sql123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    static int addBook(Book b){
        //insert query
        String query ="insert into book_info(Book_name,Book_price)values(?,?)";
         int count=0;
        PreparedStatement pstmt;
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1, b.getBookName());
            pstmt.setDouble(2,b.getBookPrice());
           count= pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }
    static  int deleteBook(Book b){
        //delete query
        String query ="delete from book_info where Book_id=?";
        int count=0;
        try {
            PreparedStatement pstmt= con.prepareStatement(query);
            pstmt.setInt(1,b.getBookId());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }
    static ArrayList<Book> displayBooks(){
        //select query
        Statement stmt;
        ResultSet rs;
        ArrayList<Book> bookList= new ArrayList<>();
        //create a sql query
        String query ="select * from book_info";
        try {
            stmt= con.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                double price=rs.getDouble(3);

                Book b1=new Book();
                b1.setBookId(id);
                b1.setBookName(name);
                b1.setBookPrice(price);
                //add DTO class object into list
                bookList.add(b1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return bookList;
    }
}
