package com.kaiyu56.wms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.kaiyu56.common.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 运单货物临时表对象 wms_cargo_temp
 *
 * @author css
 * @date 2021-04-01
 */
public class WmsCargoTemp extends WmsCargo {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID--序号
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 品名
     */
    @Excel(name = "品名")
    private String tCargoName;

    /**
     * 件数
     */
    @Excel(name = "件数")
    private Long tCargoCount;

    /**
     * 计量数
     */
    @Excel(name = "计量数")
    private BigDecimal valuationCount;

    /**
     * 基础运费
     */
    @Excel(name = "基础运费")
    private BigDecimal tCargoTotalFee;

    /**
     * 运单ID
     */
    @Excel(name = "运单ID")
    private Long waybillId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTCargoName(String tCargoName) {
        this.tCargoName = tCargoName;
    }

    public String getTCargoName() {
        return tCargoName;
    }

    public void setTCargoCount(Long tCargoCount) {
        this.tCargoCount = tCargoCount;
    }

    public Long getTCargoCount() {
        return tCargoCount;
    }

    public void setValuationCount(BigDecimal valuationCount) {
        this.valuationCount = valuationCount;
    }

    public BigDecimal getValuationCount() {
        return valuationCount;
    }

    public void setTCargoTotalFee(BigDecimal tCargoTotalFee) {
        this.tCargoTotalFee = tCargoTotalFee;
    }

    public BigDecimal getTCargoTotalFee() {
        return tCargoTotalFee;
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
                .append("id", getId())
                .append("tCargoName", getTCargoName())
                .append("packageType", getPackageType())
                .append("tCargoCount", getTCargoCount())
                .append("valuationType", getValuationType())
                .append("valuationValue", getValuationValue())
                .append("valuationCount", getValuationCount())
                .append("tCargoTotalFee", getTCargoTotalFee())
                .append("valuable", getValuable())
                .append("irregular", getIrregular())
                .append("documents", getDocuments())
                .append("cargoId", getCargoId())
                .append("waybillId", getWaybillId())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
