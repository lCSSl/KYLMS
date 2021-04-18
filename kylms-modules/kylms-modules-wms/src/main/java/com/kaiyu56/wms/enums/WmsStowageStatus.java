package com.kaiyu56.wms.enums;

import com.kaiyu56.common.core.enums.BaseEnum;

/**
 * @author: cssly
 * @date: 2021/4/12 16:52
 * @description:
 * @url:
 */
public enum WmsStowageStatus implements BaseEnum {

    ABANDON("-1", "废弃"),
    CREATED("0", "创建"),
    STOWAGE("1", "已配载"),
    DEPARTED("2", "已发车"),
    COMPLETE("3", "完成"),
    ;

    private final String code;
    private final String info;

    WmsStowageStatus(String code, String info) {
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
