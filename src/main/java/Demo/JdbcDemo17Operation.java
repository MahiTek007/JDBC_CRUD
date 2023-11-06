package Demo;

import java.sql.*;

public class JdbcDemo17Operation {
    static Connection con;
    static PreparedStatement pstmt;



    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm9?user=root&password=sql123");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void addStudent( String name, String stream, String percent) {

        String query ="insert into student_info values(?,?,?,?)";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2,name);
            pstmt.setString(3,stream);
            pstmt.setString(4,percent);
            int count1= pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }
    public void byId(int id) { //Search by Id...
        ResultSet rs=null;
        String query ="select * from student_info where id=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println("ID        :"+rs.getInt(1)+"\t");
                System.out.println("NAME      :"+rs.getString(2)+"\t");
                System.out.println("STREAM    :"+rs.getString(3)+"\t");
                System.out.println("PERCENTAGE:"+rs.getString(4)+"\t");
                System.out.println("===========================================================");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void byStream( String stream) { //Search by Stream
        ResultSet rs=null;
        String query ="select * from student_info where strem=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,stream);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println("ID        :"+rs.getInt(1)+"\t");
                System.out.println("NAME      :"+rs.getString(2)+"\t");
                System.out.println("STREAM    :"+rs.getString(3)+"\t");
                System.out.println("PERCENTAGE:"+rs.getString(4)+"\t");
                System.out.println("=============================================================");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void byName( String name) { // search by Name
        ResultSet rs=null;
        String query ="select * from student_info where name=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,name);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println("ID        :"+rs.getInt(1)+"\t");
                System.out.println("NAME      :"+rs.getString(2)+"\t");
                System.out.println("STREAM    :"+rs.getString(3)+"\t");
                System.out.println("PERCENTAGE:"+rs.getString(4)+"\t");
                System.out.println("==============================================================");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
