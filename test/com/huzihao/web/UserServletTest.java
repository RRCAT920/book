package com.huzihao.web;

import org.junit.Test;

/**
 * @author huzihao
 * @since 2020/10/23 12:18
 */
public class UserServletTest {
    public void login() {
        System.out.println("这是login方法");
    }

    public void register() {
        System.out.println("这是register方法");
    }

    public void updateUser() {
        System.out.println("这是updateUser方法");
    }

    public void updateUserPassword() {
        System.out.println("这是updateUserPassword方法");
    }

    @Test
    public void reflect() {
        var action = "login";
        
    }
}