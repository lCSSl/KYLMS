package com.kaiyu56.wms.enums;

import com.kaiyu56.common.core.enums.BaseEnum;

/**
 * @author: cssly
 * @date: 2021/4/7 10:58
 * @description:
 * @url:
 */
public enum WmsWaybillStatus implements BaseEnum {

    SIGN_FOR("0", "签收"),
    NEW("1", "新开"),
    WAREHOUSING("3", "入库"),
    PRE_LOADING("4", "预装车"),
    LOADING("5", "装车"),
    DEPARTURE("7", "发车"),
    DEPARTURE_AG("9", "又发"),
    TRANSIT("11", "中转"),
    ARRIVAL("13", "到货"),
    ARRIVAL_WAREHOUSING("14", "到货入库"),
    DELIVERY("15", "送货"),
    ARRIVAL_AG("17", "又到");

    private final String code;
    private final String info;

    WmsWaybillStatus(String code, String info) {
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
