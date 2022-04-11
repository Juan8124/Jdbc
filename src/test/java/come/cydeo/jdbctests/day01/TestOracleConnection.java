package come.cydeo.jdbctests.day01;

import java.sql.*;

public class TestOracleConnection {
    public static void main(String[] args) throws SQLException {
        /*
        How can I get this in real ?
        This is called connection String
        You will ask this info uou team to use. Basically take it and use it
        They will give you portNumber, IP, Username, password
         */
        String dbUrl = "jdbc:oracle:thin:@54.158.153.204 :1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";

        //DriverManger class to get Connection method is used to make connection with Db
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        // create statement from connection to run quires
        Statement statement = conn.createStatement();

        // using with statement we will execute query
        // statement object we can run quires
        ResultSet rs = statement.executeQuery("select * from regions");

        // move to cursor first row
        rs.next();
        System.out.println(rs.getInt(1)+"-"+rs.getString("region_name"));
        // now we are at first row and will get data
/*
        System.out.println("rs.getString(\"region_name\") = " + rs.getString("region_name"));
        System.out.println("rs.getString(2) = " + rs.getString(2));

        //1 Europe
        // 2 americas

        // second row
        rs.next();
        rs.getString(1);
         System.out.println(rs.getString(2));
 */

        while (rs.next()) {
            System.out.println(rs.getInt(1)+"-"+ rs.getString("region_name"));
        }

        // close connection
        // needs to be in reverse order
        rs.close();
        statement.close();
        conn.close();


    }
}
