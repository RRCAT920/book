package com.huzihao.dao;

import com.huzihao.dao.impl.UserDaoImpl;
import com.huzihao.pojo.User;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huzihao
 * @since 2020/10/20 23:55
 */
public class UserDaoTest {
    private static UserDao dao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        assertEquals("admin", dao.queryUserByUsername("admin").getUsername());
        assertNull(dao.queryUserByUsername("admin123"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        var user = dao.queryUserByUsernameAndPassword("admin", "admin");
        assertEquals("admin", user.getUsername());
        assertEquals("admin", user.getPassword());

        assertNull(dao.queryUserByUsernameAndPassword("admin", "admin123"));
    }

    @Test
    public void saveUser() {
        var user1 = new User(null, "admin", "123", "123@qq.com");
        assertEquals(-1, dao.saveUser(user1));

        var user2 = new User(
                null, "rrcat920", "123456", "rrcat920@qq.com");
        assertEquals(1, dao.saveUser(user2));
    }
}