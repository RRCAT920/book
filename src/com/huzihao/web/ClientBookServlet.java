package com.huzihao.web;

import com.huzihao.pojo.Page;
import com.huzihao.service.BookService;
import com.huzihao.service.impl.BookServiceImpl;
import com.huzihao.utils.WebUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huzihao
 * @since 2020/10/24 01:01
 */
public class ClientBookServlet extends BaseServlet {
    private final BookService service = new BookServiceImpl();

    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void paging(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获取请求参数number, size
        调用service.paging(number, size): Page
        在request域中保存page
        转发到/pages/client/book_manager.jsp
         */
        int number = WebUtils.parseInt(req.getParameter("number"), 1);
        int size = WebUtils.parseInt(req.getParameter("size"), Page.PAGE_SIZE);
        var page = service.paging(number, size);
        page.setUrl("client/book?action=paging");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pagingByPrice(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获取请求参数number, size, min, max
        调用service.pagingPrice(number, size, min, max): Page
        在request域中保存page
        转发到/pages/client/book_manager.jsp
         */
        int number = WebUtils.parseInt(req.getParameter("number"), 1);
        int size = WebUtils.parseInt(req.getParameter("size"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        var page = service.pagingByPrice(number, size, min, max);

        var urlBuilder = new StringBuilder("client/book?action=pagingByPrice");
        if (null != req.getParameter("min")) urlBuilder.append("&min=").append(min);
        if (null != req.getParameter("max")) urlBuilder.append("&max=").append(max);
        page.setUrl(urlBuilder.toString());

        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
