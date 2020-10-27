package com.huzihao.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author huzihao
 * @since 2020/10/20 22:36
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> connections = new ThreadLocal<>();

    static {
        try (var in = JdbcUtils.class.getClassLoader()
                .getResourceAsStream("jdbc.properties")) {
            var props = new Properties();
            props.load(in);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接
     * @return 数据库连接
     */
    public static Connection getConnection() {
        var cxn = connections.get();
        if (null == cxn) {
            try {
                cxn = dataSource.getConnection();
                connections.set(cxn);
                cxn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return cxn;
    }

    // TODO: 2020/10/20 使用try-with-resources无需使用此函数
    /**
     * 关闭数据库连接
     * @param connection 需要关闭的数据库连接
     */
    public static void close(Connection connection) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void commitAndClose() {
        final var cxn = connections.get();
        if (null != cxn) {
            try (cxn) {
                cxn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // 一定要执行，否则会出错（因为Tomcat底层使用了线程池）
        connections.remove();
    }

    public static void rollbackAndClose() {
        final var cxn = connections.get();
        if (null != cxn) {
            try (cxn) {
                cxn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        connections.remove();
    }
}
