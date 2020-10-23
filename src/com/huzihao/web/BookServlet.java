package com.huzihao.web;

import com.huzihao.pojo.Book;
import com.huzihao.service.BookService;
import com.huzihao.service.impl.BookServiceImpl;
import com.huzihao.utils.WebUtils;

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
        /*
        1.获取请求参数，封装成Book对象
        2.调用service.addBook
        3.重定向到/manager/book?action=list
         */
        var book = WebUtils.copyParameterToBean(req.getParameterMap(), new Book());
        service.addBook(book);
        // 表单重复提交：
        // 浏览器会记录最后一次请求的信息，当刷新页面时会再次发送最后一次请求
        // 若使用重定向，则改变了最后一次请求
        resp.sendRedirect(req.getContextPath() + "/manager/book?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获取请求参数id
        service调用deleteBookById
        重定向到/manager/book?action=list
         */
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        service.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/book?action=list");
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
