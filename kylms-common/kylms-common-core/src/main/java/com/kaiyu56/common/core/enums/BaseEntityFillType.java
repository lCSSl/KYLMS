package com.kaiyu56.common.core.enums;

/**
 * @author: cssly
 * @date: 2021/4/13 9:32
 * @description:
 * @url:
 */
public enum  BaseEntityFillType{
    INSERT(0,"插入"),
    UPDATE(1,"更新"),
    ;

    private final int code;
    private final String info;

    BaseEntityFillType(int code, String info) {
        this.code = code;
        this.info = info;
    }
    public int getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }
}
