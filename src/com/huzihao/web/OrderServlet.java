package com.huzihao.web;

import com.huzihao.pojo.Cart;
import com.huzihao.pojo.User;
import com.huzihao.service.OrderService;
import com.huzihao.service.impl.OrderServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huzihao
 * @since 2020/10/26 18:19
 */
public class OrderServlet extends BaseServlet {
    private final OrderService orderService = new OrderServiceImpl();

    /**
     * Create an order with cart and id of user
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        获得session域中的cart和user的id
        生成订单
        将订单号保存到session域中
        重定向到生成订单页面
         */
        var session = req.getSession();
        var cart = (Cart) session.getAttribute("cart");
        var loginUser = (User) session.getAttribute("user");

        if (null == loginUser) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        var userId = loginUser.getId();

        var orderId = orderService.createOrder(cart, userId);

        session.setAttribute("orderId", orderId);

        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
