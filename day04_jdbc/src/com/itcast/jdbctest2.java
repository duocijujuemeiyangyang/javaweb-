package com.itcast;

import java.sql.*;

public class jdbctest2 {
    public static void main(String[] args)  {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://124.221.28.228:3306/test", "root", "1234");
            String sql="update user set sex='18' where id=1";
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
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
