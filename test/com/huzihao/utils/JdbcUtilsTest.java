package com.huzihao.utils;

import org.junit.Test;

/**
 * @author huzihao
 * @since 2020/10/20 22:55
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            var cxn = JdbcUtils.getConnection();
            System.out.println(cxn);
            if (i >= 9) {
                JdbcUtils.close(cxn);
            }
        }
    }
}