package com.kaiyu56.wms.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.wms.api.domain.vo.WmsVehicleLL;
import com.kaiyu56.wms.enums.WmsStowageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;


/**
 * 运单配载对象 wms_stowage
 *
 * @author css
 * @date 2021-04-08
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WmsStowage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "stowage_id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stowageId;

    /**
     * 配载编码
     */
    @Excel(name = "配载编码")
    private String stowageCode;

    /**
     * 配载站点名
     */
    @Excel(name = "配载站点名")
    private String stowageWarehouseName;

    /**
     * 发出站点
     */
    @Excel(name = "发出站点")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long departure;

    /**
     * 发出站点名
     */
    @Excel(name = "发出站点名")
    private String departureName;

    /**
     * 发车批次
     */
    @Excel(name = "发车批次")
    private String departureCode;

    /**
     * 发车司机ID
     */
    @Excel(name = "发车司机ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long departureDriverId;

    /**
     * 发车司机名
     */
    @Excel(name = "发车司机名")
    private String departureDriverName;

    /**
     * 发车车ID
     */
    @Excel(name = "发车车ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long departureVehicleId;

    /**
     * 发车车编码
     */
    @Excel(name = "发车车编码")
    private String departureVehicleCode;

    /**
     * 发车车牌号
     */
    @Excel(name = "发车车牌号")
    private String departureVehiclePlate;

    /**
     * 发车时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "发车时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date departureTime;

    /**
     * 目的地站点
     */
    @Excel(name = "目的地站点")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long destination;

    /**
     * 目的地站点名
     */
    @Excel(name = "目的地站点名")
    private String destinationName;

    /**
     * 部门ID
     */
    @Excel(name = "部门ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deptId;

    @Excel(name = "配载状态")
    private String stowageStatus;

    /**
     * 状态
     */
    private String status;

    /**
     * 删除标志
     */
    private String delFlag;

    private WmsVehicleLL ll;

    /**
     * 改变状态
     * @param stowageId
     * @param stowageStatus
     */
    public WmsStowage(Long stowageId, String stowageStatus) {
        this(stowageId,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,stowageStatus,null,null);
        fillBasicAttributes(1);
        if (WmsStowageStatus.DEPARTED.getCode().equals(stowageStatus)){
            setDepartureTime(DateUtils.getNowDate());
        }
    }
}
