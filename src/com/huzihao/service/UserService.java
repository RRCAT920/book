package com.huzihao.service;

import com.huzihao.pojo.User;

/**
 * @author huzihao
 * @since 2020/10/21 11:56
 */
public interface UserService {
    /**
     * 注册用户
     * @param user User对象
     */
    void registUser(User user);

    /**
     * 登录
     * @param user User对象
     * @return null: 失败<br>否则: 成功
     */
    User login(User user);

    /**
     * 检查用户名是否存在
     * @param username 用户名
     * @return true: 存在<br>false: 不存在
     */
    boolean existsUsername(String username);
}
