package com.huzihao.dao;

import com.huzihao.dao.impl.OrderItemDaoImpl;
import com.huzihao.pojo.OrderItem;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author huzihao
 * @since 2020/10/26 17:50
 */
public class OrderItemDaoTest {
    private final OrderItemDao ORDER_ITEM_DAO = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        var orderItem = new OrderItem(null, "Java从入门到精通", 1,
                new BigDecimal(100), new BigDecimal(100), "1234567890");
        ORDER_ITEM_DAO.saveOrderItem(orderItem);
    }
}