package com.huzihao.service;

import com.huzihao.pojo.Cart;

/**
 * @author huzihao
 * @since 2020/10/26 18:04
 */
public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
