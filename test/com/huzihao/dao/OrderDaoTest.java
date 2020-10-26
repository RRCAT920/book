package com.huzihao.dao;

import com.huzihao.dao.impl.OrderDaoImpl;
import com.huzihao.pojo.Order;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

/**
 * @author huzihao
 * @since 2020/10/26 17:50
 */
public class OrderDaoTest {
    private final OrderDao ORDER_DAO = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        var order = new Order("1234567890", Date.valueOf(LocalDate.now()),
                new BigDecimal(100), 0, 1);
        ORDER_DAO.saveOrder(order);
    }
}