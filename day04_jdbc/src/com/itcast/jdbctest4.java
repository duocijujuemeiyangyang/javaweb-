package com.itcast;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import entry.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class jdbctest4 {
    public static void main(String[] args) throws Exception {

        Connection connection = null;
        Statement statement = null;

        Properties prop = new Properties();
        prop.load(jdbctest4.class.getClassLoader().getResourceAsStream("pro.properties"));
        String url = prop.getProperty("url");
        String username =prop.getProperty("username");
        String password =prop.getProperty("password");
        String driver =prop.getProperty("driver-class-name");
//        System.out.println(url);
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(driver);

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            String sql="SELECT * FROM user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<user> list = new ArrayList<>();
            while (resultSet.next()){
                user user = new user();
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                user.setId(id);
                user.setName(name);
                user.setSex(sex);
                list.add(user);
            }

            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
