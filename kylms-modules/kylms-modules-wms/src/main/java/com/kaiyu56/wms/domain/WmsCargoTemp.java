package com.kaiyu56.wms.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kaiyu56.common.core.annotation.Excel;
import com.kaiyu56.common.core.web.domain.BaseEntity;

/**
 * 运单货物临时对象 wms_cargo_temp
 * 
 * @author css
 * @date 2021-03-24
 */
public class WmsCargoTemp extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 主键ID--序号 */
    private Long id;

    /** 运单ID */
    @Excel(name = "运单ID")
    private Long waybillId;

    /** 货物ID */
    @Excel(name = "货物ID")
    private Long cargoId;

    /** 品名 */
    @Excel(name = "品名")
    private String tCargoName;

    /** 件数 */
    @Excel(name = "件数")
    private Integer tCargoNumber;

    /** 重量 */
    @Excel(name = "重量")
    private BigDecimal tCargoTotalWeight;

    /** 体积 */
    @Excel(name = "体积")
    private BigDecimal tCargoTotalVolume;

    /** 贵重货物 */
    @Excel(name = "贵重货物")
    private String valuable;

    /** 异形货物 */
    @Excel(name = "异形货物")
    private String irregular;

    /** 货物单据 */
    @Excel(name = "货物单据")
    private String documents;

    /** 包装方式 */
    @Excel(name = "包装方式")
    private String packageType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWaybillId(Long waybillId) 
    {
        this.waybillId = waybillId;
    }

    public Long getWaybillId() 
    {
        return waybillId;
    }
    public void setCargoId(Long cargoId) 
    {
        this.cargoId = cargoId;
    }

    public Long getCargoId() 
    {
        return cargoId;
    }
    public void settCargoName(String tCargoName) 
    {
        this.tCargoName = tCargoName;
    }

    public String gettCargoName() 
    {
        return tCargoName;
    }
    public void settCargoNumber(Integer tCargoNumber) 
    {
        this.tCargoNumber = tCargoNumber;
    }

    public Integer gettCargoNumber() 
    {
        return tCargoNumber;
    }
    public void settCargoTotalWeight(BigDecimal tCargoTotalWeight) 
    {
        this.tCargoTotalWeight = tCargoTotalWeight;
    }

    public BigDecimal gettCargoTotalWeight() 
    {
        return tCargoTotalWeight;
    }
    public void settCargoTotalVolume(BigDecimal tCargoTotalVolume) 
    {
        this.tCargoTotalVolume = tCargoTotalVolume;
    }

    public BigDecimal gettCargoTotalVolume() 
    {
        return tCargoTotalVolume;
    }
    public void setValuable(String valuable) 
    {
        this.valuable = valuable;
    }

    public String getValuable() 
    {
        return valuable;
    }
    public void setIrregular(String irregular) 
    {
        this.irregular = irregular;
    }

    public String getIrregular() 
    {
        return irregular;
    }
    public void setDocuments(String documents) 
    {
        this.documents = documents;
    }

    public String getDocuments() 
    {
        return documents;
    }
    public void setPackageType(String packageType) 
    {
        this.packageType = packageType;
    }

    public String getPackageType() 
    {
        return packageType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("waybillId", getWaybillId())
            .append("cargoId", getCargoId())
            .append("tCargoName", gettCargoName())
            .append("tCargoNumber", gettCargoNumber())
            .append("tCargoTotalWeight", gettCargoTotalWeight())
            .append("tCargoTotalVolume", gettCargoTotalVolume())
            .append("valuable", getValuable())
            .append("irregular", getIrregular())
            .append("documents", getDocuments())
            .append("packageType", getPackageType())
            .toString();
    }
}
