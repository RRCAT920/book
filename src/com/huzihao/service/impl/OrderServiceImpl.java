package com.huzihao.service.impl;

import com.huzihao.dao.OrderDao;
import com.huzihao.dao.OrderItemDao;
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

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 唯一订单号
        var orderId = System.currentTimeMillis() + "" + userId;
        var order = new Order(orderId, Date.valueOf(LocalDate.now()), cart.getTotalPrice(),
                0, userId);
        orderDao.saveOrder(order);
        cart.getItems().values().stream()
                .map(item -> new OrderItem(null, item.getName(), item.getNumber(),
                        item.getPrice(), item.getTotalPrice(), orderId))
                .forEach(orderItemDao::saveOrderItem);

        cart.clear();

        return orderId;
    }
}
