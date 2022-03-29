package com.example.demo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * @Author YYT
 * @Date 2022/3/25 18:25
 **/
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Date currentDate = new Date();
        String[] setterNames = metaObject.getSetterNames();
        HashSet<String> setterNameSet = new HashSet<>(Arrays.asList(setterNames));
        if (setterNameSet.contains("deleted")) {
            //默认未删除
            setFieldValByName("deleted", 1, metaObject);
        }
        if (setterNameSet.contains("gmtCreate")) {
            //创建时间默认当前时间
            setFieldValByName("gmtCreate", currentDate, metaObject);
        }
        if (setterNameSet.contains("gmtModify")) {
            //创建时间默认当前时间
            setFieldValByName("gmtModify", currentDate, metaObject);
        }
        if (setterNameSet.contains("createUser")) {
            //创建时间默认当前时间
            setFieldValByName("createUser", "unknow", metaObject);
        }
        if (setterNameSet.contains("modifyUser")) {
            //创建时间默认当前时间
            setFieldValByName("modifyUser", "unknow", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date currentDate = new Date();
        String[] setterNames = metaObject.getSetterNames();
        HashSet<String> setterNameSet = new HashSet<>(Arrays.asList(setterNames));
        if (setterNameSet.contains("gmtCreate")) {
            //创建时间默认当前时间
            setFieldValByName("gmtCreate", currentDate, metaObject);
        }
        if (setterNameSet.contains("gmtModify")) {
            //创建时间默认当前时间
            setFieldValByName("gmtModify", currentDate, metaObject);
        }
        if (setterNameSet.contains("createUser")) {
            //创建时间默认当前时间
            setFieldValByName("createUser", "unknow", metaObject);
        }
        if (setterNameSet.contains("modifyUser")) {
            //创建时间默认当前时间
            setFieldValByName("modifyUser", "unknow", metaObject);
        }
    }
}