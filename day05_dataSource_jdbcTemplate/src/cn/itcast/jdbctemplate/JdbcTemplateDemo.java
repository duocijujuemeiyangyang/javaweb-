package cn.itcast.jdbctemplate;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplateDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "update user set sex='22' WHERE id=?";
        PreparedStatement pre = connection.prepareStatement(sql);
        pre.setInt(1, 1);
        int i = pre.executeUpdate();
        if (i > 0) {
            System.out.println("成功");
        }
        JDBCUtils.close(pre, connection);
    }
}
