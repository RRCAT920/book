package com.huzihao.dao;

import com.huzihao.pojo.OrderItem;

/**
 * @author huzihao
 * @since 2020/10/26 17:43
 */
public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
}
