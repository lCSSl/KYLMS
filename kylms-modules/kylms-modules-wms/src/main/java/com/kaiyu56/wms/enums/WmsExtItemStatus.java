package com.kaiyu56.wms.enums;

import com.kaiyu56.common.core.enums.BaseEnum;

/**
 * @author: cssly
 * @date: 2021/4/7 10:58
 * @description:
 * @url:
 */
public enum WmsExtItemStatus implements BaseEnum {

    DISABLED("0", "禁用"),
    ENABLED("1", "启用"),
    LOAD("2", "装载");

    private final String code;
    private final String info;

    WmsExtItemStatus(String code, String info) {
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
