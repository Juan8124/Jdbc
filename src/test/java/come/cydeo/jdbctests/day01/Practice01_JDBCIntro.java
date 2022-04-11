package come.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Practice01_JDBCIntro {

    String dbUrl = "jdbc:oracle:thin:@54.158.153.204 :1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws Exception {

        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from departments where manager_id is not null ");

/*
10 -Administration -200 - 1700
 */

        while (rs.next()) {
            System.out.println(rs.getInt(1) + "-" + rs.getString("department_name") + "-" + rs.getInt(3) + "-" + rs.getInt(4));
        }
        rs = statement.executeQuery("select * from regions ");

        while (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString("region_name"));
        }

        rs.close();
        statement.close();
        conn.close();
    }


}
