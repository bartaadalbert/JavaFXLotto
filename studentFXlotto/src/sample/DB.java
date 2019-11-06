package sample;

import java.sql.*;

public class DB {

    final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    final String URL="jdbc:mysql://localhost/test?serverTimezone=UTC";
    final String USERNAME="mroot";
    final String PASSWORD="1234";
    Connection conn=null;
    Statement st=null;
    DatabaseMetaData dbmd=null;

    public DB(){
        try {
             conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connection is ready!!!!");
        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("We have problem with connection!!!");;
        }

        try {
             st= conn.createStatement();
            System.out.println("The statement is work");
        } catch (SQLException e) {
            System.err.println(e);
        }

        try {
             dbmd= conn.getMetaData();
        } catch (SQLException e) {
            System.err.println(e);
        }

        try {
            String sql="CREATE TABLE customers(FirstName  varchar(30) not null, LastNAme  varchar(30) not null, email varchar(30) not null)";
            ResultSet rs= dbmd.getColumns(null, "APP", "customers", null);
            System.out.println("The table was created!!!");
            if (!rs.next()){
                st.execute(sql);
                st.close();
                System.out.println("if loop!!!!");
            }
        } catch (SQLException e) {

            System.err.println(e);
        }

    }


}
