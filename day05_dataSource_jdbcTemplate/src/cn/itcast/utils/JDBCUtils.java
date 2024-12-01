package cn.itcast.utils;

import cn.itcast.datasource.druid.druid01;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource ds;

    static {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = druid01.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt, Connection conn){
		       /* if(stmt != null){
		            try {
		                stmt.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }

		        if(conn != null){
		            try {
		                conn.close();//归还连接
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }*/

        close(null,stmt,conn);
    }

    public static void close(ResultSet rs , Statement stmt, Connection conn){

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池方法
     */

    public static DataSource getDataSource(){
        return  ds;
    }

}
