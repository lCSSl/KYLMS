package com.kaiyu56.wms.enums;

import com.kaiyu56.common.core.enums.BaseEnum;

/**
 * @author: cssly
 * @date: 2021/4/12 16:52
 * @description:
 * @url:
 */
public enum WmsStowageRouteStatus implements BaseEnum {

    ABNORMAL("-1", "异常"),
    NOT_ARRIVED("0", "未到"),
    ARRIVED("1", "已到"),
    WARN("2", "警告"),
    ;

    private final String code;
    private final String info;

    WmsStowageRouteStatus(String code, String info) {
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
