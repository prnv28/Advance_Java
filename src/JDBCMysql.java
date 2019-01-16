import com.sun.nio.sctp.SctpSocketOption;

import java.sql.*;
public class JDBCMysql {
   public static void main(String [] args) throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");

       Statement st = con.createStatement();
//       st.executeUpdate("INSERT INTO `student` (`id`, `name`, `age`) VALUES (NULL, 'gaurav', '20')");
       String table[]={"TABLE"};
       ResultSet rs = st.executeQuery("select * from student");
       DatabaseMetaData dbmd=con.getMetaData();
       System.out.println("Driver Name : "+dbmd.getDriverName());
       System.out.println("Driver Virsion : "+dbmd.getDriverVersion());
       System.out.println("User Name : "+dbmd.getUserName());
       System.out.println("DataBase Product Name : "+dbmd.getDatabaseProductName());
       System.out.println("DataBase Product Version : "+dbmd.getDatabaseProductVersion());
       System.out.println("Tables : "+dbmd.getTables(null,null,null,table));


       while(rs.next()){
           System.out.println("ID : "+rs.getInt(1));
           System.out.println("Name : "+rs.getString(2));
           System.out.println("Age : "+rs.getString(3));
       }
   }
}
