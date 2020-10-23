package com.huzihao.web;

import com.huzihao.service.BookService;
import com.huzihao.service.impl.BookServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huzihao
 * @since 2020/10/23 20:24
 */
public class BookServlet extends BaseServlet {
    private final BookService service = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        1、查询全部图书
        var bookList = service.queryBooks();
//        2、保存到request
        req.setAttribute("bookList", bookList);
//        3、转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
