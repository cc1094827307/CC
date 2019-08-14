package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.util.DruidUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());
    //queryForObject:方法封装数据到JavaBean中，要求结果集必须1条（0条不行；多条也不行，会抛出异常）
    public User findUser(String username, String password) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user WHERE username=? and password=?",
                    new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (DataAccessException e) {
            return null;
        }
    }
}
