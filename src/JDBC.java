import java.sql.*;

public class JDBC {
    public static void main(String [] args) throws ClassNotFoundException, SQLException {
        Class.forName("sun.jdbc:odbc:JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:mydb1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student");
        while(rs.next()){
            System.out.println("ID : "+rs.getInt(1));
            System.out.println("Name : "+rs.getString(2));
            System.out.println("Age : "+rs.getString(3));
        }
    }
}
