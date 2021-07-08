package com.kaiyu56.common.core.utils.tree.annotation;

import com.kaiyu56.common.core.utils.tree.enums.FieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Hamser
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TreeField {
    /**
     * 所属类型
     * 三种: ID,PID,CHILD
     *
     * @return
     */
    FieldType fieldType();
}
