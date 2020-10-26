package com.huzihao.dao.impl;

import com.huzihao.dao.BaseDao;
import com.huzihao.dao.OrderItemDao;
import com.huzihao.pojo.OrderItem;

import java.util.List;

/**
 * @author huzihao
 * @since 2020/10/26 17:46
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        var sql = """
                insert into t_order_item(name, number, price, total_price, order_id)
                values(?, ?, ?, ?, ?)
                """;
        return update(sql, orderItem.getName(), orderItem.getNumber(), orderItem.getPrice(),
                orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        return null;
    }
}
