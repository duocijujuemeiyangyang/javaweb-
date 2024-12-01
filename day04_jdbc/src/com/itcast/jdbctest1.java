package com.itcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class jdbctest1 {
    public static void main(String[] args)  {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://124.221.28.228:3306/test", "root", "1234");
            String sql="update user set name='zhangsan' where id=1";
             preparedStatement = connection.prepareStatement(sql);
            int i = preparedStatement.executeUpdate(sql);
            if (i>0){
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
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
