package com.huzihao.web;

import com.huzihao.pojo.User;
import com.huzihao.service.UserService;
import com.huzihao.service.impl.UserServiceImpl;
import com.huzihao.utils.WebUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

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

        String path;
        var loginUser = userService.login(new User(username, password));
        if (null != loginUser) {
            // 登录成功
            path = "/pages/user/login_success.jsp";
            // TODO: 2020/10/24 设置session在浏览器关闭时存活
            // 保存用户登录之后的信息
            req.getSession().setAttribute("user", loginUser);
        } else {
            // 登录失败
            path = "/pages/user/login.jsp";
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
        }
        resp.sendRedirect(req.getContextPath() + path);
//        req.getRequestDispatcher(path).forward(req, resp);
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        var session = req.getSession();
        var kaptcha = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        session.removeAttribute(KAPTCHA_SESSION_KEY);
        // TODO: 2020/10/23 请求参数可以通过user获取
        // 获取请求参数
        var username = req.getParameter("username");
        var password = req.getParameter("password");
        var email = req.getParameter("email");
        var captcha = req.getParameter("code");

        var user = WebUtils.copyParameterToBean(req.getParameterMap(), new User());
        // 验证验证码
        var path = "/pages/user/register.jsp";
        if (null != kaptcha && kaptcha.equalsIgnoreCase(captcha)) {
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
            System.out.printf("验证码[%s]错误%n", captcha);
        }
//        resp.sendRedirect(req.getContextPath() + path);
        req.getRequestDispatcher(path).forward(req, resp);
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        销毁session的用户信息（或销毁session）
        重定向到首页（登录页）
         */
        req.getSession().removeAttribute("user");
//        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
}
