package com.huzihao.dao;

import com.huzihao.pojo.Book;
import com.huzihao.pojo.Order;

import java.util.List;

/**
 * @author huzihao
 * @since 2020/10/26 17:43
 */
public interface OrderDao {
    int saveOrder(Order order);

    List<Book> queryAllOrders();

    void changeOrderStatus(String orderId, int status);

    List<Book> queryOrdersByUserId(int userId);
}
