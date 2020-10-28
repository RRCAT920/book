package com.huzihao.web;

import com.google.gson.Gson;
import com.huzihao.pojo.Cart;
import com.huzihao.pojo.CartItem;
import com.huzihao.service.BookService;
import com.huzihao.service.impl.BookServiceImpl;
import com.huzihao.utils.WebUtils;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huzihao
 * @since 2020/10/25 18:10
 */
public class CartServlet extends BaseServlet {
    private static final BookService BOOK_SERVICE = new BookServiceImpl();

    /**
     * Add shopping cart item
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获得请求参数id
        bookService调用queryBookById得到book对象
        转换成CartItem对象
        再调用Cart.addItem
        重定向到首页
         */
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        var book = BOOK_SERVICE.queryBookById(id);
        var cartItem = new CartItem(
                book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        var cart = (Cart) req.getSession().getAttribute("cart");
        if (null == cart) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * Delete item of cart
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获得请求参数id
        获得session中的购物车
        删除商品项
        重定向回去
         */
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        var cart = (Cart) req.getSession().getAttribute("cart");
        if (null != cart) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * Empty shopping cart
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获得session中的购物车
        清空购物车
        重定向回去
         */
        var cart = (Cart) req.getSession().getAttribute("cart");
        if (null != cart) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * Update the number of item of cart
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateNumber(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获取请求参数id、itemNumber
        获得session中的购物车
        清空购物车
        重定向回去
         */
        var id = WebUtils.parseInt(req.getParameter("id"), 0);
        var number = WebUtils.parseInt(req.getParameter("itemNumber"), 1);
        var cart = (Cart) req.getSession().getAttribute("cart");
        if (null != cart) {
            cart.updateItemNumber(id, number);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    // FIXME: 2020/10/28 代码重复
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获取商品编号
        bookService调用queryBookById得到book对象
        转换成CartItem对象
        再调用Cart.addItem
        响应数据
         */
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        var book = BOOK_SERVICE.queryBookById(id);
        var cartItem = new CartItem(
                book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        var cart = (Cart) req.getSession().getAttribute("cart");
        if (null == cart) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());

        var strObjMap = new HashMap<String, Object>();
        strObjMap.put("totalNumber", cart.getTotalNumber());
        strObjMap.put("lastName", cartItem.getName());

        var gson = new Gson();
        var jsonStr = gson.toJson(strObjMap);
        resp.getWriter().print(jsonStr);
    }
}
