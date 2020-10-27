package com.huzihao.dao;

import com.huzihao.utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 给子类提供增删该查基本功能
 * @author huzihao
 * @since 2020/10/20 23:14
 */
public abstract class BaseDao {
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行insert/update/delete语句
     * @param sql 执行的SQL语句
     * @param args 占位符对应的值
     * @return -1表示执行失败，否则返回影响行数
     */
    public int update(String sql, Object... args) {
        var cxn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(cxn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 根据语句查询数据库，将数据封装成Bean对象后返回
     * @param type Bean对象的运行时类
     * @param sql 执行的SQL语句
     * @param args 占位符的值
     * @param <T> Bean对象的类型
     * @return Bean对象
     */
    public <T> T get(Class<T> type, String sql, Object... args) {
        var cxn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(cxn, sql, new BeanHandler<>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 根据语句查询数据库，将数据封装成Bean对象的List后返回
     * @param type Bean对象的运行时类
     * @param sql 执行的SQL语句
     * @param args 占位符的值
     * @param <T> Bean对象的类型
     * @return Bean对象的List
     */
    public <T> List<T> getList(Class<T> type, String sql, Object... args) {
        var cxn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(cxn, sql, new BeanListHandler<>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 执行结果为一行一列的SQL语句，并将结果返回
     * @param sql 要执行的SQL语句
     * @param args 占位符的值
     * @return 结果
     */
    public Object getValue(String sql, Object... args) {
        var cxn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(cxn, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
}
