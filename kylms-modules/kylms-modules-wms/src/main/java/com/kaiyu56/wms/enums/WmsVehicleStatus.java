package com.kaiyu56.wms.enums;

import com.kaiyu56.common.core.enums.BaseEnum;

/**
 * @author: cssly
 * @date: 2021/4/7 16:37
 * @description:
 * @url:
 */
public enum WmsVehicleStatus implements BaseEnum {

    MAINTENANCE("-1", "维护中"),
    IDLE("0", "空闲"),
    USING("1", "使用中"),
    TRANSIT("2", "运输中"),
    ASSIGNMENT("3", "外派中"),
    ;

    private final String code;
    private final String info;

    WmsVehicleStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getInfo() {
        return info;
    }
}