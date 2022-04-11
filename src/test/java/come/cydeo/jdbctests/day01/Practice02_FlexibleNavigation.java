package come.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Practice02_FlexibleNavigation {
    String dbUrl = "jdbc:oracle:thin:@54.158.153.204 :1521:XE"; ///write your ip
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task2() throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("select first_name,last_name from employees ");

        rs.next();
        System.out.println(rs.getString(1) + "-" + rs.getString(2));


        rs.next();
        System.out.println(rs.getString(1) + "-" + rs.getString(2));

        rs.last();


        /*
      ResultSet.TYPE_SCROLL_INSENSITIVE  --> to be able to scroll your cursor or to jump directly in a certain row
        ResultSet.CONCUR_READ_ONLY         --> we are saying I don't want change anything in database
                                                makes the object immutable
         */

        // How to find how many row we have
        System.out.println(rs.getRow());

        // jump to row 8
        rs.absolute(8);
        System.out.println(rs.getRow());
        System.out.println(rs.getString(1) + "-" + rs.getString(2));


        //rs.absolute(7);
        rs.previous();
        System.out.println(rs.getRow());
        System.out.println(rs.getString(1) + "-" + rs.getString(2));
        rs.last();
        System.out.println(rs.getRow());
        //go back to first
        rs.beforeFirst();

        while (rs.next()){
            System.out.println(rs.getString(1)+ "--"+ rs.getString(2));
        }

        rs.first();
        System.out.println(rs.getRow());


        rs.close();
        statement.close();
        conn.close();

    }


}
