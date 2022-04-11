package come.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Practice03_MetaDataTest {
    String dbUrl = "jdbc:oracle:thin:@54.158.153.204 :1521:XE"; ///write your ip
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws Exception {
        ;
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("select * from regions ");

        // Database Metadata --> Information about database

        DatabaseMetaData dbMetaData = conn.getMetaData();

        System.out.println(dbMetaData.getUserName());
        System.out.println(dbMetaData.getDatabaseProductName());
        System.out.println(dbMetaData.getDatabaseProductVersion());
        System.out.println(dbMetaData.getDriverName());
        System.out.println(dbMetaData.getDriverVersion());

    /*
    You will not use it as a testing purpose. This is extra information about Meta
     */

        //ResultSet MetaData

        ResultSetMetaData metaData = rs.getMetaData();

        int columnCount = metaData.getColumnCount();
        System.out.println(columnCount);


        // How can we learn columnName for second colum
        System.out.println(metaData.getColumnName(2));

        //Print all column name as dynamicly
        for (int i = 1; i <=columnCount; i++) {
            System.out.println(metaData.getColumnName(i));
        }

        /*
        ResultSet
        rs.next(); --> to iterate each row
        rs.getString(index) --> to get data from related column

        ResultMetaData
        metaData.getColumnCount() --> to get column get
        metaData.getColumnName() --> to get column information/name
         */

       while (rs.next()){
           for (int i = 1; i <=columnCount ; i++) {
               System.out.println(metaData.getColumnName(i)+"-"+rs.getString(i));
           }
       }





        rs.close();
        statement.close();
        conn.close();

    }


}
