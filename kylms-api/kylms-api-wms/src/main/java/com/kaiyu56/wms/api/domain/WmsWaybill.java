package com.kaiyu56.wms.api.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.common.core.web.domain.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.*;

/**
 * 运单信息主对象 wms_waybill
 *
 * @author css
 * @date 2021-03-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "wms_waybill")
@EqualsAndHashCode(callSuper = true)
public class WmsWaybill extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 序号
     */
    @TableId(value = "waybill_id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long waybillId;
    /**
     * 运单号
     */
    @Excel(name = "运单号")
    @TableField(value = "waybill_code")
    private String waybillCode;
    /**
     * 始发站
     */
    @Excel(name = "始发站")
    @TableField(value = "departure")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long departure;
    /**
     * 到达站
     */
    @Excel(name = "到达站")
    @TableField(value = "destination")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long destination;
    /**
     * 中转地
     */
    @Excel(name = "中转地")
    @TableField(value = "transit_place")
    private String transitPlace;
    /**
     * 客户ID
     */
    @Excel(name = "客户ID")
    @TableField(value = "csr_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long csrId;
    /**
     * 客户编号
     */
    @Excel(name = "客户编号")
    @TableField(value = "csr_code")
    private String csrCode;
    /**
     * 客户单号
     */
    @Excel(name = "客户单号")
    @TableField(value = "csr_order_number")
    private String csrOrderNumber;
    /**
     * 发货公司ID
     */
    @Excel(name = "发货公司ID")
    @TableField(value = "deliver_co_id")
    private String deliverCoId;
    /**
     * 发货公司名称
     */
    @Excel(name = "发货公司名称")
    @TableField(value = "deliver_co_name")
    private String deliverCoName;
    /**
     * 发货联系人
     */
    @Excel(name = "发货联系人")
    @TableField(value = "consignor_name")
    private String consignorName;
    /**
     * 发货人手机
     */
    @Excel(name = "发货人手机")
    @TableField(value = "consignor_mobile")
    private String consignorMobile;
    /**
     * 发货人座机
     */
    @Excel(name = "发货人座机")
    @TableField(value = "consignor_telephone")
    private String consignorTelephone;
    /**
     * 收货公司ID
     */
    @Excel(name = "收货公司ID")
    @TableField(value = "receiving_co_id")
    private String receivingCoId;
    /**
     * 收货公司名称
     */
    @Excel(name = "收货公司名称")
    @TableField(value = "receiving_co_name")
    private String receivingCoName;
    /**
     * 收货联系人
     */
    @Excel(name = "收货联系人")
    @TableField(value = "consignee_name")
    private String consigneeName;
    /**
     * 收货人手机
     */
    @Excel(name = "收货人手机")
    @TableField(value = "consignee_mobile")
    private String consigneeMobile;
    /**
     * 收货人座机
     */
    @Excel(name = "收货人座机")
    @TableField(value = "consignee_telephone")
    private String consigneeTelephone;
    /**
     * 收货省
     */
    @Excel(name = "收货省")
    @TableField(value = "receiving_province")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long receivingProvince;
    /**
     * 收货市
     */
    @Excel(name = "收货市")
    @TableField(value = "receiving_city")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long receivingCity;
    /**
     * 收货区
     */
    @Excel(name = "收货区")
    @TableField(value = "receiving_district")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long receivingDistrict;
    /**
     * 收货街道
     */
    @Excel(name = "收货街道")
    @TableField(value = "receiving_street")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long receivingStreet;
    /**
     * 收货详细地址
     */
    @Excel(name = "收货详细地址")
    @TableField(value = "receiving_address")
    private String receivingAddress;
    /**
     * 开单事业部
     */
    @Excel(name = "开单事业部")
    @TableField(value = "dept_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deptId;
    /**
     * 配载站点
     */
    @Excel(name = "配载站点")
    @TableField(value = "stowage_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stowageId;
    /**
     * 目的网点
     */
    @Excel(name = "目的网点")
    @TableField(value = "destination_node")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long destinationNode;
    /**
     * 交接方式
     */
    @Excel(name = "交接方式")
    @TableField(value = "handover_mode")
    private String handoverMode;
    /**
     * 运输方式
     */
    @Excel(name = "运输方式")
    @TableField(value = "transport_mode")
    private String transportMode;
    /**
     * 付款方式
     */
    @Excel(name = "付款方式")
    @TableField(value = "pay_method")
    private String payMethod;
    /**
     * 回单状态
     */
    @Excel(name = "回单状态")
    @TableField(value = "receipt_status")
    private String receiptStatus;
    /**
     * 回扣已返
     */
    @Excel(name = "回扣已返")
    @TableField(value = "rebate_returned")
    private String rebateReturned;
    /**
     * 是否开发票
     */
    @Excel(name = "是否开发票")
    @TableField(value = "write_invoice")
    private String writeInvoice;
    /**
     * 基本运费
     */
    @Excel(name = "基本运费")
    @TableField(value = "basic_freight")
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal basicFreight;
    /**
     * 实收运费
     */
    @Excel(name = "实收运费")
    @TableField(value = "real_freight")
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal realFreight;
    /**
     * 总运费
     */
    @Excel(name = "总运费")
    @TableField(value = "total_freight")
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal totalFreight;
    /**
     * 送货车号
     */
    @Excel(name = "送货车号")
    @TableField(value = "delivery_vehicle_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deliveryVehicleId;
    /**
     * 送货车号
     */
    @Excel(name = "送货车号")
    @TableField(value = "delivery_vehicle_code")
    private String deliveryVehicleCode;
    /**
     * 送货司机
     */
    @Excel(name = "送货司机")
    @TableField(value = "delivery_driver_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deliveryDriverId;
    /**
     * 送货司机
     */
    @Excel(name = "送货司机")
    @TableField(value = "delivery_driver_name")
    private String deliveryDriverName;
    /**
     * 送货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "送货时间", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(value = "delivery_time")
    private Date deliveryTime;
    /**
     * 开单人ID
     */
    @Excel(name = "开单人ID")
    @TableField(value = "drawer_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long drawerId;
    /**
     * 开单人
     */
    @Excel(name = "开单人")
    @TableField(value = "drawer_name")
    private String drawerName;
    /**
     * 设备来源
     */
    @Excel(name = "设备来源")
    @TableField(value = "equipment_source")
    private String equipmentSource;
    /**
     * 开单来源
     */
    @Excel(name = "开单来源")
    @TableField(value = "creation_source")
    private String creationSource;
    /**
     * 运单状态
     */
    @Excel(name = "运单状态")
    @TableField(value = "waybill_status")
    private String waybillStatus;
    /**
     * 运单祖先ID
     */
    @Excel(name = "运单祖先ID")
    @TableField(value = "ancestor_waybill_id")
    private Long ancestorWaybillId;
    /**
     * 状态
     */
    @Excel(name = "状态")
    @TableField(value = "status")
    private String status;
    /**
     * 删除标志
     */
    @TableLogic
    @TableField(value = "del_flag")
    private String delFlag;

    /**
     * 改变状态
     * @param waybillId
     * @param waybillStatus
     */
    public WmsWaybill(Long waybillId, String waybillStatus) {
        this(waybillId,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,waybillStatus,null,null,null);
        if (StringUtils.isNotNull(waybillId)&&waybillId.compareTo(0l)>=0){
            fillBasicAttributes(1);
        }
    }
}
