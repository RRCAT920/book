package com.huzihao.dao;

import com.huzihao.pojo.User;

/**
 * @author huzihao
 * @since 2020/10/20 23:29
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息(null则数据库中无此数据)
     * @apiNote 注册时检查用户名是否可用
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 用户（null表示用户名或密码错误）
     * @apiNote 登录
     */
    User queryUserByUsernameAndPassword(String username, String password);
    /**
     * 保存用户信息
     * @param user 用户
     * @return 1表示执行成功，-1失败
     * @apiNote 保存注册用户
     */
    int saveUser(User user);
}
