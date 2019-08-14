package com.itheima.view;

import com.itheima.domain.User;
import com.itheima.service.UserService;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        //请求
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        //核心业务逻辑
        UserService userService = new UserService();
        User user = userService.login(username,password);
        //响应
        if(user==null){
            System.out.println("错误的用户名或密码");
        }else{
            System.out.println("欢迎您："+user.getNickname());
        }
    }
}
