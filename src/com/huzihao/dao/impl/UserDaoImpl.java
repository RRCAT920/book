package com.huzihao.dao.impl;

import com.huzihao.dao.BaseDao;
import com.huzihao.dao.UserDao;
import com.huzihao.pojo.User;

/**
 * @author huzihao
 * @since 2020/10/20 23:51
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        var sql = """
                select id, username, password, email
                from t_user
                where username = ?
                """;
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        var sql = """
                select id, username, password, email
                from t_user
                where username = ? and password = ?
                """;
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        var sql = """
                insert into t_user(username, password, email)
                values(?, ?, ?)
                """;
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
