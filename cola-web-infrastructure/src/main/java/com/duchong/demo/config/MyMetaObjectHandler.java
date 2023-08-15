package com.duchong.demo.config;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * 自动填充数据库字段
 * @author chong.du
 * @date 2022-11-3 14:07:59
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    public static final String UPDATE_TIME = "gmtModify";
    public static final String CREATE_TIME = "gmtCreate";
    public static final String DELETE_TIME = "gmtDelete";
    public static final String DELETED = "deleted";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start auto-insert fill ....");
        this.strictInsertFill(metaObject, CREATE_TIME, Date.class, DateUtil.date());
        this.strictInsertFill(metaObject, DELETED, Integer.class,0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start auto-update fill ....");
        if (Objects.nonNull(metaObject.getValue(UPDATE_TIME))) {
            metaObject.setValue(UPDATE_TIME, null);
        }
        this.strictUpdateFill(metaObject, UPDATE_TIME, Date.class, DateUtil.date());
    }
}