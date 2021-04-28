package com.kaiyu56.wms.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 运输工具信息主对象 wms_vehicle
 *
 * @author css
 * @date 2021-03-24
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WmsVehicle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long vehicleId;

    /**
     * 编码
     */
    @Excel(name = "编码")
    private String vehicleCode;

    /**
     * 牌号
     */
    @Excel(name = "牌号")
    private String vehiclePlate;

    /**
     * 类型
     */
    @Excel(name = "类型")
    private String vehicleType;

    /**
     * 来源
     */
    @Excel(name = "来源")
    private String vehicleSource;

    /**
     * 宽
     */
    @Excel(name = "宽")
    private BigDecimal vehicleWidth;

    /**
     * 长
     */
    @Excel(name = "长")
    private BigDecimal vehicleLength;

    private BigDecimal vehicleLongitude;

    private BigDecimal vehicleLatitude;

    /**
     * 高
     */
    @Excel(name = "高")
    private BigDecimal vehicleHeight;
    /**
     * 部门ID
     */
    @Excel(name = "部门ID")
    private Long deptId;
    /**
     * 部门ID
     */
    @Excel(name = "部门名")
    private String deptName;
    /**
     * 设备状态:(-1)-维护中0-空闲1-运行中2-运输中3-外派中'
     */
    @Excel(name = "设备状态", readConverterExp = "0=正常,1=停用")
    private String vehicleStatus;
    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 改变状态
     * @param vehicleId
     * @param vehicleStatus
     */
    public WmsVehicle(Long vehicleId, String vehicleStatus) {
        this(vehicleId, null, null, null, null, null,null,null,null, null, null, null, vehicleStatus, null, null);
        fillBasicAttributes(1);
    }

    /**
     *
     * @param vehicleId
     * @param vehicleLongitude
     * @param vehicleLatitude
     */
    public WmsVehicle(Long vehicleId, BigDecimal vehicleLongitude,BigDecimal vehicleLatitude) {
        this(vehicleId, null, null, null, null, null,null,vehicleLongitude,vehicleLatitude, null, null, null, null, null, null);
        fillBasicAttributes(1);
    }
}
