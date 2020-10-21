package com.huzihao.web;

import com.huzihao.pojo.User;
import com.huzihao.service.UserService;
import com.huzihao.service.impl.UserServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huzihao
 * @since 2020/10/21 12:16
 */
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求参数
        var username = request.getParameter("username");
        var password = request.getParameter("password");
        var email = request.getParameter("email");
        var code = request.getParameter("code");

        // 验证验证码
        if ("abcde".equalsIgnoreCase(code)) {
            if (!userService.existsUsername(username)) {
                userService.registUser(new User(null, username, password, email));
                request.getRequestDispatcher("/pages/user/register_success.html").forward(request, response);
            } else {
                System.out.printf("用户名[%s]已存在！%n", username);
                request.getRequestDispatcher("/pages/user/register.html").forward(request, response);
            }
        } else {
            System.out.printf("验证码[%s]错误%n", code);
            request.getRequestDispatcher("/pages/user/register.html").forward(request, response);
        }
    }
}