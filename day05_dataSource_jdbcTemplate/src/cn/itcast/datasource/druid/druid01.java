package cn.itcast.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class druid01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        InputStream resourceAsStream = druid01.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        for (int i = 0; i < 11; i++) {
            Connection connection = ds.getConnection();
            System.out.println(connection);
        }
    }
}
