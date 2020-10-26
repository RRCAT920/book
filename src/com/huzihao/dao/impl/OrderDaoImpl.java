package com.huzihao.dao.impl;

import com.huzihao.dao.BaseDao;
import com.huzihao.dao.OrderDao;
import com.huzihao.pojo.Book;
import com.huzihao.pojo.Order;

import java.util.List;

/**
 * @author huzihao
 * @since 2020/10/26 17:44
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        var sql = """
                insert into t_order(order_id,create_time,price,`status`,user_id)
                values(?,?,?,?,?)
                """;
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(),
                order.getStatus(), order.getUserId());
    }

    @Override
    public List<Book> queryAllOrders() {
        return null;
    }

    @Override
    public void changeOrderStatus(String orderId, int status) {

    }

    @Override
    public List<Book> queryOrdersByUserId(int userId) {
        return null;
    }
}
