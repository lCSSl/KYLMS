package com.kaiyu56.wms.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 配载运单中间关联对象 wms_stowage_md_waybill
 *
 * @author css
 * @date 2021-04-08
 */
public class WmsStowageMdWaybill extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 线路ID
     */
    @Excel(name = "线路ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long routeId;

    /**
     * 配载ID
     */
    @Excel(name = "配载ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stowageId;

    /**
     * 运单ID
     */
    @Excel(name = "运单ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long waybillId;

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setStowageId(Long stowageId) {
        this.stowageId = stowageId;
    }

    public Long getStowageId() {
        return stowageId;
    }

    public void setWaybillId(Long waybillId) {
        this.waybillId = waybillId;
    }

    public Long getWaybillId() {
        return waybillId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("routeId", getRouteId())
                .append("stowageId", getStowageId())
                .append("waybillId", getWaybillId())
                .toString();
    }
}
