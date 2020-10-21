package com.huzihao.service;

import com.huzihao.pojo.User;
import com.huzihao.service.impl.UserServiceImpl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huzihao
 * @since 2020/10/21 12:06
 */
public class UserServiceTest {
    private static final UserService service = new UserServiceImpl();

    @Test
    public void registUser() {
        service.registUser(new User(null, "admin", "null", null));
        service.registUser(new User(null, "lirongrong", "lirongrong", "lirongrong@qq.com"));
    }

    @Test
    public void login() {
        assertNotNull(service.login(new User(null, "admin", "admin", null)));
        assertNull(service.login(new User(null, "lirongrong", "123", null)));
    }

    @Test
    public void existsUsername() {
        assertTrue(service.existsUsername("admin"));
        assertFalse(service.existsUsername("1232"));
    }
}