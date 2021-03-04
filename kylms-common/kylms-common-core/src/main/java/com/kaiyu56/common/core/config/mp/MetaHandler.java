package com.kaiyu56.common.core.config.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.kaiyu56.common.core.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author cssly
 * @date 2021/2/25
 */
@Slf4j
@Component
public class MetaHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        String currentUser = SecurityUtils.getUsername();
        Date now = new Date();
        Object createBy = getFieldValByName("createBy", metaObject);
        Object updateBy = getFieldValByName("updateBy", metaObject);
//        Object createTime = getFieldValByName("createTime", metaObject);
//        Object updateTime = getFieldValByName("updateTime", metaObject);
//        if (null == createTime) {
//            setFieldValByName("createTime", now, metaObject);
//        }
//        if (null == updateTime) {
//            setFieldValByName("updateTime", now, metaObject);
//        }
        setFieldValByName("createTime", now, metaObject);
        setFieldValByName("updateTime", now, metaObject);
        if (null == createBy) {
            setFieldValByName("createBy", currentUser, metaObject);
        }
        if (null == updateBy) {
            setFieldValByName("updateBy", currentUser, metaObject);
        }
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        String currentUser = SecurityUtils.getUsername();
        setFieldValByName("updateTime", new Date(), metaObject);
        Object updateBy = getFieldValByName("updateBy", metaObject);
        if (null == updateBy) {
            setFieldValByName("updateBy", currentUser, metaObject);
        }
    }
}
