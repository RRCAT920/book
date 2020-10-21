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
        var path = "/pages/user/login.html";
        if (null != SERVICE.login(new User(username, password))) {
            path = "/pages/user/login_success.html";
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
