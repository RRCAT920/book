package com.huzihao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author huzihao
 * @since 2020/10/26 22:13
 */
public class ManagerFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        var session = ((HttpServletRequest) req).getSession();
        var user = session.getAttribute("user");

        if (null != user) chain.doFilter(req, resp);
        else {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
