package com.huzihao.service.impl;

import com.huzihao.dao.UserDao;
import com.huzihao.dao.impl.UserDaoImpl;
import com.huzihao.pojo.User;
import com.huzihao.service.UserService;

/**
 * @author huzihao
 * @since 2020/10/21 12:00
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
