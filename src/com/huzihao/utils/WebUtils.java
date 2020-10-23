package com.huzihao.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author huzihao
 * @since 2020/10/23 12:56
 */
public class WebUtils {
    /**
     * 将map的数据注入到Bean对象中
     *
     * @param map  存储数据的Map
     * @param bean Bean对象
     * @param <T>  Bean对象的类型
     * @return Bean对象
     */
    // TODO: 2020/10/23 改成createBeanWithParameter可以直接创Bean
    public static <T> T copyParameterToBean(Map<String, String[]> map, T bean) {
        try {
            BeanUtils.populate(bean, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
