package com.huzihao.service.impl;

import com.huzihao.dao.BookDao;
import com.huzihao.dao.OrderDao;
import com.huzihao.dao.OrderItemDao;
import com.huzihao.dao.impl.BookDaoImpl;
import com.huzihao.dao.impl.OrderDaoImpl;
import com.huzihao.dao.impl.OrderItemDaoImpl;
import com.huzihao.pojo.Cart;
import com.huzihao.pojo.Order;
import com.huzihao.pojo.OrderItem;
import com.huzihao.service.OrderService;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author huzihao
 * @since 2020/10/26 18:05
 */
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao = new OrderDaoImpl();
    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 唯一订单号
        var orderId = System.currentTimeMillis() + "" + userId;
        var order = new Order(orderId, Date.valueOf(LocalDate.now()), cart.getTotalPrice(),
                0, userId);
        orderDao.saveOrder(order);

        System.out.println(12 / 0);

        for (var cartItem : cart.getItems().values()) {
            var orderItem = new OrderItem(null, cartItem.getName(), cartItem.getNumber(),
                    cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);

            var book = bookDao.queryBookById(cartItem.getId());
            // TODO: 2020/10/26 没有数据检查
            book.setSales(book.getSales() + cartItem.getNumber());
            book.setStock(book.getStock() - cartItem.getNumber());
            bookDao.updateBook(book);
        }

        cart.clear();

        return orderId;
    }
}
