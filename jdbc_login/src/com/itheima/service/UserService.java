package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
    private UserDao userDao = new UserDao();

    /** javadoc注释
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 如果用户名和密码正确，返回User对象。不正确返回null。
     */
    public User login(String username,String password){
        return userDao.findUser(username,password);
    }
}
