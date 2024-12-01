package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class c3p01 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        for (int i = 0; i < 10; i++) {
            connection = dataSource.getConnection();
            System.out.println(i+""+connection);
        }
    }
}
