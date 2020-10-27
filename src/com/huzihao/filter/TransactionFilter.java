package com.huzihao.filter;

import com.huzihao.utils.JdbcUtils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author huzihao
 * @since 2020/10/27 21:26
 */
public class TransactionFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        try {
            chain.doFilter(req, resp);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e); //   把异常抛给Tomcat服务器
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
