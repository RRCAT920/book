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
 * @since 2020/10/21 20:41
 */
public class LoginServlet extends HttpServlet {
    public static final UserService SERVICE = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        var username = req.getParameter("username");
        var password = req.getParameter("password");

        var path = "/pages/user/login.jsp";
        if (null != SERVICE.login(new User(username, password))) {
            // 登录成功
            path = "/pages/user/login_success.jsp";
        } else {
            // 登录失败
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
