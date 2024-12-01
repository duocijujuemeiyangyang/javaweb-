package cn.itcast.jdbctemplate;

import cn.itcast.domain.SysUser;
import cn.itcast.utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void test() {
        String sql= "select * from sys_user";
        List<SysUser> users=jdbcTemplate.query(sql,new RowMapper<SysUser>() {
            @Override
            public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                SysUser user = new SysUser();
                user.setUserId(rs.getLong("user_id")); // 假设有一个id字段
                user.setUserName(rs.getString("user_name")); // 假设有一个name字段
                return user;
            }
        });
        // 打印结果
        users.forEach(System.out::println);
    }


    @Test
    public void test2() {
        String sql= "select * from sys_user";
        List<SysUser> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SysUser.class));
        query.forEach(System.out::println);
    }


    @Test
    public void test3() {
        String sql= "select * from sys_user where user_id = ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, 1L);
        System.out.println(stringObjectMap);
    }

    @Test
    public void test4() {
        String sql= "select * from sys_user";
        jdbcTemplate.queryForList(sql).forEach(System.out::println);
    }
}
