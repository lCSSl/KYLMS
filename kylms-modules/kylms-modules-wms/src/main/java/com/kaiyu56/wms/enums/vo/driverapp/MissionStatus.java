package com.kaiyu56.wms.enums.vo.driverapp;

import com.kaiyu56.common.core.enums.BaseEnum;

/**
 * @author: cssly
 * @date: 2021/4/20 23:44
 * @description:
 * @url:
 */
public enum MissionStatus implements BaseEnum {

    UNCONFIRMED("1", "未确认"),
    PROCESSING("2", "进行中"),
    COMPLETED("3", "已完成"),
    ;

    private final String code;
    private final String info;

    MissionStatus(String code, String info) {
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

