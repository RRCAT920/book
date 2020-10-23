package com.huzihao.web;

import com.huzihao.pojo.User;
import com.huzihao.service.UserService;
import com.huzihao.service.impl.UserServiceImpl;
import com.huzihao.utils.WebUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huzihao
 * @since 2020/10/23 12:02
 */
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        var username = req.getParameter("username");
        var password = req.getParameter("password");

        var path = "/pages/user/login.jsp";
        if (null != userService.login(new User(username, password))) {
            // 登录成功
            path = "/pages/user/login_success.jsp";
        } else {
            // 登录失败
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO: 2020/10/23 请求参数可以通过user获取
        // 获取请求参数
        var username = req.getParameter("username");
        var password = req.getParameter("password");
        var email = req.getParameter("email");
        var code = req.getParameter("code");

        var user = WebUtils.copyParameterToBean(req.getParameterMap(), new User());
        // 验证验证码
        var path = "/pages/user/register.jsp";
        if ("abcde".equalsIgnoreCase(code)) {
            if (!userService.existsUsername(username)) {
                // 用户名不存在

                userService.registerUser(user);
                path = "/pages/user/register_success.jsp";
            } else {
                // 用户名已存在
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                System.out.printf("用户名[%s]已存在！%n", username);
            }
        } else {
            // 验证码错误
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            System.out.printf("验证码[%s]错误%n", code);
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
